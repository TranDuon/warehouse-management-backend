/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.mavenproject3.View.Product;

import com.mycompany.mavenproject3.View.Interface.ViewHasChosenObjectInterface;
import com.mycompany.mavenproject3.View.Interface.ViewHasListObjectInterface;
import com.mycompany.mavenproject3.View.Interface.ViewHasObjectInterface;
import com.mycompany.mavenproject3.View.Interface.ViewHasParameterObject;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class ListProductView 
        extends javax.swing.JFrame 
        implements 
            ViewHasListObjectInterface<Product>,
            ViewHasChosenObjectInterface<Product>,
            ViewHasParameterObject<ListProductViewParameter>
{

    private List<Product> dsO;
    private ListProductViewParameter p;
    
    /** Creates new form ListVatPhamView */
    public ListProductView() {
        initComponents();
    }

    public void add_Listener_GetList_Button(ActionListener a){
        this.getList.addActionListener(a);
    }
            
    public void add_Listener_GetDetails_Button(ActionListener a){
        this.getDetails.addActionListener(a);
    }

    @Override
    public void hideView() {
        this.setVisible(false);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void deleteContent() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        
        this.pageNum.setText("1");
        this.sizePage.setText("20");
    }

    @Override
    public void setListObjectAndReload(List<Product> dsT) {
        this.dsO = dsT;
        this.reloadListObjectOnView();
    }

    @Override
    public List<Product> getListObjectFromView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        Integer sohang = model.getRowCount();
        
        List<Product> list = new ArrayList<>();
        for(int i=0; i<sohang; i++){
            Product t = new Product(
                    Long.valueOf(model.getValueAt(i, 0).toString()),
                    (String) model.getValueAt(i, 1),
                    Long.valueOf(model.getValueAt(i, 2).toString()),
                    (String) model.getValueAt(i, 3),
                    (String) model.getValueAt(i, 4),
                    Integer.valueOf(model.getValueAt(i, 5).toString())
                    
            );
            list.add(t);
        }
        
        return list;
    }

    @Override
    public void reloadListObjectOnView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        
        for(Product o : dsO){
            model.addRow(
                    new Object[]{
                        o.getId(),
                        o.getName(),
                        o.getPrice(),
                        o.getUnit(),
                        o.getDescription(),
                        o.getQuantity()
                    } 
            );
            //"id", "ten", "gia", "don vi", "mo ta", "so luong"            
        }
        
        this.repaint();
    }

    
    @Override
    public Product getChosenObject() {
        Integer sttHangDaChon = this.table.getSelectedRow();
        if(sttHangDaChon!=-1){
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            
            Product t = new Product(
                    Long.valueOf(model.getValueAt(sttHangDaChon, 0).toString()),
                    (String) model.getValueAt(sttHangDaChon, 1),
                    Long.valueOf(model.getValueAt(sttHangDaChon, 2).toString()),
                    (String) model.getValueAt(sttHangDaChon, 3),
                    (String) model.getValueAt(sttHangDaChon, 4),
                    Integer.valueOf(model.getValueAt(sttHangDaChon, 5).toString())
            );
            return t;
        }
        return null;
        // throw exception 
    }

    @Override
    public ListProductViewParameter getParameterFromView() {
        return new ListProductViewParameter(
                Integer.valueOf(this.pageNum.getText()),
                Integer.valueOf(this.sizePage.getText())
        );
    }

    @Override
    public void setParameterAndReload(ListProductViewParameter t) {
        this.p = t;
        this.reloadParameterOnView();
    }

    @Override
    public void reloadParameterOnView() {
        this.pageNum.setText(this.p.getPageNum().toString());
        this.sizePage.setText(this.p.getSizePage().toString());
    }
    
    

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pageNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sizePage = new javax.swing.JTextField();
        getList = new javax.swing.JButton();
        getDetails = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "ten", "gia", "don vi", "mo ta", "so luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Choose Page :");

        jLabel2.setText("size page : ");

        getList.setText("Get list");

        getDetails.setText("Get Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sizePage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getList))
                            .addComponent(getDetails))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pageNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sizePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getDetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
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
            java.util.logging.Logger.getLogger(ListProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getDetails;
    private javax.swing.JButton getList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pageNum;
    private javax.swing.JTextField sizePage;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
