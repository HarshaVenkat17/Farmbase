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
public class Warehouse implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det,det2;
    JButton b9;
    Warehouse(int us)
    {
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font fontl=new Font("Verdana",Font.BOLD,25);
        Font font=new Font("Verdana",Font.BOLD,16);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
        this.us=us;
        b9=new JButton("EXIT");
        b9.setBounds(1000,480,300, 35);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall5.jpg"))));
            l2.setBounds(0,-50,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
        l2.add(b9);
        b9.addActionListener(this);
        panel.add(l2);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b9)
        {   
            frame.dispose();
            Farmbase fb=new Farmbase(us);
        }
    }
    void viewer(String a,String b,int c, int d)
    {   
        det=new JLabel();
        det.setForeground(Color.WHITE);
        det.setBounds(100,400,1200, 35);
        det2=new JLabel("Warehouse:");
        det2.setForeground(Color.WHITE);
        det2.setBounds(100,360,250, 35);
        det.setText("Owner Name:  "+a+"  Village:"+b+"   Tenant ID: "+c+"   Rent per Day:"+d);
        l2.add(det2);
        l2.add(det);
    }
}
