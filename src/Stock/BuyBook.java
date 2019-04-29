/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Stock;

import DBL.BuyBookDB;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hnd
 */
public class BuyBook extends javax.swing.JFrame {

    /**
     * Creates new form BuyBook
     */
    public BuyBook() {
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
    
    public ArrayList<BuyBookDB> getBuyBookDBList() 
    {
        ArrayList<BuyBookDB> BuyBookDBList = new ArrayList<BuyBookDB>();
        Connection connection = getConnection();

        String query = "SELECT * FROM [ABC__Book_Company].[dbo].[BUY_Book] ";
        Statement st;
        ResultSet rs;

        try 
        {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            BuyBookDB user;

            while (rs.next()) 
            {
                user = new BuyBookDB
                (rs.getString("StoredDate"),
                rs.getString("StoredTime"),
                rs.getString("BookID"),
                rs.getString("BookName"),
                rs.getString("Mr_Mrs"),
                rs.getString("BookAuthor"),
                rs.getDouble("BookUnitPrice"),
                rs.getString("BookCategory"));
                BuyBookDBList.add(user);
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return BuyBookDBList;
    }
    
    private void Show_Users_In_JTable()
   {
       ArrayList<BuyBookDB> list = getBuyBookDBList();
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
    
    
public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Data Not "+message);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBookID = new javax.swing.JTextField();
        jTextFieldBookName = new javax.swing.JTextField();
        jTextFieldBookAuthor = new javax.swing.JTextField();
        jComboBoxMr_Mrs = new javax.swing.JComboBox<String>();
        jTextFieldBookUnitprice = new javax.swing.JTextField();
        jComboBoxCategory = new javax.swing.JComboBox<String>();
        jButtonBuy = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonClearTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEXIT = new javax.swing.JButton();
        jButtonBACK = new javax.swing.JButton();
        jLabelDate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_BookTable = new javax.swing.JTable();
        jLabelBackgroundIMAGE = new javax.swing.JLabel();
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

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 110, 100, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Title");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 150, 120, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Author");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 190, 130, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Unit Price");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 230, 140, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 270, 110, 30);
        getContentPane().add(jTextFieldBookID);
        jTextFieldBookID.setBounds(260, 110, 100, 30);
        getContentPane().add(jTextFieldBookName);
        jTextFieldBookName.setBounds(260, 150, 100, 30);

        jTextFieldBookAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBookAuthorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBookAuthor);
        jTextFieldBookAuthor.setBounds(260, 190, 100, 30);

        jComboBoxMr_Mrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr.", "Mrs.", "Ms." }));
        jComboBoxMr_Mrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMr_MrsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxMr_Mrs);
        jComboBoxMr_Mrs.setBounds(200, 190, 60, 20);

        jTextFieldBookUnitprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBookUnitpriceActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBookUnitprice);
        jTextFieldBookUnitprice.setBounds(260, 230, 100, 30);

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Childrens", "Adventure", "Horror", "Romance" }));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategory);
        jComboBoxCategory.setBounds(260, 270, 100, 30);

