package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
public class sub1 implements ActionListener
{   
    JButton b1,b2,b3,b4;
    JFrame frame;
    JPanel panel;
    JLabel l1,l2,det;
    int FID;
    sub1(int FID)
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
 
        b1=new JButton("Machinery");
        b1.setBounds(200, 320,300,35);
        b2=new JButton("Transportation");
        b2.setBounds(200,420,300, 35);
        b3=new JButton("Motors");
        b3.setBounds(800, 320,300, 35);
        b4=new JButton("Exit");
        b4.setBounds(800,420,300, 35);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall3.jpg"))));
            l2.setBounds(0,-50,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
        l2.add(b1);l2.add(b2);l2.add(b3);l2.add(b4);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
        b4.addActionListener(this);      
        panel.add(l2);    
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {   
            try
            {
            Database db=new Database('v',FID,"7");
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
            Database db=new Database('v',FID,"8");
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
            Database db=new Database('v',FID,"9");
            db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
            frame.dispose(); 
        }
        if(e.getSource()==b4)
        { 
            frame.dispose();
            Farmbase fb =new Farmbase(FID);
        }
    }
}