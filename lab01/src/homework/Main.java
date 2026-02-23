package homework;

public class Main {
    static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        int size = Integer.parseInt(args[0]);
        Image image = new Image(size);

        long t1 = System.currentTimeMillis();

        if (args[1].equals("circle")) {
            if (args.length != 3) {
                System.out.println("Usage:");
                System.out.println("  java homework.Main <size> circle <radius>");
                System.exit(-1);
            }

            int radius = Integer.parseInt(args[2]);
            image.whiteCircle(radius);

        } else if (args[1].equals("rectangle")) {
            if (args.length != 4) {
                System.out.println("Usage:");
                System.out.println("  java homework.Main <size> rectangle <length> <width>");
                System.exit(-1);
            }

            int length = Integer.parseInt(args[2]);
            int width = Integer.parseInt(args[3]);

            image.darkRectangle(length, width);

        } else {
            System.out.println("Usage:");
            System.out.println("  java homework.Main <size> circle <radius>");
            System.out.println("  java homework.Main <size> rectangle <length> <width>");
            System.exit(-1);
        }

        long t2 = System.currentTimeMillis();

        if (size <= 100) {
            System.out.println(image.stringRepresentation());
        } else {
            System.out.println("Running time: " + (t2 - t1) + " ms");
        }

        // pt valori n incepand de la ~32000, primim OutOfMemoryError
    }
}
