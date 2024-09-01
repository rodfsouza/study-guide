package array.matrix;

public class FloodFill {

    public int[][] flood(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }
        if (image[sr][sc] == color) {
            return image;
        }

        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void fill(int[][] image, int row, int col, int inColor, int outColor) {
        if (!isValid(image, row, col)) {
            return;
        }

        if (image[row][col] == inColor) {
            image[row][col] = outColor;
            fill(image, row, col + 1, inColor, outColor);
            fill(image, row, col - 1, inColor, outColor);
            fill(image, row + 1, col, inColor, outColor);
            fill(image, row - 1, col, inColor, outColor);
        }
    }

    private boolean isValid(int[][] image, int row, int col) {
        return row >= 0 && col >= 0 && row < image.length && col < image[0].length;
    }
}
