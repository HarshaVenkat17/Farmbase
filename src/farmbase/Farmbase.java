package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
/**
 *
 * @author HarshaVenkat
 */
public class Farmbase implements ActionListener
{   
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JFrame frame;
    JPanel panel;
    JLabel l1,l2,det;
    int FID;
    Farmbase(int FID)
    {   
        
        this.FID=FID;
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font fontl=new Font("Verdana",Font.BOLD,20);
        Font font=new Font("Verdana",Font.BOLD,20);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
   
        b1=new JButton("Field details");
        b1.setBounds(200, 280,300,35);
        b2=new JButton("Machines & Security");
        b2.setBounds(200, 350,300, 35);
        b3=new JButton("Crop Diseases");
        b3.setBounds(200, 420,300, 35);
        b4=new JButton("Warehouses");
        b4.setBounds(200,490,300, 35);
        b5=new JButton("Workers Available");
        b5.setBounds(800, 280,300, 35);
        b6=new JButton("My Contracts");
        b6.setBounds(800, 350,300, 35);
        b7=new JButton("Help");
        b7.setBounds(800, 420,300, 35);
        b8=new JButton("Exit");
        b8.setBounds(800, 490,300, 35);
       
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall2.jpg"))));
            l2.setBounds(0,-50,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
       
        l2.add(b1);l2.add(b2);l2.add(b3);l2.add(b4);l2.add(b5);
        l2.add(b6);l2.add(b7);l2.add(b8);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
        b4.addActionListener(this);b5.addActionListener(this);b6.addActionListener(this);
        b7.addActionListener(this);b8.addActionListener(this);        
        panel.add(l2);    
        frame.setVisible(true);   
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        char ch;
        if(e.getSource()==b1)
        {   
            try
            {
                Database db=new Database('v',FID,"1");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b2)
        {   
            frame.dispose(); 
            sub1 sb1=new sub1(FID);
        }
        if(e.getSource()==b3)
        {   
            try
            {
                Database db=new Database('v',FID,"3");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b4)
        {   
            try
            {
                Database db=new Database('v',FID,"4");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b5)
        {   
            try
            {
                Database db=new Database('v',FID,"5");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b6)
        {   
            try
            {
                Database db=new Database('v',FID,"6");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b7)
        {   
            frame.dispose(); 
            sub2 sb2=new sub2(FID);
        }
        if(e.getSource()==b8)
        { 
            frame.dispose();
        }
    }
    void viewer(int a,String b,double c, String d)
    {   
        det=new JLabel();
        det.setForeground(Color.WHITE);
        det.setText("ID:    "+a+"    Name:"+b+"     Area Owned: "+c+"     Village:"+d);
        det.setBounds(200,600,800, 35);
        l2.add(det);
    }
    public static void main(String[] args) throws SQLException 
    {
        Login l=new Login();
    }
}