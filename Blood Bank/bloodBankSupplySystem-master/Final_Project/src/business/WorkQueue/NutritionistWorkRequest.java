/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.UserAccount.UserAccount;

/**
 *
 * @author piyush sharma
 */
public class NutritionistWorkRequest extends WorkRequest {
    
      private UserAccount user;

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
    
    @Override
    public String toString(){
        return this.getMessage();
    }
}
