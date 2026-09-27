/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vitalsigns;
import java.util.ArrayList;

/**
 * Info 5100
 * Shai Rashada Parasram
 * Lab 2
 * 9/26/2026
 * VitalSignsHistory.java: stores and manages multiple records using a arraylist
 * @author shai8
 */

public class VitalSignsHistory {

    private ArrayList<VitalSigns> history;

    public VitalSignsHistory() {
        history = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getHistory() {
        return history;
    }

    public VitalSigns addNewVitals() {

        VitalSigns newVitals = new VitalSigns();

        history.add(newVitals);

        return newVitals;
    }

    public void deleteVitals(VitalSigns vitalSigns) {
        history.remove(vitalSigns);
    }
}