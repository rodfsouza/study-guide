package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortColorsTest {

  @Test
  public void SortColorsRGBArray() {
    char[] colors = new char[] {'G', 'G', 'B', 'R', 'B', 'G', 'R', 'R'};
    SortColors sort = new SortColors();
    char[] sortedColors = sort.sort(colors);
    Assertions.assertEquals(8, sortedColors.length);
  }

  @Test
  public void SortingColorsRGBArray() {
    char[] colors = new char[] {'G', 'G', 'B', 'R', 'B', 'G', 'R', 'R'};
    SortColors sort = new SortColors();
    char[] sortedColors = sort.sorting(colors);
    Assertions.assertEquals(8, sortedColors.length);
  }
}
