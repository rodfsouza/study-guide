package hash;

public interface IMap<K, V> {

  V get(K key);

  void put(K key, V value);

  boolean isEmpty();

  void remove(K key);
}