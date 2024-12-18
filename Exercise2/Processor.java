
package nguyentrongkhoi_5867.Exercise2;

import java.text.ParseException;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) throws ParseException {
        BookList booklist = new BookList();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Find Book");
            System.out.println("5. Diplay all Book");
            System.out.println("6. DIsplay total amount");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt() ;
            
            
            sc.nextLine();
            switch(choice){
                case 1: {
                    booklist.addBook();
                    break;
                }
                case 2: {
                    System.out.println("Enter id UPDATE: ");
                    String id = sc.nextLine();
                    booklist.updateBook(id);
                    break;
                }
                case 3: {
                    System.out.print("Enter id DELETE: ");
                    String id = sc.nextLine();
                    booklist.deleteBookById(id);
                    break;
                }
                case 4: {
                    System.out.print("Enter id FIND: "); 
                    String id = sc.nextLine();
                    booklist.findBookById(id);
                    break;
                }
                case 5: {
                    System.out.println("== LIST BOOK ==");
                    booklist.displayAllBook();
                    break;
                }
               
                case 6: {
                    System.out.println("== TOTAL AMOUNT ==");
                    booklist.total();
                }
                case 7: {
                    System.out.println("Exit program!!!");
                    break;
                }
                default: {
                    System.out.println("Choice invalid !!!");
                }
            }
        }while(choice != 7);
        
    }
}
