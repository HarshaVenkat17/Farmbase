package farmbase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection conn;
    private Statement si,si1;
   
    char c;String name,sendn,ch,pwd; 
    String[] s1=new String[15];
    String[] s2=new String[15];
    String[] s3=new String[15];
    String[] s4=new String[15];
    String[] s5=new String[15];
    int id,sc;
    int send2,send8;
    String send3,send5,source,send6,send7;
    double send4;
    public static int[] fid=new int[15];
    public static String[] pass=new String[15];
    int i=0;
    Database(char ch,int id,String pass)
    {
        this.c=ch;this.id=id;
        this.pwd=pass;
    }
    public Connection openConnection() throws SQLException
    {
        if(conn==null)
        {
            String dbName="farming";
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://db4free.net/";
            String userName="harshavenkat17";
            String password="Surya@123";
            try
            {
                Class.forName(driver);
                this.conn=(Connection)DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("Connection Successful");
                if(c=='p')
                {
                    if(pwd.equals("check"))
                    {
                        String q="SELECT * FROM passwords";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);
                        i=0;
                        while(rs.next())
                        {
                            fid[i]=rs.getInt("FID");
                            pass[i]=rs.getString("Pass");
                            i++;
                        }
                    }
                    else
                    {
                        String q1="UPDATE passwords SET PASS='"+pwd+"' WHERE FID="+id;                        
                        si1=(Statement)conn.createStatement();
                        si1.executeUpdate(q1);
                    }
                }
                else if(c=='v')
                {
                    if(pwd.equals("0"))
                    {
                        String q="SELECT * FROM farmer WHERE FID="+id;
                        
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            send2=rs.getInt("FID");
                            send3=rs.getString("F_Name");
                            send4=rs.getDouble("Area_acres");
                            send5=rs.getString("Village");
                        }       
                        Farmbase fb=new Farmbase(send2);
                        fb.viewer(send2,send3,send4,send5);
                    }
                    if(pwd.equals("1"))
                    {
                        String q="SELECT * FROM field WHERE FID=(SELECT Field FROM cultivates WHERE FarmerID="+id+")";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            send2=rs.getInt("FID");
                            send3=rs.getString("F_Name");
                            send4=rs.getDouble("Area_acres");
                            send5=rs.getString("Village");
                        }   
                           
                        Field fld=new Field(id);
                        fld.viewer(send2,send3,send4,send5);
                    }
                    if(pwd.equals("3"))
                    {
                        String q="SELECT * FROM disease";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);
                        i=0;
                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Cause");
                            s3[i]=rs.getString("Crop1");
                            s4[i]=rs.getString("Crop2");
                            i++;
                        }    
                        Disease dis=new Disease(id);
                        dis.viewer(s1,s2,s3,s4);
                    }
                    if(pwd.equals("4"))
                    {
                        String q="SELECT * FROM warehouse WHERE FID="+id;
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);
                        i=0;
                        while(rs.next())
                        {
                            send3=rs.getString("OwnerFName");
                            send5=rs.getString("Village");
                            send2=rs.getInt("FID");
                            send8=rs.getInt("Rent_perday");
                            i++;
                        }               
                        Warehouse wh=new Warehouse(id);
                        wh.viewer(send3,send5,send2,send8);
                    }
                    if(pwd.equals("5"))
                    {
                        String q="SELECT * FROM `permanant workers`";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Wages");
                            s3[i]=rs.getString("Crop");
                            s4[i]=rs.getString("UnionID");
                            i++;
                        }   
                        Worker wkr=new Worker(id);
                        wkr.viewer1(s1,s2,s3,s4);
                        i=0;
                        q="SELECT * FROM `temporary workers`";
                        si=(Statement)conn.createStatement();
                        rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Wages");
                            s3[i]=rs.getString("Crop");
                            s4[i]=rs.getString("Time_period_months");
                            i++;
                        }   
                        wkr.viewer2(s1,s2,s3,s4);
                    }
                    if(pwd.equals("6"))
                    {
                        String q="SELECT Shop,wholesale.Location,wholesale.Crop,Quantitysold_kg,Priceperkg FROM wholesale,sellsto2 WHERE sellsto2.Shop=wholesale.Shopname and sellsto2.Location=wholesale.Location and FarmerID="+id;
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Shop");
                            s2[i]=rs.getString("Location");
                            s3[i]=rs.getString("Crop");
                            s4[i]=rs.getString("Quantitysold_kg");
                            s5[i]=rs.getString("Priceperkg");
                            i++;
                        }   
                        Contracts cnt=new Contracts(id);
                        cnt.viewer1(s1,s2,s3,s4,s5);
                        q="SELECT market.Location,market.Crop,Quantity_quintals,Priceperkg FROM market,sellsto1 WHERE sellsto1.Location=market.Location and FarmerID="+id;
                        si=(Statement)conn.createStatement();
                        rs=si.executeQuery(q);
                           i=0;
                        while(rs.next())
                        {
                            s1[i]=rs.getString("Location");
                            s2[i]=rs.getString("Crop");
                            s3[i]=rs.getString("Quantity_quintals");
                            s4[i]=rs.getString("PriceperKg");
                            i++;
                        }   
                        cnt.viewer2(s1,s2,s3,s4);
                    }
                    if(pwd.equals("7"))
                    {
                        String q="SELECT * FROM machinery WHERE Machine in (SELECT Machine FROM ploughs_using WHERE FarmerID="+id+")";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Machine");
                            s2[i]=rs.getString("Life_yrs");
                            s3[i]=rs.getString("Cost");
                            i++;
                        }   
                        Machinery mch=new Machinery(id);
                        mch.viewer(s1,s2,s3,1);
                    }
                    if(pwd.equals("8"))
                    {
                        String q="SELECT * FROM transportation WHERE `License plate` in (SELECT `License plate` FROM to_market WHERE FarmerID="+id+")";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("License plate");
                            s2[i]=rs.getString("Mode");
                            s3[i]=rs.getString("CostperKg");
                            i++;
                        }                          
                        Machinery mch=new Machinery(id);
                        mch.viewer(s1,s2,s3,2);
                    }
                    if(pwd.equals("9"))
                    {
                        String q="SELECT * FROM electric_motor";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Company");
                            s2[i]=rs.getString("Life_yrs");
                            s3[i]=rs.getString("Efficiency_star");
                            s4[i]=rs.getString("Power_hp");
                            s5[i]=rs.getString("Voltage_V");
                            i++;
                        }    
                        Contracts cnt=new Contracts(id);
                        cnt.viewer3(s1,s2,s3,s4,s5);
                    }
                    if(pwd.equals("10"))
                    {
                        String q="SELECT * FROM fertilizers";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Cost");
                            s3[i]=rs.getString("QuantityBought");
                            s4[i]=rs.getString("Type");
                            i++;
                        }   
                        Agrihelp agp=new Agrihelp(id);
                        agp.viewer1(s1,s2,s3,s4,1);
                    }
                    if(pwd.equals("11"))
                    {
                        String q="SELECT * FROM pesticides";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Cost");
                            s3[i]=rs.getString("QuantityBought");
                            s4[i]=rs.getString("Type");
                            i++;
                        }    
                        Agrihelp agp=new Agrihelp(id);
                        agp.viewer1(s1,s2,s3,s4,2);
                    }
                     if(pwd.equals("12"))
                    {
                        String q="SELECT * FROM fence";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Type");
                            s3[i]=rs.getString("Cost");
                            i++;
                        }                       
                        Agrihelp2 agp2=new Agrihelp2(id);
                        agp2.viewer1(s1,s2,s3);
                    }
                    if(pwd.equals("13"))
                    {
                        String q="SELECT * FROM consultant where FID="+id;
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("CID");
                            s2[i]=rs.getString("FName");
                            s3[i]=rs.getString("Degree1");
                            s4[i]=rs.getString("Degree2");
                            s5[i]=rs.getString("Phone");
                            i++;
                        }                           
                        Agrihelp agp=new Agrihelp(id);
                        agp.viewer2(s1,s2,s3,s4,s5);
                    }
                    if(pwd.equals("14"))
                    {
                        String q="SELECT * FROM banks WHERE Location=(SELECT Village FROM farmer WHERE FID="+id+")";
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);

                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Location");
                            s3[i]=rs.getString("Interest");
                            s4[i]=rs.getString("Amount");
                            i++;
                        }                             
                        Agrihelp2 agp2=new Agrihelp2(id);
                        agp2.viewer2(s1,s2,s3,s4,1);
                        q="SELECT * FROM `private financers` WHERE Location=(SELECT Village FROM farmer WHERE FID="+id+")";
                        si=(Statement)conn.createStatement();
                        rs=si.executeQuery(q);
                        i=0;
                        while(rs.next())
                        {
                            s1[i]=rs.getString("Name");
                            s2[i]=rs.getString("Location");
                            s3[i]=rs.getString("Interest");
                            s4[i]=rs.getString("Max_Loan");
                            i++;
                        }   
                        agp2.viewer2(s1,s2,s3,s4,2);
                    }           
                }
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        return conn;
    }
}
