
package nguyentrongkhoi_5867.Exercise8_Interface;

public abstract class Book implements IBook {
    String id;
    String title;
    double basePrice;
    
    public Book(){}
    public Book(String id, String title, double basePrice) {
        this.id = id;
        this.title = title;
        this.basePrice = basePrice;
    }
    
    @Override
    public abstract double calculatePrice();
    @Override
    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Base Price: " + basePrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
}
