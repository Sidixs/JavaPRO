import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class KeyEventApplication extends JFrame implements KeyListener {
    String str;
    KeyEventApplication() {
        addKeyListener(…);
    }
    public static void main(String[] args) {
        KeyEventApplication frame = new KeyEventApplication();
        frame.setTitle("KeyEventApplication");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed: " + e);
    }
    public void keyTyped(KeyEvent e) {
        str = e.getKeyChar() + "";
        System.out.println("Key Typed: " + str);
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released: " + e);
    }
}