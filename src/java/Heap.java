import java.util.Arrays;
import java.util.Comparator;

public abstract class Heap<T extends Comparable<T>> {

    protected final int INITIAL_CAPACITY = 20;
    protected T[] array;
    protected int size;
    protected Comparator<T> comp;

    @SuppressWarnings("unchecked")
    protected Heap(Comparator<T> comparator) {
        array = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
        comp = comparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        return array[0];
    }

    public String toString() {
        return Arrays.toString(array);
    }

    protected boolean hasParent(int i) {
        return i > 0;
    }

    protected int leftChild(int i) {
        return i * 2 + 1;
    }

    protected int rightChild(int i) {
        return i * 2 + 2;
    }

    protected boolean hasLeftChild(int i) {
        return leftChild(i) < size;
    }

    protected boolean hasRightChild(int i) {
        return rightChild(i) < size;
    }

    protected T parent(int i) {
        return array[parentIndex(i)];
    }

    protected int parentIndex(int i) {
        return (i - 1) / 2;
    }

    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    protected void bubbleDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChild = leftChild(index);

            if (hasRightChild(index)
                    && comp.compare(array[leftChild(index)], array[rightChild(index)]) > 0) {
                smallerChild = rightChild(index);
            }

            if (comp.compare(array[index], array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }

            index = smallerChild;
        }
    }

    protected void bubbleUp() {
        int index = this.size - 1;

        while (hasParent(index)
                && (comp.compare(parent(index), array[index]) > 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public T remove() {
        T result = peek();

        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        bubbleDown();
        return result;
    }

    public void add(T value) {
        if (size >= array.length - 1) {
            array = this.resize();
        }

        int index = size;
        array[index] = value;
        size++;

        bubbleUp();
    }

}
