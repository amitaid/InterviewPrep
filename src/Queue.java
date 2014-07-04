/**
 * FIFO Queue implementation
 */

public class Queue<T> {

    LinkedList<T> list = new LinkedList<>();

    public Queue() {}

    public int size() {
        return list.getLength();
    }

    public Queue<T> enqueue(T data) {
        list.append(data);
        return this;
    }

    public T dequeue() {
        return list.removeHead();
    }

    public boolean hasNext() {
        return size() > 0;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(0).enqueue(1).enqueue(2);
        while (q.hasNext()) {
            System.out.println(q.dequeue());
        }
    }

}
