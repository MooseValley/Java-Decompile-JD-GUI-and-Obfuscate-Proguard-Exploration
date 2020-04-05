/*
Author: Moose O'Malley
File:   SimpleGUI.java
Descr:  A really simple GUI application to help demonstrate
        basic Java decompiling and basic objuscation.
*/

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.*;

public class SimpleGUI extends JFrame
{
   // Constants
   public static final String  APPLICATION_NAME_VERSION     = "SimpleGUI – v0.001";
   private static final int    FRAME_WIDTH                  = 950;
   private static final int    FRAME_HEIGHT                 = 550;
   private static final SimpleDateFormat DD_MMM_YYYY_FORMAT = new SimpleDateFormat ("dd-MMM-yyyy");

   // GUI Components
   private JLabel      applicationTitleLabel           = new JLabel       (" " + APPLICATION_NAME_VERSION + " ");
   private JTextArea   logTextArea                     = new JTextArea    ();
   private JScrollPane logTextAreaScrollPane           = new JScrollPane  (logTextArea);
   private JTextField  inputTextField                  = new JTextField   (30);
   private JButton     addButton                       = new JButton      ("Add",   new ImageIcon ("icons\\add.gif") );
   private JButton     resetButton                     = new JButton      ("Reset", new ImageIcon ("icons\\reset.gif") );
   private JButton     aboutButton                     = new JButton      ("About", new ImageIcon ("icons\\help.gif") );
   private JButton     exitButton                      = new JButton      ("Exit",  new ImageIcon ("icons\\exit.png") );

   public SimpleGUI()
   {
      // Set Window Title Bar text.
      super (APPLICATION_NAME_VERSION);

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      // *** Construct GUI ***
      setLayout (new BorderLayout());

      // Create main panel and add it to CENTER region of user JFrame:
      add (createMainPanel(),  BorderLayout.CENTER);
   }

   public JPanel createMainPanel()
   {
      JPanel thePanel        = new JPanel (new BorderLayout() );
      JPanel titlePanel      = new JPanel (new FlowLayout (FlowLayout.CENTER) );
      JPanel inputPanel      = new JPanel (new FlowLayout (FlowLayout.CENTER) );
      JPanel buttonPanel     = new JPanel (new FlowLayout (FlowLayout.CENTER) );
      JPanel southPanel      = new JPanel (new FlowLayout (FlowLayout.CENTER) );

      // Add GUI components to main panel:
      applicationTitleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
      titlePanel.add (applicationTitleLabel);

      inputPanel.add (new JLabel ("Input: ") );
      inputPanel.add (inputTextField);

      buttonPanel.add (addButton);
      buttonPanel.add (resetButton);
      buttonPanel.add (aboutButton);
      buttonPanel.add (exitButton);

      southPanel.add (inputPanel);
      southPanel.add (new JLabel ("    "));
      southPanel.add (buttonPanel);

      thePanel.add (titlePanel,             BorderLayout.NORTH);
      thePanel.add (logTextAreaScrollPane,  BorderLayout.CENTER);
      thePanel.add (southPanel,             BorderLayout.SOUTH);

      // Activate buttons:
      addButton.addActionListener   (event -> addToLog () );
      resetButton.addActionListener (event -> resetLog () );
      aboutButton.addActionListener (event -> showHelpDialog () );
      exitButton.addActionListener  (event -> exitApplication () );

      return thePanel;
   }

   private void addToLog ()
   {
      logTextArea.append (inputTextField.getText () + "\n");
   }

   private void resetLog ()
   {
      logTextArea.setText ("");
   }

   private void showHelpDialog ()
   {
      JOptionPane.showMessageDialog (SimpleGUI.this, APPLICATION_NAME_VERSION + "\n" +
                                     "by Moose", "About ...", JOptionPane.INFORMATION_MESSAGE);
   }

   private void exitApplication ()
   {
      System.out.println ("Exiting application ... have a nice day !");
      System.exit (0); // All OK.
   }

   public static void main (String args[])
   {
      SimpleGUI myApp = new SimpleGUI ();

      myApp.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      myApp.setLocation (15, 15);
      myApp.setSize     (FRAME_WIDTH, FRAME_HEIGHT);
      myApp.setVisible  (true);
   } // public static void main

} // public class SimpleGUI