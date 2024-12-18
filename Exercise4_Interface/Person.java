
package nguyentrongkhoi_5867.Exercise4_Interface;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public abstract class Person implements IPerson{
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
    public abstract void addPerson();
    public abstract void updatePerson(String id);
    public abstract void displayInfo();
    
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
