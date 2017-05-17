/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.util.ArrayList;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class VitalSignsHistory {
    private ArrayList<VitalSigns> vitalSignHistory;

    public VitalSignsHistory() {
        this.vitalSignHistory = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }
    
    public VitalSigns addVital()
    {
        VitalSigns vs = new VitalSigns();
        vitalSignHistory.add(vs);
        return vs;
    }
}
