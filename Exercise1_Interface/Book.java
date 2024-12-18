
package nguyentrongkhoi_5867.Exercise1_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class Book implements IBook {
    String bookId;
    String publisher;
    Date entryDate;
    double unitPrice;
    double quantity;
    
    Book(){}
    Book(String bookId, String publisher, Date entryDate, double unitPrice, double quantity){
        this.bookId = bookId;
        this.publisher = publisher;
        this.entryDate = entryDate;
        this.unitPrice= unitPrice;
        this.quantity = quantity;
    }
    
    Scanner sc = new Scanner(System.in);
    
    @Override
    public abstract void addBook();
    
    @Override
    public abstract void updateBook(String id);
    
    @Override 
    public abstract void displayBook();
    
    public String getBookId(){
        return bookId;
    }
}
