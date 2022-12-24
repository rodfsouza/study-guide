package hash;

import java.util.Objects;

public class ExtendibleHashTable<K,V> {

    int bucket_size;
    int global_depth;
    int num_buckets;
    Bucket<K,V>[] dir;

    public ExtendibleHashTable(int bucket_size) {
        this.bucket_size = bucket_size;
        this.global_depth = 0;
        this.num_buckets = 1;
        this.dir = new Bucket[num_buckets];
    }

    public void insert(K key, V value) {
        if (key == null) {
            return;
        }

        int index = indexOf(key);
        if (dir[index] == null) {
            dir[index] = new Bucket<>(bucket_size);
            dir[index].insert(key, value);
        } else {
            if (!dir[index].insert(key, value)) {
                if (global_depth == dir[index].depth) {
                    ++global_depth;
                    Bucket<K,V>[] new_dir = new Bucket[dir.length << 1];
                    System.arraycopy(dir, 0, new_dir, 0, dir.length);
                    dir = new_dir;
                    dir[index].incrementDepth();
                    RedistributeBucket(dir[index]);
                    dir[indexOf(key)].insert(key, value);
                } else if (global_depth > dir[index].depth) {
                    dir[index].incrementDepth();
                    RedistributeBucket(dir[index]);
                    dir[indexOf(key)].insert(key, value);
                }
            }
        }
    }

    public boolean get(K key, V value) {
        int index = indexOf(key);
        if (dir[index] == null) {
            return false;
        }
        return dir[index].get(key, value);
    }

    private int indexOf(K key) {
        int mask = (1 << global_depth) - 1;
        return Objects.hash(key) & mask;
    }

    private void RedistributeBucket(Bucket<K,V> toBeSplitted) {
        for (Pair<K, V> pair : toBeSplitted.list) {
            int index = indexOf(pair.left);
            if (dir[index] != null) {
                dir[index].insert(pair.left, pair.right);
            } else {
                dir[index] = new Bucket<>(bucket_size, toBeSplitted.depth);
                dir[index].insert(pair.left, pair.right);
                toBeSplitted.list.remove(pair);
            }
        }
    }
}
