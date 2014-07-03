import java.util.ArrayList;
import java.util.List;


public class BinaryNode<T> {

    public T data;
    public BinaryNode<T> left, right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public String toString() {
        return data.toString();
    }

    public void bfsPrint() {
        List<BinaryNode> l = new ArrayList<>();
        l.add(this);
        while (!l.isEmpty()) {
            BinaryNode b = l.remove(0);
            if (b.left != null) {
                l.add(b.left);
            }
            if (b.right != null) {
                l.add(b.right);
            }
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryNode<String> root = new BinaryNode<>("a");
        root.left = new BinaryNode<>("b");
        root.right = new BinaryNode<>("c");
        root.left.left = new BinaryNode<>("d");
        root.bfsPrint();
    }
}
