
package nguyentrongkhoi_5867.Exercise4_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person implements IPerson {
    float gpa;
    String major;
    
    public Student(){}
    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major){
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }
    
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void addPerson() {
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
        System.out.println("Enter GPA: ");
        gpa = sc.nextFloat();
        System.out.println("Enter Major: ");
        major = sc.nextLine();
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
        System.out.println("Enter GPA: ");
        gpa = sc.nextFloat();
        System.out.println("Enter Major: ");
        major = sc.nextLine();
    }
    @Override
    public void displayInfo(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + formatter.format(dateOfBirth));
        System.out.println("Book Borrow Date: " + formatter.format(bookBorrowDate));
        System.out.println("Book Return Date: " + formatter.format(bookReturnDate));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
    
    public float getGPA(){
        return gpa;
    }
    
    public String getId(){
        return id;
    }
}
