import java.awt.event.*;
import javax.swing.*;
public class KeyListenerDemo {
    public static void main(String[] a) {
        JFrame frame = new JFrame("Popup JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField();
        textField.addKeyListener(new MyKeyListener());
        frame.add(textField);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
class MyKeyListener implements KeyListener {
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
    }
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyChar());
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }
}