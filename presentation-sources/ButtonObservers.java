import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonObservers{
  private JButton theButton;
  private JFrame frame;
  
  public ButtonObservers(){
    initComponents();
    layoutComponents();
    frame.setVisible(true);
  }
  private void initComponents(){
    frame = new JFrame("Layout changer");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(500,500));
    theButton = new JButton("Hälärm");
    theButton.setFont(new Font("Arial", Font.PLAIN, 40));
    // Add a German panic button listener
    theButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
          System.out.println("Hilfe!");
        }
      });
    // Add a Swedish panic button listener
    theButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
          System.out.println("Hjälp!");
        }
      });
    // Add an English panic button listener
    theButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
          System.out.println("Help!");
        }
      });
    // Add a Spanish panic button listener
    theButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
          System.out.println("Socorro!");
        }
      });
  }
  private void layoutComponents(){
    frame.add(theButton, BorderLayout.CENTER);
    frame.pack();
  }
  public static void main(String[] args){
    new ButtonObservers();
  }
}
