import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FloodFill {
    Point startPoint = new Point(0, 0);
    BufferedImage image;

    Stack<Point> stack;

    int oldColor;
    int newColor = 0xFF0000FF;

    public FloodFill() throws IOException {
        image = ImageIO.read(new File("pixelblank.png"));
        if (image == null){
            System.out.println("Image is null");
            return;
        }

        oldColor = image.getRGB(startPoint.x, startPoint.y);
        stack = new Stack<>(startPoint);
    }

    public void fill() throws IOException{
        int n = image.getHeight();
        int m = image.getWidth();

        if (oldColor == newColor) {
            return;
        }

        while (stack.getTop() != null){
            Point point = stack.pop();

            int x = point.x;
            int y = point.y;

            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (image.getRGB(x, y) != oldColor) {
                continue;
            }
            image.setRGB(x, y, newColor);

            stack.push(new Point(x + 1, y));
            stack.push(new Point(x-1, y));
            stack.push(new Point(x, y+1));
            stack.push(new Point(x, y-1));
        }
        ImageIO.write(image, "png", new File("output.png"));

    }
}
