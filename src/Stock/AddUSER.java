/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import DBL.AddNEWUserDB;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lesster
 */
public class AddUSER extends javax.swing.JFrame {

    /**
     * Creates new form AddUSER
     */
    JFileChooser chooser = new JFileChooser();
    public AddUSER() {
        initComponents();
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
        jLabelDate.setText(s.format(d));   
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
    
    public ArrayList<AddNEWUserDB> getBookDBList() 
    {
        ArrayList<AddNEWUserDB> BookDBList = new ArrayList<AddNEWUserDB>();
        Connection connection = getConnection();

        String query = "SELECT * FROM [ABC__Book_Company].[dbo].[AddNewUser] ";
        Statement st;
        ResultSet rs;

        try 
        {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            AddNEWUserDB user;

            while (rs.next()) {
                 user = new AddNEWUserDB
                       (rs.getString("StoredDate"),
                        rs.getString("StoredTime"),
                        rs.getString("Name"),
                        rs.getString("Gender"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("Occupation"),
                        rs.getInt("HandphoneNo"),
                        rs.getInt("LandlineNo"),
                        rs.getString("New_UserID"),
                        rs.getString("New_Password"));
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
       ArrayList<AddNEWUserDB> list = getBookDBList();
       DefaultTableModel model = (DefaultTableModel)jTableUserTable.getModel();
       Object[] row = new Object[11];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getStoredDate();
           row[1] = list.get(i).getStoredTime();
           row[2] = list.get(i).getName();
           row[3] = list.get(i).getGender();
           row[4] = list.get(i).getAge();
           row[5] = list.get(i).getAddress();
           row[6] = list.get(i).getOccupation();
           row[7] = list.get(i).getHandphoneNo();
           row[8] = list.get(i).getLandlineNo();
           row[9] = list.get(i).getNew_UserID();
           row[10] = list.get(i).getNew_Password();
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
               DefaultTableModel model = (DefaultTableModel)jTableUserTable.getModel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAge = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jTextFieldHandphone = new javax.swing.JTextField();
        jTextFieldLandline = new javax.swing.JTextField();
        jTextFieldUserID = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordFieldReEnterPassword = new javax.swing.JPasswordField();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jButtonClearr = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonBACK = new javax.swing.JButton();
        jLabelDate = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jButtonEXIT = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jComboBoxGender = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserTable = new javax.swing.JTable();
        jLabelastrick1 = new javax.swing.JLabel();
        jCheckBoxSHOW_PW = new javax.swing.JCheckBox();
        jButtonDelete = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldSearchID = new javax.swing.JTextField();
        jButtonExit = new javax.swing.JButton();
        jCheckBoxSHOW_PW1 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxOccupation = new javax.swing.JComboBox<String>();
        jTextFieldFilePath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelBackGroundImage = new javax.swing.JLabel();
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

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 120, 90, 14);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setText("Landline Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 360, 150, 14);

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel9.setText("Address");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 240, 110, 14);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setText("Handphone Number");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 320, 170, 14);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 390, 160, 14);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setText("Occupation");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 280, 120, 14);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 160, 110, 14);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("New UserID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 350, 160, 14);

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setText("Age");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 200, 80, 14);
        getContentPane().add(jTextFieldAge);
        jTextFieldAge.setBounds(200, 190, 110, 30);
        getContentPane().add(jTextFieldAddress);
        jTextFieldAddress.setBounds(200, 230, 110, 30);

        jTextFieldHandphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHandphoneActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldHandphone);
        jTextFieldHandphone.setBounds(200, 310, 110, 30);
        getContentPane().add(jTextFieldLandline);
        jTextFieldLandline.setBounds(200, 350, 110, 30);
        getContentPane().add(jTextFieldUserID);
        jTextFieldUserID.setBounds(590, 340, 140, 30);
        getContentPane().add(jTextFieldName);
        jTextFieldName.setBounds(200, 110, 110, 30);

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Re-enter New Password");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 430, 160, 14);

        jPasswordFieldReEnterPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldReEnterPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordFieldReEnterPasswordMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordFieldReEnterPasswordMousePressed(evt);
            }
        });
        jPasswordFieldReEnterPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldReEnterPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldReEnterPassword);
        jPasswordFieldReEnterPassword.setBounds(590, 420, 140, 30);
        getContentPane().add(jPasswordFieldNewPassword);
        jPasswordFieldNewPassword.setBounds(590, 380, 140, 30);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Colonna MT", 0, 48)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/USERGIF.gif"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(270, 0, 470, 70);

        jButtonClearr.setBackground(new java.awt.Color(0, 255, 255));
        jButtonClearr.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonClearr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/File-reset-icon.png"))); // NOI18N
        jButtonClearr.setText("Clear TextFields");
        jButtonClearr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearrActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClearr);
        jButtonClearr.setBounds(120, 440, 160, 30);

        jButtonAdd.setBackground(new java.awt.Color(0, 255, 255));
        jButtonAdd.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        jButtonAdd.setText("ADD");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd);
        jButtonAdd.setBounds(20, 400, 100, 30);

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
        jButtonBACK.setBounds(30, 650, 90, 30);

        jLabelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(10, -10, 70, 40);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("||");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(80, -20, 12, 60);

        jLabelTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelTime);
        jLabelTime.setBounds(100, -10, 80, 40);

        jButtonEXIT.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEXIT.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jButtonEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jButtonEXIT.setToolTipText("EXIT from the System");
        jButtonEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEXITActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEXIT);
        jButtonEXIT.setBounds(1010, 0, 20, 20);

        jButtonUpdate.setBackground(new java.awt.Color(0, 255, 255));
        jButtonUpdate.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/update.png"))); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(140, 400, 110, 30);

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        getContentPane().add(jComboBoxGender);
        jComboBoxGender.setBounds(200, 150, 110, 30);

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setText("Please fill all the required information to Add or Update");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 80, 440, 22);

        jTableUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Name", "Gender", "Age", "Address", "Occupation", "HandphoneNo", "LandlineNo", "New_UserID", "New_Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUserTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 480, 990, 160);

        jLabelastrick1.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick1);
        jLabelastrick1.setBounds(740, 420, 20, 40);

        jCheckBoxSHOW_PW.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW.setText("Show Password");
        jCheckBoxSHOW_PW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSHOW_PWActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSHOW_PW);
        jCheckBoxSHOW_PW.setBounds(770, 420, 150, 23);

        jButtonDelete.setBackground(new java.awt.Color(0, 255, 255));
        jButtonDelete.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/clearTextfield.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete);
        jButtonDelete.setBounds(270, 400, 110, 30);

        jLabelSearch.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        jLabelSearch.setText("Search");
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(430, 130, 60, 30);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(490, 130, 40, 30);

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
        jTextFieldSearchID.setBounds(520, 130, 230, 30);

        jButtonExit.setBackground(new java.awt.Color(255, 51, 51));
        jButtonExit.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("EXIT");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit);
        jButtonExit.setBounds(890, 650, 110, 30);

        jCheckBoxSHOW_PW1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSHOW_PW1.setText("Show Password");
        jCheckBoxSHOW_PW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSHOW_PW1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSHOW_PW1);
        jCheckBoxSHOW_PW1.setBounds(770, 380, 150, 23);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/user.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(720, 120, 230, 240);

        jComboBoxOccupation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Professional", "NonWorkers", "Housewife", "Other" }));
        jComboBoxOccupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOccupationActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxOccupation);
        jComboBoxOccupation.setBounds(200, 270, 110, 30);
        getContentPane().add(jTextFieldFilePath);
        jTextFieldFilePath.setBounds(420, 290, 290, 30);

        jButton1.setText("Attach");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 250, 100, 30);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 110, 550, 360);

        jLabelBackGroundImage.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBackGroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Abstract-Wallpaper.png"))); // NOI18N
        getContentPane().add(jLabelBackGroundImage);
        jLabelBackGroundImage.setBounds(0, -20, 1040, 900);

        jMenuFILE.setText("File");

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

        setSize(new java.awt.Dimension(1046, 755));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearrActionPerformed
        // TODO add your handling code here:
        jTextFieldName.setText(null);
        jTextFieldAge.setText(null);
        jTextFieldAddress.setText(null);
        jTextFieldHandphone.setText(null);
        jTextFieldLandline.setText(null);
        jTextFieldUserID.setText(null);
        jPasswordFieldNewPassword.setText(null);
        jPasswordFieldReEnterPassword.setText(null);
        jTextFieldFilePath.setText(null);
    }//GEN-LAST:event_jButtonClearrActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        jLabelastrick1.setText(null);
        boolean valid=true;
        DefaultTableModel model = (DefaultTableModel)jTableUserTable.getModel();
        
    if(!jPasswordFieldNewPassword.getText().equals(jPasswordFieldReEnterPassword.getText()))
            {
                jLabelastrick1.setText("*");
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "Please Re-enter the password that you gave above", "Error while Adding",JOptionPane.ERROR_MESSAGE);
                jPasswordFieldReEnterPassword.setForeground(Color.red);
                valid=false;
            }
    
        if(jTextFieldName.getText().isEmpty() || jTextFieldAge.getText().isEmpty() || jTextFieldAddress.getText().isEmpty()
            || jTextFieldHandphone.getText().isEmpty() || jTextFieldLandline.getText().isEmpty() || jTextFieldUserID.getText().isEmpty() 
            || jPasswordFieldNewPassword.getText().isEmpty() || jPasswordFieldReEnterPassword.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
            valid=false;
        }
 
    if(valid)
    {
      
        String query = "insert into [ABC__Book_Company].[dbo].[AddNewUser] (StoredDate, StoredTime, Name, "
                + "Gender, Age, Address, Occupation, HandphoneNo, LandlineNo, New_UserID, New_Password) values ('"
                +jLabelDate.getText()+"','"+jLabelTime.getText()+"','"+jTextFieldName.getText()+"','"
                +jComboBoxGender.getSelectedItem().toString()+"','"
                +jTextFieldAge.getText()+"','"+jTextFieldAddress.getText()+"','"
                +jComboBoxOccupation.getSelectedItem().toString()+"','"
                +jTextFieldHandphone.getText()+"','"+jTextFieldLandline.getText()+"','"
                +jTextFieldUserID.getText()+"','"+jPasswordFieldNewPassword.getText()+"')";
        
        executeSQlQuery(query, "Added");
        jTextFieldName.setText(null);
        jTextFieldAge.setText(null);
        jTextFieldAddress.setText(null);
        jTextFieldHandphone.setText(null);
        jTextFieldLandline.setText(null);
        jTextFieldUserID.setText(null);
        jPasswordFieldNewPassword.setText(null);
        jPasswordFieldReEnterPassword.setText(null);
        jTextFieldFilePath.setText(null);
       
    }
   
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBACKActionPerformed
        // TODO add your handling code here:
        close();
        AdminMenu C = new AdminMenu();
        {
            C.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBACKActionPerformed

    private void jMenuItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackActionPerformed
        // TODO add your handling code here:
        close();
        AdminMenu C = new AdminMenu();
        {
            C.setVisible(true);
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

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jCheckBoxSHOW_PWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSHOW_PWActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxSHOW_PW.isSelected())
        {
            jPasswordFieldReEnterPassword.setEchoChar((char)0);
        }

        else
        {
            jPasswordFieldReEnterPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxSHOW_PWActionPerformed

    private void jCheckBoxSHOW_PW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSHOW_PW1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxSHOW_PW1.isSelected())
        {
            jPasswordFieldNewPassword.setEchoChar((char)0);
        }

        else
        {
            jPasswordFieldNewPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxSHOW_PW1ActionPerformed

    private void jComboBoxOccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOccupationActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to EXIT from the System ?", "NOTE", JOptionPane.YES_NO_OPTION);
        if(YesOrNo == 0)
        {
            System.exit(0);
        }
        else
        {

        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jPasswordFieldReEnterPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldReEnterPasswordMouseClicked
        // TODO add your handling code here:
        jPasswordFieldReEnterPassword.setForeground(Color.black);
    }//GEN-LAST:event_jPasswordFieldReEnterPasswordMouseClicked

    private void jTableUserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableUserTable.getModel();

        jLabelDate.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 0).toString());
        jLabelTime.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 1).toString());
        jTextFieldName.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 2).toString());
        jComboBoxGender.setSelectedItem(model.getValueAt(jTableUserTable.getSelectedRow(), 3).toString());
        jTextFieldAge.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 4).toString());
        jTextFieldAddress.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 5).toString());
        jComboBoxOccupation.setSelectedItem(model.getValueAt(jTableUserTable.getSelectedRow(), 6).toString());
        jTextFieldHandphone.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 7).toString());
        jTextFieldLandline.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 8).toString());
        jTextFieldUserID.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 9).toString());
        jPasswordFieldNewPassword.setText(model.getValueAt(jTableUserTable.getSelectedRow(), 10).toString());

    }//GEN-LAST:event_jTableUserTableMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        jLabelastrick1.setText(null);
        boolean valid=true;
        DefaultTableModel model = (DefaultTableModel)jTableUserTable.getModel();

        if(jTableUserTable.getRowCount()==-1)
        {
            if(jTableUserTable.getRowCount()==0)
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
        if(!jPasswordFieldNewPassword.getText().equals(jPasswordFieldReEnterPassword.getText()))
            {
                jLabelastrick1.setText("*");
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "Please Re-enter the password that you gave above", "Error while Adding",JOptionPane.ERROR_MESSAGE);
                jPasswordFieldReEnterPassword.setForeground(Color.red);
                valid=false;
            }
        if(jTextFieldName.getText().isEmpty() || jTextFieldAge.getText().isEmpty() || jTextFieldAddress.getText().isEmpty()
            || jTextFieldHandphone.getText().isEmpty() || jTextFieldLandline.getText().isEmpty()
            || jTextFieldUserID.getText().isEmpty() || jPasswordFieldNewPassword.getText().isEmpty() || jPasswordFieldReEnterPassword.getText().isEmpty())
        {
            getToolkit().beep(); 
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
            valid=false;
        }
        if(valid)
        {

            String query= "update [ABC__Book_Company].[dbo].[AddNewUser] set StoredDate ='"+jLabelDate.getText()
                    + "',StoredTime='"+jLabelTime.getText()
                    + "',Name='"+jTextFieldName.getText()
                    + "',Gender='"+jComboBoxGender.getSelectedItem().toString()
                    + "',Age='"+jTextFieldAge.getText()
                    + "',Address='"+jTextFieldAddress.getText()
                    + "',Occupation='"+jComboBoxOccupation.getSelectedItem().toString()
                    + "',HandphoneNo='"+jTextFieldHandphone.getText()
                    + "',LandlineNo='"+jTextFieldLandline.getText()
                    + "',New_UserID='"+jTextFieldUserID.getText()
                    + "',New_Password='"+jPasswordFieldNewPassword.getText()
                           +"'where New_UserID='"+jTextFieldUserID.getText()+"'";
            executeSQlQuery(query, "Updated");
  
            jTextFieldName.setText(null);
            jTextFieldAge.setText(null);
            jTextFieldAddress.setText(null);
            jTextFieldHandphone.setText(null);
            jTextFieldLandline.setText(null);
            jTextFieldUserID.setText(null);
            jPasswordFieldNewPassword.setText(null);
            jPasswordFieldReEnterPassword.setText(null);
            jTextFieldFilePath.setText(null);

        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cad; 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG PNG GIF Images", "jpg", "gif","png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(AddUSER.this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            System.out.print("directorio:"+chooser.getCurrentDirectory());
            cad=chooser.getCurrentDirectory()+"/"+chooser.getSelectedFile().getName();
            jTextFieldFilePath.setText(cad);
            jLabel15.setIcon(new ImageIcon(cad));
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTableUserTable.getModel();
        if(jTableUserTable.getSelectedRow()==-1)
        {
            if(jTableUserTable.getRowCount()==0)
            {
                //jLabelMessage.setText("No Data Found!");
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "No Data Found!", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //jLabelMessage.setText("Plese click the specific data from the table to Delete");
                getToolkit().beep();
                 JOptionPane.showMessageDialog(rootPane, "You must select any Row to delete", "NOTE",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        else
        {
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to delete ?", "NOTE", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0)
            {
                String query = "delete from [ABC__Book_Company].[dbo].[AddNewUser] where New_UserID ='" + jTextFieldUserID.getText() + "'";
                executeSQlQuery(query, "Deleted");
          
                jTextFieldName.setText(null);
                jTextFieldAge.setText(null);
                jTextFieldAddress.setText(null);
                jTextFieldHandphone.setText(null);
                jTextFieldLandline.setText(null);
                jTextFieldUserID.setText(null);
                jPasswordFieldNewPassword.setText(null);
                jPasswordFieldReEnterPassword.setText(null);
                jTextFieldFilePath.setText(null);
           
            }
            else
            {
                
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jPasswordFieldReEnterPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldReEnterPasswordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldReEnterPasswordMouseEntered

    private void jPasswordFieldReEnterPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldReEnterPasswordMousePressed
        // TODO add your handling code here:
                jPasswordFieldReEnterPassword.setForeground(Color.black);
    }//GEN-LAST:event_jPasswordFieldReEnterPasswordMousePressed

    private void jTextFieldSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchIDActionPerformed

    private void jTextFieldSearchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyReleased
        // TODO add your handling code here:
        Connection con = getConnection();
        ResultSet rs;
        PreparedStatement pst;

        try {
            String query = "Select * from [ABC__Book_Company].[dbo].[AddNewUser] where New_UserID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, jTextFieldSearchID.getText());
            rs = pst.executeQuery();
       
           
            if (rs.next()) {
                String add1 = rs.getString("Name");
                jTextFieldName.setText(add1);
                String add2 = rs.getString("Gender");
                jComboBoxGender.setSelectedItem(add2);
                String add3 = rs.getString("Age");
                jTextFieldAge.setText(add3);
                String add4 = rs.getString("Address");
                jTextFieldAddress.setText(add4);    
                String add5 = rs.getString("Occupation");
                jComboBoxOccupation.setSelectedItem(add5);
                String add6 = rs.getString("HandphoneNo");
                jTextFieldHandphone.setText(add6);
                String add7 = rs.getString("LandlineNo");
                jTextFieldLandline.setText(add7);
                String add8 = rs.getString("New_UserID");
                jTextFieldUserID.setText(add8);
                String add9 = rs.getString("New_Password");
                jPasswordFieldNewPassword.setText(add9);
                
            }

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchIDKeyReleased

    private void jTextFieldSearchIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyTyped
        // TODO add your handling code here:
        if(jTextFieldSearchID.getText().isEmpty())
         {
             jTextFieldName.setText(null);
                jTextFieldAge.setText(null);
                jTextFieldAddress.setText(null);
                jTextFieldHandphone.setText(null);
                jTextFieldLandline.setText(null);
                jTextFieldUserID.setText(null);
                jPasswordFieldNewPassword.setText(null);
                jPasswordFieldReEnterPassword.setText(null);
                jTextFieldFilePath.setText(null);
         }
    }//GEN-LAST:event_jTextFieldSearchIDKeyTyped

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> User Information: <br>"
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

    private void jTextFieldHandphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHandphoneActionPerformed
        // TODO add your handling code here:
        jTextFieldHandphone.minimumSize().setSize(10, 10);
    }//GEN-LAST:event_jTextFieldHandphoneActionPerformed

    private void jPasswordFieldReEnterPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldReEnterPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldReEnterPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(AddUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUSER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBACK;
    private javax.swing.JButton jButtonClearr;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JCheckBox jCheckBoxSHOW_PW;
    private javax.swing.JCheckBox jCheckBoxSHOW_PW1;
    private javax.swing.JComboBox jComboBoxGender;
    private javax.swing.JComboBox<String> jComboBoxOccupation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBackGroundImage;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelastrick1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFILE;
    private javax.swing.JMenuItem jMenuItemBack;
    private javax.swing.JMenuItem jMenuItemEXIT;
    private javax.swing.JMenuItem jMenuItemHOME;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenu jMenuSWITCHUSER;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JPasswordField jPasswordFieldReEnterPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableUserTable;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldFilePath;
    private javax.swing.JTextField jTextFieldHandphone;
    private javax.swing.JTextField jTextFieldLandline;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSearchID;
    private javax.swing.JTextField jTextFieldUserID;
    // End of variables declaration//GEN-END:variables

    //private String gender;
}
