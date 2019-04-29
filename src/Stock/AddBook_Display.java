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
import java.sql.PreparedStatement;
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
 * @author Lesster
 */
public class AddBook_Display extends javax.swing.JFrame {

    
    /**
     * Creates new form AddBook_Display
     */
    public AddBook_Display() {
        
        initComponents();     
        TableColumnModel columnModel = jTable_BookTable.getColumnModel();
        columnModel.getColumn(4).setPreferredWidth(35);
        Show_Users_In_JTable();
        showDate();
        showTime();
        
        //DefaultTableModel dm;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_BookTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox<String>();
        jComboBoxMr_Mrs = new javax.swing.JComboBox<String>();
        jButtonUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBookID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelastrick1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBookName = new javax.swing.JTextField();
        jTextFieldBookAuthor = new javax.swing.JTextField();
        jTextFieldBookUnitprice = new javax.swing.JTextField();
        jButtonADD = new javax.swing.JButton();
        jTextFieldSearchID = new javax.swing.JTextField();
        jButtonClearTable = new javax.swing.JButton();
        jButtonEXIT = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabelRs = new javax.swing.JLabel();
        jLabelastrick2 = new javax.swing.JLabel();
        jLabelastrick3 = new javax.swing.JLabel();
        jLabelastrick4 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabelBackgroundIMAGE = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFILE = new javax.swing.JMenu();
        jMenuItemBack = new javax.swing.JMenuItem();
        jMenuItemHOME = new javax.swing.JMenuItem();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jMenuItemHELP = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEXIT = new javax.swing.JMenuItem();
        jMenuSWITCHUSER = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(400, 140, 740, 180);

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/BOOKINFO.gif"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(350, -20, 490, 70);

        jLabel7.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search Book Information by its ID, Book Name, Category and etc.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(400, 60, 490, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 270, 110, 30);

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
        jButtonDelete.setBounds(260, 340, 100, 30);

        jLabelMessage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelMessage);
        jLabelMessage.setBounds(30, 310, 460, 20);

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Childrens", "Adventure", "Horror", "Romance" }));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategory);
        jComboBoxCategory.setBounds(260, 270, 100, 30);

