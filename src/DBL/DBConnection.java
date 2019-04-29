/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author hnd
 */
public class DBConnection 
{
    private static Connection con;
    
    public static Connection getConnection() throws Exception 
    {
        
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:ABC__Book_Company";
        String Username = "hnd";
        String Password = "hnd";
        Class.forName(driver);
        setCon(DriverManager.getConnection(url,Username,Password));
        return getCon();
    }
    /*
    try 
        {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            String url = "jdbc:odbc:7447";
            String Username = "hnd";
            String Password = "hnd";
            Class.forName(driver);
           con = (DriverManager.getConnection(url,Username,Password)); 
           return con;
        } 
    */

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }
    
        public void insertvalues (String SQL) throws Exception 
        {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            st.executeUpdate(SQL);
            conn.close();
                    
        }
}



