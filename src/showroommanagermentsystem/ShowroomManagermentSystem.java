/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package showroommanagermentsystem;

import app.model.Vehicle;
import app.service.VehicleService;
import java.util.List;

/**
 *
 * @author ducnt_c00437
 */
public class ShowroomManagermentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VehicleService service=new VehicleService();
        List<Vehicle> lst= service.getAll();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).getName());
        }
    }
}
