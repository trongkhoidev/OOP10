
package nguyentrongkhoi_5867.Exercise1_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReferenceBook extends Book implements IBook{
    double tax;
    
    ReferenceBook(){}
    ReferenceBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, double tax){
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.tax = tax;
    }
    
    @Override
    public void addBook(){
        System.out.println("Enter ID: ");
        bookId = sc.nextLine();
        System.out.println("Enter publisher: ");
        publisher = sc.nextLine();
        try{
            System.out.println("Enter entry Date: ");
            String inputDate = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            entryDate = formatter.parse(inputDate);
        }catch(ParseException e){
            System.out.println("Date invalid");
        }
        
        System.out.println("Enter Unit Price: ");
        unitPrice = sc.nextDouble();
        System.out.println("Enter Quantity: ");
        quantity = sc.nextDouble();
        System.out.println("Enter tax: ");
        tax = sc.nextDouble();
    }
    
    @Override
    public void updateBook(String id){
        if(bookId.equals(id)){
            System.out.println("Enter publisher: ");
            publisher = sc.nextLine();
            try{
                System.out.println("Enter entry Date: ");
                String inputDate = sc.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                entryDate = formatter.parse(inputDate);
            }catch(ParseException e){
                System.out.println("Date invalid");
            }

            System.out.println("Enter Unit Price: ");
            unitPrice = sc.nextDouble();
            System.out.println("Enter Quantity: ");
            quantity = sc.nextDouble();
            System.out.println("Enter Status: ");
            tax = sc.nextDouble();
        } else{
            System.out.println("ID not found");
        }
        
    }
    
    @Override
    public void displayBook(){
        System.out.println("Book ID: " + bookId);
        System.out.println("Publisher: " + publisher);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Entry Date: " + formatter.format(entryDate));
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Tax: " + tax);
    }
}
