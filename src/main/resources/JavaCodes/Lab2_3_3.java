package jp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FocusTest {
    JTextField tf1, tf2, tf3;
    public FocusTest() {
        JFrame f= new JFrame();
        Font font = new Font("Courier New", Font.BOLD, 30);
        tf1 = new JTextField();
        tf1.setFont(font);
        tf1.setBounds(50,50, 200,50);
        tf2 = new JTextField();
        tf2.setFont(font);
        tf2.setBounds(50,150, 200,50);
        tf3 = new JTextField();
        tf3.setFont(font);
        tf3.setBounds(50,250, 200,50);
        tf3.setEditable(false);
        MyKeyListener listener = new MyKeyListener();
        tf1.addKeyListener(listener);
        tf2.addKeyListener(listener);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.setTitle("FocusTest");
        f.setSize(350, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new FocusTest();
    }
    class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if ((e.getSource() == tf1) & (e.getKeyCode() == KeyEvent.VK_ENTER)) {
                tf3.setText(tf1.getText());
                tf1.setText("");
                tf2.requestFocus();
            } else if ((e.getSource() == tf2) & (e.getKeyCode() ==
                    KeyEvent.VK_ENTER)) {
                tf3.setText(tf2.getText());
                tf2.setText("");
                tf1.requestFocus();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}
