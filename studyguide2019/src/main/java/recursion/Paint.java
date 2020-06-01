package recursion;

public class Paint {

    public enum Color {Gray, Black};

    public boolean paintFill(Color[][] screen, int row, int col, Color nColor) {
        if (screen == null || screen.length == 0 || screen[0].length == 0) {
            return false;
        }

        if (screen[row][col] == nColor) {
            return false;
        }
        return paintFill(screen, row, col, screen[row][col], nColor);
    }

    private boolean paintFill(Color[][] screen, int row, int col, Color inColor, Color outColor) {
        if (!isValid(screen, row, col)) {
            return false;
        }

        if (screen[row][col] == inColor) {
            screen[row][col] = outColor;
            paintFill(screen, row - 1, col, inColor, outColor);
            paintFill(screen, row + 1, col, inColor, outColor);
            paintFill(screen, row, col - 1, inColor, outColor);
            paintFill(screen, row, col + 1, inColor, outColor);
        }
        return true;
    }

    private boolean isValid(Color[][] screen, int row, int col) {
        return row >= 0 && col >= 0 && row <= screen.length - 1 && col <= screen[0].length - 1;
    }
}
