/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Akhir
 */
public class withdraw extends javax.swing.JFrame {
    admin ad;
    student st;
    dbconnectivity db = new dbconnectivity();
    /**
     * Creates new form withdraw
     */
    public withdraw(student s, admin a) {
        ad = a;
        st = s;
        initComponents();
        clist.removeAll();
        BindCombo();
    }
    
    public void BindCombo(){
        try {
            ArrayList <courses> c = new ArrayList();
            c = st.getcourses();
            int i = 0;
            String temp = null;
            int csize = c.size();
            while (i < csize) {
                clist.addItem(c.get(i).getname());
                i++;
            }
        }
        catch(Exception e){
             System.out.println(e);
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
        clist = new javax.swing.JComboBox<>();
        donebtn = new javax.swing.JButton();
        okbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SUBJECTS TO BE WITHDRAWN");

        clist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clistMouseClicked(evt);
            }
        });
        clist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clistActionPerformed(evt);
            }
        });

        donebtn.setText("Done");
        donebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donebtnMouseClicked(evt);
            }
        });

        okbtn.setText("OK");
        okbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(clist, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(donebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(clist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(donebtn)
                    .addComponent(okbtn))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clistMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_clistMouseClicked

    private void donebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donebtnMouseClicked
        dispose();
    }//GEN-LAST:event_donebtnMouseClicked

    private void clistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clistActionPerformed

    private void okbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okbtnMouseClicked
        try{
            int i = 0;
            while(!st.getcourses().get(i).getname().equals((String) clist.getSelectedItem())){
                i++;
            }
            st.getadmin(ad);
            st.dropcourse(st.getcourses().get(i));
            db.dbremove(st, (String) clist.getSelectedItem());
            JOptionPane.showMessageDialog(null, "Course Withdrawn Successfully");
        }
        catch(Exception e){
             System.out.println(e);
        }
    }//GEN-LAST:event_okbtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clist;
    private javax.swing.JButton donebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okbtn;
    // End of variables declaration//GEN-END:variables
}