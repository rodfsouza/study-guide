package heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LoadBalancer implements Balancer<Machine> {

  private PriorityQueue<Machine> queue;

  private Set<Machine> machineCache;

  public LoadBalancer(Comparator<Machine> comparator) {
    this.queue = new PriorityQueue<>(comparator);
    this.machineCache = new HashSet<>();
  }

  public LoadBalancer() {
    this((Machine m, Machine n) -> Integer.compare(m.getWeight(), n.getWeight()));
  }

  @Override
  public Machine pop() {
    if (queue.isEmpty()) {
      return null;
    }

    Machine leastUsed = queue.poll();
    leastUsed.setWeight(leastUsed.getWeight() + 1);
    queue.add(leastUsed);
    return leastUsed;
  }

  @Override
  public void push(Machine machine) {
    if (machine == null) {
      throw new IllegalArgumentException();
    }

    if (!machineCache.contains(machine)) {
      machineCache.add(machine);
    } else {
      throw new IllegalArgumentException("Machine has to be unique across the balancing");
    }

    queue.add(machine);
  }

  @Override
  public int size() {
    return queue.size();
  }
}
