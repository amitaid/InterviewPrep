/**
 * Link in a linked list
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

    public Link(T data, Link<T> prev, Link<T> next) {
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

    public Link<T> getNext() {
        return next;
    }

    public void setPrev(Link<T> prev) {
        this.prev = prev;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public String toString() {
        return "[ " + data.toString() + " ]";
    }
}
