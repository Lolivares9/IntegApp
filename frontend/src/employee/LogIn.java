
package employee;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilson
 */
public class LogIn extends javax.swing.JFrame {

    Connection conn= dbConn.getConn();
    PreparedStatement pst =null;
    ResultSet rs= null;
    public LogIn() {
        initComponents();
        time();
    }

    private void time(){
    
        Calendar cal= new GregorianCalendar();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month =cal.get(Calendar.MONTH);
        int year= cal.get(Calendar.YEAR);
        
        lbldate.setText("logged in at :"+ day+"/"+(month +1) +"/"+year);
        lbldate.setForeground(Color.red);
        int sec=cal.get(Calendar.SECOND);
        int min =cal.get(Calendar.MINUTE);
        int hr= cal.get(Calendar.HOUR);
        
         lbltime.setText( sec+":"+min+":"+hr);
        lbltime.setForeground(Color.red);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmblog = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lbldate = new javax.swing.JMenu();
        lbltime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Please enter Username and Password:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(15, 250, 240, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 290, 70, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 340, 80, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Division:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 400, 100, 20);

        cmblog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
        cmblog.setPreferredSize(new java.awt.Dimension(56, 30));
        jPanel1.add(cmblog);
        cmblog.setBounds(146, 390, 160, 30);

        jButton1.setText("LogIn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(220, 453, 59, 30);

        txtUsername.setMinimumSize(new java.awt.Dimension(6, 30));
        txtUsername.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel1.add(txtUsername);
        txtUsername.setBounds(140, 280, 170, 30);

        txtPassword.setPreferredSize(new java.awt.Dimension(6, 40));
        jPanel1.add(txtPassword);
        txtPassword.setBounds(140, 330, 170, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/images/bk3.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 790, 526);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        lbldate.setText("date");
        jMenuBar1.add(lbldate);

        lbltime.setText("time");
        jMenuBar1.add(lbltime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String sql = "select * from UserLog where Username='"+txtUsername.getText()+"' and Password='"+txtPassword.getText()+"'";
         int n=0;
 try {
           
            pst =conn.prepareStatement(sql);
            rs= pst.executeQuery();
          
            loggedinId.impId = rs.getInt("id");
             loggedinId.empname=rs.getString("Username");
            while(rs.next()){
            n+=1;
            
            }
           } catch (SQLException ex) {
          // JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
        try {
                    if (rs!=null) {
                        rs.close();
                    }
                    if (pst!=null) {
                      pst.close();  
                    }
//                    if (conn!=null) {
//                      pst.close();  
//                    }
                } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null, e);
                }
        }
            Date date = GregorianCalendar.getInstance().getTime();
            DateFormat df= DateFormat.getDateInstance();
            String todaydate= df.format(date);
            Date time= new Date();
            SimpleDateFormat dff= new SimpleDateFormat("HH:mm:ss");
             String timeNow= dff.format(time);
        
        if(cmblog.getSelectedIndex()==0 && n==1){
            
     try {
         JOptionPane.showMessageDialog(null, "success");
         this.dispose();
         Home  m = new Home();
         m.setVisible(true);
         String sql2="insert Into Audit(username,time,status,id)values('"+loggedinId.empname+"','"+todaydate +"/"+timeNow+"','"+"logged in"+"','"+loggedinId.impId+"')";
         pst=conn.prepareStatement(sql2);
         pst.execute();
     } catch (SQLException ex) {
        // JOptionPane.showMessageDialog(null, ex);
     }finally{
        try {
                    if (rs!=null) {
                        rs.close();
                    }
                    if (pst!=null) {
                      pst.close();  
                    }
                    if (conn!=null) {
                      pst.close();  
                    }
                } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null, e);
                }
        }
            }else {
            JOptionPane.showMessageDialog(null, "Authentication Failure");
            
            }
         

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmblog;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu lbldate;
    private javax.swing.JMenu lbltime;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
