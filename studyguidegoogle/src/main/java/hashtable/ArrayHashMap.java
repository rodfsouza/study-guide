package hashtable;

import java.util.Objects;

public class ArrayHashMap<K, V> implements MyMap<K, V> {

    private static final int DEFAULT_SIZE_FACTOR = 32;
    private static final float LOAD_FACTOR = 0.75f;

    private HashMapNode<K,V>[] bucket;

    private int size = 0;
    private int numberOfCollisions = 0;

    public ArrayHashMap() {
        bucket = new HashMapNode[DEFAULT_SIZE_FACTOR];
    }

    public ArrayHashMap(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException();
        }
        bucket = new HashMapNode[initialSize];
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        int hash = hash(key);

        HashMapNode<K, V> current = bucket[hash];
        if (current == null) {
            ++size;
            bucket[hash] = new HashMapNode<>(hash, key, value);
        } else {
            while (current.next != null) {
                current = current.next;
            }

            ++size;
            ++numberOfCollisions;
            current.next = new HashMapNode<>(hash, key, value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = hash(key);
        return getNode(hash, key).value;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private HashMapNode<K, V> getNode(int hash, K key) {

        if (bucket[hash] == null) {
            return null;
        }

        HashMapNode<K, V> nodeFound = bucket[hash];
        HashMapNode<K, V> current = nodeFound;

        if (nodeFound != null) {
            while (current != null) {
                if (current.getHash() == hash && current.getKey().equals(key)) {
                    return current;
                }
                current = current.next;
            }
        }

        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int hash(Object key) {
        return key == null ? 0 : Objects.hash(key) % bucket.length ;
    }
}
