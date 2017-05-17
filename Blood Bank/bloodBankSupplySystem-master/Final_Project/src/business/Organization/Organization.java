/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Person.DonorDirectory;
import business.Person.EmployeeDirectory;
import business.Role.Role;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author PARAKH MAHAJAN
 */
public abstract class Organization {
    private String name;
    private int organizationID;
    private static int counter;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private DonorDirectory donorDirectory;

    public Organization(String name) {
        this.name = name;
        organizationID = counter;
        ++counter;
        workQueue = new WorkQueue();
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory=new EmployeeDirectory();
        donorDirectory=new DonorDirectory();
    }
    
    public enum Type
    {
        Donor("Donor Organization"), Receptionist("Reception Organization"), Lab("Lab Organization"), 
        Nurse("Nurse Organization"),
        Inventory("Inventory Organization"), Admin("Admin Organization") , Nutritionist("Nutritionist Organization"), 
        Pharmacist("Pharmacist Organization"), Doctor("Doctor Organization"), HospitalAdmin("HospitalAdmin Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public DonorDirectory getDonorDirectory() {
        return donorDirectory;
    }
    
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
