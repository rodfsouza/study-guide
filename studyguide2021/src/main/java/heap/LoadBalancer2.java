package heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LoadBalancer2 implements Balancer<Machine> {

  private final LinkedList<Machine> machines;

  private final Set<Machine> cache;

  public LoadBalancer2(Comparator<Machine> comparator) {
    this.machines = new LinkedList();
    this.cache = new HashSet<>();
  }

  public LoadBalancer2() {
    this((Machine m, Machine n) -> Integer.compare(m.getWeight(), n.getWeight()));
  }

  @Override
  public Machine pop() {
    if (machines.isEmpty()) {
      return null;
    }

    Machine leastUsed = machines.getFirst();
    leastUsed.setWeight(leastUsed.getWeight() + 1);
    machines.addLast(leastUsed);
    return leastUsed;
  }

  @Override
  public void push(Machine machine) {
    if (machine == null) {
      throw new IllegalArgumentException();
    }

    if (!cache.contains(machine)) {
      cache.add(machine);
    } else {
      throw new IllegalArgumentException("Machine already exists!");
    }

    machines.addFirst(machine);
  }

  @Override
  public int size() {
    return 0;
  }
}
