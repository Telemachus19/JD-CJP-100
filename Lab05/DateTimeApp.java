package Lab05;

import javax.swing.*; // For JFrame, JLabel
import java.awt.*; // For BorderLayout
import java.util.Date; // For Date

public class DateTimeApp extends JFrame implements Runnable {

    // Class members
    Thread th;
    Date d = new Date();
    JLabel timeLabel = new JLabel();

    public DateTimeApp() {
        this.setTitle("Date & Time Frame Application");

        // Essential: Ensures the app process stops when you close the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        // Set initial font to make it readable (Optional)
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setText(d.toString());

        this.add(timeLabel, BorderLayout.CENTER);

        // Create and start the thread
        th = new Thread(this);
        th.start();
    }

    public static void main(String[] args) {
        DateTimeApp app = new DateTimeApp();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Update the time
                d = new Date();
                timeLabel.setText(d.toString());

                // Pause for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the interruption
                System.out.println("Thread interrupted!");
                break; // Exit the loop if interrupted
            }
        }
    }
}