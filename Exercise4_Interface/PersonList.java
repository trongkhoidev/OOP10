
package nguyentrongkhoi_5867.Exercise4_Interface;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonList {
    ArrayList<Person> people = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    
    public void addStudent() throws ParseException{
            Student std = new Student();
            std.addPerson();
            people.add(std);
    }
    
    public void addTeacher() throws ParseException{
        Teacher tc = new Teacher();
        tc.addPerson();
        people.add(tc);      
    }
    
    public void updatePerson(String id){
        for(Person person: people){
            if(person.getId().equals(id)) {
                person.updatePerson(id);
                System.out.println("Update suscessful");
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void deletePersonById(String id){
        for(Person person: people){
            if(person.getId().equals(id)) {
                people.remove(person);
                System.out.println("Delete suscessful");
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void findPersonById(String id){
         for(Person person: people){
            if(person.getId().equals(id)) {
                person.displayInfo();
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void displayEveryone(){
        System.out.println("=== LIST PERSON ===");
        for(Person person : people){
            person.displayInfo();
        }
    }
    
    public void findTopStudent(){
        ArrayList<Student> std = new ArrayList<>();
        float gpaHighest = 0;
        String idMax = null;
        for(Student student : std){
            if(gpaHighest <= student.getGPA()){
                gpaHighest = student.getGPA();
                idMax = student.getId();
            }
        }
        findPersonById(idMax);
    }
    
    public void findTeacherByDepartment(){
        ArrayList<Teacher> tc = new ArrayList<>();
        System.out.println("Enter Department want to find: ");
        String findDepartment = sc.nextLine();
        for(Teacher teacher : tc){
            if(findDepartment == teacher.getDepartment()){
                findPersonById(teacher.getId());
            }
        }
    }
    
    public void checkBookBorrowing(){
        for(Person person : people){
            if(person.isBookOverdue()){
                findPersonById(person.getId());
                System.out.println("Overdue");
            } else {
                findPersonById(person.getId());
                System.out.println("No Overdue");
            }
        }
    }
}
