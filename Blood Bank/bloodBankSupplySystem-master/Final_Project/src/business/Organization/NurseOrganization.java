/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.NurseRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush sharma
 */
public class NurseOrganization extends Organization {
    
    public NurseOrganization() {
        super(Organization.Type.Nurse.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NurseRole());
        return roles;
    }
    
    
}
