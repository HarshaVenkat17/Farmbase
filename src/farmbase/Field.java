package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class Field implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det;
    
    JButton b9;
    Field(int us)
    {
        frame=new JFrame("Field Details");
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
        b9.setBounds(1000,490,300, 35);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall6.jpg"))));
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
    void viewer(int a,String b,double c, String d)
    {   
        det=new JLabel();
        det.setForeground(Color.WHITE);
        this.det.setText("Field ID:  "+a+"  Owner Name:"+b+"   Area occupied: "+c+"   Village:"+d);
        this.det.setBounds(100,400,1200, 35);
        this.l2.add(det);
    }
}
