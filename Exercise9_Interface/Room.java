
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


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
    public void enterRoomInfo() throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        fm.setLenient(false);
        System.out.println("Enter ID: ");
        id = sc.nextLine();
        System.out.println("Enter Name: ");
        name = sc.nextLine();
        System.out.println("Enter base Cost: ");
        baseCost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter checkin Date(dd/MM/yyyy): ");
        String inDate = sc.nextLine();
        checkinDate = fm.parse(inDate);
        System.out.println("Enter checkout Date(dd/MM/yyyy): ");
        String outDate = sc.nextLine();
        checkoutDate = fm.parse(outDate);
    }
    
    @Override
    public void updateRoomById(String id)  throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        if(this.id.equals(id)){
            System.out.println("Enter Name: ");
            name = sc.nextLine();
            System.out.println("Enter base Cost: ");
            baseCost = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter checkin Date(dd/MM/yyyy): ");
            String inDate = sc.nextLine();
            checkinDate = fm.parse(inDate);
            System.out.println("Enter checkout Date(dd/MM/yyyy): ");
            String outDate = sc.nextLine();
            checkoutDate = fm.parse(outDate);
        }
    }
    
    @Override
    public void displayDetails(){
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base cost: " + baseCost);
        System.out.println("Checkin Date: " + fm.format(checkinDate));
        System.out.println("Checkout Date: " + fm.format(checkoutDate));
        System.out.println("Day stay: " + caculateCaculateDayStays());
    }
    
    public long caculateCaculateDayStays() {
        if (checkinDate != null && checkoutDate != null) {
            return (checkoutDate.getTime() - checkinDate.getTime()) / (1000 * 60 * 60 * 24);
        }
        return 0;
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

}
