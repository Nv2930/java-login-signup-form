// Java SignUp Form;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class SIGN_UP_FORM extends JFrame{
    JLabel l5, l6, l7, l8,imgLabel2, imgLabel3, imgLabel4;
    JTextField t2, t3, t4, t5;
    JRadioButton r1, r2, r3;
    JComboBox<Integer> c1, c3;  
    JComboBox<String> c2;
    JButton b3, hiddenButton;
    ButtonGroup bg;
    String placeholder2="first name", placeholder3="last name", placeholder4="email",  placeholder5="create password";
    JOptionPane j2;
    SIGN_UP_FORM(){
        //-----------------------Coding For Frame------------------------------------------
        setTitle("Nexify");
        setSize(500, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //===========================Coding for icon & images=================================
        hiddenButton=new JButton();
        hiddenButton.setBounds(0, 0, 0,0);
        add(hiddenButton);
        hiddenButton.requestFocusInWindow();

        //To change JFrame Icon-
        ImageIcon icon1=new ImageIcon("n.png");
        setIconImage(icon1.getImage());

        //To change JFrame Background Image-
        ImageIcon img=new ImageIcon("whitepic.wpeg");
        imgLabel2=new JLabel(img);
        imgLabel2.setBounds(0, 0, 500, 600);
        add(imgLabel2);

        //To add Icons to the JFrame-
        ImageIcon icon2=new ImageIcon("question-mark.png");
        Image i=icon2.getImage();
        Image i2=i.getScaledInstance(19, 16, Image.SCALE_SMOOTH);
        icon2=new ImageIcon(i2);
        imgLabel3=new JLabel(icon2);
        imgLabel3.setBounds(104, 293, 19, 16);
        imgLabel2.add(imgLabel3);

        ImageIcon icon3=new ImageIcon("question-mark.png");
        Image i4=icon3.getImage();
        Image i5=i4.getScaledInstance(17, 15, Image.SCALE_SMOOTH);
        icon3=new ImageIcon(i5);
        imgLabel4=new JLabel(icon3);
        imgLabel4.setBounds(70, 372, 17, 15);
        imgLabel2.add(imgLabel4);

        //--------------------------Coding for Labels----------------------------------------

        l5=new JLabel("Create a new Account");
        l5.setBounds(90, 50, 320, 45);
        l5.setFont(new Font("arial",Font.BOLD, 30));
        l5.setForeground(Color.BLACK);
        imgLabel2.add(l5);
             
        l6=new JLabel("it's quick and easy");
        l6.setBounds(165, 85, 200, 25);
        l6.setFont(new Font("Arial", Font.PLAIN, 17));
        l6.setForeground(Color.BLACK);
        imgLabel2.add(l6);

        l7=new JLabel("Date of Birth");
        l7.setBounds(10,290,150, 25);
        l7.setFont(new Font("Arial", Font.PLAIN, 17));
        l7.setForeground(Color.BLACK);
        imgLabel2.add(l7);

        l8=new JLabel("Gender");
        l8.setBounds(10,367,80, 25);
        l8.setFont(new Font("Arial", Font.PLAIN, 17));
        l8.setForeground(Color.BLACK);
        imgLabel2.add(l8);

    
        //----------------------------Coding For TextFields---------------------------------------
        t2=new JTextField(placeholder2);
        t2.setBounds(10,120, 210, 40);
        t2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setForeground(Color.GRAY);
        imgLabel2.add(t2);

        t3=new JTextField(placeholder3);
        t3.setBounds(250, 120, 210, 40);
        t3.setFont(new Font("Arial", Font.PLAIN, 20));
        t3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        t3.setForeground(Color.GRAY);
        imgLabel2.add(t3);

        t4=new JTextField(placeholder4);
        t4.setBounds(10, 175, 450, 40);
        t4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        t4.setFont(new Font("Arial", Font.PLAIN, 20));
        t4.setForeground(Color.GRAY);
        imgLabel2.add(t4);

        t5=new JTextField(placeholder5);
        t5.setBounds(10, 225, 450, 40);
        t5.setFont(new Font("Arial", Font.PLAIN, 20));
        t5.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        t5.setForeground(Color.GRAY);
        imgLabel2.add(t5);

        t2.addFocusListener(new TestFocusListener2());
        t3.addFocusListener(new TestFocusListener3());
        t4.addFocusListener(new TestFocusListener4());
        t5.addFocusListener(new TestFocusListener5());

        
        //-----------------------------------CODING FOR RADIOBUTTONS-------------------------------
        r1=new JRadioButton("Female");
        r1.setBounds(10, 400, 100, 25);
        r1.setFont(new Font("Arial", Font.BOLD, 16));
      

        r2=new JRadioButton("Male");
        r2.setBounds(140, 400, 100, 25);
        r2.setFont(new Font("Arial", Font.BOLD, 16));

        r3=new JRadioButton("Other");
        r3.setBounds(270, 400, 100, 25);
        r3.setFont(new Font("Arial", Font.BOLD, 16));
        
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        imgLabel2.add(r1);
        imgLabel2.add(r2);
        imgLabel2.add(r3);


        //===============================Coding for Comboboxes===============================================
        //----------------------combobox for dates----------
        Integer date_arr[];
        date_arr=new Integer[31];
        for(int j=0; j<31; j++){
           date_arr[j]=j+1;
        }

        c1=new JComboBox<>(date_arr);
        c1.setBounds(10, 320, 100, 25);
        c1.setFont(new Font("Arial", Font.PLAIN, 15));
        imgLabel2.add(c1);


        //--------------------------combobox for months----------------
        String str[]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        c2=new JComboBox<>(str);
        c2.setBounds(140, 320, 100, 25);
        c2.setFont(new Font("Arial", Font.PLAIN, 15));
        imgLabel2.add(c2);


        //--------------------------combobox for years-------------------
        Integer years_arr[];
        years_arr=new Integer[75];
        for(int k=0; k<75; k++){
            years_arr[k]=k+1950;
        }

        c3=new JComboBox<>(years_arr);
        c3.setBounds(270, 320, 100, 25);
        c3.setFont(new Font("Arial", Font.PLAIN, 15));
        imgLabel2.add(c3);


        //------------------------------------CODING FOR BUTTONS---------------------------------------
        b3=new JButton("Sign Up");
        b3.setBounds(150, 475, 150, 43);
        b3.setFont(new Font("Helvetica", Font.BOLD, 25));
        b3.setBackground(Color.white);
        b3.setForeground(Color.BLACK);
        imgLabel2.add(b3);

        b3.addActionListener(new TestSign_UP_Button());


        setVisible(true);
    }    
    class TestFocusListener2 implements FocusListener{
        public void focusGained(FocusEvent f2){
            if(t2.getText().equals(placeholder2)){
                t2.setText("");
                t2.setForeground(Color.BLACK);
            }
        }
        public void focusLost(FocusEvent f2){
            if(t2.getText().isEmpty()){
                t2.setText(placeholder2);
                t2.setForeground(Color.gray);
            }
        }
    }
    class TestFocusListener3 implements FocusListener{
        public void focusGained(FocusEvent f3){
            if(t3.getText().equals(placeholder3)){
                t3.setText("");
                t3.setForeground(Color.BLACK);
            }
        }
        public void focusLost(FocusEvent f3){
            if(t3.getText().isEmpty()){
                t3.setText(placeholder3);
                t3.setForeground(Color.gray);
            }
        }
    }
    class TestFocusListener4 implements FocusListener{
        public void focusGained(FocusEvent f4){
            if(t4.getText().equals(placeholder4)){
                t4.setText("");
                t4.setForeground(Color.BLACK);
            }
        }
        public void focusLost(FocusEvent f4){
            if(t4.getText().isEmpty()){
                t4.setText(placeholder4);
                t4.setForeground(Color.gray);
            }
        }
    }
    class TestFocusListener5 implements FocusListener{
        public void focusGained(FocusEvent f5){
            if(t5.getText().equals(placeholder5)){
                t5.setText("");
                t5.setForeground(Color.BLACK);
            }
        }
        public void focusLost(FocusEvent f5){
            if(t5.getText().isEmpty()){
                t5.setText(placeholder5);
                t5.setForeground(Color.gray);
            }
        }
    }
    class TestSign_UP_Button implements ActionListener{
        String url="jdbc:mysql://localhost:3306/UsersDatabase";
        String username="root";
        String password="nisha@1979";
        String query="INSERT INTO users_data_table(first_name, last_name, email, user_password,date_of_birth, gender) VALUES (?, ?, ?, ?, ?, ?)";
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b3){
                String first_name=t2.getText();
                String last_name=t3.getText();
                String email=t4.getText();
                String userPassword=t5.getText();
                String yyyy=c3.getSelectedItem().toString();
                String mm=c2.getSelectedIndex()+1+"";
                String dd=c1.getSelectedItem().toString();

                String dob=yyyy.concat("-").concat(mm).concat("-").concat(dd);
                String gender;

                j2=new JOptionPane();

                if(r1.isSelected()){
                    gender="Female";
                }
                else if(r2.isSelected()){
                    gender="Male";
                }
                else{
                    gender="other";
                }

                try{
                    //step1: register and load the driver
                    //step2: create the connection
                    Connection con=DriverManager.getConnection(url, username, password);
                    System.out.println("successfully connected to the database");

                    //step3: create the object of statement interface
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1, first_name);
                    ps.setString(2, last_name);
                    ps.setString(3, email);
                    ps.setString(4, userPassword);
                    ps.setString(5, dob);
                    ps.setString(6, gender);

                    //step4: execute the query
                    int i=ps.executeUpdate();
                    if(i>0){
                        j2.showMessageDialog(null, "successfully inserted data", "DialogBox", j2.INFORMATION_MESSAGE, null);
                    }
                    else{
                        j2.showMessageDialog(null, "Signup failed", "DialogBox",j2.ERROR_MESSAGE, null);
                    }

                    //step5: close the connection;
                    ps.close();
                    con.close();

                }
                catch(SQLException s){
                    s.printStackTrace();
                }

            }
        }
    }
}