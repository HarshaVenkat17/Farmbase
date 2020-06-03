package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
public class sub2 implements ActionListener
{   
    JButton b1,b2,b3,b4,b5,b6;
    JFrame frame;
    JPanel panel;
    JLabel l1,l2,det1;
    int FID;
    sub2(int FID)
    {   
        
        this.FID=FID;
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font fontl=new Font("Verdana",Font.BOLD,30);
        Font font=new Font("Verdana",Font.BOLD,20);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
        b1=new JButton("Fertilizers");
        b1.setBounds(200, 320,300,35);
        b2=new JButton("Pesticides");
        b2.setBounds(200,400,300, 35);
        b3=new JButton("Fence");
        b3.setBounds(200, 480,300, 35);
        b4=new JButton("Consultant");
        b4.setBounds(800,320,300, 35);
        b5=new JButton("Loan");
        b5.setBounds(800,400,300, 35);
        b6=new JButton("Exit");
        b6.setBounds(800,480,300, 35);
        det1=new JLabel("For any technical help, please contact 9386986978");
        det1.setForeground(Color.white);
        det1.setBounds(200,600,1000,35);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall1.jpg"))));
            l2.setBounds(0,-50,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
        l2.add(b1);l2.add(b2);l2.add(b3);l2.add(b4);l2.add(b5);l2.add(b6);l2.add(det1);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
        b4.addActionListener(this);b5.addActionListener(this);b6.addActionListener(this);      
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
                Database db=new Database('v',FID,"10");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b2)
        {   
            try
            {
                Database db=new Database('v',FID,"11");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b3)
        {   
            try
            {
                Database db=new Database('v',FID,"12");
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
                Database db=new Database('v',FID,"13");
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
                Database db=new Database('v',FID,"14");
                db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b6)
        { 
            frame.dispose();
            Farmbase fb=new Farmbase(FID);
        }
    }
}