/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.LabAssistantRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush sharma
 */
public class LabOrganization extends Organization {
    
    public LabOrganization() {
        super(Organization.Type.Lab.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAssistantRole());
        return roles;
    }
    
}
