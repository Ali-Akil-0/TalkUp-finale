
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger; 


public class UserDatabase {
    private Connection conn;
    public final String DATABASE_NAME = "chat_db";
    public final String USERNAME = "root";
    public final String PASSWORD = "";
    public final String URL_MYSQL = "jdbc:mysql://localhost/"+DATABASE_NAME;
    
    public final String USER_TABLE = "user_tb";
    
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");     
            conn = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public ResultSet getData() {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM "+USER_TABLE);
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    private void showData() {
        rs = getData();
        try {
            while(rs.next()) {
                System.out.printf("%-15s %-4s", rs.getString(1), rs.getString(2));
                System.out.println("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insertUser(User u) {
        MD5 var = new MD5(u.pass);
        System.out.println("Before: name = "+u.name+" - pass = "+u.pass);
        try {
            pst = conn.prepareCall("INSERT INTO "+USER_TABLE+" VALUES ('"+u.name+"', '"+var+"' , '"+u.mail+"' )");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Insert successful!");
            System.out.println("After: name = "+u.name+" - pass = "+u.pass);
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int createUser(User u) {
        try {
            
            pst = conn.prepareStatement("INSERT INTO "+USER_TABLE+" VALUE(?,?,?);");
            pst.setString(1, u.name);
            pst.setString(2, u.pass);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int checkUser(String name, String pass) {  
        try {
            pst = conn.prepareStatement("SELECT * FROM "+USER_TABLE+" WHERE name = '" + name + "' AND pass = '" + pass +"'");
            rs = pst.executeQuery();
            
            if(rs.first()) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    }
    
    public void closeConnection() {
        try {
            if(rs!=null) rs.close();
            if(pst!=null) pst.close();
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[UserDatabase.java] Lỗi close connection");
        }
    }
     
    ////

     public int insertMessage(String Message, String Sender, String Reciever) {

        try {
            pst = conn.prepareCall("INSERT INTO message (Message,Sender,Reciever) VALUES ('"+Message+"', '"+Sender+"' , '"+Reciever+"' )");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Insert successful!");
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
      public String[] selectMessages(String Sender, String Reciever) {
        String[] Messages = new String[100] ;
        System.out.println("selecting messages");
       
             System.out.println("In the try ??");
             System.out.println("The sender : ??");
             System.out.println(Sender);
             System.out.println("The reciever : ??");
             System.out.println(Reciever);
             try {
        
            String query= "Select Message from message  where sender = '"+Sender+"' and reciever =  '"+Reciever+"' order by IDMessage ASC";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                int i = 0 ;
                System.out.println("before while ??");
                while (rs.next())
                {
                    System.out.println("why ??????");
                    Messages[i] = rs.getString("Message");
                    System.out.println("on the query  : ");
                    System.out.println(Messages[i]);
                    i++ ;
                    
                }
            }
            catch (SQLException e) {
            System.out.println("SOme Exception2");
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, e);

        } 

         return Messages;
        
    }
       
      public int deleteMessgaes(String Reciever) {

        try {
            pst = conn.prepareCall("delete from  message  where reciever = '"+Reciever+"'");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Supression effectué!");
            return kq;
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    ////
    
    
    
    public static void main(String[] args) {
        UserDatabase ud = new UserDatabase();
        ud.connect();
        ud.showData();
        ud.closeConnection();
        
        System.out.println("============");
        ud.connect();
        ud.insertUser(new User("omar", "452","omar@gmail.com"));
        ud.showData();
    }
}