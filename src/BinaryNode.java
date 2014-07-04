import java.util.ArrayList;
import java.util.List;

/**
 * Node in a general binary tree.
 */

public abstract class BinaryNode<T> {

    protected T data;
    protected BinaryNode<T> parent, left, right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public BinaryNode(T data, BinaryNode<T> parent, BinaryNode<T> left, BinaryNode<T> right) {
        this(data, parent);
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public BinaryNode<T> getParent() {
        return parent;
    }

    public abstract void insert(T data);

    public boolean contains(T data) {
        return this.data.equals(data) ||
               (left != null && left.contains(data)) ||
               (right != null && right.contains(data));
    }

    public int depth() {
        return 1 + Math.max(left == null ? 0 : left.depth(),
                            right == null ? 0 : right.depth());
    }

    public void bfsPrint() {
        List<BinaryNode<T>> l = new ArrayList<>();
        l.add(this);
        while (!l.isEmpty()) {
            BinaryNode<T> b = l.remove(0);
            if (b.getLeft() != null) {
                l.add(b.getLeft());
            }
            if (b.getRight() != null) {
                l.add(b.getRight());
            }
            System.out.print(b.getData() + " ");
        }
        System.out.println();
    }

    public void dfsPrint() {
        System.out.print(data + " ");
        if (left != null) {
            left.dfsPrint();
        }
        if (right != null) {
            right.dfsPrint();
        }
    }

    public String toString() {
        return "< " + data.toString() + " >";
    }

}
