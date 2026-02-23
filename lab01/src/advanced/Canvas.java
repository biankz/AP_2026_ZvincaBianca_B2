package advanced;

import java.util.Random;

class Canvas {
    private char[][] canvas;

    public Canvas(int size) {
        canvas = new char[size][size];
        fillCanvas();
        drawBorder();
    }

    public void fillCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public void drawBorder() {
        for(int i = 0; i < canvas.length; i++) {
            canvas[0][i] = canvas[canvas.length - 1][i] = canvas[i][0] = canvas[i][canvas.length - 1] = '█';
        }
    }

    public void generateRandomShape() {
        fillCanvas();
        drawBorder();

        Random rand = new Random();
        int i = rand.nextInt(canvas.length - 2) + 1;
        int j = rand.nextInt(canvas.length - 2) + 1;

        canvas[i][j] = '█';

        int steps = rand.nextInt(canvas.length * 3) + canvas.length;

        int[] direction_i = {-1, 1, 0, 0};
        int[] direction_j = {0, 0, -1, 1};

        for (int step = 0; step < steps; step++) {
            int direction = rand.nextInt(4);
            if (i + direction_i[direction] <= 0 ||
                    i + direction_i[direction] >= canvas.length - 1 ||
                    j + direction_j[direction] <= 0 ||
                    j + direction_j[direction] >= canvas.length - 1) {
                continue;
            }
            i += direction_i[direction];
            j += direction_j[direction];
            canvas[i][j] = '█';
        }
    }

    public int[] getBoundingBox() {
        int top = canvas.length;
        int bottom = -1;
        int left = canvas.length;
        int right = -1;

        for (int i = 1; i < canvas.length - 1; i++) {
            for (int j = 1; j < canvas.length - 1; j++) {
                if (canvas[i][j] == '█') {
                    if (i < top) top = i;
                    if (i > bottom) bottom = i;
                    if (j < left) left = j;
                    if (j > right) right = j;
                }
            }
        }

        if (bottom == -1) {
            return null;
        }

        return new int[]{top, left, bottom, right};
    }

    public void print() {
        int[] bb = getBoundingBox();
        int top = -1, left = -1, bottom = -1, right = -1;

        top = bb[0];
        left = bb[1];
        bottom = bb[2];
        right = bb[3];

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                if ((i == top && j >= left && j <= right) || (i == bottom && j >= left && j <= right) || (j == left && i >= top && i <= bottom) || (j == right && i >= top && i <= bottom)) {
                    System.out.print('#');
                }
                else {
                    System.out.print(canvas[i][j]);
                }
            }
            System.out.println();
        }
    }
}
