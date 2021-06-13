/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Akhir
 */
public class studentpage extends javax.swing.JFrame {
    student st;
    dbconnectivity db = new dbconnectivity();
    admin ad = db.getad("saifullah123");
    
    /**
     * Creates new form student page
     */
    public studentpage(student s, admin a) {
        initComponents();
        st = s;
        ad = a;
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
        reg = new javax.swing.JButton();
        attendance = new javax.swing.JButton();
        withdrawbtn = new javax.swing.JButton();
        transcript = new javax.swing.JButton();
        marksbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT");

        reg.setText("REGISTRATION");
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
        });

        attendance.setText("ATTENDANCE");
        attendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceMouseClicked(evt);
            }
        });

        withdrawbtn.setText("WITHDRAW");
        withdrawbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withdrawbtnMouseClicked(evt);
            }
        });

        transcript.setText("TRANSCRIPT");
        transcript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transcriptMouseClicked(evt);
            }
        });

        marksbtn.setText("Marks");
        marksbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marksbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reg)
                            .addComponent(transcript)
                            .addComponent(attendance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(withdrawbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg)
                    .addComponent(withdrawbtn))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attendance)
                    .addComponent(marksbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(transcript)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
        // TODO add your handling code here:
        try
        {
            ResultSet rs = db.checkregistration();
//            if(st.getcourses() == null){
                if(rs.next() && rs.getInt(2) == 1)
                {
                    studentregistration rg = new studentregistration(st, ad);
                    rg.setVisible(true);
                    rg.pack();
                    rg.setLocationRelativeTo(null);
                    rg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, " REGISTRATION IS INACTIVE, GO TO SAIFULLAH.");
                }
//            }
//            else{
//                JOptionPane.showMessageDialog(null, " You have already registered your courses.");
//            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_regMouseClicked

    private void withdrawbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawbtnMouseClicked
        // TODO add your handling code here:
        try {
            ResultSet rs = db.show(st);
            if(rs.next()){
                withdraw rg = new withdraw(st, ad);
                rg.setVisible(true);
                rg.pack();
                rg.setLocationRelativeTo(null);
                rg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null, "You are not registered in any course");
            }
        }    
        catch(Exception e){
             System.out.println(e);
        }    
    }//GEN-LAST:event_withdrawbtnMouseClicked

    private void transcriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transcriptMouseClicked
        
        try {
            ResultSet rs = db.show(st);
            if(rs.next()){
                transcript tr = new transcript(st);
                tr.setVisible(true);
                tr.pack();
                tr.setLocationRelativeTo(null);
                tr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null, "You are not registered in any course");
            }
        }
        catch(Exception e){
             System.out.println(e);
        }
    }//GEN-LAST:event_transcriptMouseClicked

    private void attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceMouseClicked
        
        try {
            ResultSet rs = db.show(st);
            if(rs.next()){
                attendance at = new attendance(st);
                at.setVisible(true);
                at.pack();
                at.setLocationRelativeTo(null);
                at.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null, "You are not registered in any course");
            }
        }
        catch(Exception e){
             System.out.println(e);
        }
    }//GEN-LAST:event_attendanceMouseClicked

    private void marksbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marksbtnMouseClicked
        try {
            ResultSet rs = db.show(st);
            if(rs.next()){
                markstab at = new markstab(st, ad);
                at.setVisible(true);
                at.pack();
                at.setLocationRelativeTo(null);
                at.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null, "You are not registered in any course");
            }
        }
        catch(Exception e){
             System.out.println(e);
        }
    }//GEN-LAST:event_marksbtnMouseClicked

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
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton marksbtn;
    private javax.swing.JButton reg;
    private javax.swing.JButton transcript;
    private javax.swing.JButton withdrawbtn;
    // End of variables declaration//GEN-END:variables
}
