/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.NutritionistRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Kaustubh Chaudhari
 */
public class NutritionistOrganization extends Organization{
    public NutritionistOrganization() {
        super(Organization.Type.Nutritionist.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NutritionistRole());
        return roles;
    }
}
