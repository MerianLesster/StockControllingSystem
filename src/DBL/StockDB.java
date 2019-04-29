/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBL;
public class StockDB 
{
    private String StoredDate;
    private String StoredTime;
    private String StockID;
    private String BookCategory;
    private double BookUnitprice;
    private int BookQuantity;
    private double StockPrice;
 
    public StockDB(String StoredDate, String StoredTime, 
            String StockID, String BookCategory, 
            double BookUnitprice, int BookQuantity, double StockPrice)
    {
        this.StoredDate = StoredDate;
        this.StoredTime = StoredTime;
        this.StockID = StockID;
        this.BookCategory = BookCategory;
        this.BookUnitprice = BookUnitprice;
        this.BookQuantity = BookQuantity;
        this.StockPrice = StockPrice;
    }
    public String getStoredDate()
    {
        return StoredDate;
    }
    
    public String getStoredTime()
    {
        return StoredTime;
    }
    
    public String getStockID()
    {
        return StockID;
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
    
    public double getStockPrice()
    {
        return StockPrice;
    }

}