public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap() {
        super(T::compareTo);
    }


    public static void main(String[] args) {
        MinHeap<Integer> mh = new MinHeap<>();
        mh.add(4);
        mh.add(3);
        mh.add(6);
        mh.add(9);
        mh.add(3);
        mh.add(1);
        mh.add(2);
        System.out.println(mh);
    }

}
