import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    // Components for the login window
    private JPanel panel;
    private JLabel userLabel, passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor to set up the GUI
    public Login() {
        // Set window properties
        setTitle("System Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window on screen

        // Initialize panel with a grid layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create and add Username components
        userLabel = new JLabel("Username:");
        userTextField = new JTextField();
        panel.add(userLabel);
        panel.add(userTextField);

        // Create and add Password components
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        // Create and add Login Button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this); // Register click event
        panel.add(new JLabel()); // Empty placeholder for grid alignment
        panel.add(loginButton);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        // Validate the entered credentials
        if (username.equals("admin") && password.equals("password123")) {
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Pro tip: Add code here to open your main application screen
            this.dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
            // Clear fields for a retry
            userTextField.setText("");
            passwordField.setText("");
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        // Run GUI construction on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
