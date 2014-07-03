/**
 * @author amitay
 */

public class Link<T> {

  private T data;
  private Link<T> prev;
  private Link<T> next;

  public Link(T data) {
    this.data = data;
    prev = null;
    next = null;
  }

  public Link(T data, Link prev, Link next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public Link<T> getPrev() {
    return prev;
  }

  public void setPrev(Link prev) {
    this.prev = prev;
  }

  public Link<T> getNext() {
    return next;
  }

  public void setNext(Link next) {
    this.next = next;
  }
}
