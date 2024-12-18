
package nguyentrongkhoi_5867.Exercise1;

import java.text.ParseException;
import java.util.Date;

public class ReferenceBook extends IBook {
    double tax;
    public ReferenceBook() {}
    public ReferenceBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, double tax){
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.tax = tax;
    }
    
    @Override
    public void addBook() throws ParseException{
        super.addBook();
        System.out.println("Enter Tax Book: ");
        tax = sc.nextDouble();
        System.out.println("Add book succesful!!!");
    }
    @Override
    public void updateBook(String id) throws ParseException {
        super.updateBook(id);
    }
}
