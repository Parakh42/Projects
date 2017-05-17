/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import business.UserAccount.UserAccount;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class Donor extends Person {
    private static int count;
    private int donorId;
    private VitalSignsHistory vsh;

    public Donor() {
        super();
        donorId = count;
        count++;
        this.vsh = new VitalSignsHistory();
    }

    public int getDonorId() {
        return donorId;
    }

    public VitalSignsHistory getVsh() {
        return vsh;
    }
     

    
    
}
