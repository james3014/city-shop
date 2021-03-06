package views;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import models.Clothing;
import models.DBManager;
import models.Footwear;
import models.Staff;

/**
 *
 * @author 30237347
 */
public class AddProducts extends javax.swing.JFrame {

    private ButtonGroup bg;
    private Staff loggedInStaff;
    
    /**
     *
     * @param staff
     */
    public AddProducts(Staff staff) 
    {
        staff = loggedInStaff;
        initComponents();
        
        bg = new ButtonGroup();
        bg.add(rdnClothing);
        bg.add(rdnFootwear);
        
        lblExtra.setVisible(false);
        txtExtra.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        rdnClothing = new javax.swing.JRadioButton();
        rdnFootwear = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblExtra = new javax.swing.JLabel();
        txtExtra = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add New Product");

        jLabel2.setText("Type of Product:");

        rdnClothing.setText("Clothing");
        rdnClothing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnClothingActionPerformed(evt);
            }
        });

        rdnFootwear.setText("Footwear");
        rdnFootwear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnFootwearActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        jLabel4.setText("Price:");

        jLabel5.setText("Stock Level:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblExtra.setText("jLabel6");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(lblExtra))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdnClothing)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdnFootwear))
                                    .addComponent(txtName)
                                    .addComponent(txtPrice)
                                    .addComponent(txtStock)
                                    .addComponent(txtExtra)))
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdnClothing)
                    .addComponent(rdnFootwear))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExtra)
                    .addComponent(txtExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnClear))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        bg.clearSelection();
        lblExtra.setVisible(false);
        txtExtra.setVisible(false);
        txtName.setText("");
        txtPrice.setText("");
        txtStock.setText("");
        lblError.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        StaffHome staffHome = new StaffHome(loggedInStaff);
        this.dispose();
        staffHome.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void rdnClothingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnClothingActionPerformed
        
        lblExtra.setVisible(true);
        lblExtra.setText("Measurement:");
        txtExtra.setVisible(true);
    }//GEN-LAST:event_rdnClothingActionPerformed

    private void rdnFootwearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnFootwearActionPerformed
       
        lblExtra.setVisible(true);
        lblExtra.setText("Shoe Size:");
        txtExtra.setVisible(true);
    }//GEN-LAST:event_rdnFootwearActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
        String name = txtName.getText();
        String price = txtPrice.getText();
        String stock = txtStock.getText();
        String extra = txtExtra.getText();
        
        if(!rdnClothing.isSelected() && rdnFootwear.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Select A Product Type");
        }
        else if(name.equals("") || price.equals("") || stock.equals("") || extra.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Complete All Information");
        }
        else
        {
            try
            {
                int intStock = Integer.parseInt(stock);
                try
                {
                    double doublePrice = Double.parseDouble(price);
                    if(rdnClothing.isSelected())
                    {
                        Clothing clothing = new Clothing(extra, name, doublePrice, intStock);
                        
                        DBManager db = new DBManager();
                        db.addProduct(clothing);
                        JOptionPane.showMessageDialog(null, "New Clothing Product Added");
                    }
                    else if(rdnFootwear.isSelected())
                    {
                        Footwear footwear = new Footwear(Integer.valueOf(extra), name, doublePrice, intStock);
                        
                        DBManager db = new DBManager();
                        db.addProduct(footwear);
                        JOptionPane.showMessageDialog(null, "New Footwear Product Added");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Product Selected");
                    }    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Enter Valid Price");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Enter Valid Stock");
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProducts(new Staff()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblExtra;
    private javax.swing.JRadioButton rdnClothing;
    private javax.swing.JRadioButton rdnFootwear;
    private javax.swing.JTextField txtExtra;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
