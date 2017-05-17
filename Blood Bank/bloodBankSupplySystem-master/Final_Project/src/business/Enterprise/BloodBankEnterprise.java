/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class BloodBankEnterprise extends Enterprise{

     HashMap<String, Integer> hash;
    public BloodBankEnterprise(String name) {
        super(name, EnterpriseType.BloodBank);
        hash= new HashMap<>();

        hash.put("A+", 0);
        hash.put("A-", 0);
        hash.put("B+", 0);
        hash.put("B-", 0);
        hash.put("AB+", 0);
        hash.put("AB-", 0);
        hash.put("O+", 0);
        hash.put("O-", 0);
    }

    public HashMap<String, Integer> getHash() {
        return hash;
    }

    public void setHash(HashMap<String, Integer> hash) {
        this.hash = hash;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole()
    {
        return null;
    }
    
}
