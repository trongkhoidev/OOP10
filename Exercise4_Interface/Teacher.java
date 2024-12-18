
package nguyentrongkhoi_5867.Exercise4_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Teacher extends Person {
    String department;
    String teachingSubject;
    
    public Teacher(){}
    public Teacher(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, String department, String teacString){
         super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
         this.department = department;
         this.teachingSubject = teachingSubject;
    }
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void addPerson(){
        System.out.println("Enter id: ");
        id = sc.nextLine();
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
        } finally {
            sc.close(); 
        }
        
        System.out.println("Enter book Borrow Date: ");
        String inputBorrow = sc.nextLine();
        try {
            bookBorrowDate = formatter.parse(inputBorrow);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } finally {
            sc.close();
        }
        
        System.out.println("Enter book Borrow Date: ");
        String inputReturn = sc.nextLine();
        try {
            bookReturnDate = formatter.parse(inputReturn);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } finally {
            sc.close();
        }
        System.out.println("Enter Department: ");
        department = sc.nextLine();
        System.out.println("Enter Teaching Subjec: ");
        teachingSubject = sc.nextLine();
    }
    
    @Override
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
        } finally {
            sc.close(); 
        }
        
        System.out.println("Enter book Borrow Date: ");
        String inputBorrow = sc.nextLine();
        try {
            bookBorrowDate = formatter.parse(inputBorrow);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } finally {
            sc.close();
        }
        
        System.out.println("Enter book Borrow Date: ");
        String inputReturn = sc.nextLine();
        try {
            bookReturnDate = formatter.parse(inputReturn);
        }catch (ParseException e){
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
        } finally {
            sc.close();
        }
        System.out.println("Enter Department: ");
        department = sc.nextLine();
        System.out.println("Enter Teaching Subjec: ");
        teachingSubject = sc.nextLine();
    }
    
    @Override
    public void displayInfo(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + formatter.format(dateOfBirth));
        System.out.println("Book Borrow Date: " + formatter.format(bookBorrowDate));
        System.out.println("Book Return Date: " + formatter.format(bookReturnDate));
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }
    
    public String getDepartment(){
        return department;
    }
    public String getId(){
        return id;
    }
}
