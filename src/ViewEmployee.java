package employee.management.system;
import javax.swing.*;//for frmaes.
import java.awt.*;  //color class is present in awt package.
import java.sql.*; // for importing ResultSet.
import net.proteanit.sql.DbUtils ;//for putting data from rs Object into Table.
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table; //creating table.
    Choice cemployeeId; //for dropDown.
    JButton search,print,update,back;
    
    //constructor
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for search employee by id
        JLabel searchlbl = new JLabel("Search by Employee id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        //for dropDown.
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        //For Displaying empId in DropDown.
        try{
            //hitting dataBase
            Conn c = new Conn();
            //for bringing data from dataBase.
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee"); //All data from dataBase will store in rs Object.
            
            //For looping all rows in col empId.for displaying id's in dropDown.
            while(rs.next()){
            cemployeeId.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();//printing exception.
        }

        //Inserting data in Table
        table = new JTable(); //creating object.
      
        try{
            //hitting dataBase
            Conn c = new Conn();
            //for bringing data from dataBase.
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee"); //All data from dataBase will store in rs Object.
            table.setModel(DbUtils.resultSetToTableModel(rs)); //putting all data from 'ResultSet rs' into 'table'. 
        }
        catch(Exception e){
            e.printStackTrace();//printing exception.
        }
        
        //for adding scroll bar over table.
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        //For Creating Search Buttons
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        //For Creating Print Buttons
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        //For Creating update Buttons
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        //For Creating back Buttons
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(220,50);
        setVisible(true);
    }
    
    //method override
    public void actionPerformed(ActionEvent ae){
        //if buttons are used
        if(ae.getSource() == search){
            String query = "SELECT *From employee WHERE empId = '"+ cemployeeId.getSelectedItem()+"' ";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == print){
            try{
               table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main (String args[]){
        new ViewEmployee(); //object
    }
}
