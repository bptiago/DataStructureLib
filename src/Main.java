import swing.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedImage image = ImageIO.read(new File("assets/sample.png"));

        ImagePanel imagePanel = new ImagePanel(image);

        JFrame frame = new JFrame("Flood Fill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(image.getWidth(), image.getHeight());
        frame.add(imagePanel);
        frame.setVisible(true);

        Thread.sleep(300);

        FloodFill f = new FloodFill(
                image,
                imagePanel,
                100,
                100
        );
//        f.stackFill();
        f.queueFill();
    }
}