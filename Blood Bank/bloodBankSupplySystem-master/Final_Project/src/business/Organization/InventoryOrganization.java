/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.BloodSample.BloodSample;
import business.Role.InventoryRole;
import business.Role.LabAssistantRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush sharma
 */
public class InventoryOrganization extends Organization {
    private ArrayList<BloodSample> bloodCatalog;
    
    public InventoryOrganization() {
        super(Organization.Type.Inventory.getValue());
        bloodCatalog = new ArrayList<>();
    }

    public ArrayList<BloodSample> getBloodCatalog() {
        return bloodCatalog;
    }
    
    public BloodSample AddBloodSample()
    {
        BloodSample bs = new BloodSample();
        bloodCatalog.add(bs);
        return bs;
    }
    
    public void DeleteBloodSample(BloodSample bs)
    {
        bloodCatalog.remove(bs);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InventoryRole());
        return roles;
    }
    
    
}
