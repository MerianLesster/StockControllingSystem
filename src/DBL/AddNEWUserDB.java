/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBL;
public class AddNEWUserDB 
{
    private String StoredDate;
    private String StoredTime;
    private String Name;
    private String Gender;
    private int Age;
    private String Address;
    private String Occupation;
    private int HandphoneNo;
    private int LandlineNo;
    private String New_UserID;
    private String New_Password;

    public AddNEWUserDB( String StoredDate, String StoredTime, String Name, String Gender, int Age, String Address, String Occupation, int HandphoneNo, int LandlineNo, String New_UserID, String New_Password)
    {
        this.StoredDate = StoredDate;
        this.StoredTime = StoredTime;
        this.Name = Name;
        this.Gender = Gender;
        this.Age = Age;
        this.Address = Address;
        this.Occupation = Occupation;
        this.HandphoneNo = HandphoneNo;
        this.LandlineNo = LandlineNo;
        this.New_UserID = New_UserID;
        this.New_Password = New_Password;
    }

    public String getStoredDate()
    {
        return StoredDate;
    }
    
    public String getStoredTime()
    {
        return StoredTime;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getGender()
    {
        return Gender;
    }
    
    public int getAge()
    {
        return Age;
    }
    
    public String getAddress()
    {
        return Address;
    }
    
    public String getOccupation()
    {
        return Occupation;
    }
    
    public int getHandphoneNo()
    {
        return HandphoneNo;
    }
    
    public int getLandlineNo()
    {
        return LandlineNo;
    }
    
    public String getNew_UserID()
    {
        return New_UserID;
    }
    
    public String getNew_Password()
    {
        return New_Password;
    }
}