package sort;

import java.util.Map;
import java.util.TreeMap;

public class SortColors {

  public char[] sort(char[] colorsInRgb) {
    if (colorsInRgb == null || colorsInRgb.length == 0) {
      return new char[]{};
    }

    Map<Character, Integer> colorToOccurrence = new TreeMap<>();
    colorToOccurrence.put('R', 0);
    colorToOccurrence.put('G', 0);
    colorToOccurrence.put('B', 0);

    for (int i = 0; i < colorsInRgb.length; ++i) {
      char color = colorsInRgb[i];

      if (!colorToOccurrence.containsKey(color)) {
        continue;
      }

      int currentCount = colorToOccurrence.get(color);
      colorToOccurrence.put(color, ++currentCount);
    }

    char[] sortedColors = new char[colorsInRgb.length];
    int pos = sortedColors.length - 1;

    for (Map.Entry<Character, Integer> kv : colorToOccurrence.entrySet()) {
      int reps = kv.getValue();

      while (reps-- > 0) {
        sortedColors[pos--] = kv.getKey();
      }
    }

    return sortedColors;
  }

  Map<Character, Integer> COLOR_TO_POS = Map.of(
      'R', 0,
      'G', 1,
      'B', 2
  );

  Map<Integer, Character> POS_TO_COLOR = Map.of(
      0, 'R',
      1, 'G',
      2, 'B'
  );

  public char[] sorting(char[] colors) {
    if (colors == null || colors.length == 0) {
      return new char[]{};
    }

    int[] repCounts = new int[3];
    for (int i = 0; i < colors.length; ++i) {
      char color = colors[i];

      if (!COLOR_TO_POS.containsKey(color)) {
        continue;
      }

      int repIndex = COLOR_TO_POS.get(color);
      repCounts[repIndex]++;
    }

    char[] sortedColors = new char[colors.length];
    int sortedPos = 0;

    for(int i = 0; i < repCounts.length; ++i) {
      char color = POS_TO_COLOR.get(i);

      int repCount = repCounts[i];
      while (repCount-- > 0) {
        sortedColors[sortedPos++] = color;
      }
    }

    return sortedColors;
  }
}
