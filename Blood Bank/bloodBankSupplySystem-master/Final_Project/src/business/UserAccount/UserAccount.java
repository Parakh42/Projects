/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.Person.Person;
import business.Role.Role;
import business.WorkQueue.WorkQueue;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class UserAccount {
    
    private String userName;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    @Override
    public String toString()
    {
        return userName;
    }
    
    
}
