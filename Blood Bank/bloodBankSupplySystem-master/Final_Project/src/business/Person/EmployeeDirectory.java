/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.util.ArrayList;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee addEmployee()
    {
        Employee employee = new Employee();
        employeeList.add(employee);
        return employee;
    }
    
    public void removeEmployee(Employee employee)
    {
        employeeList.remove(employee);
    }
}
