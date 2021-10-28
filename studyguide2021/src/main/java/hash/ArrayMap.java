package hash;

import java.util.Objects;

public class ArrayMap<K, V> implements IMap<K,V> {

  private static final int DEFAULT_INITIAL_CAPACITY = 11;

  private static final double LOAD_FACTOR = 0.75;

  private final int initialCapacity;

  private final Node<K, V>[] bucket;

  private int size = 0;

  public ArrayMap(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Initial capacity should be greater than zero.");
    }

    this.initialCapacity = initialCapacity;
    this.bucket = new Node[initialCapacity];
  }

  public ArrayMap() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  @Override
  public V get(K key) {
    if (key == null) {
      return null;
    }

    int hash = hash(key);
    return getNode(key, hash).value;
  }

  @Override
  public void put(K key, V value) {
    if (key == null || value == null) {
      throw new IllegalArgumentException();
    }

    int hash = hash(key);
    Node<K, V> curr = bucket[hash];

    if (curr == null) {
      bucket[hash] = new Node<>(hash, key, value);
    } else {
      if (size >= (initialCapacity * LOAD_FACTOR)) {
        //resize
      }

      if (size < initialCapacity) {
        if (curr.key.equals(key)) {
          throw new IllegalArgumentException("Key already present on the map.");
        }

        while (curr.next != null) {
          curr = curr.next;
        }
        curr.next = new Node<>(hash, key, value);
      }
    }
    ++size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void remove(K key) { //Not Implemented

  }

  private int hash(K key) {
    int index = key == null ? 0 : Objects.hash(key) % bucket.length;
    return index < 0 ? index * -1 : index;
  }

  private Node<K, V> getNode(K key, int hash) {
    if (bucket[hash] == null) {
      return null;
    }

    Node<K, V> found = bucket[hash];
    Node<K, V> curr = found;

    if (found != null) {
      while (curr != null) {
        if (curr.hash == hash && curr.key.equals(key)) {
          return curr;
        }
        curr = curr.next;
      }
    }
    return curr;
  }

  private static class Node<K, V> {
    int hash;
    K key;
    V value;
    Node<K, V> next;

    public Node(int hash, K key, V value, Node<K, V> next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public Node(int hash, K key, V value) {
      this(hash, key, value, null);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Node<?, ?> node = (Node<?, ?>) o;
      return Objects.equals(key, node.key) && Objects.equals(value, node.value)
          && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key) ^ Objects.hash(value);
    }
  }
}