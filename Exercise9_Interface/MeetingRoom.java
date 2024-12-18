
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class MeetingRoom extends Room implements IRoom {
    private int capacity;

    public MeetingRoom(int capacity, String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.capacity = capacity;
    }
    
    public MeetingRoom(){}

    public MeetingRoom(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public double calculateCost(){
        double cost = baseCost;
        if(capacity > 50){
            cost += baseCost*0.2;
        }
        return cost;
    }
    
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Capacity: " + capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
   

    
}
