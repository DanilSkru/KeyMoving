import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyMoving extends JFrame {
    JPanel panel = new JPanel();
    JLabel label_smile = new JLabel();
    int step = 50;
    int w = 500, h = 500, w_smile, h_smile;
    public KeyMoving() {
        super("KeyMoving");
        GUIkeyMoving();
    }
    public static void main(String arg[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                KeyMoving frame = new KeyMoving();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public void GUIkeyMoving() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(w, h);
        this.setResizable(false);
        panel.setLayout(null);
        panel.setFocusable(true);
        ImageIcon smile = new ImageIcon("smile.png");
        w_smile = smile.getIconWidth();
        h_smile = smile.getIconHeight();
        label_smile.setBounds(this.getWidth()/2-smile.getIconWidth()/2, this.getHeight()/2-smile.getIconHeight()/2, smile.getIconWidth(), smile.getIconHeight());
        label_smile.setIcon(smile);
        panel.add(label_smile);
        panel.setBackground(Color.WHITE);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                //System.out.println(e.getKeyText(e.getKeyCode()));
                switch (e.getKeyText(e.getKeyCode())) {
                    case "Left":
                        step = 50;
                        if (label_smile.getLocation().x - step < 0) {
                            step = label_smile.getLocation().x;
                        }
                        label_smile.setLocation(label_smile.getLocation().x - step, label_smile.getLocation().y);
                        break;
                    case "Up":
                        step = 50;
                        if (label_smile.getLocation().y - step < 0) {
                            step = label_smile.getLocation().y;
                        }
                        label_smile.setLocation(label_smile.getLocation().x, label_smile.getLocation().y - step);
                        break;
                    case "Right":
                        step = 50;
                        if (label_smile.getLocation().x + w_smile + step > w-10) {
                            step = w-10 - label_smile.getLocation().x - w_smile;
                        }
                        label_smile.setLocation(label_smile.getLocation().x + step , label_smile.getLocation().y);
                        break;
                    case "Down":
                        step = 50;
                        if (label_smile.getLocation().y + h_smile + step > h-33) {
                            step = h-33 - label_smile.getLocation().y - h_smile;
                        }
                        label_smile.setLocation(label_smile.getLocation().x, label_smile.getLocation().y + step);
                        break;
                }
            }
        });
        this.getContentPane().add(panel);
    }
}