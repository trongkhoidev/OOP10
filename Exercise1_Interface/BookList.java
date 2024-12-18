
package nguyentrongkhoi_5867.Exercise1_Interface;

import java.util.ArrayList;
import java.util.Scanner;


public class BookList {
    ArrayList<Book> books = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    
    public void addBook(){
        System.out.println("Enter type book want to add(1: Text Book, 2: Reference Book): ");
        int type = sc.nextInt();
        switch(type){
            case 1: {
                TextBook tb = new TextBook();
                tb.addBook();
                books.add(tb);
                System.out.println("Add Text Book suscessful");
                break;
            }
            case 2: {
                ReferenceBook rb = new ReferenceBook();
                rb.addBook();
                books.add(rb);
                System.out.println("Add Reference Book suscessful");
                break;
            }
            default: {
                System.out.println("Type invalid");
            }
        }
    }
    
    public void updateBook(String id){
        for(Book book : books){
            if(book.getBookId().equals(id)){
                book.updateBook(id);
                System.out.println("Update suscessful");
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void findBookById(String id){
        for(Book book : books){
            if(book.getBookId().equals(id)){
                book.displayBook();
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void deleteBookById(String id){
        for(Book book : books){
            if(book.getBookId().equals(id)){
                books.remove(book);
                return;
            }
        }
        System.out.println("ID not found");
    }
    
    public void displayBook(){
        for(Book book : books){
            if(books.isEmpty()){
                System.out.println("No have Book in library");
                return;
            }
            book.displayBook();
        }
    }
}
