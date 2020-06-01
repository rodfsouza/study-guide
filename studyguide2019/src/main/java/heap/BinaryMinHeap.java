package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  Data structure to support following operations
 *  extracMin - O(log n)
 *  addToHeap - O(log n)
 *  containsKey - O(1)
 *  decreaseKey - O(log n)
 *  getKeyWeight - O(1)
 *  *
 *  * It is a combination of binary heap and hash map
 *  *
 */
public class BinaryMinHeap<T> {

    private int capacity = 10;
    private int size = 0;
    private Node[] items;
    private Map<T, Integer> nodePosition;

    public BinaryMinHeap() {
        items = new Node[capacity];
        nodePosition = new HashMap<>();
    }

    public class Node<T> {
        int weight;
        T key;
    }

    public Node peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return (T) item;
    }

    public void add(T key, int weight) {
        ensureExtraCapacity();
        Node node = new Node();
        node.key = key;
        node.weight = weight;
        items[size] = node;
        nodePosition.put((T) node.key, size);
        size++;
        heapifyUp();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Node node) {
        return nodePosition.containsKey(node);
    }

    public void decrease(T node, int weight) {
        Integer position = null;
        if (nodePosition.containsKey(node)) {
            position = nodePosition.get(node);
        }

        if (position != null) {
            Node current = items[position];
            if (current.weight > weight) {
                current.weight = weight;
                nodePosition.remove(current);
                nodePosition.put((T) current, position);
                items[position] = current;
                heapifyUp();
            }
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)].weight;
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)].weight;
    }

    private int parent(int index) {
        return items[getParentIndex(index)].weight;
    }

    private void swap(int indexOne, int indexTwo) {
        Node temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        nodePosition.put((T) nodePosition.get(temp), indexTwo);
        nodePosition.put((T) nodePosition.get(items[indexTwo]), indexOne);
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index].weight < items[smallerChildIndex].weight) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index].weight) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }
}
