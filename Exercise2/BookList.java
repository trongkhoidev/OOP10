
package nguyentrongkhoi_5867.Exercise2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    ArrayList<IBook> books = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    public void addBook() throws ParseException{
        System.out.println("Choice book type(1: TextBook, 2: ReferenceBook): ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: {
                TextBook tb = new TextBook();
                tb.addBook();
                books.add(tb);
                break;
            }
            case 2: {
                ReferenceBook rb = new ReferenceBook();
                rb.addBook();
                books.add(rb);
                break;
            }
            default: {
                System.out.println("Choice invalid !!!");
            }
        }
    }
    
    public void updateBook(String id) throws ParseException{
        for(IBook book : books){
            if(book.getBookId().equals(id)){
                book.updateBook(id);
                System.out.println("Update suscessful");
                return;
            }
        }
        System.out.println("Found not ID ");
    }
    
    public void deleteBookById(String id) throws ParseException{
        for(IBook book : books){
            if(book.getBookId().equals(id)){
                books.remove(book);
                System.out.println("Detele Suscessful");
                break;
            }
        }
        System.out.println("Found not ID ");
    }
    
    public void findBookById(String id){
        for(IBook book : books){
            if(book.getBookId().equals(id)){
                book.displayBook();
            }
        }
        System.out.println("Found not ID ");
    }
    
    public void displayAllBook(){
        for(IBook book : books){
            book.displayBook();
        }
    }
    
    public void total(){
        double total = 0 ;
        double totalT = 0 ;
        double totalR = 0 ;
        for(IBook book : books){
            if(book instanceof TextBook){
                totalT += book.calculateTotal();
            }else{
                totalR += book.calculateTotal();
            }
        }
        total = totalT + totalR;
        System.out.println("Total TextBook: " + totalT);
        System.out.println("Total ReferanceBook: " + totalR);
        System.out.println("Total Book: " + total);
    }
            
}
