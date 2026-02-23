package homework;

class Image {
    private int[][] image;

    public Image(int size) {
        image = new int[size][size];
    }

    public void fillBorder(int value) {
        for(int i = 0; i < image.length; i++) {
            image[0][i] = image[image.length - 1][i] = image[i][0] = image[i][image.length - 1] = value;
        }
    }

    public void fillImage(int value) {
        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[i].length - 1; j++) {
                image[i][j] = value;
            }
        }
    }

    public void darkRectangle(int length, int width) {
        if (length > image.length || width > image.length) {
            System.out.println("Error! Length or width too large.");
            System.exit(-1);
        }
        else {
            fillImage(255);
            fillBorder(0);

            int left = (image.length - length) / 2;
            int right = left + length;
            int top = (image.length - width) / 2;
            int bottom = top + width;

            for (int i = left; i < right; i++) {
                for (int j = top; j < bottom; j++) {
                    image[i][j] = 0;
                }
            }
        }
    }

    public void whiteCircle(int radius) {
        if (radius > image.length / 2) {
            System.out.println("Error! Radius too large.");
            System.exit(-1);
        }
        else {
            int center = image.length / 2;

            fillImage(0);
            fillBorder(255);

            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image.length; j++) {
                    double dx = j - center;
                    double dy = i - center;
                    if (dx * dx + dy * dy <= radius * radius) {
                        image[i][j] = 255;
                    }
                }
            }
        }
    }


    public String stringRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                sb.append(image[i][j] == 0 ? "█" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
