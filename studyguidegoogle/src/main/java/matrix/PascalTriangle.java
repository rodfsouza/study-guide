package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

//         1
//        1 1
//       1 2 1
//      1 3 3 1
//     1 4 6 4 1

    public List<List<Integer>> generate(int numberOfRows) {
        if (numberOfRows <= 0) {
            return Collections.emptyList();
        }

        //TODO: What if is a very large number?

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numberOfRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                currentRow.add((j > 0 && j < i) ? triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j) : 1);
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
