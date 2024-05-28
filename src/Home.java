package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    //constructor
    Home(){
        
        setLayout(null); //for not using layouts of swing.
        
        //Adding  icons or images.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));//creating imageicon class.and adding img from icons.
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT); //scalling image and store in i2.
        ImageIcon i3 = new ImageIcon(i2);// converting img into img icon.
        //cannot add img directly so create JLabel object.
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image); // adding image component in frame.
        
        //JLabel class is use to write/display on frame.
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); // this is component.
        heading.setBounds(300,30,600,40); //setting position(left,top) and component (length,width).
        heading.setFont(new Font("Raleway",Font.BOLD,30)); //for setting font style and font size.
        heading.setForeground(Color.white); //for setting font color.
        image.add(heading);
        
      //Adding Buttons on Home Page.
      
        add = new JButton("Add Employee");
        add.setBounds(350,120,150,40);
        add.addActionListener(this); // adding click event to this button.
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(600,120,150,40);
        view.addActionListener(this); // adding click event to this button.
        image.add(view);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(350,210,150,40);
        remove.addActionListener(this); // adding click event to this button.
        image.add(remove);
        
        update = new JButton("Update Employee");
        update.setBounds(600,210,150,40);
        update.addActionListener(this); // adding click event to this button.
        image.add(update);
        
        //size of Frame...
        setSize(1120,630);
        setLocation(150,100); //250
        setVisible(true);
    }
    
    //method override -On clicking login button this function will call.
    public void actionPerformed(ActionEvent ae){
        //if add button is click following object will call its class.
        if(ae.getSource() == add ){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == remove){
            setVisible(false);
            new RemoveEmployee();
        }
        else{
            setVisible(false);
            new ViewEmployee();
        }
    }
    
    public static void main(String args[]){
        new Home();//object.
    }
}
