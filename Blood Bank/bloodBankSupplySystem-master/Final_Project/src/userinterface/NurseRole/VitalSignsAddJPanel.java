/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NurseRole;

import business.Enterprise.Enterprise;
import business.Organization.NurseOrganization;
import business.Organization.Organization;
import business.Person.Donor;
import business.Person.VitalSigns;
import business.UserAccount.UserAccount;
import business.WorkQueue.DonorWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author piyush sharma
 */
public class VitalSignsAddJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VitalSignsAddJPanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Enterprise enterprise;

    DonorWorkRequest request;
    Organization organization;

    VitalSignsAddJPanel(JPanel userProcessContainer, UserAccount userAccount, DonorWorkRequest request, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.request = request;
        this.enterprise = enterprise;
    }

    public void checkVital() {
        float bp = Float.parseFloat(bloodPressJTxt.getText());
        float temp = Float.parseFloat(tempJTxt.getText());
        float weight = Float.parseFloat(weightJTxt.getText());
        float haemo = Float.parseFloat(haemoJTxt.getText());
        if (bp > 80 && bp < 120) {
            if (temp < 99.5 && temp > 97.7) {
                if (weight > 110 && weight < 400) {
                    if (haemo > 13 && haemo < 15.1) {
                        request.setStatus("VitalSigns Taken");

                    } else {
                        request.setStatus("Assign Nutrisionist");
                    }
                } else {
                    request.setStatus("Assign Nutrisionist");
                }
            } else {
                request.setStatus("Assign Nutrisionist");
            }
        } else {
            request.setStatus("Assign Nutrisionist");
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

        jLabel3 = new javax.swing.JLabel();
        bloodPressJTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        weightJTxt = new javax.swing.JTextField();
        addVitalsBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        haemoJTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tempJTxt = new javax.swing.JTextField();
        bloodGrpComboBx = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("BloodPressure");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 143, -1));

        bloodPressJTxt.setText(" ");
        add(bloodPressJTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 107, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("BloodGroup");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 143, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Weight");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 143, -1));

        weightJTxt.setText(" ");
        add(weightJTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 107, -1));

        addVitalsBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addVitalsBtn.setText("Add Vitals");
        addVitalsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVitalsBtnActionPerformed(evt);
            }
        });
        add(addVitalsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 160, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Haemoglobin Level");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Record VitalSigns");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 290, 40));

        haemoJTxt.setText(" ");
        add(haemoJTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 107, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Temperature");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 143, -1));

        tempJTxt.setText(" ");
        add(tempJTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 107, -1));

        bloodGrpComboBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        add(bloodGrpComboBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 107, -1));

        backBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        backBtn.setText("<<BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 108, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addVitalsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVitalsBtnActionPerformed
        // TODO add your handling code here:
        if (haemoJTxt.getText().equals("") || tempJTxt.getText().equals("") || bloodPressJTxt.getText().equals("") || weightJTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All VitalSigns are mandatory", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String userName = request.getSender().getUserName();

            Donor donor = (Donor) request.getSender().getPerson();
            VitalSigns vs = donor.getVsh().addVital();
            vs.setBloodGroup((String) bloodGrpComboBx.getSelectedItem());
            vs.setBloodPressure(Float.parseFloat(bloodPressJTxt.getText()));
            vs.setHaemoglobinLevel(Float.parseFloat(haemoJTxt.getText()));
            vs.setTemperature(Float.parseFloat(tempJTxt.getText()));
            vs.setWeight(Float.parseFloat(weightJTxt.getText()));
            checkVital();
            JOptionPane.showMessageDialog(this, "VitalSigns recorded successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

            bloodPressJTxt.setText("");
            haemoJTxt.setText("");
            tempJTxt.setText("");
            weightJTxt.setText("");
        }
    }//GEN-LAST:event_addVitalsBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        request.setBloodGroup((String) bloodGrpComboBx.getSelectedItem());
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NurseWorkAreaJPanel nwjp = (NurseWorkAreaJPanel) component;
        nwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVitalsBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> bloodGrpComboBx;
    private javax.swing.JTextField bloodPressJTxt;
    private javax.swing.JTextField haemoJTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tempJTxt;
    private javax.swing.JTextField weightJTxt;
    // End of variables declaration//GEN-END:variables
}