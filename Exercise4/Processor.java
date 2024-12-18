
package nguyentrongkhoi_5867.Exercise4;

import java.text.ParseException;
import java.util.Scanner;


public class Processor {
    public static void main(String[] args) throws ParseException {
       
        PersonList personlist = new PersonList();
        Scanner sc = new Scanner(System.in);
        int choice ;
        do{
            System.out.println("=== MENU ===");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Check Overdue");
            System.out.println("9. Exit program!!");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch(choice){
                case 1: {
                    System.out.println("Enter information of Student: ");
                    personlist.addStudent();
                    break;
                }
                case 2: {
                    System.out.println("Enter information of Teacher: ");
                    personlist.addTeacher();
                    break;
                }
                case 3: {
                    System.out.println("Enter id want to update: ");
                    String id = sc.nextLine();
                    personlist.updatePerson(id);
                    break;
                }
                case 4: {
                    System.out.println("Enter id want to delete: ");
                    String id = sc.nextLine();
                    personlist.deletePersonById(id);
                    break;
                }
                case 5: {
                    personlist.displayEveryone();
                    break;
                }
                case 6: {
                    personlist.findTopStudent();
                    break;
                }
                case 7: {
                    personlist.findTeacherByDepartment();
                    break;
                }
                case 8: {
                    personlist.checkBookBorrowing();
                    break;
                }   
                default: {
                    System.out.println("Choice invalid");
                }
            }
        }while(choice != 9);
    }
}
