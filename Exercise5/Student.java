
package nguyentrongkhoi_5867.Exercise5;

import java.util.Date;


public class Student extends Person {
    float gpa;
    String major;
    double tuiition;
    boolean schoolarship;
    
    Student(){}
    Student(String id, String fullName, Date dateOfBirth, float gpa, String major, double tuiition, boolean schoolarship){
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.tuiition = tuiition;
        this.schoolarship = schoolarship;
    }
    
}
