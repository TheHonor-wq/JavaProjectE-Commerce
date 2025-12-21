package MainAndSys;

import javax.swing.SwingUtilities;
import GUI.*;
import ecommerce.*;

public class Main {
    public static void main(String[] args) {
        // Run UI on the Event Dispatch Thread for thread safety
    	ECommerceSys.readUserFile();
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }
}