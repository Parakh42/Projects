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
import business.WorkQueue.DonorWorkRequest;
import business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import userinterface.DonorRole.DonorWorkAreaJPanel;

/**
 *
 * @author piyush sharma
 */
public class DonorRole extends Role {
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, 
            Enterprise enterprise, 
            EcoSystem business) {
      return new DonorWorkAreaJPanel(userProcessContainer, account, organization,enterprise );
     }
    
}
