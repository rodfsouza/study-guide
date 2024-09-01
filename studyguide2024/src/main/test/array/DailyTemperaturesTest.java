package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DailyTemperaturesTest {

    @Test
    public void TestDailyTemperaturesSuccess() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.numberOfDays(temperatures);
        int[] k = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(k, result);
    }
}
