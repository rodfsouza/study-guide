package hashtable;

import java.util.Objects;

public class HashMapNode<K, V> {

    int hash;
    public K key;
    public V value;
    public HashMapNode<K,V> next;

    public HashMapNode(int hash, K key, V value, HashMapNode<K, V> next) {
        this(hash, key, value);
        this.next = next;
    }

    public HashMapNode(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        HashMapNode<?, ?> that = (HashMapNode<?, ?>) o;
        return Objects.equals(key, that.key) &&
            Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key) ^ Objects.hash(value);
    }
}
