
package nguyentrongkhoi_5867.Exercise4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Person {
    String id;
    String fullName;
    Date dateOfBirth;
    Date bookBorrowDate;
    Date bookReturnDate;
    
    Person(){}
    Person(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate){
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.bookBorrowDate = bookBorrowDate;
        this.bookReturnDate = bookReturnDate;
    }
    Scanner sc = new Scanner(System.in);
    public void addPerson() throws ParseException {
        System.out.println("Enter id: ");
        id = sc.nextLine();
        System.out.println("Enter full Name: ");
        fullName = sc.nextLine();

        while (true) {
            System.out.println("Enter date of Birth (dd/MM/yyyy): ");
            String inputDate = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                dateOfBirth = formatter.parse(inputDate);
                break; 
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
            }
        }

        while (true) {
            System.out.println("Enter book Borrow Date (dd/MM/yyyy): ");
            String inputBorrow = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                bookBorrowDate = formatter.parse(inputBorrow);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
            }
        }

        while (true) {
            System.out.println("Enter book Return Date (dd/MM/yyyy): ");
            String inputReturn = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                bookReturnDate = formatter.parse(inputReturn);
                break; 
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
            }
        }
    }
    public void updatePerson(String id){
        System.out.println("Enter full Name: ");
        fullName = sc.nextLine();
        System.out.println("Enter date of Birth: ");
        String inputDate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        try {
            dateOfBirth = formatter.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } 
        
        System.out.println("Enter book Borrow Date: ");
        String inputBorrow = sc.nextLine();
        try {
            bookBorrowDate = formatter.parse(inputBorrow);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } 
        
        System.out.println("Enter book Borrow Date: ");
        String inputReturn = sc.nextLine();
        try {
            bookReturnDate = formatter.parse(inputReturn);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } 
    }
    
    public void displayInfo(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + formatter.format(dateOfBirth));
        System.out.println("Book Borrow Date: " + formatter.format(bookBorrowDate));
        System.out.println("Book Return Date: " + formatter.format(bookReturnDate));
    }  
    
    public boolean isBookOverdue(){
        long diffInMillies = Math.abs(bookReturnDate.getTime() - bookBorrowDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (diffInDays >= 30) {
            
            return true; 
        } else {
            
            return false; 
        }
    }
    
    public String getId(){
        return id;
    }
}