        jComboBoxMr_Mrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr.", "Mrs.", "Ms." }));
        jComboBoxMr_Mrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMr_MrsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxMr_Mrs);
        jComboBoxMr_Mrs.setBounds(200, 190, 60, 20);

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
        jButtonUpdate.setBounds(130, 340, 110, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Book ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 110, 100, 30);
        getContentPane().add(jTextFieldBookID);
        jTextFieldBookID.setBounds(260, 110, 100, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Book Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 150, 120, 30);

        jLabelastrick1.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick1);
        jLabelastrick1.setBounds(370, 110, 20, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Book Author");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 190, 130, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Book Unit Price");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 230, 140, 30);
        getContentPane().add(jTextFieldBookName);
        jTextFieldBookName.setBounds(260, 150, 100, 30);

        jTextFieldBookAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBookAuthorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBookAuthor);
        jTextFieldBookAuthor.setBounds(260, 190, 100, 30);

        jTextFieldBookUnitprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBookUnitpriceActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBookUnitprice);
        jTextFieldBookUnitprice.setBounds(260, 230, 100, 30);

        jButtonADD.setBackground(new java.awt.Color(0, 255, 255));
        jButtonADD.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        jButtonADD.setText("ADD");
        jButtonADD.setToolTipText("Add the above given book information");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonADD);
        jButtonADD.setBounds(20, 340, 90, 30);

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
        jTextFieldSearchID.setBounds(490, 100, 370, 30);

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
        jButtonClearTable.setBounds(400, 340, 140, 30);

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

        jLabel9.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add, Update and Delete Book Information");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 60, 330, 40);

        jLabelRs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRs.setText("Rs.");
        getContentPane().add(jLabelRs);
        jLabelRs.setBounds(240, 240, 20, 14);

        jLabelastrick2.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick2);
        jLabelastrick2.setBounds(370, 150, 20, 40);

        jLabelastrick3.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick3.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick3);
        jLabelastrick3.setBounds(370, 190, 20, 40);

        jLabelastrick4.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick4.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick4);
        jLabelastrick4.setBounds(370, 230, 20, 40);

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
        jButtonClear.setBounds(110, 380, 160, 30);

        jLabelSearch.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Search");
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(400, 100, 70, 30);

        jLabelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(90, -10, 70, 40);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("||");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, -20, 20, 60);

        jLabelTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelTime);
        jLabelTime.setBounds(180, -10, 80, 40);

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
        jButtonClose.setBounds(1030, 340, 110, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(466, 100, 30, 30);

        jLabelBackgroundIMAGE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/images.jpg"))); // NOI18N
        getContentPane().add(jLabelBackgroundIMAGE);
        jLabelBackgroundIMAGE.setBounds(0, 0, 1180, 630);

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

        jMenuItemHELP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHELP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Help-icon.png"))); // NOI18N
        jMenuItemHELP.setText("Help");
        jMenuItemHELP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHELPActionPerformed(evt);
            }
        });
        jMenuFILE.add(jMenuItemHELP);
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

        setSize(new java.awt.Dimension(1175, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        jLabelastrick2.setText("");
        jLabelastrick3.setText("");
        jLabelastrick4.setText("");
        
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
        
        if(jTextFieldBookID.getText().isEmpty())
        {
            jLabelastrick1.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book ID should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookName.getText().isEmpty())
        {
            jLabelastrick2.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book Name should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookAuthor.getText().isEmpty())
        {
            jLabelastrick3.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book Author should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookUnitprice.getText().isEmpty())
        {
            jLabelastrick4.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book Unit Price should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else
        {                                   
        String query = "insert into [ABC__Book_Company].[dbo].[BookInfo] (StoredDate, StoredTime, BookID, "
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
        
    }              
 
    }//GEN-LAST:event_jButtonADDActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();

       if(jTable_BookTable.getRowCount()==-1)
        {
            
            if(jTable_BookTable.getRowCount()==0)
            {
            jLabelMessage.setText("No Data Found!");
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "No Data Found!", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
                jLabelMessage.setText("You must select any Row to update");
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
            
            String query= "update [ABC__Book_Company].[dbo].[BookInfo] set StoredDate ='"+jLabelDate.getText()
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
         
    }    
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
        if(jTable_BookTable.getSelectedRow()==-1)
        {
            if(jTable_BookTable.getRowCount()==0)
            {
                jLabelMessage.setText("No Data Found!");
                getToolkit().beep();
                JOptionPane.showMessageDialog(rootPane, "No Data Found!", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                jLabelMessage.setText("Plese click the specific data from the table to Delete");
                getToolkit().beep();
                 JOptionPane.showMessageDialog(rootPane, "You must select any Row to delete", "NOTE",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        else
        {
            int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to delete ?", "NOTE", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0)
            {
          
          String query= "delete from [ABC__Book_Company].[dbo].[BookInfo] where BookID ='"+jTextFieldBookID.getText()+"'";
          executeSQlQuery(query, "Deleted");
                jTextFieldBookID.setText(null);
                jTextFieldBookName.setText(null);
                jTextFieldBookAuthor.setText(null);
                jTextFieldBookUnitprice.setText(null);

            }
            else
            {
                
            }
        }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTable_BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_BookTable.getModel();
       jTextFieldBookID.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 2).toString());
       jTextFieldBookName.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 3).toString());
       jComboBoxMr_Mrs.setSelectedItem(model.getValueAt(jTable_BookTable.getSelectedRow(), 4).toString());
       jTextFieldBookAuthor.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 5).toString());
       jTextFieldBookUnitprice.setText(model.getValueAt(jTable_BookTable.getSelectedRow(), 6).toString());
       jComboBoxCategory.setSelectedItem(model.getValueAt(jTable_BookTable.getSelectedRow(), 7).toString());
       
    }//GEN-LAST:event_jTable_BookTableMouseClicked

    private void jTextFieldBookUnitpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBookUnitpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBookUnitpriceActionPerformed

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jTextFieldSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDActionPerformed
        // TODO add your handling code here: 
       
    }//GEN-LAST:event_jTextFieldSearchIDActionPerformed

    private void jButtonClearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearTableActionPerformed
        // TODO add your handling code here:
      if(jTable_BookTable.getRowCount()==0)
            {
                jLabelMessage.setText("There is no Data to clear");
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

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jTextFieldBookID.setText(null);
        jTextFieldBookName.setText(null);
        jTextFieldBookAuthor.setText(null);
        jTextFieldBookUnitprice.setText(null);
        
    }//GEN-LAST:event_jButtonClearActionPerformed

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

    private void jMenuItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBackActionPerformed
        // TODO add your handling code here:
        close();
        UserMenu B = new UserMenu();
        {
            B.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemBackActionPerformed

    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoryActionPerformed

    private void jComboBoxMr_MrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMr_MrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMr_MrsActionPerformed

    private void jTextFieldBookAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBookAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBookAuthorActionPerformed

    private void jTextFieldSearchIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyTyped
        // TODO add your handling code here:

       
       if(jTextFieldSearchID.getText().isEmpty())
         {
             jTextFieldBookID.setText(null);
            jTextFieldBookName.setText(null);
            jTextFieldBookAuthor.setText(null);
            jTextFieldBookUnitprice.setText(null);
         }
    }//GEN-LAST:event_jTextFieldSearchIDKeyTyped

    private void jTextFieldSearchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyReleased
        // TODO add your handling code here:

       
       Connection con = getConnection();
        ResultSet rs;
        PreparedStatement pst;
        try {
            String query = "Select * from [ABC__Book_Company].[dbo].[BookInfo] where BookID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, jTextFieldSearchID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("BookID");
                jTextFieldBookID.setText(add1);
                String add2 = rs.getString("BookName");
                jTextFieldBookName.setText(add2);
                String add3 = rs.getString("BookAuthor");
                jTextFieldBookAuthor.setText(add3);
                String add4 = rs.getString("BookUnitPrice");
                jTextFieldBookUnitprice.setText(add4);           
                String add5 = rs.getString("BookCategory");
                jComboBoxCategory.setSelectedItem(add5);
            }

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchIDKeyReleased

    private void jMenuItemHELPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHELPActionPerformed
        // TODO add your handling code here:
        String msg = "<html> Book Information: <br>"
                + "Please Enter All the required Data in the given Blanks. <br>"
                + "* You can Add, Update, Delete or Search any amount of data. <br>"
                + "* If you click the table, the specific data will be displayed <br>"
                + "on the blank textfields. <br> </html>";
        
        JOptionPane optionpane = new JOptionPane();
        optionpane.setMessage(msg);
        optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog=optionpane.createDialog(null, "Help");
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemHELPActionPerformed
    
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
            java.util.logging.Logger.getLogger(AddBook_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBook_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBook_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBook_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBook_Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonBACK;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBackgroundIMAGE;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelRs;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelastrick1;
    private javax.swing.JLabel jLabelastrick2;
    private javax.swing.JLabel jLabelastrick3;
    private javax.swing.JLabel jLabelastrick4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFILE;
    private javax.swing.JMenuItem jMenuItemBack;
    private javax.swing.JMenuItem jMenuItemEXIT;
    private javax.swing.JMenuItem jMenuItemHELP;
    private javax.swing.JMenuItem jMenuItemHOME;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenu jMenuSWITCHUSER;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable_BookTable;
    private javax.swing.JTextField jTextFieldBookAuthor;
    private javax.swing.JTextField jTextFieldBookID;
    private javax.swing.JTextField jTextFieldBookName;
    private javax.swing.JTextField jTextFieldBookUnitprice;
    private javax.swing.JTextField jTextFieldSearchID;
    // End of variables declaration//GEN-END:variables
}
