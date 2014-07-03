/**
 * Binary search tree implementation
 */

public class BinarySearchTree<T extends Comparable<T>> {

    private BinarySearchNode<T> root;

    public BinarySearchTree(T data) {
        root = new BinarySearchNode<>(data);
    }

    public BinarySearchTree<T> insert(T data) {
        root.insert(data);
        return this;
    }

    public boolean contains(T data) {
        return root.contains(data);
    }

    public int depth() {
        return root.depth();
    }

    public T max() {
        return root.findMaxNode().getData();
    }

    public T min() {
        return root.findMinNode().getData();
    }

    /**
     * Prints the result of a BFS scan starting at the root
     */
    public void bfsPrint() {
        root.bfsPrint();
    }

    /**
     * Prints the result of a DFS scan starting at the root (basically, inorder traversal)
     */
    public void dfsPrint() {
        root.dfsPrint();
    }

    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>(9);
        t.insert(5).insert(3).insert(7).insert(1);
        System.out.println(t);
        System.out.println(t.contains(3));
        System.out.println(t.depth());
        System.out.println("min = " + t.min() + ", max = " + t.max());
        t.bfsPrint();
        t.dfsPrint();
    }

}
