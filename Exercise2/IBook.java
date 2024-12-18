
package nguyentrongkhoi_5867.Exercise2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IBook {
    String bookId;
    String publisher;
    Date entryDate;
    double unitPrice;
    double quantity;
    
    IBook(){}
    IBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity){
        this.bookId = bookId;
        this.publisher = publisher;
        this.entryDate = entryDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void addBook() throws ParseException{
        System.out.println("=== Enter INFORMATION BOOK ===");
        System.out.println("Enter Book ID: ");
        bookId = sc.nextLine();
        System.out.println("Enter Publisher: ");
        publisher = sc.nextLine();
        System.out.println("Enter Entry Date (dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        entryDate = formatter.parse(inputDate);
        System.out.println("Enter unit Price: ");
        unitPrice = sc.nextDouble();
        System.out.println("Enter quantity book: ");
        quantity = sc.nextDouble();
    }
    
    public void updateBook(String id) throws ParseException{
        bookId = id;
        System.out.println("Enter Publisher: ");
        publisher = sc.nextLine();
        System.out.println("Enter Entry Date (dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        entryDate = formatter.parse(inputDate);
        System.out.println("Enter unit Price: ");
        unitPrice = sc.nextDouble();
        System.out.println("Enter quantity book: ");
        quantity = sc.nextDouble();
        System.out.println("Add book succesful!!!");
    }
    public void displayBook(){
        System.out.println("=== INFORMATION BOOK ===");
        System.out.println("ID: " + bookId);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(entryDate);
        System.out.println("Publisher: " + publisher);
        System.out.println("Entry Date: " + formattedDate );
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
    }
    
    public double calculateTotal() {
        return 0;
    }
    
     public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
