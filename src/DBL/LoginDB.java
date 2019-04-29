/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBL;

/**
 *
 * @author Lesster
 */
public class LoginDB 
{
    private String Date;
    private String Time;
    private String UserID;
    private String Password;

 public LoginDB(String Date, String Time, String UserID, String Password)

    {
        this.Date = Date;
        this.Time = Time;
        this.UserID = UserID;
        this.Password = Password;
    }
 
 public String getDate()
    {
        return Date;
    }
    
    public String getTime()
    {
        return Time;
    }
    
    public String getUserID()
    {
        return UserID;
    }
    
    public String getPassword()
    {
        return Password;
    }
}