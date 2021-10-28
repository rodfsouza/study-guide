package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyMapTime<K, T, V> implements IMapTime<K, T, V> {

  private int size;

  private Map<ComposedKey, V> composedKeyMap;

  public MyMapTime() {
    this.size = 0;
    this.composedKeyMap = new HashMap<>();
  }

  @Override
  public void put(K key, T time, V value) {
    if (key == null || time == null || value == null) {
      throw new IllegalArgumentException();
    }

    ComposedKey compKey = new ComposedKey(key, time);
    composedKeyMap.put(compKey, value);
    ++size;
  }

  @Override
  public V get(K key, T time) {
    if (key == null || time == null || isEmpty()) {
      return null;
    }

    ComposedKey compKey = new ComposedKey(key, time);
    return composedKeyMap.get(compKey);
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  private class ComposedKey {
    K key;
    T time;

    private ComposedKey(K key, T time) {
      this.key = key;
      this.time = time;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ComposedKey that = (ComposedKey) o;
      return key.equals(that.key) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key) ^ Objects.hash(time);
    }
  }
}
