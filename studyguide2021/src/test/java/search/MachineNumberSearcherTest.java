package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MachineNumberSearcherTest {

  @Test
  public void SearchLowestAvailableNumber1() {
    List<Integer> machines = List.of(5,3,1);
    Search<Integer, Collection<Integer>> machinePicker = new MachineNumberSearcher();
    int leastAvailableMachineNumber = machinePicker.search(machines);
    Assertions.assertEquals(2, leastAvailableMachineNumber);
  }

  @Test
  public void SearchLowestAvailableNumber2() {
    List<Integer> machines = List.of(5,4,2,1);
    Search<Integer, Collection<Integer>> machinePicker = new MachineNumberSearcher();
    int leastAvailableMachineNumber = machinePicker.search(machines);
    Assertions.assertEquals(3, leastAvailableMachineNumber);
  }

  @Test
  public void SearchLowestAvailableNumber3() {
    List<Integer> machines = List.of(3,2,1);
    Search<Integer, Collection<Integer>> machinePicker = new MachineNumberSearcher();
    int leastAvailableMachineNumber = machinePicker.search(machines);
    Assertions.assertEquals(4, leastAvailableMachineNumber);
  }

  @Test
  public void SearchLowestAvailableNumber4() {
    List<Integer> machines = List.of(2,3);
    Search<Integer, Collection<Integer>> machinePicker = new MachineNumberSearcher();
    int leastAvailableMachineNumber = machinePicker.search(machines);
    Assertions.assertEquals(1, leastAvailableMachineNumber);
  }

  @Test
  public void SearchLowestAvailableNumberEmpty() {
    List<Integer> machines = new ArrayList<>();
    Search<Integer, Collection<Integer>> machinePicker = new MachineNumberSearcher();
    int leastAvailableMachineNumber = machinePicker.search(machines);
    Assertions.assertEquals(1, leastAvailableMachineNumber);
  }
}
