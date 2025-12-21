package MainAndSys;

import javax.swing.SwingUtilities;
import GUI.*;
import ecommerce.*;

public class Main {
    public static void main(String[] args) {
      
    	ECommerceSys.readUserFile();
    	ECommerceSys.readProductFile();
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }
}