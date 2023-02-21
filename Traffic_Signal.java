import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 

public class Traffic_Signal
    extends JFrame implements ItemListener {
 
    // Setting the buttons for the layout
    JRadioButton jr1;
    JRadioButton jr2;
    JRadioButton jr3;
 
    // Setting the field area
    JTextField j1 = new JTextField(10);
    ButtonGroup b = new ButtonGroup();
    String msg = " ";
 
    
    int x = 0, y = 0, z = 0;
    public Traffic_Signal(String msg)
    {
        super(msg);
        setLayout(new FlowLayout());
 
        // Assigning name to the button declared above
        // with help of JRadioButton class
        jr1 = new JRadioButton("Red");
        jr2 = new JRadioButton("Yellow");
        jr3 = new JRadioButton("Green");
 
        jr1.addItemListener(this);
        jr2.addItemListener(this);
        jr3.addItemListener(this);
 
        add(jr1);
        add(jr2);
        add(jr3);
        b.add(jr1);
        b.add(jr2);
        b.add(jr3);
        add(j1);
 
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
 
    public void itemStateChanged(ItemEvent ie)
    {
        // If it is red
        if (ie.getSource() == jr1) {
            if (ie.getStateChange() == 1) {

                msg = "Stop!";
                x = 1;
 
                
                repaint();
            }
            else {
                msg = "";
            }
        }
 
        // If state is Orange or technically jr2
        if (ie.getSource() == jr2) {
            if (ie.getStateChange() == 1) {
 
                // Then display message-
                // Get ready in waiting state
                msg = "Get Ready to go!";
                y = 1;
 
                // Again repainting the button
                repaint();
            }
            else {
                msg = "";
            }
        }
 
        // If state is Green
        if (ie.getSource() == jr3) {
            if (ie.getStateChange() == 1) {
 
                // Then display message- Go
                msg = "Go!!";
                z = 1;
                repaint();
            }
            else {
                msg = "";
            }
        }
        j1.setText(msg);
    }
 
    
    public void paint(Graphics g)
    {
        g.drawRect(100, 105, 110, 270);
        g.drawOval(120, 150, 60, 60);
        g.drawOval(120, 230, 60, 60);
        g.drawOval(120, 300, 60, 60);
 
        
        if (x == 1) {
            g.setColor(Color.RED);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 300, 60, 60);
            x = 0;
        }
 
      
        if (y == 1) {
            g.setColor(Color.WHITE);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.YELLOW);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 300, 60, 60);
            y = 0;
        }
 
        
        if (z == 1) {
            g.setColor(Color.WHITE);
            g.fillOval(120, 150, 60, 60);
            g.setColor(Color.WHITE);
            g.fillOval(120, 230, 60, 60);
            g.setColor(Color.GREEN);
            g.fillOval(120, 300, 60, 60);
            z = 0;
        }
    }
 
 
    public static void main(String args[])
    {
        // Creating object of Jframe class inside main()
      
        JFrame jf = new Traffic_Signal("Traffic Light");
 
        jf.setSize(500, 500);
        jf.setVisible(true);
    }
}