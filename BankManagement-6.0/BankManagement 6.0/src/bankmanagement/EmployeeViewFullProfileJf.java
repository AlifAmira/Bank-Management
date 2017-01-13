
package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class EmployeeViewFullProfileJf extends javax.swing.JFrame {

    Connection conn;  
    ResultSet rs;
    PreparedStatement pst=null;

    public EmployeeViewFullProfileJf() {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource
        ("BankIcon3.png")).getImage());
        
        conn =javaconnect.connect();
        
        setvalue();
        
    }
    
    private void setvalue()
    {
        String id=EmployeeHomeJf.lblAccountId.getText();
        
        
         try
        {
            
            /*String sql="select customer_name, customer_phone,customer_email, house_no,road_no,zip_code,city from " +
                        "ACCOUNT as a join CUSTOMER as c on (a.customer_id=c.customer_id) " +
                        "join ADDRESSES as ad  on(c.address_id=ad.address_id) where account_id='"+id +"' ";
                */        
            
            /*
            String sql="select name,phone,email,house_no,"
                    + "zipcode,city,current_balance "
                    + "from ACCOUNTS a join CUSTOMER c "
                    + "on (a.customer_id=c.customer_id)"
                 + " where account_id='"+id +"' ";
            pst=conn.prepareStatement(sql);    
            rs=pst.executeQuery();
           
            if(rs.next())
           {
               lblId.setText(id);
               lblName.setText(rs.getString("name"));
              lblPhone.setText(rs.getString("phone"));
             lblEmail.setText(rs.getString("email"));
             String add= "House:"+ rs.getString("house_no")+", Zip:" +rs.getString("zipcode")+", City:"+rs.getString("city"); 
             lblAddress.setText(add);
               
               double balance=rs.getDouble("current_balance");
               String s=java.text.NumberFormat.getCurrencyInstance().format(balance);            
              lblBalance.setText(s);                    
           }          
            
            */
            
            lblId.setText(id);
            
            String procedurensql="{call view_full_profile(?,?,?,?,?,?,?,?)}";
            CallableStatement cstmt2 = conn.prepareCall(procedurensql);
            
            cstmt2.setString(1,id);
            cstmt2.registerOutParameter(2,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(3,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(4,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(5,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(6,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(7,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(8,oracle.jdbc.OracleTypes.NUMBER);
            
            cstmt2.execute();  

            lblName.setText(cstmt2.getString(2));
            lblPhone.setText(cstmt2.getString(3));
            lblEmail.setText(cstmt2.getString(4));
            
            String add= "House:"+ cstmt2.getString(5)+", Zip:" +cstmt2.getString(6)+", City:"+cstmt2.getString(7); 
            lblAddress.setText(add);

            Double c_amount=cstmt2.getDouble(8);  
            
            String s=java.text.NumberFormat.getCurrencyInstance().format(c_amount);            
              lblBalance.setText(s);  
            
            cstmt2.close();    
            
            
        }
            
          catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);
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

        lblPhone = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 278, 31));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 236, 33));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 236, 33));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 278, 32));

        lblBalance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 310, 36));

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 446, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Account ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 108, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 108, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Phone :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 108, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Address :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 108, 34));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Balance :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, 34));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Name :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 108, 34));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankmanagement/backall.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EmployeeViewFullProfileJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewFullProfileJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewFullProfileJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeViewFullProfileJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeViewFullProfileJf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    // End of variables declaration//GEN-END:variables
}