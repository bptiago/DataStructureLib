import structures.Stack;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FloodFill {
    private final Point startPoint;
    private BufferedImage image;
    private final Stack<Point> stack;

    public FloodFill(String path, int x, int y) {
        try {
            image = ImageIO.read(new File(path));
            if (image == null){
                throw new IllegalArgumentException("Image is null!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        startPoint = new Point(x, y);
        stack = new Stack<>();
    }

    public void fill() {
        int newColor = 0xFF0000FF;
        int oldColor = image.getRGB(startPoint.x, startPoint.y);

        int n = image.getHeight();
        int m = image.getWidth();

        if (oldColor == newColor) {
            return;
        }

        stack.push(startPoint);
        while (stack.getTop() != null){
            Point point = stack.pop();
            int x = point.x;
            int y = point.y;

            if (x < 0 || x >= m || y < 0 || y >= n || image.getRGB(x, y) != oldColor) {
                continue;
            }

            image.setRGB(x, y, newColor);
            stack.push(new Point(x + 1, y));
            stack.push(new Point(x-1, y));
            stack.push(new Point(x, y+1));
            stack.push(new Point(x, y-1));
        }

        try {
            ImageIO.write(image, "jpg", new File("assets/output.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
