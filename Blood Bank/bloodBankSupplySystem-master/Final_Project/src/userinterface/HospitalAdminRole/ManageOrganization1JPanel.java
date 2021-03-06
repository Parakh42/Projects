/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdminRole;

import business.Organization.Organization;
import business.Organization.Organization.Type;
import business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PARAKH MAHAJAN
 */
public class ManageOrganization1JPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;

    /**
     * Creates new form ManageOrganizationJPanel
     */

    ManageOrganization1JPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        populateTable();
        populateComboBox();
    }

    private void populateComboBox() {
        organizationTypeComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {
            if ((type.getValue().equals(Type.Doctor.getValue())) || (type.getValue().equals(Type.Pharmacist.getValue()))) {
                organizationTypeComboBox.addItem(type);
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) manageOrganizationTable.getModel();
        model.setRowCount(0);

        for (Organization organization : organizationDirectory.getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            model.addRow(row);
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
        manageOrganizationTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        organizationTypeComboBox = new javax.swing.JComboBox();
        BtnAddOrganization = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Organization");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 41));

        manageOrganizationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane1.setViewportView(manageOrganizationTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 740, 120));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Organization Type");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 30));

        organizationTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 100, 30));

        BtnAddOrganization.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        BtnAddOrganization.setText("Add Organization");
        BtnAddOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddOrganizationActionPerformed(evt);
            }
        });
        add(BtnAddOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 180, -1));

        BtnBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        BtnBack.setText("<<Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        add(BtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 94, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddOrganizationActionPerformed
        // TODO add your handling code here:
        Type type = (Type) organizationTypeComboBox.getSelectedItem();
        organizationDirectory.createOrganization(type);
        populateTable();
        JOptionPane.showMessageDialog(this, "Organization is added successfuly", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnAddOrganizationActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_BtnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddOrganization;
    private javax.swing.JButton BtnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable manageOrganizationTable;
    private javax.swing.JComboBox organizationTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
