/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap;

import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasListObjectInterface;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewInterface;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class CreateMotLuotNhapView 
        extends javax.swing.JFrame
        implements 
            ViewInterface ,
            ViewHasListObjectInterface<VatPhamWithSoLuongNhap>
{

    /**
     * Creates new form CreateMotLuotBan
     */
    public CreateMotLuotNhapView() {
        initComponents();
        
        // khi bán hàng mới cần điều kiện này
        // this.table.getModel().addTableModelListener(new Listener_Table_When_ChangeCellTable());
    }
    
    public void addItem(VatPham t2){
        
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        Integer sohang = model.getRowCount();
        
        model.addRow(
                new Object[]{
                    sohang,
                    t2.getId(),
                    t2.getTen(),
                    t2.getGia(),
                    t2.getDonvi(),
                    t2.getSoluong(),
                    0
                }
        );
    }

    @Override
    public void setListObjectAndReload(List<VatPhamWithSoLuongNhap> dsT) {
        this.dsVatPhamWithSoLuongNhap = dsT;
        this.reloadListObjectOnView();
    }

    @Override
    public List<VatPhamWithSoLuongNhap> getListObjectFromView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        Integer sohang = model.getRowCount();
        
        // System.out.println("model.toString, soHang : " + model.toString() + "," + sohang);
        
        List<VatPhamWithSoLuongNhap> list = new ArrayList<>();
        for(int i=0; i<sohang; i++){
            // System.out.println(">> đang ở hàng thứ " + i );
            Long    temp_id             = Long.valueOf(model.getValueAt(i, 1).toString());
            String  temp_ten            = (String)model.getValueAt(i, 2);
            Long    temp_gia            = Long.valueOf(model.getValueAt(i, 3).toString() );
            String  temp_donvi          = (String)model.getValueAt(i, 4);
            String  temp_mota           = null;
            Integer temp_soluong        = Integer.valueOf(model.getValueAt(i, 5).toString());
            Integer temp_soluongnhap    = Integer.valueOf(model.getValueAt(i, 6).toString());
            
            
            VatPhamWithSoLuongNhap t = new VatPhamWithSoLuongNhap(
                    new VatPham(
                            temp_id,
                            temp_ten,
                            temp_gia,
                            temp_donvi,
                            temp_mota,
                            temp_soluong
                    ),
                    temp_soluongnhap
            );
            list.add(t);
        }
        
        return list;
    }

    @Override
    public void reloadListObjectOnView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        
        Integer i =0;
        for(VatPhamWithSoLuongNhap o : this.dsVatPhamWithSoLuongNhap){
            model.addRow(
                    new Object[]{
                        i,
                        o.getVatPham().getId(),
                        o.getVatPham().getTen(),
                        o.getVatPham().getGia(),
                        o.getVatPham().getDonvi(),
                        o.getVatPham().getSoluong(),
                        o.getSoLuongNhap()
                    }
            );
            i++;
        }
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
    }

    // Hàm inject hàm xử lý sự kiện
    public void add_Listener_Button_Add(ActionListener e){
        this.addVatPham.addActionListener(e);
    }
    
    public void add_Listener_Button_Create(ActionListener e){
        this.createNhapBanHang.addActionListener(e);
    }
    
    public void add_Listener_Button_Cancel(ActionListener e){
        this.cancel.addActionListener(e);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addVatPham = new javax.swing.JButton();
        removeVatPham = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        createNhapBanHang = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        jLabel2.setText("Tạo một lượt bán hàng");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stt", "id", "tên", "giá", "đơn vị", "còn trong kho", "số lượng nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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

        addVatPham.setText("Add vật phẩm");

        removeVatPham.setText("Remove vật phẩm");
        removeVatPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeVatPhamActionPerformed(evt);
            }
        });

        createNhapBanHang.setText("Create lượt bán hàng");
        createNhapBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNhapBanHangActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addVatPham)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeVatPham))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(createNhapBanHang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancel)))
                                .addGap(0, 327, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVatPham)
                    .addComponent(removeVatPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNhapBanHang)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNhapBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNhapBanHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNhapBanHangActionPerformed

    private void removeVatPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeVatPhamActionPerformed
        // TODO add your handling code here:
        Integer sttHangDaChon = this.table.getSelectedRow();
        
        if(sttHangDaChon!=-1 ){
            ArrayList<VatPhamWithSoLuongNhap> dsT = new ArrayList<>();
            for(int i=0; i<this.dsVatPhamWithSoLuongNhap.size(); i++){
                if(i!=sttHangDaChon){
                    dsT.add(this.dsVatPhamWithSoLuongNhap.get(i));
                }
            }
            
            this.setListObjectAndReload(dsT);

//            System.out.println("{");
//            for(VatPhamWithSoLuongDat t : this.dsVatPhamWithSoLuongDat){
//                System.out.println("    "+ t.toString() + " ");
//            }
//            System.out.println("}");
            
        }
    }//GEN-LAST:event_removeVatPhamActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(CreateMotLuotNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMotLuotNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMotLuotNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMotLuotNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                CreateMotLuotNhapView view = new CreateMotLuotNhapView();
                
                List<VatPhamWithSoLuongNhap> list = new ArrayList<>();
                for(int i=0; i<5; i++){
                    VatPhamWithSoLuongNhap t = new VatPhamWithSoLuongNhap(
                            new VatPham(
                                    null,
                                    null,
                                    null,
                                    null,
                                    null,
                                    i+10
                            ),
                            i
                    );
                    list.add(t);
                }
                view.setListObjectAndReload(list);
                
                view.showView();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVatPham;
    private javax.swing.JButton cancel;
    private javax.swing.JButton createNhapBanHang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeVatPham;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private List<VatPhamWithSoLuongNhap> dsVatPhamWithSoLuongNhap;

    /*


}


    */
    
// khi bán mới cần check số lượng bán nhỏ hơn số lượng có sẵn   
//class Listener_Table_When_ChangeCellTable implements TableModelListener{
//
//        @Override
//        public void tableChanged(TableModelEvent e) {
//            if(e.getType() == TableModelEvent.UPDATE || e.getType()==TableModelEvent.INSERT){
//                Integer row = e.getFirstRow();
//                Integer column = e.getColumn();
//                DefaultTableModel model = (DefaultTableModel) table.getModel();
//                
//                if(column == 6){
//                    Integer soluongban = Integer.valueOf(model.getValueAt(row, 6).toString());
//                    Integer soluongmax = Integer.valueOf(model.getValueAt(row, 5).toString());
//                    
//                    if(soluongban > soluongmax){
//                        JOptionPane.showMessageDialog(table, "ở hàng "+ row + " của bảng, số lượng bán phải nhỏ hơn số lượng max");
//                        model.setValueAt("0", row, column);
//                    }
//                }
//            }
//        }
//    
//}

}
