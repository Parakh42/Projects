/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminRole;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Person.Employee;
import business.Person.Person;
import business.Role.AdminRole;
import business.Role.HospitalAdminRole;
import business.Role.Role;
import business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaustubh Chaudhari
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseAdminJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;

    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateTable();
        populateNetworkComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getName();
                    row[2] = userAccount.getUserName();

                    model.addRow(row);
                }
            }
        }
    }

    private void populateNetworkComboBox() {
        networkJComboBox.removeAllItems();

        for (Network network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Network network) {
        enterpriseJComboBox.removeAllItems();

        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseJComboBox.addItem(enterprise);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        enterpriseJComboBox = new javax.swing.JComboBox();
        usernameJTextField = new javax.swing.JTextField();
        firstNameJTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        emailJTextField = new javax.swing.JTextField();
        ageJTextField = new javax.swing.JTextField();
        contactJTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox();
        passwordJTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Manage Enterprise Admin");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 440, 40));

        enterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise name ", "Network", "Username"
            }
        ));
        jScrollPane1.setViewportView(enterpriseTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 830, 130));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 84, 26));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Enterprise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 84, 25));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Username");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 98, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Password");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 98, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Email");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 127, -1));

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });
        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 190, -1));

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 190, -1));
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 410, -1));
        add(firstNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 410, -1));

        backButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        backButton.setText("<<Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, -1, -1));

        submitButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitButton.setText("Create an admin");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Last Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 127, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("First Name");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 98, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("Gender");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 126, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("Contact");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 126, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("Address");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 126, -1));
        add(lastNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 410, -1));
        add(emailJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 410, -1));

        ageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageJTextFieldActionPerformed(evt);
            }
        });
        add(ageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 410, -1));
        add(contactJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 410, -1));

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane2.setViewportView(addressTextArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 410, 70));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setText("Age");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 126, -1));

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        add(genderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 100, 20));
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 410, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }

    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    
    public boolean validation(){
        if(usernameJTextField.getText().equals("") || passwordJTextField.getText().equals("")|| firstNameJTextField.getText().equals("")||
                lastNameJTextField.getText().equals("")||emailJTextField.getText().equals("")|| ageJTextField.getText().equals("")||
                contactJTextField.getText().equals("")||addressTextArea.getText().equals("")){
        
            
            JOptionPane.showMessageDialog(null,"All fields are mandatory");
            return false;
        }   
        else{
            String namePattern = "[a-zA-Z]+\\.?";
            String name = firstNameJTextField.getText();
             
        if(!(name.matches(namePattern)))
        {
                    
        JOptionPane.showMessageDialog(null, "Please enter a valid first name");
        return false;
        }
            
            
             String namePattern2 = "[a-zA-Z]+\\.?";
             String lastName = lastNameJTextField.getText();
             
             if(!(lastName.matches(namePattern2)))
                {
                   
                    JOptionPane.showMessageDialog(null, "Please enter a valid last name");
                    return false;
                }
             
             
             String emailPattern= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
             String email=emailJTextField.getText();
             
             if(!(email.matches(emailPattern)))
             {
                 
                 JOptionPane.showMessageDialog(null, "Please enter a valid email ID ");
                 return  false;
             } 
             
        }
        
        
        return true;
        
    }
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        if(validation()){
            
             
        try{
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        Employee employee = enterprise.getEmployeeDirectory().addEmployee();
        String userName = usernameJTextField.getText();
        String password = passwordJTextField.getText();
        employee.setFirstName(firstNameJTextField.getText());
        employee.setLastName(lastNameJTextField.getText());
        employee.setEmailId(emailJTextField.getText());
        employee.setAge(Integer.parseInt(ageJTextField.getText()));
        employee.setPhoneNumber(contactJTextField.getText());
        employee.setAddress(addressTextArea.getText());
        employee.setGender((String) genderComboBox.getSelectedItem());
        Role role=null;
        if(enterprise.getEnterpriseType() == Enterprise.EnterpriseType.BloodBank){
            role=new AdminRole();
        }
        else {
            role=new HospitalAdminRole();
        }
        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(userName, password, (Person) employee, role);
        populateTable();
        JOptionPane.showMessageDialog(this, "Enterprise Admin is added successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

        usernameJTextField.setText("");
        passwordJTextField.setText("");
        firstNameJTextField.setText("");
        lastNameJTextField.setText("");
        emailJTextField.setText("");
        ageJTextField.setText("");
        contactJTextField.setText("");
        addressTextArea.setText("");
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "Please select appropriate values in age field");
        }
        
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void ageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField contactJTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseTable;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
