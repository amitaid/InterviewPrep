import java.util.ArrayList;
import java.util.List;


public class BinarySearchNode<T extends Comparable<T>> {

  private T data;
  private BinarySearchNode<T> parent;
  private BinarySearchNode<T> left;
  private BinarySearchNode<T> right;

  public BinarySearchNode(T data) {
    this.data = data;
  }

  public BinarySearchNode(T data, BinarySearchNode<T> parent) {
    this.data = data;
    this.parent = parent;
  }

  public BinarySearchNode(T data, BinarySearchNode<T> parent, BinarySearchNode<T> left, BinarySearchNode<T> right) {
    this(data, parent);
    this.left = left;
    this.right = right;
  }

  public T getData() {
    return data;
  }

  public BinarySearchNode<T> getLeft() {
    return left;
  }

  public BinarySearchNode<T> getRight() {
    return right;
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

  public boolean contains(T data) {
    if (this.data.equals(data)) {
      return true;
    } else if (this.data.compareTo(data) > 0) {
      return left != null && left.contains(data);
    } else {
      return right != null && right.contains(data);
    }
  }

  public int depth() {
    return 1 + Math.max(left == null ? 0 : left.depth(),
                        right == null ? 0 : right.depth());
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

  public void bfsPrint() {
    List<BinarySearchNode<T>> l = new ArrayList<>();
    l.add(this);
    while (!l.isEmpty()) {
      BinarySearchNode<T> b = l.remove(0);
      if (b.getLeft() != null) { l.add(b.getLeft()); }
      if (b.getRight() != null) { l.add(b.getRight()); }
      System.out.print(b.getData() + " ");
    }
    System.out.println();
  }

  public void dfsPrint() {
    System.out.print(data + " ");
    if (left != null) { left.dfsPrint(); }
    if (right != null) { right.dfsPrint(); }
  }

  public String toString() {
    return (left == null ? "" : left.toString() + " ") +
           data.toString() +
           (right == null ? "" : " " + right.toString());
  }

}
