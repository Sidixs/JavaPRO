import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class TestJava extends JFrame implements ActionListener {
    JCheckBox cb1, cb2, cb3, cb4;
    JButton b1, b2;
    public TestJava(String title) {
        super(title);
        JLabel lab = new JLabel(" Question 1: Which syntax for creating an object
                named obj is correct ?");
                lab.setPreferredSize(new Dimension(640, 50));
        lab.setHorizontalAlignment(JLabel.CENTER);
        add(lab, "North");
        JPanel p1 = new JPanel(new GridLayout(4, 1));
        p1.setPreferredSize(new Dimension(320, 200));
        p1.setBorder(new EmptyBorder(10, 50, 50, 50));
        cb1 = new JCheckBox(" B obj = new B();");
        cb2 = new JCheckBox(" A obj = new A();");
        cb3 = new JCheckBox(" A obj = new B();");
        cb4 = new JCheckBox(" B obj = new A();");
        p1.add(cb1);
        p1.add(cb2);
        p1.add(cb3);
        p1.add(cb4);
        add(p1,"West");
        JPanel p2 = new JPanel();
        JTextArea area=new JTextArea("""
 class B {

 }

 public class A extends B {

 // here the line
 }
 """);
        area.setPreferredSize(new Dimension(220, 300));
        area.setBorder(new EmptyBorder(50, 50, 50, 50));
        p2.add(area);
        add(p2,"Center");
        JPanel p3 = new JPanel();
        b1 = new JButton("Ok");
        b2 = new JButton("Exit");
        b1.addActionListener(this);
        b2.addActionListener(this);
        p3.add(b1);
        p3.add(b2);
        add(p3,"South");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (cb1.isSelected() && cb2.isSelected() && !cb3.isSelected() &&
                    cb4.isSelected()) {
                JOptionPane.showMessageDialog(this, "Correct answer !
                        Congratulations");
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, wrong answer !
                        Try again");
            }
        } else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new TestJava("Java Test");
    }
}