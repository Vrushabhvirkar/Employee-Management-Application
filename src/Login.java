package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //Creating login Page...
    
    JTextField tfusername,tfpassword;
    // creating constructor
    Login(){
        
       getContentPane().setBackground(Color.WHITE); // setting color of login frame.
       setLayout(null); //for not using layouts of swing.
       
    //taking Input from User
       //for userName
       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(40,20,100,30);
       add(lblusername);
       //for userName textBox
       tfusername = new JTextField();
       tfusername.setBounds(150,20,150,30);
       add(tfusername);
       
       //for password
       JLabel lblpassword = new JLabel("Password");
       lblpassword.setBounds(40,70,100,30);
       add(lblpassword);
       //for password textBox
       tfpassword = new JTextField();
       tfpassword.setBounds(150,70,150,30);
       add(tfpassword);
       
       //creating ar adding button to frame.
        JButton login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); // adding click event to this button.
        add(login); //adding button .
        
        //Adding  icons or images.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));//creating imageicon class.and adding img from icons.
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //scalling image and store in i2.
        ImageIcon i3 = new ImageIcon(i2);// converting img into img icon.
        //cannot add img directly so create JLabel object.
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image); // adding image component in frame.
       
       setSize(600,300); //setting size of login frame.
       setLocation(400,200); // setting location of login frame //450.
       setVisible(true); //for displaying frame.
    }
    
    //step 4.Executing Mysql Queries...
    //On clicking login button this function will call.
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText(); //for getting input from username textBox.
            String password = tfpassword.getText(); //for getting input from password textBox.
            
            Conn c = new Conn(); //creating object for using calling execute query function.
            //MYSQL Query to check is value present in database. Creating MYSQL  query.
            String query = "SELECT *FROM login WHERE username = '" + username + "' AND password = '" + password + "' ";
            
            //step 4.Executing Mysql Queries...
            ResultSet rs = c.s.executeQuery(query);
            //if value present in ResultSet
            if(rs.next()){
                setVisible(false); // make login frame disable and traverse to other frame after login.
                //opening next class or frame after .
                new Home(); // creating object of home class,-so object will call constructor from Home class.
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(true);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
