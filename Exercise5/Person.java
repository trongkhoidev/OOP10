
package nguyentrongkhoi_5867.Exercise5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    String id;
    String fullName;
    Date dateOfBirth;
    
    
    Person(){}
    Person(String id, String fullName, Date dateOfBirth){
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }
    
    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of Birth: " + formatter.format(dateOfBirth) );
    }            
}
