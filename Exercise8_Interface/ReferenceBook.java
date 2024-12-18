
package nguyentrongkhoi_5867.Exercise8_Interface;


public class ReferenceBook extends Book {
    String pulisher;

    public ReferenceBook(String pulisher, String id, String title, double basePrice) {
        super(id, title, basePrice);
        this.pulisher = pulisher;
    }
    
    public ReferenceBook(){}
    
    @Override
    public double calculatePrice(){
        return getBasePrice() * 0.2;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Pulisher: " + pulisher);
    }
}
