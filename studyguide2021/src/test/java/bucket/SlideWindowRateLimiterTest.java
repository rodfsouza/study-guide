package bucket;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlideWindowRateLimiterTest {

  @Test
  public void SlideWindowLimiterNegativeWindowShouldThrow() {
    Duration duration = Duration.ofSeconds(30);
    Assertions.assertThrows(IllegalArgumentException.class, () ->
        new SlideWindowRateLimiter<Integer>(-1, duration));
  }

  @Test
  public void SlideWindowLimiterNullDurationWindowShouldThrow() {
    Duration duration = Duration.ofSeconds(30);
    Assertions.assertThrows(IllegalArgumentException.class, () ->
        new SlideWindowRateLimiter<Integer>(5, null));
  }

  @Test
  public void SlideWindowLimiterFailedToInsertSizeLimit() {
    Duration duration = Duration.ofSeconds(30);
    Limiter<Integer> slideWindow = new SlideWindowRateLimiter<>(5, duration);
    for (int i = 0; i < 5; ++i) {
      slideWindow.tryInsert(i);
    }

    boolean isInserted = slideWindow.tryInsert(5);
    Assertions.assertFalse(isInserted);
  }

  @Test
  public void SlideWindowLimiterSuccessRemoveAndInsert() throws InterruptedException {
    Duration duration = Duration.ofSeconds(2);
    Limiter<Integer> slideWindow = new SlideWindowRateLimiter<>(5, duration);
    for (int i = 0; i < 5; ++i) {
      slideWindow.tryInsert(i);
    }

    Thread.sleep(3000);
    boolean isInserted = slideWindow.tryInsert(5);
    Assertions.assertTrue(isInserted);
  }

  @Test
  public void SlideWindowLimiterSuccessInsertWithTimeJitter() throws InterruptedException {
    Duration duration = Duration.ofSeconds(2);
    Limiter<Integer> slideWindow = new SlideWindowRateLimiter<>(5, duration);
    for (int i = 0; i < 5; ++i) {
      slideWindow.tryInsert(i);
      int num = i == 0 ? 1 : i;
      Thread.sleep(100 % num);
    }

    Thread.sleep(3000);
    boolean isInserted = slideWindow.tryInsert(5);
    Assertions.assertTrue(isInserted);
  }
}
