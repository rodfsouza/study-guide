package queue;

import java.util.Comparator;

/**
 * This is a custom implementation of a Priority Queue (Max Heap)
 * the actual implementation assumes Max Priority Queue instead of traditional
 * libraries which does Min Priority Queue and you can tweak by the comparator.
 *
 * The actual code relies on an Array of object of type T (Generic) which accepts
 * any kind of items, however its required a compatible comparator.
 */
public class CustomPriorityQueue<T extends Comparable<T>>  {

    private static final int DEFAULT_INITIAL_CAPACITY = 1000;

    private final Object[] binaryHeap;

    private final Comparator<? super T> comparator;

    private int length;

    public CustomPriorityQueue(Comparator<? super T> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public CustomPriorityQueue(int initialCapacity, Comparator<? super T> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }

        this.binaryHeap = new Object[initialCapacity];
        this.comparator = comparator;
        this.length = 0;
    }

    /**
     *
     * @param value
     */
    public void enqueue(T value) {
        this.binaryHeap[this.length] = value;
        this.shiftUp(this.length++);
    }

    /**
     *
     * @returns
     */
    public T dequeue() throws IllegalAccessException {
        if (this.length == 0) {
            throw new IllegalAccessException("Cannot Dequeue on a empty Queue");
        }

        Object result = this.binaryHeap[0];

        //Replace the value at the root with the last leaf
        this.binaryHeap[0] = this.binaryHeap[--this.length];

        // Shift down the replaced element to maintain the heap property
        this.shiftDown(0);
        return (T) result;
    }

    /**
     *
     * @returns
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     *
     * @returns
     */
    public int size() {
        return this.length;
    }

    /**
     *
     * @returns
     */
    public T peek() {
        return (T) this.binaryHeap[0];
    }

    /**
     *
     * @param pos
     * @returns
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * @param pos
     */
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    /**
     *
     * @param pos
     */
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    /**
     *
     * @param pos
     */
    private void shiftUp(int pos) {
        while (pos > 0
                && this.comparator.compare((T) this.binaryHeap[this.parent(pos)], (T) this.binaryHeap[pos]) < 0) {
            this.swap(this.parent(pos), pos);
            pos = this.parent(pos);
        }
    }

    /**
     *
     * @param pos
     */
    private void shiftDown(int pos) {
        int maxIndex = pos;

        //Left child of pos
        int left = this.leftChild(pos);
        if (left <= this.length
                && this.comparator.compare((T) this.binaryHeap[left], (T) this.binaryHeap[maxIndex]) > 0) {
            maxIndex = left;
        }

        //Right child of pos
        int right = this.rightChild(pos);
        if (right <= this.length
                && this.comparator.compare((T) this.binaryHeap[right], (T) this.binaryHeap[maxIndex]) > 0) {
            maxIndex = right;
        }

        if (pos != maxIndex) {
            this.swap(pos, maxIndex);
            //Recursively calls after swapping
            this.shiftDown(maxIndex);
        }
    }

    /** Swap two items on the array given their positions */
    private void swap(int pos, int j) {
        Object tmp = this.binaryHeap[pos];
        this.binaryHeap[pos] = this.binaryHeap[j];
        this.binaryHeap[j] = tmp;
    }
}
