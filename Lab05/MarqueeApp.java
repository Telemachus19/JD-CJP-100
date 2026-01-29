package Lab05;

import javax.swing.*;
import java.awt.*;

public class MarqueeApp extends JFrame implements Runnable {

    Thread th;
    JLabel label;
    String message = "Hello Java World! Moving from the edge...";
    int x, y;

    public MarqueeApp() {
        this.setTitle("Marquee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.setLayout(null);

        label = new JLabel(message);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        label.setSize(label.getPreferredSize());

        x = this.getWidth();
        y = 150;

        label.setLocation(x, y);
        this.add(label);

        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        MarqueeApp app = new MarqueeApp();
        app.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                x = x - 30;
                if (x + label.getWidth() < 0) {
                    x = this.getWidth();
                }
                label.setLocation(x, y);
                Thread.sleep(50);

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                break;
            }
        }
    }
}