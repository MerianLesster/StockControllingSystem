/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBL;
public class BookDB 
{
 private String StoredDate;
 private String StoredTime;
 private String BookID;
 private String BookName;
 private String Mr_Mrs;
 private String BookAuthor;
 private double BookUnitPrice;
 private String BookCategory;
 
    public BookDB(String StoredDate, String StoredTime, 
                  String BookID, String BookName, 
                  String Mr_Mrs, String BookAuthor, 
                  double BookUnitPrice, String BookCategory)
    {
        this.StoredDate = StoredDate;
        this.StoredTime = StoredTime;
        this.BookID = BookID;
        this.BookName = BookName;
        this.Mr_Mrs = Mr_Mrs;
        this.BookAuthor = BookAuthor;
        this.BookUnitPrice = BookUnitPrice;
        this.BookCategory = BookCategory;
    }
    public String getStoredDate()
    {
        return StoredDate;
    }
    
    public String getStoredTime()
    {
        return StoredTime;
    }
    
    public String getBookID()
    {
        return BookID;
    }
    
    public String getBookName()
    {
        return BookName;
    }
    
    public String getMr_Mrs()
    {
        return Mr_Mrs;
    }
    
    public String getBookAuthor()
    {
        return BookAuthor;
    }
    
    public double getBookUnitPrice()
    {
        return BookUnitPrice;
    }
    
    public String getBookCategory()
    {
        return BookCategory;
    }
}
