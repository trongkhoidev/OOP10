
package nguyentrongkhoi_5867.Exercise8_Interface;


public class TextBook extends Book {
    String subject;

    public TextBook(String subject, String id, String title, double basePrice) {
        super(id, title, basePrice);
        this.subject = subject;
    }
    
    public TextBook(){}
    
    @Override
    public double calculatePrice(){
        return getBasePrice() * 0.1 ;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("SUbject: " + subject);
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
}
