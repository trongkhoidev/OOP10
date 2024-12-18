
package nguyentrongkhoi_5867.UI;

import javax.swing.*;
public class Ex2 { 
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Erase your hard disk?");
        System.out.println(choice);
        if (choice == JOptionPane.YES_OPTION) { JOptionPane.showMessageDialog(null, "Disk erased!");
        } else {
        JOptionPane.showMessageDialog(null, "Cancelled.");
        }
    }
}
