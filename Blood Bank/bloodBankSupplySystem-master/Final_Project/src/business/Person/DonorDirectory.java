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
public class DonorDirectory {
    private ArrayList<Donor> donorList;

    public DonorDirectory() {
        this.donorList = new ArrayList<>();
    }

    public ArrayList<Donor> getDonorList() {
        return donorList;
    }
    
    public Donor addDonor()
    {
        Donor donor = new Donor();
        donorList.add(donor);
        return donor;
    }
    
    public void removeDonor(Donor donor)
    {
        donorList.remove(donor);
    }
}
