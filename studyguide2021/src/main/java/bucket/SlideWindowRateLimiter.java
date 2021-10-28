package bucket;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class SlideWindowRateLimiter<T> implements Limiter<T> {

  private final int windowLength;

  private final Duration windowDuration;

  private final LinkedList<Node<T>> window;

  public SlideWindowRateLimiter(int windowLength, Duration windowDuration) {
    if (windowLength <= 0) {
      throw  new IllegalArgumentException("Window length cannot be less or equal to zero.");
    }

    if (windowDuration == null) {
      throw new IllegalArgumentException("Duration cannot be null.");
    }

    this.windowLength = windowLength;
    this.windowDuration = windowDuration;
    this.window = new LinkedList<>();
  }

  @Override
  public boolean tryInsert(T value) {
    if (size() >= windowLength)
    {
      Node<T> tail = window.peekLast();
      if (ChronoUnit.SECONDS.between(tail.insertionTime, Instant.now()) > windowDuration.toSeconds())
      {
        window.pollLast();
      } else {
        return false;
      }
    }
    window.addFirst(new Node<T>(value, Instant.now()));
    return true;
  }

  @Override
  public int size() {
    return window.size();
  }

  private static class Node<T> {

    T value;
    Instant insertionTime;

    public Node(T value, Instant insertionTime) {
      this.value = value;
      this.insertionTime = insertionTime;
    }

  }
}
