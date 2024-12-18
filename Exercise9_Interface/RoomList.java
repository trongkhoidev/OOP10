
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomList {
    ArrayList<Room> roomList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    
    public void addRoom(Room room) throws ParseException{
        fm.setLenient(false);
        if(room instanceof MeetingRoom){
            System.out.println("Enter ID: ");
            String id = sc.nextLine();
            room.setId(id);
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            room.setName(name);
            System.out.println("Enter base Cost: ");
            double baseCost = sc.nextDouble();
            room.setBaseCost(baseCost);
            sc.nextLine();
            System.out.println("Enter checkin Date(dd/MM/yyyy): ");
            String inDate = sc.nextLine();
            room.setCheckinDate(fm.parse(inDate));
            System.out.println("Enter checkout Date(dd/MM/yyyy): ");
            String outDate = sc.nextLine();
            room.setCheckoutDate(fm.parse(outDate));
            System.out.println("Enter capacity: ");
            int capacity = sc.nextInt();
            ((MeetingRoom) room).setCapacity(capacity);
            roomList.add(room);
        } else if(room instanceof BedRoom){
            sc.nextLine();
            System.out.println("Enter ID: ");
            String id = sc.nextLine();
            room.setId(id);
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            room.setName(name);
            System.out.println("Enter base Cost: ");
            double baseCost = sc.nextDouble();
            room.setBaseCost(baseCost);
            sc.nextLine();
            System.out.println("Enter checkin Date(dd/MM/yyyy): ");
            String inDate = sc.nextLine();
            room.setCheckinDate(fm.parse(inDate));
            System.out.println("Enter checkout Date(dd/MM/yyyy): ");
            String outDate = sc.nextLine();
            room.setCheckoutDate(fm.parse(outDate));
            System.out.println("Enter number of bed: ");
            int numberOfBeds = sc.nextInt();
            ((BedRoom) room).setNumberOfBeds(numberOfBeds);
            roomList.add(room);
        }
    }
    
    
    public boolean updateRoomById(String id) throws ParseException{
        fm.setLenient(false);
        for(Room room : roomList){
            if(room.getId().equals(id)){
                if(room instanceof MeetingRoom){
                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    room.setName(name);
                    System.out.println("Enter base Cost: ");
                    double baseCost = sc.nextDouble();
                    room.setBaseCost(baseCost);
                    System.out.println("Enter capacity: ");
                    int capacity = sc.nextInt();
                    ((MeetingRoom) room).setCapacity(capacity);
                    sc.nextLine();
                    System.out.println("Enter checkin Date(dd/MM/yyyy): ");
                    String inDate = sc.nextLine();
                    room.setCheckinDate(fm.parse(inDate));
                    System.out.println("Enter checkout Date(dd/MM/yyyy): ");
                    String outDate = sc.nextLine();
                    room.setCheckoutDate(fm.parse(outDate));
                    System.out.println("Update successful");
                    return true;
                } else if(room instanceof BedRoom){
                    sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    room.setName(name);
                    System.out.println("Enter base Cost: ");
                    double baseCost = sc.nextDouble();
                    room.setBaseCost(baseCost);
                    System.out.println("Enter number of bed: ");
                    int numberOfBeds = sc.nextInt();
                    ((BedRoom) room).setNumberOfBeds(numberOfBeds);
                    sc.nextLine();
                    System.out.println("Enter checkin Date(dd/MM/yyyy): ");
                    String inDate = sc.nextLine();
                    room.setCheckinDate(fm.parse(inDate));
                    System.out.println("Enter checkout Date(dd/MM/yyyy): ");
                    String outDate = sc.nextLine();
                    room.setCheckoutDate(fm.parse(outDate));
                    System.out.println("Update successful");
                    return true;
                }
            }
        }
        System.out.println("Not found ID!");
        return false;
    }
    
    public boolean deleteRoomById(String id){
        for(Room room : roomList){
            if(room.getId().equals(id)){
                roomList.remove(room);
                System.out.println("Delete successful");
                return true;
            }
        }
        System.out.println("Not found ID");
        return false;
    }
    
    public Room findRoomById(String id){
        for(Room room : roomList){
            if(room.getId().equals(id)){
                System.out.println("Find successful");
                room.displayDetails();
                return room;
            }
        }
        System.out.println("Not found ID");
        return null;
    }
    
    public void displayAllRooms(){
        for(Room room : roomList){
            room.displayDetails();
        }
    }
    
    public Room findMostExpensiveRoom(){
        double maxCost = 0;
        Room maxRoom = null;
        for (Room room : roomList) {
            double cost = room.calculateCost();
            if (cost > maxCost) {
                maxCost = cost;
                maxRoom = room;
            }
        }
        maxRoom.displayDetails();
        return maxRoom;
    }
    
    public void countRooms(){
        int countM = 0 ;
        int countB = 0 ;
        for(Room room : roomList){
            if(room instanceof MeetingRoom){
                countM++;
            } else{
                countB++;
            }
        }
        System.out.println("Quantity meeting room: " + countM);
        System.out.println("Quantity bed room: " + countB);
    }
    
    public long dayStay(String id){
        for(Room room : roomList){
            if(room.getId().equals(id)){
                if(room.getCheckinDate() != null && room.getCheckoutDate() != null){
                    return (room.getCheckoutDate().getTime() - room.getCheckinDate().getTime())/ (1000 * 60 * 60 * 24);
                }
            }
        }
        return 0;
    }
}
