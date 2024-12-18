
package nguyentrongkhoi_5867.Exercise9_Interface;

import java.text.ParseException;


interface IRoom {
    abstract double calculateCost();
    abstract void enterRoomInfo() throws ParseException;
    void updateRoomById(String id) throws ParseException;
    abstract void displayDetails();
}
