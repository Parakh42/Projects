/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Person.Employee;
import business.Person.Person;
import business.Role.SystemAdminRole;
import business.UserAccount.UserAccount;

/**
 *
 * @author Kaustubh Chaudhari
 */
public class ConfigureASystem {
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().addEmployee();
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("kaustubh", "kaustubh", (Person)employee, new SystemAdminRole());
        
        return system;    
    }
    
}
