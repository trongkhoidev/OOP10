
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
            ((MeetingRoom) room).enterRoomInfo();
            roomList.add(room);
        } else if(room instanceof BedRoom){
            ((BedRoom) room).enterRoomInfo();
            roomList.add(room);
        }
    }
    
    
    public boolean updateRoomById(String id) throws ParseException{
        fm.setLenient(false);
        for(Room room : roomList){
            if(room.getId().equals(id)){
                if(room instanceof MeetingRoom){
                    room.updateRoomById(id);
                    System.out.println("Update successful");
                    return true;
                } else if(room instanceof BedRoom){
                    room.enterRoomInfo();
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
    
}
