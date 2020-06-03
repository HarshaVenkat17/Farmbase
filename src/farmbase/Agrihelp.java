package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;
/**
 *
 * @author HarshaVenkat
 */
public class Agrihelp implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det1,det2,det3;
    JButton b9;
    Font font,fontl,fontt;
    JTable tab1,tab2;
    Agrihelp(int us)
    {
        frame=new JFrame("We Help");
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
        b9.setBounds(1100,520,200, 30);
        det1=new JLabel("Fertilizers");
        det1.setBounds(150,265,300,30);
        det1.setForeground(Color.black);
        det2=new JLabel("Pesticides");
        det2.setBounds(150,265,300, 30);
        det2.setForeground(Color.black);
        det3=new JLabel("Agricultural Advisor");
        det3.setBounds(150,190,300, 30);
        det3.setForeground(Color.black);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall12.jpg"))));
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
            sub2 s2=new sub2(us);
            frame.dispose();
        } 
    }
    void viewer1(String[] a,String[] b,String[] c, String[] d,int e)
    {   
        if(e==1)
        {
            l2.add(det1);
        }
        else
        {
            l2.add(det2);
        }
       
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
        }
        String[] cols={"Name","Cost","Quantity","Type"};
        tab1=new JTable(data,cols);
        tab1.setRowHeight(20);
        tab1.setFont(fontt);
        tab1.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(150,300);
        js.setSize(1150,200);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }

    void viewer2(String[] a,String[] b,String[] c, String[] d,String[] e)
    {   
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
            data[j][4]=e[j];
        }
       
        String[] cols={"ID","Name","Degree1","Degree2","Contact"};
        tab1=new JTable(data,cols);
        tab1.setRowHeight(23);
        tab1.setFont(fontt);
        TableColumn column;
        for (int i = 0; i < 5; i++) {
        column = tab1.getColumnModel().getColumn(i);
        if (i == 2||i==3) {
            column.setPreferredWidth(115); 
        } else {
            column.setPreferredWidth(50);
        }
    }    
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(150,225);
        js.setSize(1100,250);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.add(det3);
        l2.setLayout(null); 
    }
}
