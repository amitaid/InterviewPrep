import java.util.EmptyStackException;

/**
 * @author amitay
 */

public class Stack<T> {

  private Link<T> head;
  private int size = 0;

  public void push(T data) {
    Link<T> l = new Link<>(data);
    l.setNext(head);
    head = l;
    size++;
  }

  public T peek() {
    if (head == null) {
      throw new EmptyStackException();
    }
    return head.getData();
  }

  public T pop() {
    if (head == null) {
      throw new EmptyStackException();
    }
    T result = head.getData();
    head = head.getNext();
    size--;
    return result;
  }

  public int getSize() {
    return size;
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(5);
    s.push(7);
    System.out.println(s.pop());
    System.out.println(s.pop());
  }
}
