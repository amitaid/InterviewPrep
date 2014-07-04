import java.util.HashSet;
import java.util.Set;

/**
 * Linked list implementation
 */

public class LinkedList<T> {

    private Link<T> head;
    private Link<T> tail;
    private int length = 0;


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

    // Remove and return the first element in the list
    public T removeHead() {
        if (head == null) {
            throw new NullPointerException("No elements in the list.");
        }
        T temp = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        length--;
        return temp;
    }

    // Remove and return the last element in the list
    public T removeTail() {
        if (tail == null) {
            throw new NullPointerException("No elements in the list.");
        }
        T temp = tail.getData();
        tail = tail.getPrev();
        if (head != null) {
            head.setNext(null);
        }
        length--;
        return temp;
    }

    public T remove(int i) {
        if (i >= length) {
            return null;
        }
        Link<T> temp = head;
        while (i > 0) {
            temp = temp.getNext();
            i--;
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        length--;
        return temp.getData();
    }

    // Get the i'th element in the list
    public T get(int i) {
        if (i >= length) {
            return null;
        }
        Link<T> temp = head;
        while (i > 0) {
            temp = temp.getNext();
            i--;
        }
        return temp.getData();
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

    public boolean hasCycle() {
        if (length <= 1) {
            return false;
        }
        Link<T> fast = head, slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Finds the first link in the list which repeats.
    // Matches actual pointers, not internal data (shallow).
    public Link<T> startOfCycle() {
        if (!hasCycle()) {
            return null;
        }
        Set<Link<T>> s = new HashSet<>();
        Link<T> link = head;
        while (link != null) {
            if (!s.contains(link)) {
                s.add(link);
                link = link.getNext();
            } else {
                return link;
            }
        }
        return null; // Should never reach this statement.
    }

    public void reverse() {
        Link<T> temp1 = head, temp2;
        while (temp1 != null) {
            temp2 = temp1.getNext();
            temp1.setNext(temp1.getPrev());
            temp1.setPrev(temp2);
            temp1 = temp2;
        }
        temp1 = head;
        head = tail;
        tail = temp1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link<T> temp = head;

        while (temp != null) {
            sb.append(temp);
            if (temp.getNext() != null) {
                sb.append("->");
            }
            temp = temp.getNext();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.append("A").append("B").append("C").append("D").append("E");
        System.out.println(l);
        l.reverse();
        System.out.println(l);

    }

}
