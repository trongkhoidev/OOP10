
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Room implements IRoom {
    String id;
    String name;
    double baseCost;
    Date checkinDate; 
    Date checkoutDate;

    public Room(String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }
    public Room(){}
    
    @Override
    public abstract double calculateCost();
    
    @Override
    public void displayDetails(){
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base cost: " + baseCost);
        System.out.println("Checkin Date: " + fm.format(checkinDate));
        System.out.println("CHeckout Date: " + fm.format(checkoutDate));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }
    
    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    
    public long dayStay() {
        if (checkinDate != null && checkoutDate != null) {
            return (checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24);
        }
        return 0;
    }
    

    

}
