/**
 * FIFO Queue implementation
 */

public class Queue<T> {

    LinkedList<T> list = new LinkedList<>();

    public Queue() {
    }

    public int size() {
        return list.getLength();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean hasNext() {
        return !isEmpty();
    }

    public Queue<T> enqueue(T data) {
        list.append(data);
        return this;
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new NullPointerException("Attempt to dequeue from an empty queue.");
        }
        return list.removeHead();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(0).enqueue(1).enqueue(2);
        while (q.hasNext()) {
            System.out.println(q.dequeue());
        }
    }

}
