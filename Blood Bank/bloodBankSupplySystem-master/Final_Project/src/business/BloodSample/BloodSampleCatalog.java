/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.BloodSample;

import java.util.ArrayList;

/**
 *
 * @author Kaustubh Chaudhari
 */
public class BloodSampleCatalog {
    private ArrayList<BloodSample> bloodCatalog;
    
    public BloodSampleCatalog() {
        
        bloodCatalog = new ArrayList<>();
    }

    public ArrayList<BloodSample> getBloodCatalog() {
        return bloodCatalog;
    }
    
    public BloodSample addBloodSample()
    {
        BloodSample bs = new BloodSample();
        bloodCatalog.add(bs);
        return bs;
    }
    
    public void DeleteBloodSample(BloodSample bs)
    {
        bloodCatalog.remove(bs);
    }
}
