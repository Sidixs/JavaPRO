import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseEventDemo extends JFrame implements MouseListener {
    JLabel display;
    public MouseEventDemo () {
        super("Mouse Events");
        display = new JLabel("", JLabel.CENTER);
        add(display,BorderLayout.PAGE_START);
        addMouseListener(this);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        MouseEventDemo demo = new MouseEventDemo();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mouseClicked(MouseEvent e) {
        display.setText("Clicked at location: "+location(e));
    }
    private String location(MouseEvent e) {
        return("(" + e.getX() + "," + e.getY() + ")");
    }
}