        jButtonBuy.setBackground(new java.awt.Color(0, 255, 255));
        jButtonBuy.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        jButtonBuy.setText("Purchase Order");
        jButtonBuy.setToolTipText("Add the above given book information");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuy);
        jButtonBuy.setBounds(10, 340, 160, 30);

        jButtonUpdate.setBackground(new java.awt.Color(0, 255, 255));
        jButtonUpdate.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/update.png"))); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.setToolTipText("Update the selected book information");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(180, 340, 110, 30);

        jButtonDelete.setBackground(new java.awt.Color(0, 255, 255));
        jButtonDelete.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/clearTextfield.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.setToolTipText("Delete the selected book information");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete);
        jButtonDelete.setBounds(300, 340, 100, 30);

        jLabel10.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 51));
        jLabel10.setText("These Following Books Has Been Purchased");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(400, 90, 330, 40);

        jButtonClear.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClear.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/File-reset-icon.png"))); // NOI18N
        jButtonClear.setText("Clear TextFields");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear);
        jButtonClear.setBounds(130, 380, 160, 30);

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
        jButtonClose.setBounds(1020, 340, 110, 30);

        jButtonClearTable.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClearTable.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonClearTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/clearTable.png"))); // NOI18N
        jButtonClearTable.setText("Clear Table");
        jButtonClearTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearTableActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClearTable);
        jButtonClearTable.setBounds(440, 340, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/PurchaseOrderGIF.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, -70, 480, 180);

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
        jButtonEXIT.setBounds(1140, 0, 20, 20);

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
        jButtonBACK.setBounds(0, 0, 80, 25);

        jLabelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(90, -10, 70, 40);

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("||");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(160, -20, 20, 60);

        jLabelTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelTime);
        jLabelTime.setBounds(180, -10, 80, 40);

        jLabel9.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("Please Enter All The Filelds");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 60, 330, 40);

        jTable_BookTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable_BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Date", " Time", "Book ID", "Book Title", "Mr / Mrs", "Book Author", "Book Unit Price", "Book Category"
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
        jScrollPane1.setBounds(400, 140, 740, 180);

        jLabelBackgroundIMAGE.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBackgroundIMAGE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/images.jpg"))); // NOI18N
        getContentPane().add(jLabelBackgroundIMAGE);
        jLabelBackgroundIMAGE.setBounds(0, 0, 1710, 860);

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

        setSize(new java.awt.Dimension(1178, 511));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBookAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBookAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBookAuthorActionPerformed

    private void jComboBoxMr_MrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMr_MrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMr_MrsActionPerformed

    private void jTextFieldBookUnitpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBookUnitpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBookUnitpriceActionPerformed

    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoryActionPerformed

    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();

        if(jTextFieldBookID.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookName.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookAuthor.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookUnitprice.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            /*JOptionPane.showMessageDialog(rootPane, "Successfully Added", "Saved",JOptionPane.INFORMATION_MESSAGE);

            {
                model.addRow(new Object[]{jLabelDate.getText(), jLabelTime.getText(), jTextFieldBookID.getText(), jTextFieldBookName.getText(), jComboBoxMr_Mrs.getSelectedItem().toString(), jTextFieldBookAuthor.getText(), jTextFieldBookUnitprice.getText(), jComboBoxCategory.getSelectedItem().toString()});
            }*/

            String query = "insert into [ABC__Book_Company].[dbo].[BUY_Book] (StoredDate, StoredTime, BookID, "
                + "BookName, Mr_Mrs, BookAuthor, BookUnitPrice, BookCategory) values ('"
                +jLabelDate.getText()+"','"+jLabelTime.getText()+"','"+jTextFieldBookID.getText()+"','"
                +jTextFieldBookName.getText()+"','"+jComboBoxMr_Mrs.getSelectedItem().toString()+"','"
                +jTextFieldBookAuthor.getText()+"','"+jTextFieldBookUnitprice.getText()+"','"
                +jComboBoxCategory.getSelectedItem().toString()+"')";
        
            executeSQlQuery(query, "Added");
            jTextFieldBookID.setText(null);
            jTextFieldBookName.setText(null);
            jTextFieldBookAuthor.setText(null);
            jTextFieldBookUnitprice.setText(null);

            /*BookDB obj=new BookDB();

            obj.setStoredDate(jLabelDate.getText());
            //jLabelDate.setText(null);

            obj.setStoredTime(jLabelTime.getText());
            //jLabelTime.setText(null);

            obj.setBookID(jTextFieldBookID.getText());
            jTextFieldBookID.setText(null);

            obj.setBookName(jTextFieldBookName.getText());
            jTextFieldBookName.setText(null);

            obj.setMr_Mrs(jComboBoxMr_Mrs.getSelectedItem().toString());
            //jComboBoxMr_Mrs.getSelectedItem().equals(null);

            obj.setBookAuthor(jTextFieldBookAuthor.getText());
            jTextFieldBookAuthor.setText(null);

            obj.setBookUnitPrice(Double.parseDouble(jTextFieldBookUnitprice.getText()));
            jTextFieldBookUnitprice.setText(null);

            obj.setBookCategory(jComboBoxCategory.getSelectedItem().toString());
            // jComboBoxCategory.getSelectedItem().equals(null);

            try
            {
                obj.AddBook(obj);
            }
            catch (Exception ex)
            {
                System.err.println(ex.toString());
            }*/
        }

    }//GEN-LAST:event_jButtonBuyActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();

        if(jTable_BookTable.getRowCount()==-1)
        {

            if(jTable_BookTable.getRowCount()==0)
            {
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "No Data Found!", "ERROR",JOptionPane.ERROR_MESSAGE);
            }

            else
            {
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "You must select any Row to update", "NOTE",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(jTextFieldBookID.getText().isEmpty() || jTextFieldBookName.getText().isEmpty() || jTextFieldBookAuthor.getText().isEmpty()
            || jTextFieldBookUnitprice.getText().isEmpty())
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Updating",JOptionPane.ERROR_MESSAGE);

        }
        else
        {

            String query= "update [ABC__Book_Company].[dbo].[BUY_Book] set StoredDate ='"+jLabelDate.getText()
                    + "',StoredTime='"+jLabelTime.getText()
                    + "',BookID='"+jTextFieldBookID.getText()
                    + "',BookName='"+jTextFieldBookName.getText()
                    + "',Mr_Mrs='"+jComboBoxMr_Mrs.getSelectedItem().toString()
                    + "',BookAuthor='"+jTextFieldBookAuthor.getText()
                    + "',BookUnitPrice='"+jTextFieldBookUnitprice.getText()
                    + "',BookCategory='"+jComboBoxCategory.getSelectedItem().toString()
                           +"'where BookID='"+jTextFieldBookID.getText()+"'";
            executeSQlQuery(query, "Updated");
  
                jTextFieldBookID.setText(null);
                jTextFieldBookName.setText(null);
                jTextFieldBookAuthor.setText(null);
                jTextFieldBookUnitprice.setText(null);

            /*
            String query = "INSERT INTO [ABC_Book_Company].[dbo].[BookInfo](`StoredDate`, `StoredTime`, `BookID`, `BookName`,`Mr_Mrs`, `BookAuthor`, `BookUnitPrice`, `BookCategory`) VALUES "
            + "('"+jLabelDate.getText()+"','"+jLabelTime.getText()+"','"+jTextFieldBookID.getText()+"','"+jTextFieldBookName.getText()+"','"+jComboBoxMr_Mrs.getSelectedItem().toString()+"','"+jTextFieldBookAuthor.getText()+"','"+jTextFieldBookUnitprice.getText()+"','"+jComboBoxCategory.getSelectedItem().toString()+"')";

            executeSQlQuery(query, "Inserted");
            BookDB obj=new BookDB();

            obj.setStoredDate(jLabelDate.getText());
            //jLabelDate.setText(null);

            obj.setStoredTime(jLabelTime.getText());
            //jLabelTime.setText(null);

            obj.setBookID(jTextFieldBookID.getText());
            jTextFieldBookID.setText(null);

            obj.setBookName(jTextFieldBookName.getText());
            jTextFieldBookName.setText(null);

            obj.setMr_Mrs(jComboBoxMr_Mrs.getSelectedItem().toString());
            // jComboBoxMr_Mrs.getSelectedItem().equals(null);

            obj.setBookAuthor(jTextFieldBookAuthor.getText());
            jTextFieldBookAuthor.setText(null);

            obj.setBookUnitPrice(Double.parseDouble(jTextFieldBookUnitprice.getText()));
            jTextFieldBookUnitprice.setText(null);

            obj.setBookCategory(jComboBoxCategory.getSelectedItem().toString());
            //jComboBoxCategory.getSelectedItem().equals(null);

            try
            {
                obj.UpdateBook(obj);
            }
            catch (Exception ex)
            {
                System.err.println(ex.toString());
            }*/

        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
        if(jTable_BookTable.getSelectedRow()==-1)
        {
            if(jTable_BookTable.getRowCount()==0)
            {
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "No Data Found!", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "You must select any Row to delete", "NOTE",JOptionPane.INFORMATION_MESSAGE);
            }
        }

        else
        {
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to delete ?", "NOTE", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0)
            {
                //model.removeRow(jTable_BookTable.getSelectedRow());

                //BookDB obj = new BookDB();

                String query= "delete from [ABC__Book_Company].[dbo].[BUY_Book] where BookID ='"+jTextFieldBookID.getText()+"'";
                executeSQlQuery(query, "Deleted");
                jTextFieldBookID.setText(null);
                jTextFieldBookName.setText(null);
                jTextFieldBookAuthor.setText(null);
                jTextFieldBookUnitprice.setText(null);

                /*obj.setStoredDate(jLabelDate.getText());
                //jLabelDate.setText(null);

                obj.setStoredTime(jLabelTime.getText());
                //jLabelTime.setText(null);

                obj.setBookID(jTextFieldBookID.getText());
                jTextFieldBookID.setText(null);

                obj.setBookName(jTextFieldBookName.getText());
                jTextFieldBookName.setText(null);

                obj.setMr_Mrs(jComboBoxMr_Mrs.getSelectedItem().toString());
                jComboBoxMr_Mrs.getSelectedItem().equals(null);

                obj.setBookAuthor(jTextFieldBookAuthor.getText());
                jTextFieldBookAuthor.setText(null);

                obj.setBookUnitPrice(Double.parseDouble(jTextFieldBookUnitprice.getText()));
                jTextFieldBookUnitprice.setText(null);

                obj.setBookCategory(jComboBoxCategory.getSelectedItem().toString());
                jComboBoxCategory.getSelectedItem().equals(null);

                try
                {
                    obj.DeleteBook(obj);
                }
                catch (Exception ex)
                {
                    System.err.println(ex.toString());
                }*/
            }
            else
            {

            }
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextFieldBookID.setText(null);
        jTextFieldBookName.setText(null);
        jTextFieldBookAuthor.setText(null);
        jTextFieldBookUnitprice.setText(null);

    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jTable_BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
        //jLabelDate.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 0).toString());
        //jLabelTime.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 1).toString());
        jTextFieldBookID.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 2).toString());
        jTextFieldBookName.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 3).toString());
        jComboBoxMr_Mrs.setSelectedItem(model.getValueAt(jTable_BookTable.getSelectedRow(), 4).toString());
        jTextFieldBookAuthor.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 5).toString());
        jTextFieldBookUnitprice.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 6).toString());
        jComboBoxCategory.setSelectedItem(model.getValueAt(jTable_BookTable.getSelectedRow(), 7).toString());

    }//GEN-LAST:event_jTable_BookTableMouseClicked

    private void jButtonClearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearTableActionPerformed
        // TODO add your handling code here:
        if(jTable_BookTable.getRowCount()==0)
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "There is no Data to clear!", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
            while(model.getRowCount() > 0)
            {
                for(int i = 0; i < model.getRowCount(); i++)
                {
                    model.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_jButtonClearTableActionPerformed

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

    private void jButtonBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBACKActionPerformed
        // TODO add your handling code here:
        close();
        UserMenu B = new UserMenu();
        {
            B.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBACKActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> Purchase Order: <br>"
                + "Please Enter All the required Data in the given Blanks. <br>"
                + "* You can Add, Update, Delete or Search any amount of data. <br>"
                + "* If you click the table, the specific data will be displayed <br>"
                + "on the blank textfields. <br> </html>";
        
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
            java.util.logging.Logger.getLogger(BuyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBACK;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonClearTable;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JComboBox<String> jComboBoxMr_Mrs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBackgroundIMAGE;
    private javax.swing.JLabel jLabelDate;
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
    private javax.swing.JTextField jTextFieldBookAuthor;
    private javax.swing.JTextField jTextFieldBookID;
    private javax.swing.JTextField jTextFieldBookName;
    private javax.swing.JTextField jTextFieldBookUnitprice;
    // End of variables declaration//GEN-END:variables
}
