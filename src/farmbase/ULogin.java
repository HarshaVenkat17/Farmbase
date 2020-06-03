package farmbase;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class ULogin implements ActionListener {

    JFrame f,alert1,alert2;
    JPanel p;
    JLabel ls1,ls2,l1, l2, title,ls3;
    JButton b1, b2,b3;
    JTextField f1,f3;JPasswordField f2;
    String pw,id;
    int us,ch=0;
    int i=0;
    int[] fid=new int[15];
    String[] pass=new String[15];
    Font fontt =new Font("Verdana",Font.BOLD,50);
    Font fontl =new Font("Sans Serif",Font.PLAIN,20);
    
    ULogin() 
    {    
        f = new JFrame();
        p = new JPanel();
        Database db=new Database('p',1,"check");
        try 
        {
            db.openConnection();
            for(i=0;i<15;i++)
            {
            fid[i]=db.fid[i];
            pass[i]=db.pass[i];
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQL exception");
        }
        p.setBackground(Color.ORANGE);
        f.setSize(610, 350);
        f.setLocation(400, 200);
        title = new JLabel("User Login");
        b1=new JButton("Submit");
        b2=new JButton("Clear");
        b3=new JButton("Change Password");
        l1 = new JLabel("Farmer ID: ");
        l2 = new JLabel("Password: ");
        title.setFont(fontt);
        title.setBounds(150,0,500,60);
        l1.setFont(fontl);l2.setFont(fontl);
        b1.setFont(fontl);b2.setFont(fontl);b3.setFont(fontl);
        l1.setBounds(30,100,115,30);
        l2.setBounds(30,150,115,30);
        b1.setBounds(20, 230,115,30);
        b2.setBounds(200,230,115,30);
        b3.setBounds(380,230,200,30);
        f1=new JTextField();        
        f2=new JPasswordField();
        f1.setBounds(160,102,300,30);
        f2.setBounds(160,150,300,30);
        f1.setFont(fontl);
        f2.setEchoChar('*');         
        
        p.add(title);
        p.add(l1);p.add(l2);
        p.add(f1);p.add(f2);
        p.add(b1);p.add(b2);p.add(b3);
        
        f.setContentPane(p);
        p.setLayout(null);
        p.setVisible(true);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int flag=0;
        if(e.getSource()==b1)
        {
            us=Integer.parseInt(f1.getText());
            pw=String.valueOf(f2.getPassword());
            try
            {
                for(i=0;i<15;i++)
                {
                    if(us==(fid[i]))
                    {
                        flag=1;
                        break;
                    } 
                }
                if(pw.equals(pass[i]))
                {
                    flag=2;
                    Database db=new Database('v',us,"0");
                    try {
                        db.openConnection();
                        } 
                    catch (SQLException ex) {
                        System.out.println("SQL exception");
                        }
                    f.dispose();

                }
                else if(flag==1)
                {
                    alert2=new JFrame();
                    JOptionPane.showMessageDialog(alert2,"Password incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);
                    f2.setText("");
                }}
            catch(Exception E)
            {   
                if(flag==0)
                {alert1=new JFrame();  
                JOptionPane.showMessageDialog(alert1,"User ID incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);   
                f1.setText("");
                f2.setText("");}
            }      
        }
        if(e.getSource()==b2)
        {
            f1.setText("");
            f2.setText("");
            ls1.setText("");
            ls2.setText("");
        }    
        if(e.getSource()==b3)
        {
            us=Integer.parseInt(f1.getText());
            pw=String.valueOf(f2.getPassword());
            flag=0;
            try{
            for(i=0;i<15;i++)
            {
                if(us==fid[i])
                {
                    flag=1;
                    break;
                } 
            }
            if(pw.equals(pass[i]))
            {
                flag=2;
                ChangeP c=new ChangeP(us);
            }
            else if(flag==1)
            {
                alert2=new JFrame();  
                JOptionPane.showMessageDialog(alert2,"Password incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);
                f2.setText("");
            }}
            catch(Exception E)
            {   
                alert1=new JFrame();  
                JOptionPane.showMessageDialog(alert1,"User ID incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);   
                f1.setText("");
                f2.setText("");
            }     
        }    
    }
}