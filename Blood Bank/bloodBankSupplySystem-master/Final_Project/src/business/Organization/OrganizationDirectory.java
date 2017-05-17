/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import java.util.ArrayList;
import business.Organization.Organization.Type;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Donor.getValue())){
            organization = new DonorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Nurse.getValue())){
            organization = new NurseOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Receptionist.getValue())){
            organization = new ReceptionOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Nutritionist.getValue())){
            organization = new NutritionistOrganization();
            organizationList.add(organization);
        }
        
        else if(type.getValue().equals(Type.HospitalAdmin.getValue())){
            organization = new HospitalAdminOrganization();
            organizationList.add(organization);
        }
        
        else if(type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        
        else if(type.getValue().equals(Type.Pharmacist.getValue())){
            organization = new PharmacistOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
