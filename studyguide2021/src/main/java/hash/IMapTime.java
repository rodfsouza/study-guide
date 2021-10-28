package hash;

public interface IMapTime<K, T, V> {

  void put(K key, T time, V value);

  V get(K key, T time);

  boolean isEmpty();

  int size();
}
