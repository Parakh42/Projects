/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Organization.AdminOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdminRole.AdminWorkAreaJPanel;

/**
 *
 * @author piyush sharma
 */
public class AdminRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business){
        
        return new AdminWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
}
