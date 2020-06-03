package farmbase;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {

    JFrame f;
    JPanel p;
    JLabel title,lg;
    JButton b1, b2;
    Font fontt =new Font("Verdana",Font.BOLD,50);
    Font fontl =new Font("Sans Serif",Font.PLAIN,20);
    Font fontlg =new Font("Sans Serif",Font.PLAIN,30);
    Login() {
        f = new JFrame();
        p = new JPanel();
        
        p.setBackground(new Color(0,255,0,160));
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(800,400);
        f.setLocation(dim.width/2-f.getSize().width/2,dim.height/2-f.getSize().height/2);
        //f.setLocation(300, 100);
        title = new JLabel("Farmbase welcomes you");
        lg=new JLabel("Please login to continue...");
        lg.setFont(fontlg);
        lg.setBounds(50,120,800,60);
        b1=new JButton("Admin");
        b2=new JButton("User");
        title.setFont(fontt);
        title.setBounds(50,35,800,60);
        b1.setFont(fontl);b2.setFont(fontl);
        b1.setBounds(80, 250,115,50);
        b2.setBounds(600,250,115,50);
        p.add(title);
        p.add(lg);
        p.add(b1);p.add(b2);
        
        f.setContentPane(p);
        p.setLayout(null);
        p.setVisible(true);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         b1.addActionListener(this);b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            f.dispose();
            ALogin al=new ALogin();
        }
        if(e.getSource()==b2)
        {
            f.dispose();
            ULogin ul=new ULogin();
        }    
    }
}
   

