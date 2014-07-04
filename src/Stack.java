import java.util.EmptyStackException;

/**
 * Stack implementation using the linked list
 */

public class Stack<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void push(T data) {
        list.prepend(data);
    }

    public T peek() {
        return list.get(0);
    }

    public T pop() {
        if (list.getLength() == 0) {
            throw new EmptyStackException();
        }
        return list.removeHead();
    }

    public int getSize() {
        return list.getLength();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(7);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
