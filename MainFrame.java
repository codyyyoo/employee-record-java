import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

  public MainFrame() {
        initComponents();
        setIcon();
        updBtn.setEnabled(false);
        delBtn.setEnabled(false);
        Connect();
        LoadProductNo();
        Fetch();
        
        comboId.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        Object selectedItem = comboId.getSelectedItem();
        if (selectedItem == null) return;

        String selectedId = selectedItem.toString();
        if (selectedId.equals("0")) {
            updBtn.setEnabled(false);
            delBtn.setEnabled(false);

            txtName.setText("");
            txtAddy.setText("");
            txtEmail.setText("");
            txtSalary.setText("₱");
            txtPhone.setText("");
        }
    }
});


    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void LoadProductNo(){
      try {
          pst = con.prepareStatement("SELECT id FROM employee_tbl");
          rs = pst.executeQuery();
          comboId.removeAllItems();
          
          comboId.addItem("0");
          
          while(rs.next()){
              comboId.addItem(rs.getString(1));
          }
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void Fetch(){
      try {
          int a;
          pst = con.prepareStatement("SELECT * FROM employee_tbl");
          rs = pst.executeQuery();
          ResultSetMetaData rss = rs.getMetaData();
          a = rss.getColumnCount();
          
          DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
          df.setRowCount(0);
          
          while(rs.next()){
              Vector v2 = new Vector();
              for(int b = 1; b<=a; b++){
                  v2.add(rs.getString("id"));
                  v2.add(rs.getString("ename"));
                  v2.add(rs.getString("eadd"));
                  v2.add(rs.getString("email"));
                  v2.add(rs.getString("esalary"));
                  v2.add(rs.getString("ephone"));
              }
              df.addRow(v2);
          }
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddy = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboId = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Record System");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Employee Record System");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Name:");

        txtName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtName.setToolTipText("");
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Address:");

        txtAddy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAddy.setToolTipText("");
        txtAddy.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAddy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddyActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setToolTipText("");
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Salary:");

        txtSalary.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSalary.setText("₱");
        txtSalary.setToolTipText("");
        txtSalary.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Phone:");

        txtPhone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPhone.setToolTipText("");
        txtPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Employee ID:");

        comboId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        searchBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchBtn.setText("Search by ID");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updBtn.setText("Update");
        updBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        newBtn.setText("Reset Field");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddy, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(searchBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(delBtn)
                .addGap(18, 18, 18)
                .addComponent(newBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(updBtn)
                    .addComponent(delBtn)
                    .addComponent(newBtn))
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 470));

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Address", "Email", "Salary", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee-feedback-15-questions.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtAddyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddyActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
      try {
        String eid = comboId.getSelectedItem().toString();
        if(eid.equals("0")) {
            JOptionPane.showMessageDialog(this, "Please Enter a Valid Employee ID");
            return;
        }

        pst = con.prepareStatement("SELECT * FROM employee_tbl WHERE id=?");
        pst.setString(1, eid);
        rs = pst.executeQuery();

        if(rs.next()){
            txtName.setText(rs.getString(2));
            txtAddy.setText(rs.getString(3));
            txtEmail.setText(rs.getString(4));
            txtSalary.setText(rs.getString(5));
            txtPhone.setText(rs.getString(6));

            delBtn.setEnabled(true);
            updBtn.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.");
            updBtn.setEnabled(false);  // Optional safety
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        txtName.setText("");
              txtAddy.setText("");
              txtEmail.setText("");
              txtSalary.setText("₱");
              txtPhone.setText("");
              updBtn.setEnabled(false);
              delBtn.setEnabled(true);

    }//GEN-LAST:event_newBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
      try {
          // TODO add your handling code here:
          
          String ename = txtName.getText();
          String eadd = txtAddy.getText();
          String email = txtEmail.getText();
          String esalary = txtSalary.getText();
          String ephone = txtPhone.getText();
          
          pst = con.prepareStatement("INSERT INTO employee_tbl (ename,eadd,email,esalary,ephone)VALUES(?,?,?,?,?)");
          pst.setString(1, ename);
          pst.setString(2, eadd);
          pst.setString(3, email);
          pst.setString(4, esalary);
          pst.setString(5, ephone);
          
          int k = pst.executeUpdate();
          
          if(k==1){
              JOptionPane.showMessageDialog(this, "Record Added");
              txtName.setText("");
              txtAddy.setText("");
              txtEmail.setText("");
              txtSalary.setText("₱");
              txtPhone.setText("");
              Fetch();
              LoadProductNo();
          }else{
              JOptionPane.showMessageDialog(this, "Failed to Add");
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }

    }//GEN-LAST:event_addBtnActionPerformed

    private void updBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updBtnActionPerformed
      try {
          // TODO add your handling code here:
         String eid = comboId.getSelectedItem().toString();
        if(eid.equals("0")) {
            JOptionPane.showMessageDialog(this, "Please Enter a V   alid Employee ID");
            return;
        }
          
          String ename = txtName.getText();
          String eadd = txtAddy.getText();
          String email = txtEmail.getText();
          String esalary = txtSalary.getText();
          String ephone = txtPhone.getText();
          eid = comboId.getSelectedItem().toString();
          
          pst = con.prepareStatement("UPDATE employee_tbl SET ename=?,eadd=?,email=?,esalary=?,ephone=? WHERE id=?");
          
          pst.setString(1, ename);
          pst.setString(2, eadd);
          pst.setString(3, email);
          pst.setString(4, esalary);
          pst.setString(5, ephone);
          pst.setString(6, eid);
          
          int k = pst.executeUpdate();
          
          if (k==1){
              JOptionPane.showMessageDialog(this, "Record Updated");
              
              txtName.setText("");
              txtAddy.setText("");
              txtEmail.setText("");
              txtSalary.setText("₱");
              txtPhone.setText("");
              
              txtName.requestFocus();
              Fetch();
              LoadProductNo();
              updBtn.setEnabled(false);
          }else{
              JOptionPane.showMessageDialog(this, "Failed to Update");
          }
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_updBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
      try {
          // TODO add your handling code here:
          String eid = comboId.getSelectedItem().toString();
        if(eid.equals("0")) {
            JOptionPane.showMessageDialog(this, "Please Enter a V   alid Employee ID");
            return;
        }
          
          eid = comboId.getSelectedItem().toString();
          pst = con.prepareStatement("DELETE FROM employee_tbl WHERE ID=?");
          pst.setString(1, eid);
          
          int k = pst.executeUpdate();
          
          if (k==1){
            JOptionPane.showMessageDialog(this, "Record Deleted");
            txtName.setText("");
              txtAddy.setText("");
              txtEmail.setText("");
              txtSalary.setText("₱");
              txtPhone.setText("");
             txtName.requestFocus();
             Fetch();
              LoadProductNo();
            delBtn.setEnabled(true);
          }else{
              JOptionPane.showMessageDialog(this, "Failed to Delete");
          }
      } catch (SQLException ex) {
          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_delBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> comboId;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txtAddy;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JButton updBtn;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.jpg")));
    }
}
