package hash;

public class Pair<K, V> {
    K left;
    V right;

    public Pair(K key, V value) {
        this.left = key;
        this.right = value;
    }
}
