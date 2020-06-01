package hashset;

public interface MySet<V> {

    void put(V value);
    V get(V value);

    boolean contains(V value);
    boolean isEmpty();
    int size();
}
