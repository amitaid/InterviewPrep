/**
 * Node in a binary search tree
 */
public class BinarySearchNode<T extends Comparable<T>> extends BinaryNode<T> {

    private BinarySearchNode<T> parent, left, right;

    public BinarySearchNode(T data) {
        super(data);
    }

    public BinarySearchNode(T data, BinarySearchNode<T> parent) {
        super(data, parent);
    }

    public BinarySearchNode(T data,
                            BinarySearchNode<T> parent,
                            BinarySearchNode<T> left,
                            BinarySearchNode<T> right) {
        super(data, parent, left, right);
    }


    public void insert(T data) {
        if (this.data.equals(data)) {
            return;
        }
        if (this.data.compareTo(data) > 0) {
            if (left == null) {
                left = new BinarySearchNode<>(data, this);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new BinarySearchNode<>(data, this);
            } else {
                right.insert(data);
            }
        }
    }

    @Override
    public boolean contains(T data) {
        if (this.data.equals(data)) {
            return true;
        } else if (this.data.compareTo(data) > 0) {
            return left != null && left.contains(data);
        } else {
            return right != null && right.contains(data);
        }
    }


    public BinarySearchNode<T> findMaxNode() {
        if (right == null) {
            return this;
        } else {
            return right.findMaxNode();
        }
    }

    public BinarySearchNode<T> findMinNode() {
        if (left == null) {
            return this;
        } else {
            return left.findMinNode();
        }
    }

    public String toString() {
        return (left == null ? "" : left.toString() + " ") +
                data.toString() +
                (right == null ? "" : " " + right.toString());
    }

}
