/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyentrongkhoi_5867.Exercise8_Interface;

import java.util.ArrayList;
import java.util.Scanner;


public class BookList {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    void addBook(Book book){
        System.out.println("Enter type BOOK(1.TextBook, 2. ReferenceBook) : ");
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Enter id: " );
            String id = sc.nextLine();
            book.setId(id);
            System.out.println("Enter title: ");
            String title = sc.nextLine();
            book.setTitle(title);
            System.out.println("Enter Base Price: ");
            double basePrice = sc.nextDouble();
            book.setBasePrice(basePrice);
            books.add(book);
        }
        
    }
    
    boolean updateBookById(String id){
        for(Book book : books){
            if(book.getId().equals(id)){
                System.out.println("Enter title: ");
                String title = sc.nextLine();
                book.setTitle(title);
                System.out.println("Enter Base Price: ");
                double basePrice = sc.nextDouble();
                book.setBasePrice(basePrice);
                return true;
            }
        }
        return false;
    }
    
    boolean deleteBookById(String id){
        for(Book book : books){
            if(book.getId().equals(id)){
                 books.remove(book);
                 return true;
            }
        }
        return false;
    }
    
    Book findBookById(String id){
        for(Book book : books){
            if(book.getId().equals(id)){
                book.displayDetails();
                break;
            }
        }
        return null;
    }
    
    void displayAllBooks(){
        for(Book book : books){
            book.displayDetails();
        }
    }
    
    Book findMostExpensiveBook(){
        double maxPrice = 0;
        String maxId = "";
        for(Book book : books){
            if(book.getBasePrice() > maxPrice){
                maxPrice = book.getBasePrice();
                maxId = book.getId();
            }
        }
        findBookById(maxId);
        return null;
    }
    
    void countBook(){
        int count = 0;
        for(Book book : books){
            count++;
        }
    }
}
