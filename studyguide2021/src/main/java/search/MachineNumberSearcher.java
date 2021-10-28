package search;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MachineNumberSearcher implements Search<Integer, Collection<Integer>> {

  @Override
  public Integer search(Collection<Integer> input) {
    if (input == null) {
      throw new IllegalArgumentException();
    }

    int lowestAvailableNumber = 1;
    if (input.isEmpty()) {
      return lowestAvailableNumber;
    }

    Set<Integer> presentMachines = new HashSet<>(input.size());
    for (int machineNumber : input) {
      if (presentMachines.contains(machineNumber)) {
        continue;
      }
      presentMachines.add(machineNumber);
    }

    for (int machineNumber : input) {
      if (presentMachines.contains(lowestAvailableNumber)) {
        lowestAvailableNumber++;
      } else {
        return lowestAvailableNumber;
      }
    }
    return lowestAvailableNumber;
  }
}
