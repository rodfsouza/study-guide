package hash;

import java.util.LinkedList;
import java.util.List;

public class Bucket<K,V> {
    int size;
    int depth;
    List<Pair<K,V>> list;

    public Bucket(int bucket_size) {
        this.size = bucket_size;
        this.list = new LinkedList<>();
    }

    public Bucket(int bucket_size, int depth) {
        this(bucket_size);
        this.depth = depth;
    }

    public boolean insert(K key, V value) {
        if (isFull()) {
            return false;
        }
        list.add(new Pair<>(key, value));
        return true;
    }

    public boolean get(K key, V value) {
        for (Pair<K, V> pair : list) {
            if (pair.left == key && pair.right == value) {
                return true;
            }
        }
        return false;
    }

    public void incrementDepth() {
        depth++;
    }

    public boolean isFull() {
        return list.size() == size;
    }
}

