
package nguyentrongkhoi_5867.Exercise1;

import java.text.ParseException;
import java.util.Date;

public class TextBook extends IBook {
    String status;

    public TextBook() {}
    public TextBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, String status){
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.status = status;
    }
    
    @Override
    public void addBook() throws ParseException{
        super.addBook();
        System.out.println("Enter Status Book: ");
        status = sc.nextLine();
        System.out.println("Add book succesful!!!");
    }
    @Override
    public void updateBook(String id) throws ParseException {
        super.updateBook(id);
    }
}
    

