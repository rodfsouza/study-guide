package array;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    @Test
    public void testAdd() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums = {2, 7, 11, 15};
        //Arrays.sort(nums);
        int target = 9;
        int[] result = addTwoNumbers.add(nums, target);
        assert result[0] == 0;
        assert result[1] == 1;
    }

    @Test
    public void testAdd2() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums = {3, 2, 3};
        int target = 6;
        int[] result = addTwoNumbers.add(nums, target);
        assert result[0] == 0;
        assert result[1] == 2;
    }

    @Test
    public void testAdd3() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] result = addTwoNumbers.add(nums, target);
        assert result[0] == 1;
        assert result[1] == 2;
    }
}
