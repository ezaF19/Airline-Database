/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezaF
 */
public class AdminInterface extends javax.swing.JFrame {

    /**
     * Creates new form AdminInterface
     */
        ArrayList<String> dfidlist = new ArrayList<String>();
        ArrayList<String> dfdep = new ArrayList<String>();
        ArrayList<String> dfarr = new ArrayList<String>();        
        ArrayList<String> dfdate = new ArrayList<String>();
        ArrayList<String> dforig = new ArrayList<String>();
        ArrayList<String> dfdest = new ArrayList<String>();
        ArrayList<String> dfroute = new ArrayList<String>();                
        ArrayList<String> dseatid = new ArrayList<String>();
        ArrayList<String> dseatpr = new ArrayList<String>();
        ArrayList<String> dseattp = new ArrayList<String>();
        ArrayList<String> dseatprid = new ArrayList<String>(); 
        ArrayList<String> dfplid = new ArrayList<String>();
        ArrayList<String> dfpname = new ArrayList<String>();
        ArrayList<String> dfprice = new ArrayList<String>();                
        ArrayList<String> dpsid = new ArrayList<String>();
        ArrayList<String> dpname = new ArrayList<String>();
        ArrayList<String> dpaddr = new ArrayList<String>();
        ArrayList<String> dpconn = new ArrayList<String>();
        ArrayList<String> dtrnid = new ArrayList<String>();
        ArrayList<String> dtrntp = new ArrayList<String>();
        ArrayList<String> dtrndt = new ArrayList<String>();
        ArrayList<String> dtrntm = new ArrayList<String>();
        ArrayList<String> dfcap = new ArrayList<String>();
        ArrayList<String> dfseat = new ArrayList<String>();
        int totalcount = 0;
    public AdminInterface() {
        initComponents();
        this.setLocation(35,15);
        this.setSize(1300,750);
        this.setResizable(false);      
        display();
    }
    public Connection SQLConnect(){ //syntax para mag connect sa wamp.
        Connection conDB;
        try{    
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conDB = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            return conDB;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Disconnect Derby", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public ArrayList<AdminHome> sionoList(){ //pang execute ng Siono.java
        ArrayList<AdminHome> ulist = new ArrayList<AdminHome>();
        Connection con = SQLConnect();
        System.out.print("START");
        String query = "SELECT * FROM APP.FLIGHT ";
        Statement st;
        ResultSet rs;
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            AdminHome user;
            while(rs.next()){
             //   String FID, String FDep, String FArr, String Origin, String Destination, String SeatNo, String SeatType,
            //String Price, String PLName, String PSID, String PSName, String PSAddress, String PSCNum, String TID,
            //String TType, String TDate, String TTime
                user = new AdminHome(rs.getString("FID"), rs.getString("FDATE"),rs.getString("FDep"), rs.getString("FArr"),rs.getString("Routeid"),rs.getString("Plid"),rs.getString("Fprice"));
                System.out.print(rs.getString("FID").toString());
                ulist.add(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Disconnect Derby", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return ulist;
    }
    
    public void display(){ //pang display ng table ng mga list
               ArrayList<AdminHome> ulist = sionoList();
        Connection con = SQLConnect();
        ResultSet rs;
        ResultSet ps;
        Statement st=null;
        try{                  
            st = con.createStatement();    
            DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
            Object[] row = new Object[8];
            table.getDataVector().removeAllElements();
            revalidate();
            for(int i=0; i<ulist.size(); i++){
                row[0] = ulist.get(i).getFID();
                row[1] = ulist.get(i).getFdate();
                row[2] = ulist.get(i).getFDep();
                row[3] = ulist.get(i).getFArr();
                String tmp = ulist.get(i).getRoutei();
                rs = st.executeQuery("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+tmp+"'");                
                if(rs.next()){
                row[4] = rs.getString("Origin");
                row[5] = rs.getString("Destination");
                }
                tmp = ulist.get(i).getPlid();
                System.out.println("TMP:"+tmp);
                ps = st.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+tmp+"'");
                if(ps.next())
                    row[6] = ps.getString("PLNAME");
                row[7] = ulist.get(i).getFprice();
                table.addRow(row);                
            }
            }
        catch(Exception e)
        {
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

        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cnum = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        origin = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        search_but = new javax.swing.JButton();
        pcombo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        flight_field = new javax.swing.JTextField();
        Flight_button = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        flight_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 600));
        getContentPane().setLayout(null);

        jButton3.setText("Return to User Interface");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1063, 10, 170, 23);

        jLabel3.setFont(new java.awt.Font("Colleged", 0, 20)); // NOI18N
        jLabel3.setText("HAPPY TRAVEL AGENCY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 490, 60);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1223, 522));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1223, 522));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel7.setText("*Please fill information for booking of ticket*");

        jLabel8.setText("Name:");

        jLabel9.setText("Address:");

        jLabel10.setText("Contact No:");

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        edit.setText("CLEAR");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel17.setText("____________");

        jLabel16.setText("Fare:");

        jLabel15.setText("Destination:");

        destination.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        origin.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel18.setText("Origin:");

        jLabel14.setText("Flight Date:");

        jLabel13.setText("Seat Type:");

        jLabel11.setText("Aircraft:");

        jLabel1.setText("+");

        jLabel2.setText("____________");

        jLabel4.setText("Total:");

        jLabel5.setText("____________");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Flight Date", "Departure", "Arrival", "Origin", "Destination", "Aircraft", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setText("Flight ID:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("PROFILE");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("FLIGHT");

        jLabel22.setText("Departure:");

        jLabel23.setText("Arrival:");

        jLabel21.setText("____________________________");

        jLabel24.setText("____________________________");

        jLabel25.setText("____________________________");

        jLabel26.setText("____________________________");

        jLabel27.setText("____________________________");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "Economy", "First Class" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(cnum, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(submit)
                                .addGap(6, 6, 6)
                                .addComponent(edit))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(destination))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15))
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit)
                    .addComponent(edit))
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jTabbedPane1.addTab("Book", jPanel4);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Plane Name", "PSID", "Name", "Address", "Seat No.", "Seat Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        search_but.setText("Search");
        search_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_butActionPerformed(evt);
            }
        });

        pcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ECONOMY CLASS", "FIRST CLASS" }));
        pcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcomboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1265, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_but)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_but))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Passenger Flights", jPanel1);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight ID", "Flight Date", "Departure", "Arrival", "Price", "Plane ID", "Origin", "Destination" }));

        Flight_button.setText("Search");
        Flight_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Flight_buttonActionPerformed(evt);
            }
        });

        flight_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Flight Date", "Departure", "Arrival", "Origin", "Destination", "Price", "Plane ID", "Plane Name", "Seats Available", "Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(flight_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flight_field, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Flight_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1265, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flight_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Flight_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Flight Details", jPanel5);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 60, 1270, 650);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/airline/UI BG.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-10, 0, 1310, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        name.setText("");
        cnum.setText("");
        address.setText("");
        origin.setText("");
        destination.setText("");    // TODO add your handling code here:
    // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
            // TODO add your handling code here:
            
    }//GEN-LAST:event_submitActionPerformed

    private void search_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_butActionPerformed
        // TODO add your handling code here:
        ArrayList<String> fidlist = new ArrayList<String>();
        ArrayList<String> seatid = new ArrayList<String>();        
        ArrayList<String> seattp = new ArrayList<String>();        
        ArrayList<String> fplid = new ArrayList<String>();
        ArrayList<String> fpname = new ArrayList<String>();                        
        ArrayList<String> psid = new ArrayList<String>();
        ArrayList<String> pname = new ArrayList<String>();
        ArrayList<String> paddr = new ArrayList<String>();                
        ArrayList<String> fseat = new ArrayList<String>();
        ArrayList<String> tmp = new ArrayList<String>();
        String combo = pcombo.getSelectedItem().toString();
        DefaultTableModel table = (DefaultTableModel)jTable3.getModel();        
        String cmp = pcombo.getSelectedItem().toString();
        Object[] rowe = new Object[7];
        table.getDataVector().removeAllElements();
        revalidate();
        try{
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conDB = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement state = conDB.createStatement();
            //System.out.println("Connection made");
            ResultSet gd,tmpid;
        if(cmp.equals("ALL"))
        {
            System.out.println("IN ALL");
            for(int i = 0; i<totalcount;i++)
            {
                fidlist.add(dfidlist.get(i));
                fpname.add(dfpname.get(i));
                psid.add(dpsid.get(i));
                pname.add(dpname.get(i));
                paddr.add(dpaddr.get(i));
                seatid.add(dseatid.get(i));
                seattp.add(dseattp.get(i));            
            }
        }
        //System.out.println("ECONOMY:"+dfidlist.size());
        else if(cmp.equals("ECONOMY CLASS"))
        {   
            gd = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST");
                while(gd.next())
                {
                    tmp.add(gd.getString("SEATID"));
                }
            for(int i = 0; i<tmp.size(); i++)
            {
                tmpid = state.executeQuery("SELECT * FROM SEATS WHERE SEATID='"+tmp.get(i)+"' and SEATTYPE='ECONOMY'");
                while(tmpid.next())
                {
                    seatid.add(tmp.get(i));
                }
            }
            for(int i = 0; i<totalcount ; i++)
            {
                for(int a = 0; a<seatid.size(); a++)
                {
                    if(dseatid.get(i).equals(seatid.get(a)))
                    {
                        System.out.println("I GATHER");
                        fidlist.add(dfidlist.get(i));
                        fpname.add(dfpname.get(i));
                        psid.add(dpsid.get(i));
                        pname.add(dpname.get(i));
                        paddr.add(dpaddr.get(i));
                        seattp.add(dseattp.get(i)); 
                    }
                }
            }
            
        } 
        else if(cmp.equals("FIRST CLASS"))
        {            
            gd = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST");
                while(gd.next())
                {
                    tmp.add(gd.getString("SEATID"));
                }
            for(int i = 0; i<tmp.size(); i++)
            {
                tmpid = state.executeQuery("SELECT * FROM SEATS WHERE SEATID='"+tmp.get(i)+"' and SEATTYPE='FIRST'");
                while(tmpid.next())
                {
                    seatid.add(tmp.get(i));
                }
            }
            for(int i = 0; i<totalcount ; i++)
            {
                for(int a = 0; a<seatid.size(); a++)
                {
                    if(dseatid.get(i).equals(seatid.get(a)))
                    {
                        System.out.println("I GATHER");
                        fidlist.add(dfidlist.get(i));
                        fpname.add(dfpname.get(i));
                        psid.add(dpsid.get(i));
                        pname.add(dpname.get(i));
                        paddr.add(dpaddr.get(i));
                        seattp.add(dseattp.get(i)); 
                    }
                }
            }
        }       
         
               
        for(int z=0; z<totalcount; z++)
            {
                    
                rowe[0]=fidlist.get(z);
                rowe[1]=fpname.get(z);                
                rowe[2]=psid.get(z);
                rowe[3]=pname.get(z);
                rowe[4]=paddr.get(z);                                               
                rowe[5]=seatid.get(z);
                rowe[6]=seattp.get(z);                                                                     
                table.addRow(rowe);            
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
    }//GEN-LAST:event_search_butActionPerformed

    private void pcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcomboActionPerformed

    private void Flight_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Flight_buttonActionPerformed
        // TODO add your handling code here:
        ArrayList<String> ffdep = new ArrayList<String>();
        ArrayList<String> ffidlist = new ArrayList<String>();
        ArrayList<String> ffarr = new ArrayList<String>();
        ArrayList<String> ffdate = new ArrayList<String>();
        ArrayList<String> ffroute = new ArrayList<String>();
        ArrayList<String> fforig = new ArrayList<String>();
        ArrayList<String> ffdest = new ArrayList<String>();
        ArrayList<String> ffprice = new ArrayList<String>();
        ArrayList<String> ffplid = new ArrayList<String>();
        ArrayList<String> ffpname = new ArrayList<String>();
        ArrayList<String> ffcap = new ArrayList<String>();
        ArrayList<String> ffseat = new ArrayList<String>();
        String fid = flight_field.getText();
        String comb = combo.getSelectedItem().toString();
        String cmb = "";
        //ArrayList<AdminHome> ulist = sionoList();
        DefaultTableModel table = (DefaultTableModel)flight_table.getModel();
        Object[] rowe = new Object[11];
        table.getDataVector().removeAllElements();
        revalidate();
        int capa = 0;
        try{
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conDB = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement state = conDB.createStatement();
            //System.out.println("Connection made");
            ResultSet gd = null;
            if(comb.equals("Destination"))
            {    
                
                cmb = "DESTINATION";
                gd = state.executeQuery("SELECT * FROM APP.ROUTE where "+cmb+" = '"+fid+"'" );
                while(gd.next())
                {
                    ffroute.add(gd.getString("ROUTEID"));
                }               
                for(int i=0; i<ffroute.size();i++)
                {
                    String rt = ffroute.get(i);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.FLIGHT where RouteID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.FLIGHT where RouteID='"+rt+"'");
                    while(route.next())
                    {
                        ffidlist.add(route.getString("fid"));
                        ffdep.add(route.getString("fdep"));
                        ffarr.add(route.getString("farr"));
                        ffprice.add(route.getString("fprice"));                    
                        ffplid.add(route.getString("plid"));
                        ffdate.add(route.getString("fdate"));
                   
                    }
                    int c = 0;
                    for(int t=0; t<ffplid.size();t++){
                    rt = ffplid.get(t);
                    ResultSet plane = state.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    while(plane.next())
                    {
                        ffpname.add(plane.getString("PLNAME"));
                        ffcap.add(plane.getString("PLCAP"));
                    }
                    }
                    for(int t=0; t<ffroute.size();t++)
                    {
                    rt = ffroute.get(t);
                    //System.out.println("Route:"+rt);
                    ResultSet routee = state.executeQuery("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println(i);
                    while(routee.next())
                    {
                        fforig.add(routee.getString("ORIGIN"));
                        ffdest.add(routee.getString("DESTINATION"));
                    }
                    }
                    for(int t=0; t<ffidlist.size();t++)
                 {
                    capa=0;
                    rt = ffidlist.get(t);
                    ResultSet cape = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println(i);
                    while(cape.next()){
                        capa++;
                    }
                    capa = Integer.parseInt(ffcap.get(t)) - capa;
                    ffseat.add(String.valueOf(capa));
                }   
                }
            }
            else if(comb.equals("Origin"))
            {    
                
                cmb = "ORIGIN";
                gd = state.executeQuery("SELECT * FROM APP.ROUTE where "+cmb+" = '"+fid+"'" );
                while(gd.next())
                {
                    ffroute.add(gd.getString("ROUTEID"));
                }               
                for(int i=0; i<ffroute.size();i++)
                {
                    String rt = ffroute.get(i);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.FLIGHT where RouteID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.FLIGHT where RouteID='"+rt+"'");
                    while(route.next())
                    {
                        ffidlist.add(route.getString("fid"));
                        ffdep.add(route.getString("fdep"));
                        ffarr.add(route.getString("farr"));
                        ffprice.add(route.getString("fprice"));                    
                        ffplid.add(route.getString("plid"));
                        ffdate.add(route.getString("fdate"));
                   
                    }
                    int c = 0;
                    for(int t=0; t<ffplid.size();t++){
                    rt = ffplid.get(t);
                    ResultSet plane = state.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    while(plane.next())
                    {
                        ffpname.add(plane.getString("PLNAME"));
                        ffcap.add(plane.getString("PLCAP"));
                    }
                    }
                    for(int t=0; t<ffroute.size();t++)
                    {
                    rt = ffroute.get(t);
                    //System.out.println("Route:"+rt);
                    ResultSet routee = state.executeQuery("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println(i);
                    while(routee.next())
                    {
                        fforig.add(routee.getString("ORIGIN"));
                        ffdest.add(routee.getString("DESTINATION"));
                    }
                    }
                    for(int t=0; t<ffidlist.size();t++)
                 {
                    capa=0;
                    rt = ffidlist.get(t);
                    ResultSet cape = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println(i);
                    while(cape.next()){
                        capa++;
                    }
                    capa = Integer.parseInt(ffcap.get(t)) - capa;
                    ffseat.add(String.valueOf(capa));
                }   
                }
            }
            else{
            if(comb.equals("Flight ID") )
            {    
                cmb = "FID";
                gd = state.executeQuery("SELECT * FROM APP.FLIGHT where fid = '"+fid+"'" );
                //System.out.println("Statement made");
            }
            else if(comb.equals("Flight Date"))
            {    
                cmb = "Fdate";
                 gd = state.executeQuery("SELECT * FROM APP.FLIGHT where "+cmb+" = '"+fid+"'" );
            }
            else if(comb.equals("Departure"))
            {    
                cmb = "FDEP";
                 gd = state.executeQuery("SELECT * FROM APP.FLIGHT where "+cmb+" = '"+fid+"'" );
            }
            else if(comb.equals("Arrival"))
            {    
                cmb = "FARR";
                 gd = state.executeQuery("SELECT * FROM APP.FLIGHT where "+cmb+" = '"+fid+"'" );
            }
            else if(comb.equals("Price"))
            {
                cmb = "FPRICE";
                 gd = state.executeQuery("SELECT * FROM APP.FLIGHT where "+cmb+" = '"+fid+"'" );
            }
            else if(comb.equals("Plane ID"))
            {    
                cmb = "PLID";
                gd = state.executeQuery("SELECT * FROM APP.FLIGHT where "+cmb+" = '"+fid+"'" );
            }            
            //System.out.println("Statement madeTHIS");
            while(gd.next())
                {
                    ffidlist.add(gd.getString("fid"));
                    ffdep.add(gd.getString("fdep"));
                    ffarr.add(gd.getString("farr"));
                    ffprice.add(gd.getString("fprice"));                    
                    ffplid.add(gd.getString("plid"));
                    ffroute.add(gd.getString("routeid"));
                    ffdate.add(gd.getString("fdate"));
                }
                //for(int i=0; i<fdeplist.size();i++)
                //  System.out.println(froute.get(i));
                int c=0;
                for(int i=0; i<ffplid.size();i++){
                    String rt = ffplid.get(i);
                    ResultSet plane = state.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    while(plane.next())
                    {
                        ffpname.add(plane.getString("PLNAME"));
                        ffcap.add(plane.getString("PLCAP"));
                    }
                }
                //System.out.println("Routeee:"+froute.get(0));
                for(int i=0; i<ffroute.size();i++)
                {
                    String rt = ffroute.get(i);
                    //System.out.println("Route:"+rt);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println(i);
                    while(route.next()){
                    fforig.add(route.getString("ORIGIN"));
                    ffdest.add(route.getString("DESTINATION"));
                    }
                }
                 for(int i=0; i<ffidlist.size();i++)
                 {
                    capa=0;
                    String rt = ffidlist.get(i);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println(i);
                    while(route.next()){
                        capa++;
                        //System.out.println(route.getString("PSID"));
                    }
                    //System.out.println(capa);
                    capa = Integer.parseInt(ffcap.get(i)) - capa;
                    ffseat.add(String.valueOf(capa));
                }                
            }
                for(int z=0; z<ffdep.size(); z++)
                {
                    
                    rowe[0]=ffidlist.get(z);
                    rowe[1]=ffdate.get(z);
                    rowe[2]=ffdep.get(z);
                    rowe[3]=ffarr.get(z);
                    rowe[4]=fforig.get(z);
                    rowe[5]=ffdest.get(z);
                    rowe[6]=ffprice.get(z);
                    rowe[7]=ffplid.get(z);
                    rowe[8]=ffpname.get(z);
                    rowe[9]=ffseat.get(z);
                    rowe[10]=ffcap.get(z);
                    table.addRow(rowe);
                    //System.out.println("TABLE");
                }
            
        }
        catch(Exception e){
            // E
            System.out.println(e);
        }
    }//GEN-LAST:event_Flight_buttonActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:        
        ArrayList<String> ffdep = new ArrayList<String>();
        ArrayList<String> ffidlist = new ArrayList<String>();
        ArrayList<String> ffarr = new ArrayList<String>();
        ArrayList<String> ffdate = new ArrayList<String>();
        ArrayList<String> ffroute = new ArrayList<String>();
        ArrayList<String> fforig = new ArrayList<String>();
        ArrayList<String> ffdest = new ArrayList<String>();
        ArrayList<String> ffprice = new ArrayList<String>();
        ArrayList<String> ffplid = new ArrayList<String>();
        ArrayList<String> ffpname = new ArrayList<String>();
        ArrayList<String> ffcap = new ArrayList<String>();
        ArrayList<String> ffseat = new ArrayList<String>();
        String fid = flight_field.getText();
        String comb = combo.getSelectedItem().toString();
        String cmb = "";
        //ArrayList<AdminHome> ulist = sionoList();
        DefaultTableModel table = (DefaultTableModel)flight_table.getModel();
        Object[] rowe = new Object[11];
        table.getDataVector().removeAllElements();
        revalidate();
        int capa = 0;
        ResultSet gd;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conDB = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement state = conDB.createStatement();
            gd = state.executeQuery("SELECT * FROM APP.FLIGHT");
        while(gd.next())
                {
                    ffidlist.add(gd.getString("fid"));
                    ffdep.add(gd.getString("fdep"));
                    ffarr.add(gd.getString("farr"));
                    ffprice.add(gd.getString("fprice"));                    
                    ffplid.add(gd.getString("plid"));
                    ffroute.add(gd.getString("routeid"));
                    ffdate.add(gd.getString("fdate"));
                }
                //for(int i=0; i<fdeplist.size();i++)
                //  System.out.println(froute.get(i));
                int c=0;
                for(int i=0; i<ffplid.size();i++){
                    String rt = ffplid.get(i);
                    ResultSet plane = state.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                    while(plane.next())
                    {
                        ffpname.add(plane.getString("PLNAME"));
                        ffcap.add(plane.getString("PLCAP"));
                    }
                }
                //System.out.println("Routeee:"+froute.get(0));
                for(int i=0; i<ffroute.size();i++)
                {
                    String rt = ffroute.get(i);
                    //System.out.println("Route:"+rt);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.ROUTE WHERE ROUTEID='"+rt+"'");
                    //System.out.println(i);
                    while(route.next()){
                    fforig.add(route.getString("ORIGIN"));
                    ffdest.add(route.getString("DESTINATION"));
                    }
                }
                 for(int i=0; i<ffidlist.size();i++)
                 {
                    capa=0;
                    String rt = ffidlist.get(i);
                    ResultSet route = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST WHERE FID='"+rt+"'");
                    //System.out.println(i);
                    while(route.next()){
                        capa++;
                        //System.out.println(route.getString("PSID"));
                    }
                    //System.out.println(capa);
                    capa = Integer.parseInt(ffcap.get(i)) - capa;
                    ffseat.add(String.valueOf(capa));
                }                
            
                for(int z=0; z<ffdep.size(); z++)
                {
                    
                    rowe[0]=ffidlist.get(z);
                    rowe[1]=ffdate.get(z);
                    rowe[2]=ffdep.get(z);
                    rowe[3]=ffarr.get(z);
                    rowe[4]=fforig.get(z);
                    rowe[5]=ffdest.get(z);
                    rowe[6]=ffprice.get(z);
                    rowe[7]=ffplid.get(z);
                    rowe[8]=ffpname.get(z);
                    rowe[9]=ffseat.get(z);
                    rowe[10]=ffcap.get(z);
                    table.addRow(rowe);
                    //System.out.println("TABLE");
                }
        ArrayList<String> fidlist = new ArrayList<String>();
        ArrayList<String> fdep = new ArrayList<String>();
        ArrayList<String> froute = new ArrayList<String>();                
        ArrayList<String> seatid = new ArrayList<String>();
        ArrayList<String> seattp = new ArrayList<String>();
        ArrayList<String> seatprid = new ArrayList<String>(); 
        ArrayList<String> fplid = new ArrayList<String>();
        ArrayList<String> fpname = new ArrayList<String>();               
        ArrayList<String> psid = new ArrayList<String>();
        ArrayList<String> pname = new ArrayList<String>();
        ArrayList<String> paddr = new ArrayList<String>();
        ArrayList<String> fcap = new ArrayList<String>();
        DefaultTableModel tablee = (DefaultTableModel)jTable3.getModel();
        Object[] prowe = new Object[18];
        ResultSet pgd,passenger,passinfo;   
        
            passenger = state.executeQuery("SELECT * FROM APP.PASSENGER_LIST");
            while(passenger.next())
            {
                psid.add(passenger.getString("PSID"));
                fidlist.add(passenger.getString("FID"));
                seatid.add(passenger.getString("SEATID"));
            }
            
            //GET PASSENGER INFO
            for(int i = 0; i<psid.size();i++)
            {
                passinfo = state.executeQuery("SELECT * FROM APP.PASSENGERS WHERE PSID='"+psid.get(i)+"'");
                while(passinfo.next())
                {
                    pname.add(passinfo.getString("PSNAME"));
                    paddr.add(passinfo.getString("PSADDRESS"));                
                }
            }
            
            //GET FLIGHT INFO
            for(int i = 0; i<fidlist.size();i++)
            {
                pgd = state.executeQuery("SELECT * FROM APP.FLIGHT WHERE FID='"+fidlist.get(i)+"'");
                while(pgd.next())
                {                    
                    fdep.add(pgd.getString("fdep"));                  
                    fplid.add(pgd.getString("plid"));
                    froute.add(pgd.getString("routeid"));
                }
            }
                              
            //GET PLANE INFO
            for(int i=0; i<fplid.size();i++)
            {
                String rt = fplid.get(i);
                ResultSet plane = state.executeQuery("SELECT * FROM APP.PLANE WHERE PLID='"+rt+"'");
                while(plane.next())
                {
                    fpname.add(plane.getString("PLNAME"));
                    fcap.add(plane.getString("PLCAP"));
                }
            }         
            
            //GET SEATS INFO
            for(int i = 0; i<seatid.size(); i++)
            {
                ResultSet seat = state.executeQuery("SELECT * FROM APP.SEATS WHERE SEATID='"+seatid.get(i)+"'");
                while(seat.next())
                {
                    seattp.add(seat.getString("SEATTYPE"));
                    seatprid.add(seat.getString("PRICEID"));
                }
            }
              
            //PUT IN ROW FORM
            tablee.getDataVector().removeAllElements();
            revalidate();
            for(int z=0; z<fdep.size(); z++)
            {
                    
                prowe[0]=fidlist.get(z);dfidlist.add(fidlist.get(z));
                prowe[5]=seatid.get(z);dseatid.add(seatid.get(z));
                prowe[6]=seattp.get(z);dseattp.add(seattp.get(z));
                prowe[1]=fpname.get(z);dfpname.add(fpname.get(z));
                prowe[2]=psid.get(z);dpsid.add(psid.get(z));
                prowe[3]=pname.get(z);dpname.add(pname.get(z));
                prowe[4]=paddr.get(z);dpaddr.add(paddr.get(z));               
                tablee.addRow(prowe);
                System.out.println("Counter:"+z);                
            }
            System.out.println("Final:"+fidlist.size());    
            totalcount = fidlist.size();    
            }
                catch(Exception e){
                    System.out.println(e);
                }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        origin.setEditable(false);
        destination.setEditable(false);        
        int i = jTable1.getSelectedRow();
        jLabel21.setText(jTable1.getModel().getValueAt(i,0).toString());
        jLabel27.setText(jTable1.getModel().getValueAt(i,1).toString());     
        jLabel25.setText(jTable1.getModel().getValueAt(i,2).toString());    
        jLabel26.setText(jTable1.getModel().getValueAt(i,3).toString());  
        origin.setText(jTable1.getModel().getValueAt(i,4).toString());
        destination.setText(jTable1.getModel().getValueAt(i,5).toString());
        jLabel24.setText(jTable1.getModel().getValueAt(i,6).toString()); 
        jLabel2.setText(jTable1.getModel().getValueAt(i,7).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:        
        UserInterface frame = new UserInterface();
        frame.setVisible(true);
        AdminInterface.this.setVisible(false); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
 
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conDB = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement state = conDB.createStatement();
            
            //GET ALL PASSENGER ID AND COMPONENTS
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Flight_button;
    private javax.swing.JTextField address;
    private javax.swing.JTextField cnum;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField destination;
    private javax.swing.JButton edit;
    private javax.swing.JTextField flight_field;
    private javax.swing.JTable flight_table;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField origin;
    private javax.swing.JComboBox<String> pcombo;
    private javax.swing.JButton search_but;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
