package employee.management.system;

import javax.swing.*; //package for creating frame.
import java.awt.*;  //color class is present in awt package.
import java.awt.event.*; // for adding actionListener.(events to buttons).
import java.sql.*; // for importing ResultSet.

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphone,tfaadhar,tfemail,tfdesignation;// globlly declaration of textFields.
    JButton back,add; // globlly declaration of buttons.
    JLabel lblempId; // globlly declaration of empId.
    String empId;
    
    //constructor
    UpdateEmployee(String empId){
        this.empId = empId;
        //accessing frame - getContentPane().
        getContentPane().setBackground(Color.WHITE); // setting color of frame.
        
        setLayout(null); //for not using layouts of swing.
        
    //for Heading...........
        //JLabel class is use to write/display on frame.
        JLabel heading = new JLabel("Update Employee Details"); // this is component.
        heading.setBounds(310,30,500,50); //setting position(left,top) and component (length,width).
        heading.setFont(new Font("serif",Font.BOLD,25)); //for setting font style and font size.
       // heading.setForeground(Color.red); //for setting font color.
        add(heading); // adding component on frame.
        
    // for inputs....
        //For Name.
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
            //for input box.
        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        //for Father's Name.
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
           //for input box.
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //For BirthDate
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
           //for input box As Calender.
        JLabel lbldob = new JLabel(); //object for creating calender.
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        //for Salary.
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
           //input box for salary.
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        //for Address.
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
           //input box for Address.
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //for Phone.
        JLabel labelphone = new JLabel("Phone No");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
           //input box for phone no.
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        //for Email..
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
           //input box for Email.
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //for Education.
        JLabel labeleducation = new JLabel("Higher Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
           //dropDown for Education.
        //ARRAY for inputs in dropDown.
        tfeducation = new JTextField();
        //cbeducation.setAction(a);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
         //for Designation.
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
           //input box for Designation.
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        //for Aadhar.
        JLabel labelaadhar = new JLabel("Aadhar No");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
           //input box for Aadhar no.
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
            Conn c = new Conn();
            String query = "SELECT *FROM employee WHERE empId = '"+ empId +"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Adding Buttons on Page.
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this); // adding click event to this button.
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this); // adding click event to this button.
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        //for frame of AddEmployee..
        setSize(900,700);
        setLocation(220,50);
        setVisible(true);
    }
    
    //method override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            //taking inputs from above after add buttons.
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            //Storing above input in database.
            try{
                Conn conn = new Conn();//creating connection class's Object.
                
                //query to add data in DBMS.
                String query ="UPDATE employee SET fname = '" + fname + "', salary = '"+ salary +"' , address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' WHERE empId = '"+empId+"'";           
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Home();
            }   
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
     public static void main (String args[]){
        new UpdateEmployee(""); //object
    }
}
