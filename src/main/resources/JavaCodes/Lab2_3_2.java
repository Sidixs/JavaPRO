import java.awt.event.*;
import javax.swing.*;
public class KeyListenerExample implements KeyListener {
    JFrame frame;
    public KeyListenerExample() {
        frame = new JFrame();
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed: " + e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released: " + e);
    }
    public static void main(String[] args) {
        KeyListenerExample keyListenerExample = new KeyListenerExample();
    }
}