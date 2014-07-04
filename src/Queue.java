/**
 * FIFO Queue implementation
 */

public class Queue<T> {

    LinkedList<T> list = new LinkedList<>();

    public Queue() {}

    public int size() {
        return list.getLength();
    }

    public Queue<T> insert(T data) {
        list.append(data);
        return this;
    }

    public T next() {
        return list.removeHead();
    }

    public boolean hasNext() {
        return size() > 0;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(0).insert(1).insert(2);
        while (q.hasNext()) {
            System.out.println(q.next());
        }
    }

}
