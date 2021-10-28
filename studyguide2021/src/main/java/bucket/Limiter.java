package bucket;

public interface Limiter<T> {

  boolean tryInsert(T value);

  int size();
}
