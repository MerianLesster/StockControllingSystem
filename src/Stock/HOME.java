/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;


import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Lesster
 */
public class HOME extends javax.swing.JFrame {

    /**
     * Creates new form Authentication_Level
     */
    public HOME() {
       initComponents();       
       showDate();
       showTime();
    }

    public void close()
    {

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
   public void showDate()
    {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jMenuDate.setText("||  Current Date - " + s.format(d) + "     || ");   
    }
    
    public void showTime()
    {
        new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                jMenuTime.setText("Current Time - " + s.format(d));    
            }
        }).start();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonEXIT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jLabelGif = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemLogin = new javax.swing.JMenuItem();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEXIT = new javax.swing.JMenuItem();
        jMenuDate = new javax.swing.JMenu();
        jMenuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HOME PAGE");
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome To  ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 580, 30);

        jLabel2.setFont(new java.awt.Font("Felix Titling", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABC Book Company");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 160, 480, 50);

        jButtonEXIT.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEXIT.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButtonEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jButtonEXIT.setToolTipText("EXIT from the System");
        jButtonEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEXITActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEXIT);
        jButtonEXIT.setBounds(630, 0, 20, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/company-logo.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 10, 366, 110);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Property of ABC Enterprise.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 440, 134, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Terms of Service | Licensing & Reprints | About Us | Privacy Policy | Advertise ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 460, 377, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Copyright 2017 QuinStreet Inc. All Rights Reserved.");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(190, 480, 251, 14);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/powerrrrd.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(500, 430, 130, 70);

        jButtonLogin.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setFont(new java.awt.Font("Aharoni", 2, 18)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setToolTipText("Click to Proceed");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(130, 230, 110, 30);

        jButtonClose.setBackground(new java.awt.Color(255, 51, 51));
        jButtonClose.setFont(new java.awt.Font("Aharoni", 2, 18)); // NOI18N
        jButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClose.setText("CLOSE");
        jButtonClose.setToolTipText("EXIT from the System");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose);
        jButtonClose.setBounds(130, 310, 110, 30);

        jButtonHelp.setBackground(new java.awt.Color(51, 204, 255));
        jButtonHelp.setFont(new java.awt.Font("Aharoni", 2, 18)); // NOI18N
        jButtonHelp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHelp.setText("HELP");
        jButtonHelp.setToolTipText("Search for HELP");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHelp);
        jButtonHelp.setBounds(130, 270, 110, 30);

        jLabelGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/book.gif"))); // NOI18N
        jLabelGif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabelGif);
        jLabelGif.setBounds(120, 210, 440, 210);

        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/nature.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 650, 510);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu1.setText("File");

        jMenuItemLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Log-Out-icon.png"))); // NOI18N
        jMenuItemLogin.setText("Login");
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemLogin);

        jMenuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Help-icon.png"))); // NOI18N
        jMenuItemHelp.setText("Help");
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemHelp);
        jMenu1.add(jSeparator1);

        jMenuItemEXIT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jMenuItemEXIT.setText("Exit");
        jMenuItemEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEXITActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEXIT);

        jMenuBar1.add(jMenu1);

        jMenuDate.setText("Date");
        jMenuBar1.add(jMenuDate);

        jMenuTime.setText("Time");
        jMenuBar1.add(jMenuTime);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(665, 566));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        close();
        LOGINS i = new LOGINS();
        {
            i.setVisible(true);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        getToolkit().beep();
        int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to EXIT from the System ?", "NOTE", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0)
            {
                System.exit(0);
            }
            else
            {
                
            }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jMenuItemEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemEXITActionPerformed

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        // TODO add your handling code here:
        close();
        LOGINS i = new LOGINS();
        {
            i.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> This is a Stock Controlling Information System which Helps <br>"
                + "to Generate Records of the Books In and Out. <br>"
                + "There are 3 User Levels and they are : <br>"
                + "* Administrator User - (Add new User, Controll all the operations)<br> "
                + "* Stock Controller User - (Add, Update, Delete and Search Book Information)<br>"
                + "* User - (View and Search Book Information, Order Book)<br></html>";
        
        JOptionPane optionpane = new JOptionPane();
        optionpane.setMessage(msg);
        optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog=optionpane.createDialog(null, "Help");
        dialog.setVisible(true);
        
       // JOptionPane.showMessageDialog(rootPane, "This is a Stock Controlling Information System"
         //       + "Which Helps to Generate Records of the Books In and Out.", "HELP",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> This is a Stock Controlling Information System which Helps <br>"
                + "to Generate Records of the Books In and Out. <br>"
                + "There are 3 User Levels and they are : <br>"
                + "* Administrator User - (Add new User, Controll all the operations)<br> "
                + "* Stock Controller User - (Add, Update, Delete and Search Book Information)<br>"
                + "* User - (View and Search Book Information, Order Book)<br></html>";
        
        JOptionPane optionpane = new JOptionPane();
        optionpane.setMessage(msg);
        optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog=optionpane.createDialog(null, "Help");
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemHelpActionPerformed

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
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelGif;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDate;
    private javax.swing.JMenuItem jMenuItemEXIT;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenu jMenuTime;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
