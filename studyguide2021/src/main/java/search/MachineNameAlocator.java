package search;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MachineNameAlocator implements Alocator {

  private final Search<Integer, Collection<Integer>> lowestNumberSearcher;

  private final Map<String, Set<Integer>> prefixToAllocatedNumbers;

  private final Map<String, Integer> cachedMachineNameToNumber;

  public MachineNameAlocator() {
    this(new MachineNumberSearcher());
  }

  //Visible for Testing
  protected MachineNameAlocator(Search<Integer, Collection<Integer>> searcher) {
    if (searcher == null) {
      throw new IllegalArgumentException();
    }
    this.lowestNumberSearcher = searcher;
    this.prefixToAllocatedNumbers = new HashMap<>();
    this.cachedMachineNameToNumber = new HashMap<>();
  }

  @Override
  public String allocate(String prefix) {
    if (prefix == null || prefix.length() == 0) {
      throw new IllegalArgumentException();
    }

    Set<Integer> allocatedNumbers;
    int machineNumber = 0;

    if (!prefixToAllocatedNumbers.containsKey(prefix)) {
      machineNumber = lowestNumberSearcher.search(Collections.EMPTY_LIST);
      allocatedNumbers = new HashSet<>();
    } else {
      allocatedNumbers = prefixToAllocatedNumbers.get(prefix);
      machineNumber = lowestNumberSearcher.search(allocatedNumbers);
    }

    allocatedNumbers.add(machineNumber);
    prefixToAllocatedNumbers.put(prefix, allocatedNumbers);

    String machineName = prefix + machineNumber;
    cachedMachineNameToNumber.putIfAbsent(machineName, machineNumber);

    return machineName;
  }

  @Override
  public void deallocate(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException();
    }

    int oldMachineNumber = 0;
    if (!cachedMachineNameToNumber.containsKey(name)) {
      throw new IllegalArgumentException("Machine does not exist!");
    }

    oldMachineNumber = cachedMachineNameToNumber.get(name);
    cachedMachineNameToNumber.remove(name);

    String machinePrefix = findMachinePrefix(name);
    assert machinePrefix != null;

    Set<Integer> preAllocatedNumbers = prefixToAllocatedNumbers.get(machinePrefix);
    assert preAllocatedNumbers != null;

    preAllocatedNumbers.remove(oldMachineNumber);
    prefixToAllocatedNumbers.put(machinePrefix, preAllocatedNumbers);
  }

  private String findMachinePrefix(String machineName) {

    String prefix = "";
    for (int i = 0; i < machineName.length(); ++i) {
      prefix += String.valueOf(machineName.charAt(i));

      if (prefixToAllocatedNumbers.containsKey(prefix)) {
        return prefix;
      }
    }
    return null;
  }
}
