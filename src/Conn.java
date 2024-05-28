//connecting JDBC
package employee.management.system;
import java.sql.*; //for mysql connection interface.

public class Conn {
    
    //step 2.Creating the connection String.
    Connection c;  //interface for sql connection.
    //step 3.Creating Statement.
    Statement s;
    
    //creating constructor
    public Conn(){
        //Exception Handling - because MySql is External entity.
        try{
            //step 1.Register for driver Class.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2.Creating the connection String.
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root" ,"Virkar@2002"); 
            //step 3.Creating Statement.
            s = c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
