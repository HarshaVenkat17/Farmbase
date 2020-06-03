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
public class Machinery implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det1,det2;
    JButton b9;
    Font font,fontt,fontl;
    JTable tab1,tab2;
    Machinery(int us)
    {
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fontl=new Font("Verdana",Font.BOLD,25);
        font=new Font("Verdana",Font.BOLD,16);
        fontt=new Font("Verdana",Font.PLAIN,18);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        det1=new JLabel("Machinery");
        det1.setForeground(Color.black);
        det2=new JLabel("Transportation");
        det2.setForeground(Color.black);
        det1.setBounds(150,145,250,30);
        det2.setBounds(150,145,250,30);
        
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
        this.us=us;
        b9=new JButton("EXIT");
        b9.setBounds(1000,450,300, 30);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall4.jpg"))));
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
        char ch;
        if(e.getSource()==b9)
        {   
            frame.dispose();
            sub1 sb=new sub1(us);
        }
    }
    void viewer(String[] a,String[] b,String[] c,int d)
    {   
        String [][] data=new String [10][3];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
        }
        
        if(d==1)
        {
            l2.add(det1);
            String[] cols={"Machine","Life","Cost"};
            tab1=new JTable(data,cols);
        }
        else
        {
            l2.add(det2);
            String[] cols={"Vehicle No.","Mode","Cost per kg"};
            tab1=new JTable(data,cols);
        }
        
        
        tab1.setRowHeight(22);
        tab1.setFont(fontt);   
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(150,180);
        js.setSize(1000,198);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
}
