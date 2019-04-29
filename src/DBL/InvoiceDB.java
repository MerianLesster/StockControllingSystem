/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBL;
public class InvoiceDB 
{
    private String StoredDate;
    private String StoredTime;
    private String InvoiceNo;
    private String BookName;
    private String BookCategory; 
    private double BookUnitprice;
    private int BookQuantity;
    private double Totalprice;

    public InvoiceDB(String StoredDate, String StoredTime, String InvoiceNo, String BookName, String BookCategory, double BookUnitprice, int BookQuantity, double Totalprice)

    {
        this.StoredDate = StoredDate;
        this.StoredTime = StoredTime;
        this.InvoiceNo = InvoiceNo;
        this.BookName = BookName;
        this.BookCategory = BookCategory;
        this.BookUnitprice = BookUnitprice;
        this.BookQuantity = BookQuantity;
        this.Totalprice = Totalprice;

    }

    
    public String getStoredDate()
    {
        return StoredDate;
    }
    
    public String getStoredTime()
    {
        return StoredTime;
    }
    
    public String getInvoiceNo()
    {
        return InvoiceNo;
    }
    
    public String getBookName()
    {
        return BookName;
    }
    
    public String getBookCategory()
    {
        return BookCategory;
    }
    
    public double getBookUnitprice()
    {
        return BookUnitprice;
    }
    
    public int getBookQuantity()
    {
        return BookQuantity;
    }
    
    public double getTotalprice()
    {
        return Totalprice;
    }
}