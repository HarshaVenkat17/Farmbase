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
public class Disease implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det;
    Font font,fontt,fontl;
    JButton b9;
    JTable tab;
    Disease(int us)
    {
        frame=new JFrame("Farmbase Welcomes You");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fontl=new Font("Verdana",Font.BOLD,25);
        fontt=new Font("Verdana",Font.PLAIN,20);
        font=new Font("Verdana",Font.BOLD,16);
        UIManager.put("Label.font",fontl);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
        det=new JLabel("Crop Diseases");
        det.setForeground(Color.black);
        det.setBounds(100,145,250,30);
        this.us=us;
        b9=new JButton("EXIT");
        b9.setBounds(1000,500,300, 35);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall6.jpg"))));
            l2.setBounds(0,-50,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
        l2.add(b9);l2.add(det);
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
    void viewer(String[] a,String[] b,String[] c, String[] d)
    {   
        String [][] data=new String [15][4];
        for(int j=0;j<15;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
        }
        String[] cols={"NAME","CAUSE","CROP1","CROP2"};
        
        tab=new JTable(data,cols);
        tab.setRowHeight(22);
        tab.setFont(fontt);     
        JScrollPane js=new JScrollPane(tab);
        js.setLocation(100,180);
        js.setSize(1000,222);
        tab.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
}
