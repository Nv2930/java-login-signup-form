import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.loginpackage.SIGN_UP_FORM;

class LOG_IN_FORM extends JFrame implements ActionListener {
    JLabel imgLabel, l1, l2, l3, l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;
    
    // Database credentials
    public static String url = "jdbc:mysql://localhost:3306/UsersDatabase";
    public static String username = "root";
    public static String dbPassword = "nisha@1979"; // Renamed for clarity

    LOG_IN_FORM() {
        // Frame settings
        setTitle("Nexify");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Icons & images
        ImageIcon icon = new ImageIcon("n.png");
        setIconImage(icon.getImage());

        ImageIcon img = new ImageIcon("whitepic.webp");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 400, 500);
        add(imgLabel);

        // Labels & Textfields
        l1 = new JLabel("Login Form");
        l1.setBounds(100, 60, 180, 35);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.BLACK);
        imgLabel.add(l1);

        l2 = new JLabel("Email");
        l2.setBounds(70, 130, 100, 25);
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setForeground(Color.BLACK);
        imgLabel.add(l2);

        t1 = new JTextField();
        t1.setBounds(70, 160, 250, 30);
        t1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t1.setFont(new Font("Arial", Font.PLAIN, 17));
        imgLabel.add(t1);

        l3 = new JLabel("Password");
        l3.setBounds(70, 190, 100, 25);
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setForeground(Color.BLACK);
        imgLabel.add(l3);

        p1 = new JPasswordField();
        p1.setBounds(70, 215, 250, 30);
        p1.setFont(new Font("Arial", Font.PLAIN, 17));
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        imgLabel.add(p1);

        // Buttons
        b1 = new JButton("Log in");
        b1.setFont(new Font("Arial", Font.PLAIN, 18));
        b1.setBounds(70, 270, 250, 30);
        b1.setBackground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        imgLabel.add(b1);

        b1.addActionListener(this);

        l4 = new JLabel("OR");
        l4.setBounds(180, 290, 50, 50);
        l4.setForeground(Color.BLACK);
        imgLabel.add(l4);

        b2 = new JButton("REGISTER");
        b2.setFont(new Font("Arial", Font.PLAIN, 18));
        b2.setBounds(70, 330, 250, 30);
        b2.setBackground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        imgLabel.add(b2);

        b2.addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String user_email = t1.getText();
            String user_password = new String(p1.getPassword()); // Renamed for clarity

            String query = "SELECT * FROM users_data_table WHERE email=? AND user_password=?";

            try {
                // Load & register the driver; create the connection
                Connection con = DriverManager.getConnection(url, username, dbPassword);

                // Prepare the statement
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, user_email);
                ps.setString(2, user_password);

                // Execute the query
                ResultSet r = ps.executeQuery();

                // Check if a result was returned
                if (r.next()) {
                    JOptionPane.showMessageDialog(null, "User Successfully logged in", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Perform any additional actions after successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }

                // Clean up
                r.close();
                ps.close();
                con.close();
            }catch (SQLException s){
                s.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(ae.getSource()==b2){
            SIGN_UP_FORM s=new SIGN_UP_FORM(); 
        }
    }
}
public class LogInForm {
    public static void main(String[] args) {
        LOG_IN_FORM l1 = new LOG_IN_FORM();
    }
}