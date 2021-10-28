package heap;

import java.util.UUID;

public class Machine {

  private UUID id;

  private int weight;

  public Machine(UUID id) {
    this.id = id;
    this.weight = 0;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public UUID getId() {
    return id;
  }
}
