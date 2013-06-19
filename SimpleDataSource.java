/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stellar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
   A simple data source for getting database connections. 
*/
public class SimpleDataSource extends JFrame
{
    /*
   private static String url;
   private static String username;
   private static String password;
   */
   Connection con;//`enter code here`

   
   public SimpleDataSource()
   {
       String url = "jdbc:mysql://localhost:3306/";
   String db = "druglords1?zeroDateTimeBehavior=convertToNull";
   
   
   //Class.forName("com.mysql.jdbc.Driver").newInstance();
   //String driver = "com.mysql.jdbc.Driver";
  String user = ; // get from commandline
String pass = ; // get from commandline
       
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(url + db, user, pass);
            
   }
   catch(ClassNotFoundException | SQLException e)
   {
       
   }
   }
}











