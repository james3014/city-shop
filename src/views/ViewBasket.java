/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import java.util.Map;
import javax.swing.table.*;
import models.Product;

/**
 *
 * @author 30237347
 */
public class ViewBasket extends javax.swing.JFrame {

    private Order currentOrder;
    Customer loggedInCustomer;
    
    public ViewBasket(Customer customer) 
    {
        initComponents();
        
        loggedInCustomer = customer;
        currentOrder = loggedInCustomer.findLatestOrders();

        DefaultTableModel basket = (DefaultTableModel)tblBasket.getModel();
        
        for(Map.Entry<Integer, OrderLine> olEntry : currentOrder.getOrderLines().entrySet())
        {
            OrderLine actualOrderLine = olEntry.getValue();
            Product orderedProduct = actualOrderLine.getProduct();
            
            basket.addRow(new Object[]
            {orderedProduct.getProductId(), orderedProduct, actualOrderLine.getQuantity(),
                "£" + String.format("%.02f",orderedProduct.getPrice())});  
                    
        }
        
        lblOrderTotal.setText("£" + String.format("%.02f", currentOrder.getOrderTotal()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBasket = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        lblOrderTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblBasket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblBasket);

        btnRemove.setText("Remove");

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        lblOrderTotal.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOrderTotal)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnBuy)
                    .addComponent(lblOrderTotal))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        ViewProducts viewProducts = new ViewProducts(loggedInCustomer);
        this.dispose();
        viewProducts.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        
        currentOrder.setStatus("Confirmed");
        
        DBManager db = new DBManager();
        db.completeOrder(currentOrder.getOrderId());
        
        Confirmation confirmation = new Confirmation(loggedInCustomer, currentOrder);
        this.dispose();
        confirmation.setVisible(true);
    }//GEN-LAST:event_btnBuyActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewBasket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrderTotal;
    private javax.swing.JTable tblBasket;
    // End of variables declaration//GEN-END:variables
}