/*import java.awt.*;
import java.awt.event.*;

  // this is counter using(AWT components, (Abstract Window Toolkit).

public class Counter {
    private Frame mainFrame;
    private Label counterLabel;
    private Button countButton, resetButton;
    private int counterValue = 0;

    public Counter() {
        prepareGUI();
    }
    private void prepareGUI() {
        // Set up the main frame
        mainFrame = new Frame("Counter App");
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setBackground(Color.LIGHT_GRAY);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Create and style the counter label
        counterLabel = new Label("0", Label.CENTER);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 30));
        counterLabel.setBackground(Color.WHITE);
        counterLabel.setForeground(Color.BLUE);

        // Use a panel with a centered layout for the counter label
        Panel counterPanel = new Panel(new BorderLayout());
        counterPanel.add(counterLabel, BorderLayout.CENTER);

        // Create and style the Count button
        countButton = new Button("Count");
        countButton.setFont(new Font("Arial", Font.BOLD, 18));
        countButton.setBackground(Color.GREEN);
        countButton.setForeground(Color.WHITE);

        // Create and style the Reset button
        resetButton = new Button("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);

        // Add action listeners for the buttons
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counterValue++;
                counterLabel.setText(String.valueOf(counterValue));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counterValue = 0;
                counterLabel.setText(String.valueOf(counterValue));
            }
        });

        // Use a panel for the buttons
        Panel buttonPanel = new Panel(new FlowLayout());
        buttonPanel.add(countButton);
        buttonPanel.add(resetButton);

        // Add components to the frame
        mainFrame.add(counterPanel, BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Counter();
 
    }
}
*/

// this time we will use Swing components
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private JTextField counterField;
    private JButton countButton, resetButton;
    private int counterValue = 0;

    public CounterApp() {
        // Set up the frame
        setTitle("Swing Counter Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and style the counter text field
        counterField = new JTextField("0", 10);
        counterField.setFont(new Font("Arial", Font.BOLD, 30));
        counterField.setHorizontalAlignment(JTextField.CENTER);
        counterField.setEditable(false);
        counterField.setBackground(Color.WHITE);
        counterField.setForeground(Color.BLUE);

        // Create and style the "Count" button
        countButton = new JButton("Count");
        countButton.setFont(new Font("Arial", Font.BOLD, 18));
        countButton.setBackground(Color.GREEN);
        countButton.setForeground(Color.WHITE);

        // Create and style the "Reset" button
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);

        // Add action listeners for the buttons
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValue++;
                counterField.setText(String.valueOf(counterValue));
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValue = 0;
                counterField.setText(String.valueOf(counterValue));
            }
        });

        // Add components to the frame
        add(counterField);
        add(countButton);
        add(resetButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create and show the Swing application
        SwingUtilities.invokeLater(() -> new CounterApp());
    }
}
*/

//this lesson review

import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.ArrayList;

public class Counter {
    private static ArrayList<String> clickHistory = new ArrayList<>();

    public static void main(String[] args) {
        // Creating Frame GUI
        Frame fCounter = new Frame();
        fCounter.setTitle("Java GUI Counter");
        fCounter.setSize(700, 500);
        fCounter.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        fCounter.setBackground(Color.LIGHT_GRAY);

        // Adding a Label on Frame
        Label lblTitle = new Label("GUI COUNTER");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBackground(Color.WHITE);
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setAlignment(Label.CENTER); // Align the text in the center
        fCounter.add(lblTitle);

        // Creating TextField
        JTextField txtCounter = new JTextField("0", 20);
        txtCounter.setFont(new Font("Arial", Font.BOLD, 30));
        txtCounter.setBackground(Color.WHITE); // Background color for TextField
        txtCounter.setForeground(Color.BLUE);  // Text color for TextField
        txtCounter.setEditable(false);  // non-editable 
        txtCounter.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        fCounter.add(txtCounter);

        // Creating Buttons
        Button btnReset = new Button("Reset");
        btnReset.setFont(new Font("Arial", Font.BOLD, 30));
        btnReset.setBackground(Color.RED);
        btnReset.setForeground(Color.BLACK);
        fCounter.add(btnReset);

        Button btnCount = new Button("Count");
        btnCount.setFont(new Font("Arial", Font.BOLD, 30));
        btnCount.setBackground(Color.GREEN);
        btnCount.setForeground(Color.BLACK);
        fCounter.add(btnCount);

        // Adding ActionListener for Count Button
        btnCount.addActionListener(new ActionListener() {
            private int counterValue = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Manipulate variable textCounter
                String currentText = txtCounter.getText();
                int CurrentValue = Integer.parseInt(currentText);
                CurrentValue = CurrentValue + 1;
                txtCounter.setText(String.valueOf(CurrentValue));

                // Adding log the click event to the console
                String clickInfo = "Button Clicked; " + CurrentValue;
                clickHistory.add(clickInfo);
                System.out.println(clickInfo);
            }
        });

        // Adding ActionListener for Reset Button
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCounter.setText("0");
                clickHistory.clear();
                System.out.println("Counter reset.");
            }
        });

        // Adding Window Listener for Closing the Frame
        fCounter.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Set the Frame Visible
        fCounter.setVisible(true);
    }
}
