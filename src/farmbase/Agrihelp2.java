package farmbase;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;

public class Agrihelp2 implements ActionListener
{
    int us;
    JFrame frame;
    JPanel panel;
    JLabel l2,det1,det2,det3;
    Font font,fontl,fontt;
    JButton b9;
    JTable tab1,tab2;
    Agrihelp2(int us)
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
        b9.setBounds(1050,650,200, 30);
        det1=new JLabel("Banks");
        det1.setForeground(Color.white);
        det2=new JLabel("Private Financers");
        det2.setForeground(Color.white);
        det3=new JLabel("Pick a Fence");
        det3.setForeground(Color.white);
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\Farmbase\\src\\images\\wall11.jpg"))));
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
            sub2 sb2=new sub2(us);
        } 
    }
    void viewer1(String[] a,String[] b,String[] c)
    {   
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
        }
        String[] cols={"Name","Type","Cost"};
        tab1=new JTable(data,cols);
        tab1.setRowHeight(24);
        tab1.setFont(fontt);
        tab1.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane js=new JScrollPane(tab1);
        js.setLocation(100,400);
        js.setSize(1150,215);
        det3.setBounds(100,365,300, 30);
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(det3);
        l2.add(js);
        l2.setLayout(null); 
    }
    void viewer2(String[] a,String[] b,String[] c, String[] d,int e)
    {   
        String [][] data=new String [10][5];
        for(int j=0;j<10;j++)
        {
            data[j][0]=a[j];
            data[j][1]=b[j];
            data[j][2]=c[j];
            data[j][3]=d[j];
        }
        String[] cols={"Name","Location","Interest","Amount"};
        tab1=new JTable(data,cols);
        tab1.setRowHeight(24);
        tab1.setFont(fontt);
        JScrollPane js=new JScrollPane(tab1);
        if (e==1)
        {
            det1.setBounds(150,85,300,30);
            js.setLocation(150,120);
            js.setSize(1100,200);
            l2.add(det1);
        }
        else if (e==2)
        {
            det2.setBounds(150,405,300, 30);
            js.setLocation(150,445);
            js.setSize(1100,200);
            l2.add(det2);
        }
        tab1.getTableHeader().setPreferredSize(new Dimension(js.getWidth(),24));
        tab1.getTableHeader().setFont(font);
        js.setVisible(true);
        l2.add(js);
        l2.setLayout(null); 
    }
}
