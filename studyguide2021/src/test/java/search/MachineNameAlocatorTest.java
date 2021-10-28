package search;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MachineNameAlocatorTest {

  private static Search<Integer, Collection<Integer>> machineNumberSearcher;

  private static Alocator machineNamePicker;

  @BeforeAll
  public static void setup() {
    machineNumberSearcher = new MachineNumberSearcher();
    machineNamePicker = new MachineNameAlocator(machineNumberSearcher);
  }

  @Test
  public void AllocateMachinesAndDeallocate() {
    String prefix = "apibox";
    Set<String> machineNames = new HashSet<>();
    for (int i = 1; i <= 5; ++i) {
      machineNames.add(machineNamePicker.allocate(prefix));
    }

    machineNamePicker.deallocate(prefix + 1);
    String machineName = machineNamePicker.allocate(prefix);
    Assertions.assertEquals(prefix + 1, machineName);
    machineNames.remove(prefix + 1);
  }

  @Test
  public void AllocateMachines() {
    String prefix = "apibox";
    for (int i = 1; i <= 3; ++i) {
      machineNamePicker.allocate(prefix);
    }

    String prefix2 = "sitebox";
    String machine = machineNamePicker.allocate(prefix2);
    Assertions.assertEquals(prefix2 + 1, machine);
  }
}
