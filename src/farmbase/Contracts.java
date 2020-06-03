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
public class Contracts implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det1,det2,det3;
    Font font,fontl,fontt;
    JButton b9;
    JTable tab1,tab2;
    Contracts(int us)
    {
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fontl=new Font("Verdana",Font.BOLD,25);
        fontt=new Font("Verdana",Font.PLAIN,18);
        font=new Font("Verdana",Font.BOLD,16);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);

        this.us=us;
        b9=new JButton("EXIT");
        b9.setBounds(1000,680,300, 30);     
        det1=new JLabel("Shops");
        det1.setBounds(150,95,300,30);
        det1.setForeground(Color.white);
        det2=new JLabel("Markets");
        det2.setBounds(150,420,300, 30);
        det2.setForeground(Color.white);
        det3=new JLabel("Electric Motors");
        det3.setBounds(150,150,300, 30);
        det3.setForeground(Color.white);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall13.jpg"))));
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
    void viewer1(String[] a,String[] b,String[] c, String[] d,String[] e)
    {   
        l2.add(det1);
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
            data[j][4]=e[j];
        }
        String[] cols={"Shop","Location","Crop","Quantity sold","Price"};
        
        tab1=new JTable(data,cols);
        tab1.setRowHeight(20);
        tab1.setFont(fontt);     
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(150,130);
        js.setSize(1000,200);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
    void viewer2(String[] a,String[] b,String[] c, String[] d)
    {   
        l2.add(det2);
        String [][] data=new String [10][4];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
        }
        String[] cols={"Location","Crop","Quintals Sold","Price per kg"};
        tab2=new JTable(data,cols);
        tab2.setRowHeight(20);
        tab2.setFont(fontt);        
        //tab1.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane js=new JScrollPane(tab2);
        js.setLocation(150,460);
        js.setSize(1000,200);
        tab2.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab2.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
    void viewer3(String[] a,String[] b,String[] c, String[] d,String[] e)
    {   
        l2.add(det3);
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
            data[j][4]=e[j];
        }
        String[] cols={"Company","Life_yrs","Efficiency(stars)","Power(hp)","Voltage(V)"};      
        tab1=new JTable(data,cols);
        tab1.setRowHeight(20);
        tab1.setFont(fontt);        
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(150,190);
        js.setSize(1000,200);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
}
