/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author PARAKH MAHAJAN
 */
public abstract class Role {
   
    public enum RoleType
    {
        Donor("Donor"),
        Receptionist("Reception"),
        LabAssistant("Lab"),
        Nurse("Nurse"),
        Inventory("Inventory"),
        Nutritionist("Nutritionist"),
        Admin("Admin"),
        HospitalAdmin("HospitalAdmin"),
        Doctor("Doctor"),
        Pharmacist("Pharmacist");
        
        private String value;
        private RoleType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString()
        {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business);
    
    @Override
    public String toString()
    {
        return this.getClass().getName();
    }
}
