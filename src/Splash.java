package employee.management.system;

import javax.swing.*; //package for creating frame.
import java.awt.*; //color class is present in awt package.
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener { //interface for click event (implements ActionListener).
    //creating frame.
    //constructor - is created when object is created.
    Splash(){
        //accessing frame - getContentPane().
        getContentPane().setBackground(Color.WHITE); // setting color of frame.
        
        setLayout(null); //for not using layouts of swing.
        
        //JLabel class is use to write/display on frame.
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); // this is component.
        heading.setBounds(80,30,1200,60); //setting position(left,top) and component (length,width).
        heading.setFont(new Font("serif",Font.PLAIN,60)); //for setting font style and font size.
        heading.setForeground(Color.white); //for setting font color.
        
        add(heading); // adding component on frame.
        
        //Adding  icons or images.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front1.jpg"));//creating imageicon class.and adding img from icons.
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT); //scalling image and store in i2.
        ImageIcon i3 = new ImageIcon(i2);// converting img into img icon.
        //cannot add img directly so create JLabel object.
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image); // adding image component in frame.
        
        //creating ar adding button to frame.
        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBounds(400,250,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this); // adding click event to this button
        image.add(clickhere); //adding button element over img element.
        
        //for Frame
        setSize(1170,650); // length and breadth of frame.
        setLocation(100,50); // location(left,top). //200
        setVisible(true); // for displaying.
        
        //for blinking effect on heading
//        while(true){
//            heading.setVisible(false);//for hiding element.
//            try{
//                Thread.sleep(500); //it takes times in millisecond to stop.
//            }
//            catch(Exception e){
//                
//            }
//            heading.setVisible(true);
//             try{
//                Thread.sleep(500); //it takes times in millisecond to stop.
//            }
//            catch(Exception e){
//                
//            }
//        }
        
    }
    //method overriding - for visiting login frame.
    public void actionPerformed(ActionEvent ae){
        setVisible(false); // on clicking button this frame will close and...
        new Login(); //for opening login frame - creating object of login class.
                    // on creating object it call constructor for login.And Login frame will open.
    }
    public static void main (String args[]){
        //creating object
        new Splash();
    }
    
}
