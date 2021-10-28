package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CmdLineParamRevertTest {

  private String CMD_LINE = "cut -f -d";

  @Test
  public void FindCmdLineParams() {
    String[] tokens = CMD_LINE.split(" ");

    List<String> params = new ArrayList<>();
    for (String token : tokens) {
      if (token.startsWith("-")) {
        params.add(token);
      }
    }
    Assertions.assertEquals(2, params.size());
  }

  @Test
  public void FindAndRevertCmdLineParams() {
    String[] tokens = CMD_LINE.split(" ");

    LinkedList<String> params = new LinkedList<>();
    for (String token : tokens) {
      if (token.startsWith("-")) {
        params.addFirst(token);
      }
    }
    Assertions.assertEquals(2, params.size());

    StringBuilder sb = new StringBuilder();
    sb.append(tokens[0]);

    while (!params.isEmpty()) {
      sb.append(" ").append(params.pop());
    }
    Assertions.assertEquals("cut -d -f", sb.toString());
  }

  @Test
  public void CompareTwoLists() {
    List<Integer> first = List.of(1, 2, 3);
    List<Integer> second = List.of(1, 2, 3);
    Assertions.assertIterableEquals(first, second, "Failed to compare the lists.");
  }
}
