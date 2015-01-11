
public class Solution {

    // could correctly handle same x, y pos, the binarySearch could
    // return any pos equal to the value.
    //
    // could also use set the dedup, then convert it to int array to
    // reduce the memory and time complexity
    public int calculateSize(int[][] rectangles) {
        if (rectangles == null) {
            return 0;
        }

        int n = rectangles.length;

        int[] x = new int[n * 2];
        int[] y = new int[n * 2];
        boolean[][] isCovered = new boolean[2 * n][2 * n];

        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < n; i++) {
            // left down point
            x[xPos++] = rectangles[i][0];
            y[yPos++] = rectangles[i][1];

            // right up point
            x[xPos++] = rectangles[i][2];
            y[yPos++] = rectangles[i][3];
        }

        Arrays.sort(x);
        Arrays.sort(y);

        for (int i = 0; i < n; i++) {
            int x0 = binarySearch(x, rectangles[i][0]);
            int x1 = binarySearch(x, rectangles[i][2]);

            int y0 = binarySearch(y, rectangles[i][1]);
            int y1 = binarySearch(y, rectangles[i][3]);

            for (int k = x0 + 1; k <= x1; k++) {
                for (int l = y0 + 1; l <= y1; l++) {
                    isCovered[k][l] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 2*n; i++) {
            for (int j = 0; j < 2*n; j++) {
                area += isCovered[i][j] ? (x[i] - x[i - 1]) * (y[j] - y[j - 1]) : 0;
            }
        }

        return area;
    }

    int binarySearch(int[] array, int value) {
        int l = 0;
        int h = array.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[m] == value) {
                return m;
            } else if (array[m] > value) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int size = new Rectangles().calculateSize(new int[][]{
            {1, 2, 7, 7}, {3, 1, 10, 5}, {1, 5, 3, 7} });
        System.out.println(size);
    }
}
