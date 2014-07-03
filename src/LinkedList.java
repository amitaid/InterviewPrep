/**
 * Linked list implementation
 */

public class LinkedList<T> {

    private Link<T> head;
    private Link<T> tail;
    private int length = 0;

    public LinkedList() {
    }

    public LinkedList(T data) {
        head = tail = new Link<>(data);
        length = 1;
    }

    public int getLength() {
        return length;
    }

    // Attach an item at the beginning of the list
    public LinkedList<T> prepend(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Link<T> link = new Link<>(data, null, head);
        if (head == null) {
            head = link;
            tail = link;
        } else {
            head.setPrev(link);
            head = head.getPrev();
        }
        length++;
        return this;
    }

    // Attach an item at the end of the list
    public LinkedList<T> append(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Link<T> link = new Link<>(data, tail, null);
        if (head == null) {
            head = link;
            tail = link;
        } else {
            tail.setNext(link);
            tail = tail.getNext();
        }
        length++;
        return this;
    }

    // Removes the first occurrence of the given item in the list
    public boolean removeFirst(T data) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(data)) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            length--;
            return true;
        }
        Link<T> temp = head.getNext();
        while (temp != null) {
            if (temp.getData().equals(data)) {
                temp.getPrev().setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(temp.getPrev());
                }
                length--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    // Removes all occurrences of the given item
    public int removeAll(T data) {
        int removed = 0;
        Link<T> temp = head;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                removed++;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    if (temp.getPrev() != null) {
                        temp.getPrev().setNext(temp.getNext());
                    }
                    if (temp.getNext() != null) {
                        temp.getNext().setPrev(temp.getPrev());
                    }
                    if (temp == head) {
                        head = head.getNext();
                    }
                }
            }
            temp = temp.getNext();
        }
        length -= removed;
        return removed;
    }

    // Check if an item is contained in the list
    public boolean contains(T data) {
        Link<T> link = head;
        while (link != null) {
            if (link.getData().equals(data)) {
                return true;
            }
            link = link.getNext();
        }
        return false;
    }

    // Count the occurrences of the given item in the list
    public int count(T data) {
        Link<T> link = head;
        int counter = 0;
        while (link != null) {
            if (link.getData().equals(data)) {
                counter++;
            }
            link = link.getNext();
        }
        return counter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link<T> temp = head;

        sb.append("[ ");
        while (temp != null) {
            if (temp.getNext() != null) {
                sb.append(temp.getData().toString() + " ]->[ ");
            } else {
                sb.append(temp.getData());
            }
            temp = temp.getNext();
        }

        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>("A");
        l.append("A").append("B").append("A").append("A").append("C").append("D").append("A");
        System.out.println(l);
        System.out.println(l.count("A"));
        System.out.println(l.removeAll("A"));
        System.out.println(l);
        System.out.println(l.count("A"));
    }

}
