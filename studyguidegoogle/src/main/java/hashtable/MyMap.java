package hashtable;

public interface MyMap<K, V> {

    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);

    int size();
    boolean isEmpty();
    int hash(K key);
}
