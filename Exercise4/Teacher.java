
package nguyentrongkhoi_5867.Exercise4;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


public class Teacher  extends Person {
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
    public void addPerson() throws ParseException{
        super.addPerson();
        System.out.println("Enter Department: ");
        department = sc.nextLine();
        System.out.println("Enter Teaching Subjec: ");
        teachingSubject = sc.nextLine();
    }
    
    @Override
    public void updatePerson(String id){
        super.updatePerson(id);
        System.out.println("Enter Department: ");
        department = sc.nextLine();
        System.out.println("Enter Teaching Subjec: ");
        teachingSubject = sc.nextLine();
    }
    
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }
    
    public String getDepartment(){
        return department;
    }
}
