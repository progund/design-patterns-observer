import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates the observer pattern, in that
 * it shows how a JButton in Swing can have multiply action listenters.
 */
public class ButtonObservers {
  private JButton theButton;
  private JFrame frame;

  /**
   * Constructs a new ButtonObservers object,
   * initializes its components, does the layout
   * and shows the containing JFrame.
   */
  public ButtonObservers() {
    initComponents();
    layoutComponents();
    frame.setVisible(true);
  }
  
  private void initComponents() {
    frame = new JFrame("Multi-lingual Panic Button");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(500,500));
    theButton = new JButton("Hälärm");
    theButton.setFont(new Font("Arial", Font.PLAIN, 40));
    // Add a German panic button listener
    theButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          System.out.println("Hilfe!");
        }
      });
    // Add a Swedish panic button listener
    theButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          System.out.println("Hjälp!");
        }
      });
    // Add an English panic button listener
    theButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          System.out.println("Help!");
        }
      });
    // Add a Spanish panic button listener
    theButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          System.out.println("Socorro!");
        }
      });

    // Using lambda to add an action listener:
    theButton.addActionListener( e -> System.out.println("Au secours!") );
  }
  
  private void layoutComponents() {
    frame.add(theButton, BorderLayout.CENTER);
    frame.pack();
  }

  // Main creates an instance of ButtonObservers
  public static void main(String[] args) {
    new ButtonObservers();
  }
}
