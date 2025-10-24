/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap;

import com.mycompany.mavenproject3.ControllerAndView.MotLuotBan.*;
import com.mycompany.mavenproject3.ControllerAndView.VatPham.*;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasChosenObjectInterface;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasListObjectInterface;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasParameterObject;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class SearchAndAddVatPhamView 
        extends javax.swing.JFrame 
        implements 
            ViewHasListObjectInterface<VatPham>,
            ViewHasChosenObjectInterface<VatPham>,
            ViewHasParameterObject<SearchByNameVatPhamViewParameter>
{
    private List<VatPham> dsO;
    private SearchByNameVatPhamViewParameter p;

    /**
     * Creates new form SearchVatPhamByNameView
     */
    public SearchAndAddVatPhamView() {
        initComponents();
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
        
        this.nameKeyword.setText("");
    }
    
    @Override
    public void setListObjectAndReload(List<VatPham> dsT) {
        this.dsO = dsT;
        this.reloadListObjectOnView();
    }

    @Override
    public List<VatPham> getListObjectFromView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        Integer sohang = model.getRowCount();
        
        List<VatPham> list = new ArrayList<>();
        for(int i=0; i<sohang; i++){
            VatPham t = new VatPham(
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
        model.setRowCount(0); // xxxxxxx
        for(VatPham o : dsO){
            model.addRow(
                    new Object[]{
                        o.getId(),
                        o.getTen(),
                        o.getGia(),
                        o.getDonvi(),
                        o.getMota(),
                        o.getSoluong()
                    } 
            );
            //"id", "ten", "gia", "don vi", "mo ta", "so luong"            
        }
        
        this.repaint();
    }
    
    

    @Override
    public VatPham getChosenObject() {
        Integer sttHangDaChon = this.table.getSelectedRow();
        if(sttHangDaChon!=-1){
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            
            VatPham t = new VatPham(
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
    public SearchByNameVatPhamViewParameter getParameterFromView() {
        return new SearchByNameVatPhamViewParameter(
                this.nameKeyword.getText()
        );
    }

    @Override
    public void setParameterAndReload(SearchByNameVatPhamViewParameter t) {
        this.p = t;
        this.reloadParameterOnView();
    }

    @Override
    public void reloadParameterOnView() {
        this.nameKeyword.setText(this.p.getNameKeyword());
    }
    
    // add listener 🟩🟩🟩🟩 
    public void add_Listener_Button_Search(ActionListener e){
        this.search.addActionListener(e);
    }
    
    public void add_Listener_Button_Add(ActionListener e){
        this.add.addActionListener(e);
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
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameKeyword = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();

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

        jLabel1.setText("Name : ");

        search.setText("Search");

        jLabel2.setText("Ket qua tim kiem : ");

        add.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
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
            java.util.logging.Logger.getLogger(SearchAndAddVatPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAndAddVatPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAndAddVatPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAndAddVatPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAndAddVatPhamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameKeyword;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
