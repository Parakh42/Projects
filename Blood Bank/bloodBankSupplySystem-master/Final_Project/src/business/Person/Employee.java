/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class Employee extends Person{
    private static int count;
    private int employeeId;

    public Employee() {
        employeeId = count;
        count++;
    }

    public int getEmployeeId() {
        return employeeId;
    }

}
