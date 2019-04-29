/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Stock;
import DBL.BookDB;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hnd
 */
public class FindBook extends javax.swing.JFrame {

    /**
     * Creates new form FindBook
     */
    public FindBook() {
        initComponents();
        TableColumnModel columnModel = jTable_BookTable.getColumnModel();
        columnModel.getColumn(4).setPreferredWidth(35);
        showDate();
        showTime();
        Show_Users_In_JTable();
    }
    
     public void close()
    {

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
    
    private void showDate()
    {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jLabelDate.setText(s.format(d) );   
    }
    
    private void showTime()
    {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                jLabelTime.setText(s.format(d));
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
    
    public ArrayList<BookDB> getBookDBList() 
    {
        ArrayList<BookDB> BookDBList = new ArrayList<BookDB>();
        Connection connection = getConnection();

        String query = "SELECT * FROM [ABC__Book_Company].[dbo].[BookInfo] ";
        Statement st;
        ResultSet rs;

        try 
        {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            BookDB user;

            while (rs.next()) 
            {
                user = new BookDB
                (rs.getString("StoredDate"),
                rs.getString("StoredTime"),
                rs.getString("BookID"),
                rs.getString("BookName"),
                rs.getString("Mr_Mrs"),
                rs.getString("BookAuthor"),
                rs.getDouble("BookUnitPrice"),
                rs.getString("BookCategory"));
                BookDBList.add(user);
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return BookDBList;
    }
    
    private void Show_Users_In_JTable()
   {
       ArrayList<BookDB> list = getBookDBList();
       DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
       Object[] row = new Object[8];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getStoredDate();
           row[1] = list.get(i).getStoredTime();
           row[2] = list.get(i).getBookID();
           row[3] = list.get(i).getBookName();
           row[4] = list.get(i).getMr_Mrs();
           row[5] = list.get(i).getBookAuthor();
           row[6] = list.get(i).getBookUnitPrice();
           row[7] = list.get(i).getBookCategory();
           model.addRow(row);
       }
    }

     private void Populate(String BookID, String BookName, String Mr_Mrs, String BookAuthor, String BookUnitPrice, String BookCategory)
    {
         DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
        
        String []rowData={BookID, BookName, Mr_Mrs, BookAuthor, BookUnitPrice, BookCategory};
        
    }
    
    private void Search(String query)
    {
         DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();

        TableRowSorter<DefaultTableModel> tb=new TableRowSorter<DefaultTableModel>(model);
        jTable_BookTable.setRowSorter(tb);
        tb.setRowFilter(RowFilter.regexFilter(query));
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
        jTable_BookTable = new javax.swing.JTable();
        jTextFieldSearchID = new javax.swing.JTextField();
        jButtonBACK = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonEXIT = new javax.swing.JButton();
        jLabelDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelBackGround = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFILE = new javax.swing.JMenu();
        jMenuItemBack = new javax.swing.JMenuItem();
        jMenuItemHOME = new javax.swing.JMenuItem();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEXIT = new javax.swing.JMenuItem();
        jMenuSWITCHUSER = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/FindbookGIF.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, -40, 420, 110);

        jTable_BookTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable_BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stored Date", "Stored Time", "Book ID", "Book Name", "Mr / Mrs", "Book Author", "Book Unit Price", "Book Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_BookTable.setGridColor(new java.awt.Color(255, 255, 153));
        jTable_BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_BookTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 740, 180);

        jTextFieldSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchIDActionPerformed(evt);
            }
        });
        jTextFieldSearchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSearchIDKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldSearchID);
        jTextFieldSearchID.setBounds(110, 110, 370, 30);

        jButtonBACK.setBackground(new java.awt.Color(255, 255, 255));
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
        jButtonBACK.setBounds(30, 360, 80, 25);

        jButtonClose.setBackground(new java.awt.Color(255, 51, 51));
        jButtonClose.setFont(new java.awt.Font("Aharoni", 2, 18)); // NOI18N
        jButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClose.setText("EXIT");
        jButtonClose.setToolTipText("EXIT from the System");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose);
        jButtonClose.setBounds(640, 360, 110, 30);

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
        jButtonEXIT.setBounds(760, 0, 20, 20);

        jLabelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(10, -10, 70, 40);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("||");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, -20, 20, 60);

        jLabelTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelTime);
        jLabelTime.setBounds(100, -10, 80, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(80, 110, 30, 30);

        jLabelSearch.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Search");
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(20, 110, 70, 30);

        jLabel7.setFont(new java.awt.Font("Aharoni", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 153));
        jLabel7.setText("Search Book Information by its ID, Book Name, Category and etc.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 70, 680, 40);

        jLabelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/red.jpg"))); // NOI18N
        getContentPane().add(jLabelBackGround);
        jLabelBackGround.setBounds(0, -470, 1120, 910);

        jMenuFILE.setText("File   ||  ");

        jMenuItemBack.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Go-back-icon.png"))); // NOI18N
        jMenuItemBack.setText("Back to Menu");
        jMenuItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBackActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemBack);

        jMenuItemHOME.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHOME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/House-icon.png"))); // NOI18N
        jMenuItemHOME.setText("Home");
        jMenuItemHOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHOMEActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemHOME);

        jMenuItemLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Log-Out-icon.png"))); // NOI18N
        jMenuItemLogOut.setText("Log-Out");
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemLogOut);

        jMenuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Help-icon.png"))); // NOI18N
        jMenuItemHelp.setText("Help");
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemHelp);
        jMenuFILE.add(jSeparator1);

        jMenuItemEXIT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jMenuItemEXIT.setText("Exit");
        jMenuItemEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEXITActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemEXIT);

        jMenuBar1.add(jMenuFILE);

        jMenuSWITCHUSER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/switch-user-icon.png"))); // NOI18N
        jMenuSWITCHUSER.setText("Switch User");
        jMenuSWITCHUSER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSWITCHUSERMouseClicked(evt);
            }
        });
        jMenuSWITCHUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSWITCHUSERActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuSWITCHUSER);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(794, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BookTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_BookTableMouseClicked

    private void jTextFieldSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchIDActionPerformed

    private void jTextFieldSearchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyReleased
        // TODO add your handling code here:
        String qurey = jTextFieldSearchID.getText().toLowerCase();
        Search (qurey);
    }//GEN-LAST:event_jTextFieldSearchIDKeyReleased

    private void jTextFieldSearchIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyTyped
        // TODO add your handling code here:
        String qurey = jTextFieldSearchID.getText().toLowerCase();
        Search (qurey);
    }//GEN-LAST:event_jTextFieldSearchIDKeyTyped

    private void jButtonBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBACKActionPerformed
        // TODO add your handling code here:
        close();
        UserMenu B = new UserMenu();
        {
            B.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBACKActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:

        int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to EXIT from the System ?", "NOTE", JOptionPane.YES_NO_OPTION);
        if(YesOrNo == 0)
        {
            System.exit(0);
        }
        else
        {

        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jMenuItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackActionPerformed
        // TODO add your handling code here:
        close();
        UserMenu B = new UserMenu();
        {
            B.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemBackActionPerformed

    private void jMenuItemHOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHOMEActionPerformed
        // TODO add your handling code here:
        close();
        HOME SW = new HOME();
        {
            SW.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemHOMEActionPerformed

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Successfully LoggedOut", "NOTE",JOptionPane.INFORMATION_MESSAGE);
        close();
        LOGINS LO = new LOGINS();
        {
            LO.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    private void jMenuItemEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemEXITActionPerformed

    private void jMenuSWITCHUSERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSWITCHUSERMouseClicked
        // TODO add your handling code here:
        close();
        LOGINS SW = new LOGINS();
        {
            SW.setVisible(true);
        }
    }//GEN-LAST:event_jMenuSWITCHUSERMouseClicked

    private void jMenuSWITCHUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSWITCHUSERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuSWITCHUSERActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> Find Book: <br>"
                + "Please Enter the BookID in the given Search Blanks <br>"
                + "to Search for the Books <br> </html>";
        
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
            java.util.logging.Logger.getLogger(FindBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBACK;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBackGround;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFILE;
    private javax.swing.JMenuItem jMenuItemBack;
    private javax.swing.JMenuItem jMenuItemEXIT;
    private javax.swing.JMenuItem jMenuItemHOME;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenu jMenuSWITCHUSER;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable_BookTable;
    private javax.swing.JTextField jTextFieldSearchID;
    // End of variables declaration//GEN-END:variables
}
