public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    protected MaxHeap() {
        super((t1, t2) -> t2.compareTo(t1));
    }


    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap<>();
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
