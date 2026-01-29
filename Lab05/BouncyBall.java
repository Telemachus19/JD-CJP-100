package Lab05;

import javax.swing.*;
import java.awt.*;

public class BouncyBall extends JFrame implements Runnable {

    Thread th;
    int x = 50, y = 100, dx = 5, dy = 5, ballSize = 40;

    public BouncyBall() {
        this.setTitle("Bouncy One");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, ballSize, ballSize);
    }

    public static void main(String[] args) {
        BouncyBall app = new BouncyBall();
        app.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                moveBall();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void moveBall() {
        Insets insets = getInsets();
        int left = insets.left;
        int right = getWidth() - insets.right;
        int top = insets.top;
        int bottom = getHeight() - insets.bottom;

        x += dx;
        y += dy;

        if (x < left) {
            x = left;
            dx = -dx;
        }
        if (x + ballSize > right) {
            x = right - ballSize;
            dx = -dx;
        }
        if (y < top) {
            y = top;
            dy = -dy;
        }
        if (y + ballSize > bottom) {
            y = bottom - ballSize;
            dy = -dy;
        }
    }
}