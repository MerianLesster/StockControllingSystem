/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import DBL.LoginDB;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lesster
 */
public class LOGINS extends javax.swing.JFrame {

    /**
     * Creates new form AuthenticationLevels
     */
    public LOGINS() {
        initComponents();
        showDate();
        showTime();
    }

    int i = 1;
   
    
    public void close()
    {

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
    
    private void showDate()
    {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jMenuDate.setText(s.format(d));   
    }
    
    private void showTime()
    {
        new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                jMenuTime.setText(s.format(d));    
            }
        }).start();
    }
    
    public Connection getConnection()
    {
        Connection con;
        try 
        {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            String url = "jdbc:odbc:7447";
            String Username = "hnd";
            String Password = "hnd";
            Class.forName(driver);
           con = (DriverManager.getConnection(url,Username,Password)); 
           return con;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               
           }
           else
           {
              
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSIGNIN = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jLabelastrick1 = new javax.swing.JLabel();
        jLabelastrick2 = new javax.swing.JLabel();
        jTextFieldUserID = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jButtonRESET = new javax.swing.JButton();
        jButtonEXIT = new javax.swing.JButton();
        jButtonBACK = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();
        jCheckBoxSHOW_PW = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelAdmin = new javax.swing.JLabel();
        jLabelStockCont = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelBackGroundImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuDate = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGINS");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 140, 110, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 180, 100, 40);

        jButtonSIGNIN.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jButtonSIGNIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/next.png"))); // NOI18N
        jButtonSIGNIN.setText("Signin");
        jButtonSIGNIN.setToolTipText("Accept Username and Password");
        jButtonSIGNIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSIGNINActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSIGNIN);
        jButtonSIGNIN.setBounds(780, 300, 100, 40);

        jLabelMessage.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelMessage);
        jLabelMessage.setBounds(610, 110, 170, 30);

        jLabelastrick1.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick1);
        jLabelastrick1.setBounds(800, 190, 20, 30);

        jLabelastrick2.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick2);
        jLabelastrick2.setBounds(800, 140, 20, 30);

        jTextFieldUserID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextFieldUserID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUserIDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldUserIDMouseEntered(evt);
            }
        });
        jTextFieldUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUserID);
        jTextFieldUserID.setBounds(600, 140, 190, 30);

        jPasswordFieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldPasswordMouseClicked(evt);
            }
        });
        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });
        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(jPasswordFieldPassword);
        jPasswordFieldPassword.setBounds(600, 190, 190, 30);

        jButtonRESET.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jButtonRESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/File-reset-icon.png"))); // NOI18N
        jButtonRESET.setText("Clear All");
        jButtonRESET.setToolTipText("Clear Username and Password");
        jButtonRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRESETActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRESET);
        jButtonRESET.setBounds(630, 300, 120, 40);

        jButtonEXIT.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jButtonEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jButtonEXIT.setToolTipText("EXIT from the System");
        jButtonEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEXITActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEXIT);
        jButtonEXIT.setBounds(970, 0, 20, 20);

        jButtonBACK.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jButtonBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Go-back-icon.png"))); // NOI18N
        jButtonBACK.setText("Back");
        jButtonBACK.setToolTipText("Go back tp HOME menu");
        jButtonBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBACKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBACK);
        jButtonBACK.setBounds(500, 300, 100, 40);

        jLabelInfo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelInfo.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setText("Please enter the Username and Password to Sign-In");
        getContentPane().add(jLabelInfo);
        jLabelInfo.setBounds(420, 60, 450, 20);

        jCheckBoxSHOW_PW.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW.setText("Show Password");
        jCheckBoxSHOW_PW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSHOW_PWActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSHOW_PW);
        jCheckBoxSHOW_PW.setBounds(840, 190, 120, 23);

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 3));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 90, 550, 200);

        jLabelUser.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/user.png"))); // NOI18N
        jLabelUser.setText("jLabel4");
        getContentPane().add(jLabelUser);
        jLabelUser.setBounds(60, 90, 250, 270);

        jLabelAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/admin_icon.png"))); // NOI18N
        getContentPane().add(jLabelAdmin);
        jLabelAdmin.setBounds(0, 60, 150, 210);

        jLabelStockCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Login.png"))); // NOI18N
        jLabelStockCont.setText("jLabel4");
        getContentPane().add(jLabelStockCont);
        jLabelStockCont.setBounds(150, 60, 260, 260);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Transparent.gif"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 10, 460, 40);

        jLabelBackGroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Abstract-Wallpaper.png"))); // NOI18N
        getContentPane().add(jLabelBackGroundImage);
        jLabelBackGroundImage.setBounds(0, 0, 990, 370);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/House-icon.png"))); // NOI18N
        jMenuHome.setText("Home   || ");
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuHome);

        jMenu2.setText("Current Date -");
        jMenuBar1.add(jMenu2);

        jMenuDate.setText("Date");
        jMenuBar1.add(jMenuDate);

        jMenu1.setText("||");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Current Time -");
        jMenuBar1.add(jMenu3);

        jMenuTime.setText("Time");
        jMenuBar1.add(jMenuTime);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1003, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSIGNINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSIGNINActionPerformed
        // TODO add your handling code here:
             
        
        close();
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        jLabelastrick2.setText("");
        
        String username = jTextFieldUserID.getText();
        String password = jPasswordFieldPassword.getText();

        
        if (username.equals("AdminUser") && (password.equals("a123")))
        {           
            JOptionPane.showMessageDialog(rootPane, "Welcome Administrator User", "Successfully Logged-in",JOptionPane.INFORMATION_MESSAGE);
            
            String query = "insert into [ABC__Book_Company].[dbo].[Logins] (Date, Time, UserID, Password ) values ('"
                +jMenuDate.getText()+"','"+jMenuTime.getText()+"','"+jTextFieldUserID.getText()+"','"
                +jPasswordFieldPassword.getText()+"')";
        
            executeSQlQuery(query, "Added");
            jTextFieldUserID.setText(null);
            jPasswordFieldPassword.setText(null);
            
            close();
            AdminMenu info = new AdminMenu();
            info.setVisible(true);
        }
        else if (username.equals("StockUser") && (password.equals ("s456")))
        {
       
            JOptionPane.showMessageDialog(rootPane, "Welcome Stock Controller User", "Successfully Logged-in",JOptionPane.INFORMATION_MESSAGE);
            
            String query = "insert into [ABC__Book_Company].[dbo].[Logins] (Date, Time, UserID, Password ) values ('"
                +jMenuDate.getText()+"','"+jMenuTime.getText()+"','"+jTextFieldUserID.getText()+"','"
                +jPasswordFieldPassword.getText()+"')";
        
            executeSQlQuery(query, "Added");
            jTextFieldUserID.setText(null);
            jPasswordFieldPassword.setText(null);
            
            close();
            StockControllerMenu info = new StockControllerMenu();
            info.setVisible(true);
        }
        else if (username.equals("User") && (password.equals ("u789")))
        {  
                        
            JOptionPane.showMessageDialog(rootPane, "Welcome User", "Successfully Logged-in",JOptionPane.INFORMATION_MESSAGE);
            
            String query = "insert into [ABC__Book_Company].[dbo].[Logins] (Date, Time, UserID, Password ) values ('"
                +jMenuDate.getText()+"','"+jMenuTime.getText()+"','"+jTextFieldUserID.getText()+"','"
                +jPasswordFieldPassword.getText()+"')";
        
            executeSQlQuery(query, "Added");
            jTextFieldUserID.setText(null);
            jPasswordFieldPassword.setText(null);
            
            close();
            UserMenu info = new UserMenu();
            info.setVisible(true);
        }
             
             
             else if(i==3 && username!="AdminUser"&&password!="a123" )
               {
                 JOptionPane.showMessageDialog(rootPane,"Access Denied"," ERROR",JOptionPane.ERROR_MESSAGE); 
                 JOptionPane.showMessageDialog(rootPane,"Number of Attempts Exceeded!!!"+" "  +i,"ERROR",JOptionPane.ERROR_MESSAGE); 

                 this.dispose();
              }
             else if(i==3 && username!="StockUser"&&password!="s456" )
               {
                 JOptionPane.showMessageDialog(rootPane,"Access Denied"," ERROR",JOptionPane.ERROR_MESSAGE); 
                 JOptionPane.showMessageDialog(rootPane,"Number of Attempts Exceeded!!!"+" "  +i,"ERROR",JOptionPane.ERROR_MESSAGE); 

                 this.dispose();
              }
             else if(i==3 && username!="User"&&password!="u789" )
               {
                 JOptionPane.showMessageDialog(rootPane,"Access Denied"," ERROR",JOptionPane.ERROR_MESSAGE); 
                 JOptionPane.showMessageDialog(rootPane,"Number of Attempts Exceeded!!!"+" "  +i,"ERROR",JOptionPane.ERROR_MESSAGE); 

                 this.dispose();
              }
             else 
               {
                JOptionPane.showMessageDialog(rootPane, "Invalid Attempt" + " " + i, "WARNING", JOptionPane.WARNING_MESSAGE);
                i++;
                jTextFieldUserID.setText("");
                jPasswordFieldPassword.setText("");
                
                jLabelMessage.setText("Invalid Login Details");
            jLabelastrick1.setText("*");
            jLabelastrick2.setText("*");
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error",JOptionPane.ERROR_MESSAGE);
            
            jTextFieldUserID.setForeground(Color.red);
            jPasswordFieldPassword.setText(null);

            }
     
    }//GEN-LAST:event_jButtonSIGNINActionPerformed

    private void jTextFieldUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserIDActionPerformed

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void jButtonRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRESETActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        jLabelastrick2.setText("");
        if(jTextFieldUserID.getText().isEmpty() && jPasswordFieldPassword.getText().isEmpty())
            {
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "There is No data to clear", "ERROR",JOptionPane.YES_NO_CANCEL_OPTION);
            }
        else
        {
        jTextFieldUserID.setText(null);
        jPasswordFieldPassword.setText(null);
        }
    }//GEN-LAST:event_jButtonRESETActionPerformed

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jButtonBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBACKActionPerformed
        // TODO add your handling code here:
        close();
        HOME i = new HOME();
        {
            i.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBACKActionPerformed

    private void jTextFieldUserIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUserIDMouseClicked
        // TODO add your handling code here:
        jTextFieldUserID.setForeground(Color.black);
        //jTextFieldUserName.setText(null);
    }//GEN-LAST:event_jTextFieldUserIDMouseClicked

    private void jPasswordFieldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordMouseClicked
        // TODO add your handling code here:
        //jPasswordFieldPassword.setForeground(Color.black);
       // jPasswordFieldPassword.setText(null);
    }//GEN-LAST:event_jPasswordFieldPasswordMouseClicked

    private void jCheckBoxSHOW_PWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSHOW_PWActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxSHOW_PW.isSelected())
        {
            jPasswordFieldPassword.setEchoChar((char)0);
        }

        else
        {
            jPasswordFieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxSHOW_PWActionPerformed

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHomeMouseClicked
        // TODO add your handling code here:
        close();
        HOME i = new HOME();
        {
            i.setVisible(true);
        }
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void jPasswordFieldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyTyped
        // TODO add your handling code here:
        jTextFieldUserID.setForeground(Color.black);
    }//GEN-LAST:event_jPasswordFieldPasswordKeyTyped

    private void jTextFieldUserIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUserIDMouseEntered
        // TODO add your handling code here:
        jTextFieldUserID.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldUserIDMouseEntered

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
            java.util.logging.Logger.getLogger(LOGINS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGINS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGINS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGINS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGINS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBACK;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JButton jButtonRESET;
    private javax.swing.JButton jButtonSIGNIN;
    private javax.swing.JCheckBox jCheckBoxSHOW_PW;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAdmin;
    private javax.swing.JLabel jLabelBackGroundImage;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelStockCont;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelastrick1;
    private javax.swing.JLabel jLabelastrick2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDate;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenu jMenuTime;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUserID;
    // End of variables declaration//GEN-END:variables
}