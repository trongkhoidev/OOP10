
package nguyentrongkhoi_5867.Exercise1_Interface;

import java.util.Scanner;


public class Processor {
    public static void main(String[] args) {
        BookList book = new BookList();
        
        Scanner sc = new Scanner(System.in);
        
        int choice ;
        do{
            System.out.println("=== MENU ===");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Find book by ID");
            System.out.println("5. Display all Book");
            System.out.println("6. Exit program");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1: {
                    book.addBook();
                    break;
                }
                case 2: {
                    System.out.println("Enter id want to update: ");
                    String id = sc.nextLine();
                    book.updateBook(id);
                    break;
                }
                case 3: {
                    System.out.println("Enter id want to delete: ");
                    String id = sc.nextLine();
                    book.deleteBookById(id);
                    break;
                }
                case 4: {
                    System.out.println("Enter id want to find: ");
                    String id = sc.nextLine();
                    book.findBookById(id);
                    break;
                }
                case 5: {
                    book.displayBook();
                    break;
                }
                case 6: {
                    System.out.println("Exit program");
                    break;
                }
                default: {
                    System.out.println("Choice invalid");
                }
            }
        }while(choice != 6);
    }
}
