/**
 * A Queue implementation from two stacks
 */

public class StackQueue<T> {

    private Stack<T> a = new Stack<>();
    private Stack<T> b = new Stack<>();

    private void a2b() {
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
    }

    private void b2a() {
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    public void enqueue(T data) {
        b2a();
        a.push(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Attempt to dequeue from an empty queue.");
        }

        a2b();
        return b.pop();
    }

    public int size() {
        return a.size() + b.size();
    }

    public boolean isEmpty() {
        return a.isEmpty() && b.isEmpty();
    }


    public static void main(String[] args) {
        StackQueue<Integer> sq = new StackQueue<>();
        sq.enqueue(1);
        sq.enqueue(2);
        sq.enqueue(3);

        while (!sq.isEmpty()) {
            System.out.println(sq.dequeue());
        }

    }

}
