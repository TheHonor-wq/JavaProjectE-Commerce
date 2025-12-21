package ecommerce;

import javax.swing.SwingUtilities;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        // Run UI on the Event Dispatch Thread for thread safety
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }
}