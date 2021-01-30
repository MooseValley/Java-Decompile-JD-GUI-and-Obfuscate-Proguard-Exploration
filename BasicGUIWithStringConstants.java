import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicGUIWithStringConstants extends JFrame
{
   public static final String PASSWORD_STR = "ABCD1234";

   private JLabel  passwordLabel         = new JLabel (" ");
   private JButton showPasswordButton    = new JButton ("Show Password");
   private JButton clearPasswordButton   = new JButton ("Clear");

   public BasicGUIWithStringConstants ()
   {
      setLayout (new FlowLayout() );

      add (showPasswordButton);
      add (clearPasswordButton);
      add (passwordLabel);

      showPasswordButton.addActionListener  (event -> showPassword() );
      clearPasswordButton.addActionListener (event -> clearPassword() );
   }

   private void showPassword()
   {
      passwordLabel.setText ("Password is: " + PASSWORD_STR );

      JOptionPane.showMessageDialog
         (BasicGUIWithStringConstants.this, "Password is: " + PASSWORD_STR,
         "Showing password ...",  JOptionPane.INFORMATION_MESSAGE);
   }

   private void clearPassword()
   {
      passwordLabel.setText ("Password is: CLEARED");
   }

   public static void main (String args[])
   {
      BasicGUIWithStringConstants myApp = new BasicGUIWithStringConstants ();
      myApp.setSize (550, 550);
      myApp.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      myApp.setVisible (true);
   } // public static void main

} // public class BasicGUIWithStringConstants
