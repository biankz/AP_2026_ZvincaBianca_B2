package advanced;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(30);
        canvas.generateRandomShape();
        int[] bb = canvas.getBoundingBox();
        canvas.print();
        System.out.println("Bounding Box (top, left, bottom, right): " + Arrays.toString(bb));
    }
}