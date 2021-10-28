package heap;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoadBalancerTest {

  private static Balancer<Machine> machineBalancer;

  @BeforeAll
  public static void setup() throws InterruptedException {
    machineBalancer = new LoadBalancer();

    for (int i = 0; i < 5; ++i) {
      UUID guid = UUID.randomUUID();
      Machine m = new Machine(guid);
      machineBalancer.push(m);
      Thread.sleep(30);
    }
  }

  @Test
  public void PopAddIncreasingWeightCount() {
    for (int i = 0; i < 3; ++i) {
      Machine m = machineBalancer.pop();
    }
    Assertions.assertEquals(1, machineBalancer.pop().getWeight());
  }
}
