/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;
import DBL.InvoiceDB;
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
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Lesster
 */
public class AddInvoice_Display extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceUI
     */
    public AddInvoice_Display() {
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
    
    public ArrayList<InvoiceDB> getInvoiceDBList() 
    {
        ArrayList<InvoiceDB> InvoiceDBList = new ArrayList<InvoiceDB>();
        Connection connection = getConnection();

        String query = "SELECT * FROM [ABC_Book__Company].[dbo].[InvoiceInfo] ";
        Statement st;
        ResultSet rs;

        try 
        {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            InvoiceDB user;

            while (rs.next()) 
            {
                user = new InvoiceDB
                (rs.getString("StoredDate"),
                rs.getString("StoredTime"),
                rs.getString("InvoiceNo"),
                rs.getString("BookName"),
                rs.getString("BookCategory"),
                rs.getDouble("BookUnitprice"),
                rs.getInt("BookQuantity"),
                rs.getDouble("Totalprice"));
                InvoiceDBList.add(user);

            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return InvoiceDBList;
    }
    
    private void Show_Users_In_JTable()
   {
       ArrayList<InvoiceDB> list = getInvoiceDBList();
       DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();
       Object[] row = new Object[8];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getStoredDate();
           row[1] = list.get(i).getStoredTime();
           row[2] = list.get(i).getInvoiceNo();
           row[3] = list.get(i).getBookName();
           row[4] = list.get(i).getBookCategory();
           row[5] = list.get(i).getBookUnitprice();
           row[6] = list.get(i).getBookQuantity();
           row[7] = list.get(i).getTotalprice();
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
               DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();
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

        jLabel1 = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jButtonBACK = new javax.swing.JButton();
        jLabelBookID = new javax.swing.JLabel();
        jLabelBookCategory = new javax.swing.JLabel();
        jLabelBookQuantity = new javax.swing.JLabel();
        jLabelBookQuantity1 = new javax.swing.JLabel();
        jLabelBookUnitPrice = new javax.swing.JLabel();
        jTextFieldTotalprice = new javax.swing.JTextField();
        jTextFieldBookQuantity = new javax.swing.JTextField();
        jTextFieldBookUnitprice = new javax.swing.JTextField();
        jComboBoxCategory = new javax.swing.JComboBox<String>();
        jTextFieldInvoiceNo = new javax.swing.JTextField();
        jLabelRs = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonClearTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_InvoiceTable = new javax.swing.JTable();
        jButtonClose = new javax.swing.JButton();
        jTextFieldSearchID = new javax.swing.JTextField();
        jLabelSearch = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelBookID1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonEXIT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBookName = new javax.swing.JTextField();
        jLabelMessage = new javax.swing.JLabel();
        jLabelastrick4 = new javax.swing.JLabel();
        jLabelastrick3 = new javax.swing.JLabel();
        jLabelastrick1 = new javax.swing.JLabel();
        jLabelastrick2 = new javax.swing.JLabel();
        jLabelbackgroundImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFILE = new javax.swing.JMenu();
        jMenuItemBack = new javax.swing.JMenuItem();
        jMenuItemHOME = new javax.swing.JMenuItem();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEXIT = new javax.swing.JMenuItem();
        jMenuSWITCHUSER = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(90, -10, 70, 40);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("||");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, -20, 12, 60);

        jLabelTime.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelTime);
        jLabelTime.setBounds(180, -10, 80, 40);

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

        jLabelBookID.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookID.setText("Invoice No.");
        getContentPane().add(jLabelBookID);
        jLabelBookID.setBounds(30, 70, 100, 16);

        jLabelBookCategory.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookCategory.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookCategory.setText("Book Category");
        getContentPane().add(jLabelBookCategory);
        jLabelBookCategory.setBounds(30, 150, 96, 16);

        jLabelBookQuantity.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookQuantity.setText("Book Unitprice");
        getContentPane().add(jLabelBookQuantity);
        jLabelBookQuantity.setBounds(30, 190, 92, 20);

        jLabelBookQuantity1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookQuantity1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookQuantity1.setText("Book Quantity");
        getContentPane().add(jLabelBookQuantity1);
        jLabelBookQuantity1.setBounds(30, 230, 93, 20);

        jLabelBookUnitPrice.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookUnitPrice.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookUnitPrice.setText("Total Amount");
        getContentPane().add(jLabelBookUnitPrice);
        jLabelBookUnitPrice.setBounds(30, 270, 120, 16);

        jTextFieldTotalprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalpriceActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTotalprice);
        jTextFieldTotalprice.setBounds(200, 260, 100, 30);

        jTextFieldBookQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBookQuantityActionPerformed(evt);
            }
        });
        jTextFieldBookQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBookQuantityKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldBookQuantity);
        jTextFieldBookQuantity.setBounds(200, 220, 100, 30);

        jTextFieldBookUnitprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBookUnitpriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBookUnitpriceKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldBookUnitprice);
        jTextFieldBookUnitprice.setBounds(200, 180, 100, 30);

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Childrens", "Adventure", "Horror", "Romance" }));
        jComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategory);
        jComboBoxCategory.setBounds(200, 140, 100, 30);
        getContentPane().add(jTextFieldInvoiceNo);
        jTextFieldInvoiceNo.setBounds(200, 60, 100, 30);

        jLabelRs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRs.setText("Rs.");
        getContentPane().add(jLabelRs);
        jLabelRs.setBounds(180, 270, 20, 14);

        jButtonAdd.setBackground(new java.awt.Color(0, 255, 255));
        jButtonAdd.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/add.png"))); // NOI18N
        jButtonAdd.setText("Create Invoice");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd);
        jButtonAdd.setBounds(70, 340, 190, 30);

        jButtonUpdate.setBackground(new java.awt.Color(0, 255, 255));
        jButtonUpdate.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/update.png"))); // NOI18N
        jButtonUpdate.setText("Amend Invoice");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(70, 380, 190, 30);

        jButtonDelete.setBackground(new java.awt.Color(0, 255, 255));
        jButtonDelete.setFont(new java.awt.Font("Century", 1, 11)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/clearTextfield.png"))); // NOI18N
        jButtonDelete.setText("Delete Invoice");
        jButtonDelete.setToolTipText("Delete the selected book information");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete);
        jButtonDelete.setBounds(70, 420, 190, 30);

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
        jButtonClear.setBounds(390, 320, 160, 30);

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
        jButtonClearTable.setBounds(610, 320, 140, 30);

        jTable_InvoiceTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable_InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stored Date", "Stored Time", "InvoiceNo", "BookName", "Category", "Book Unitprice", "Book Quantity", "Total "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_InvoiceTable.setGridColor(new java.awt.Color(255, 255, 153));
        jTable_InvoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_InvoiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_InvoiceTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(380, 150, 570, 160);

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
        jButtonClose.setBounds(830, 320, 110, 30);

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
        jTextFieldSearchID.setBounds(480, 110, 370, 30);

        jLabelSearch.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        jLabelSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSearch.setText("Search");
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(380, 110, 70, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Search.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(440, 110, 30, 30);

        jLabelBookID1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelBookID1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookID1.setText("Book Name");
        getContentPane().add(jLabelBookID1);
        jLabelBookID1.setBounds(30, 110, 100, 16);

        jLabel7.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search Stock Information by its ID, Book Name, Category and etc.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(380, 70, 510, 40);

        jButtonEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Button-Close-icon.png"))); // NOI18N
        jButtonEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEXITActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEXIT);
        jButtonEXIT.setBounds(950, 0, 20, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/invoice gif.gif"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, -20, 480, 70);
        getContentPane().add(jTextFieldBookName);
        jTextFieldBookName.setBounds(200, 100, 100, 30);

        jLabelMessage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelMessage);
        jLabelMessage.setBounds(20, 310, 460, 20);

        jLabelastrick4.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick4.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick4);
        jLabelastrick4.setBounds(310, 220, 20, 50);

        jLabelastrick3.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick3.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick3);
        jLabelastrick3.setBounds(310, 180, 20, 40);

        jLabelastrick1.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick1);
        jLabelastrick1.setBounds(310, 60, 20, 50);

        jLabelastrick2.setFont(new java.awt.Font("Aharoni", 0, 40)); // NOI18N
        jLabelastrick2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabelastrick2);
        jLabelastrick2.setBounds(310, 100, 20, 50);

        jLabelbackgroundImage.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabelbackgroundImage.setForeground(new java.awt.Color(255, 255, 255));
        jLabelbackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/background.jpg"))); // NOI18N
        getContentPane().add(jLabelbackgroundImage);
        jLabelbackgroundImage.setBounds(0, 0, 970, 460);

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

        setSize(new java.awt.Dimension(983, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTextFieldTotalpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalpriceActionPerformed

    private void jTextFieldBookQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBookQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBookQuantityActionPerformed

    private void jTextFieldBookQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBookQuantityKeyReleased
        // TODO add your handling code here:
        if(jTextFieldBookQuantity.getText().isEmpty())
        {
            jTextFieldTotalprice.setText(null);
        }
        else
        {
            double Qty, Uprice, total;
            Qty = Integer.parseInt(jTextFieldBookQuantity.getText());
            Uprice = Double.parseDouble(jTextFieldBookUnitprice.getText());
            total = Qty * Uprice;
            jTextFieldTotalprice.setText(Double.toString(total));
        }
    }//GEN-LAST:event_jTextFieldBookQuantityKeyReleased

    private void jTextFieldBookUnitpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBookUnitpriceKeyReleased
        // TODO add your handling code here:
        jTextFieldBookQuantity.setText(null);
        jTextFieldTotalprice.setText(null);
    }//GEN-LAST:event_jTextFieldBookUnitpriceKeyReleased

    private void jComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoryActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        jLabelastrick2.setText("");
        jLabelastrick3.setText("");
        jLabelastrick4.setText("");

        DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();

        if(jTextFieldInvoiceNo.getText().isEmpty())
        {
            jLabelastrick1.setText("*"); getToolkit().beep(); jLabelMessage.setText("InvoiceNo should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookName.getText().isEmpty())
        {
            jLabelastrick2.setText("*"); getToolkit().beep(); jLabelMessage.setText("BookID should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookUnitprice.getText().isEmpty())
        {
            jLabelastrick3.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book Unitprice should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTextFieldBookQuantity.getText().isEmpty())
        {
            jLabelastrick4.setText("*"); getToolkit().beep(); jLabelMessage.setText("Book Quantity should not be left blank");
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Adding",JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            
            String query = "insert into [ABC__Book_Company].[dbo].[InvoiceInfo] ( StoredDate,  StoredTime,  "
                    + "InvoiceNo,  BookName,  BookCategory,  BookUnitprice,  BookQuantity,  Totalprice) values ('"
                +jLabelDate.getText()+"','"+jLabelTime.getText()+"','"+jTextFieldInvoiceNo.getText()+"','"+jTextFieldBookName.getText()+"','"
                +jComboBoxCategory.getSelectedItem().toString()+"','"
                +jTextFieldBookUnitprice.getText()+"','"+jTextFieldBookQuantity.getText()+"','"
                +jTextFieldTotalprice.getText()+"')";
              
            executeSQlQuery(query, "Added");
            
            jTextFieldInvoiceNo.setText(null);
            jTextFieldBookName.setText(null);
            jTextFieldBookQuantity.setText(null);
            jTextFieldBookUnitprice.setText(null);
            jTextFieldTotalprice.setText(null);
            
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        jLabelastrick1.setText("");
        DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();

        if(jTable_InvoiceTable.getRowCount()==-1)
        {
            if(jTable_InvoiceTable.getRowCount()==0)
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
        if(jTextFieldInvoiceNo.getText().isEmpty() || jTextFieldBookName.getText().isEmpty() || jTextFieldBookQuantity.getText().isEmpty() || jTextFieldBookUnitprice.getText().isEmpty())
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Fill All The Details", "Error while Updating",JOptionPane.ERROR_MESSAGE);

        }
        else
        {
            String query= "update [ABC__Book_Company].[dbo].[InvoiceInfo] set StoredDate ='"+jLabelDate.getText()
                    + "',StoredTime='"+jLabelTime.getText()
                    + "',InvoiceNo='"+jTextFieldInvoiceNo.getText()
                    + "',BookName='"+jTextFieldBookName.getText()
                    + "',BookCategory='"+jComboBoxCategory.getSelectedItem().toString()
                    + "',BookUnitprice='"+jTextFieldBookUnitprice.getText()
                    + "',BookQuantity='"+jTextFieldBookQuantity.getText()
                    + "',Totalprice='"+jTextFieldTotalprice.getText()
                           +"'where InvoiceNo='"+jTextFieldInvoiceNo.getText()+"'";
            executeSQlQuery(query, "Updated");

            jTextFieldInvoiceNo.setText(null);
            jTextFieldBookName.setText(null);
            jTextFieldBookQuantity.setText(null);
            jTextFieldBookUnitprice.setText(null);
            jTextFieldTotalprice.setText(null);

        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        jLabelMessage.setText("");
        DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();
        if(jTable_InvoiceTable.getSelectedRow()==-1)
        {
            if(jTable_InvoiceTable.getRowCount()==0)
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
                
             String query= "delete from [ABC__Book_Company].[dbo].[InvoiceInfo] where InvoiceNo ='"+jTextFieldInvoiceNo.getText()+"'";
             executeSQlQuery(query, "Deleted");
                
                jTextFieldInvoiceNo.setText(null);
                jTextFieldBookName.setText(null);
                jTextFieldBookQuantity.setText(null);
                jTextFieldBookUnitprice.setText(null);
                jTextFieldTotalprice.setText(null);
       
            }
            else
            {

            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextFieldInvoiceNo.setText(null);
        jTextFieldBookName.setText(null);
        jTextFieldBookQuantity.setText(null);
        jTextFieldBookUnitprice.setText(null);
        jTextFieldTotalprice.setText(null);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonClearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearTableActionPerformed
        // TODO add your handling code here:
        if(jTable_InvoiceTable.getRowCount()==0)
        {
            jLabelMessage.setText("There is no Data to clear");
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "There is no Data to clear!", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();
            while(model.getRowCount() > 0)
            {
                for(int i = 0; i < model.getRowCount(); i++)
                {
                    model.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_jButtonClearTableActionPerformed

    private void jTable_InvoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_InvoiceTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_InvoiceTable.getModel();

        jTextFieldInvoiceNo.setText(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 2).toString());
        jTextFieldBookName.setText(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 3).toString());
        jComboBoxCategory.setSelectedItem(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 4).toString());
        jTextFieldBookUnitprice.setText(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 5).toString());
        jTextFieldBookQuantity.setText(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 6).toString());
        jTextFieldTotalprice.setText(model.getValueAt(jTable_InvoiceTable.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_jTable_InvoiceTableMouseClicked

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

    private void jTextFieldSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jTextFieldSearchIDActionPerformed

    private void jTextFieldSearchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyReleased
        // TODO add your handling code here:


       Connection con = getConnection();
        ResultSet rs;
        PreparedStatement pst;

        try {
            String query = "Select * from [ABC__Book_Company].[dbo].[InvoiceInfo] where InvoiceNo = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, jTextFieldSearchID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("InvoiceNo");
                jTextFieldInvoiceNo.setText(add1);
                String add2 = rs.getString("BookName");
                jTextFieldBookName.setText(add2);
                String add3 = rs.getString("BookCategory");
                jComboBoxCategory.setSelectedItem(add3);
                String add4 = rs.getString("BookUnitPrice");
                jTextFieldBookUnitprice.setText(add4);    
                String add5 = rs.getString("BookQuantity");
                jComboBoxCategory.setSelectedItem(add5);
                String add6 = rs.getString("Totalprice");
                jTextFieldTotalprice.setText(add6);
            }

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextFieldSearchIDKeyReleased

    private void jTextFieldSearchIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchIDKeyTyped
        // TODO add your handling code here:
  
         if(jTextFieldBookQuantity.getText().isEmpty())
         {
             jTextFieldInvoiceNo.setText(null);
            jTextFieldBookName.setText(null);
            jTextFieldBookQuantity.setText(null);
            jTextFieldBookUnitprice.setText(null);
            jTextFieldTotalprice.setText(null);
         }
    }//GEN-LAST:event_jTextFieldSearchIDKeyTyped

    private void jButtonEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonEXITActionPerformed

    private void jTextFieldBookUnitpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBookUnitpriceKeyPressed
        // TODO add your handling code here:
        jTextFieldBookQuantity.setText(null);
        jTextFieldTotalprice.setText(null);
    }//GEN-LAST:event_jTextFieldBookUnitpriceKeyPressed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        // TODO add your handling code here:
        String msg = "<html> Create INVOICE: <br>"
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
            java.util.logging.Logger.getLogger(AddInvoice_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInvoice_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInvoice_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInvoice_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInvoice_Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBACK;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonClearTable;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEXIT;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBookCategory;
    private javax.swing.JLabel jLabelBookID;
    private javax.swing.JLabel jLabelBookID1;
    private javax.swing.JLabel jLabelBookQuantity;
    private javax.swing.JLabel jLabelBookQuantity1;
    private javax.swing.JLabel jLabelBookUnitPrice;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelRs;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelastrick1;
    private javax.swing.JLabel jLabelastrick2;
    private javax.swing.JLabel jLabelastrick3;
    private javax.swing.JLabel jLabelastrick4;
    private javax.swing.JLabel jLabelbackgroundImage;
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
    private javax.swing.JTable jTable_InvoiceTable;
    private javax.swing.JTextField jTextFieldBookName;
    private javax.swing.JTextField jTextFieldBookQuantity;
    private javax.swing.JTextField jTextFieldBookUnitprice;
    private javax.swing.JTextField jTextFieldInvoiceNo;
    private javax.swing.JTextField jTextFieldSearchID;
    private javax.swing.JTextField jTextFieldTotalprice;
    // End of variables declaration//GEN-END:variables
}
