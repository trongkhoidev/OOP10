
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.text.ParseException;
import java.util.Scanner;


public class Processor {
    public static void main(String[] args) throws ParseException {
        RoomList rooms = new RoomList();
    
        Scanner sc = new Scanner(System.in);

        int choice;
        do{
            System.out.println("1. Add a new meeting room");
            System.out.println("2. Add a new bed room");
            System.out.println("3. Update Room by ID");
            System.out.println("4. Delete Room by ID");
            System.out.println("5. Find Room by ID");
            System.out.println("6. Display all Rooms");
            System.out.println("7. Find the most expensive Room");
            System.out.println("8. Count Room");
            System.out.println("9. Exit program");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1: {
                    MeetingRoom mt = new MeetingRoom();
                    rooms.addRoom(mt);
                    break;
                }
                case 2: {
                    BedRoom bd = new BedRoom();
                    rooms.addRoom(bd);
                    break;
                }
                case 3: {
                    System.out.println("Enter ID want to update: ");
                    String id = sc.nextLine();
                    rooms.updateRoomById(id);
                    break;
                }
                case 4: {
                    System.out.println("Enter ID want to delete: ");
                    String id = sc.nextLine();
                    rooms.deleteRoomById(id);
                    break;
                }
                case 5: {
                    System.out.println("Enter ID want to find: ");
                    String id = sc.nextLine();
                    rooms.findRoomById(id);
                    break;
                }
                case 6: {
                    System.out.println("===LIST ROOM===");
                    rooms.displayAllRooms();
                    break;
                }
                case 7: {
                    System.out.println("Room has is the most expensive: ");
                    rooms.findMostExpensiveRoom();
                    break;
                }
                case 8: {
                    rooms.countRooms();
                    break;
                }
                case 9: {
                    System.out.println("Exit Program!!!");
                    break;
                }
                default:{
                    System.out.println("Choice invalid, Re-enter your choice(1-10) please!!!!");
                    break;
                }          
            }
        }while(choice != 9);
    }
}
