package heap;

public interface Balancer<T> {

  T pop();

  void push(T value);

  int size();
}
