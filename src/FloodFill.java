import structures.Queue;
import structures.Stack;
import swing.ImagePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FloodFill {
    private final Point startPoint;
    private BufferedImage image;
    private final Stack<Point> stack;
    private final Queue<Point> queue;
    private ImagePanel panel;

    public FloodFill(BufferedImage image, ImagePanel panel, int x, int y) {
        this.image = image;
        if (this.image == null){
            throw new IllegalArgumentException("Image is null!");
        }

        this.panel = panel;
        startPoint = new Point(x, y);
        stack = new Stack<>();
        queue = new Queue<>();
    }

    public void stackFill() throws InterruptedException {
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

            // Bordas e cores diferentes do target
            if (x < 0 || x >= m || y < 0 || y >= n || image.getRGB(x, y) != oldColor) {
                continue;
            }

            image.setRGB(x, y, newColor);
            panel.repaint();
            Thread.sleep(1);

            // 4 pixels adjacentes
            stack.push(new Point(x + 1, y));
            stack.push(new Point(x-1, y));
            stack.push(new Point(x, y+1));
            stack.push(new Point(x, y-1));
        }

        try {
            ImageIO.write(image, "jpg", new File("assets/output.jpg"));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void queueFill() throws InterruptedException {
        int newColor = 0xFF0000FF;
        int oldColor = image.getRGB(startPoint.x, startPoint.y);

        int n = image.getHeight();
        int m = image.getWidth();

        if (oldColor == newColor) {
            return;
        }

        queue.enqueue(startPoint);
        while (!queue.isEmpty()){
            Point point = queue.dequeue();
            int x = point.x;
            int y = point.y;

            // Bordas e cores diferentes do target
            if (x < 0 || x >= m || y < 0 || y >= n || image.getRGB(x, y) != oldColor) {
                continue;
            }

            image.setRGB(x, y, newColor);
            panel.repaint();
            Thread.sleep(1);

            // 4 pixels adjacentes
            queue.enqueue(new Point(x + 1, y));
            queue.enqueue(new Point(x-1, y));
            queue.enqueue(new Point(x, y+1));
            queue.enqueue(new Point(x, y-1));
        }

        try {
            ImageIO.write(image, "jpg", new File("assets/output.jpg"));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
