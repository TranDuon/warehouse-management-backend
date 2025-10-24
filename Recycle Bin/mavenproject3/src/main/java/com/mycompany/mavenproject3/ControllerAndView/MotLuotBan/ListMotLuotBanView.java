/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotBan;

import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasChosenObjectInterface;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasListObjectInterface;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ViewHasParameterObject;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBan;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azoom
 */
public class ListMotLuotBanView 
        extends javax.swing.JFrame 
        implements 
            ViewHasListObjectInterface<MotLuotBan>,
            ViewHasChosenObjectInterface<MotLuotBan>,
            ViewHasParameterObject<ListMotLuotBanViewParameter>
{

    
    /**
     * Creates new form ListMotLuotBanView
     */
    public ListMotLuotBanView() {
        initComponents();
    }

    @Override
    public void setListObjectAndReload(List<MotLuotBan> dsT) {
        this.dsT = dsT;
        this.reloadListObjectOnView();
    }

    @Override
    public List<MotLuotBan> getListObjectFromView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        Integer sohang = model.getRowCount();
        
        List<MotLuotBan> list = new ArrayList<>();
        for(int i=0; i<sohang; i++){
            MotLuotBan t = new MotLuotBan(
                    Long.valueOf(model.getValueAt(i, 0).toString()),
                    Timestamp.valueOf(LocalDateTime.parse(model.getValueAt(i, 1).toString(), dateTimeFormatter2)),
                    Boolean.valueOf(model.getValueAt(i, 2).toString()),
                    Long.valueOf(model.getValueAt(i, 3).toString())
            );
            
            list.add(t);
        }
        return list;
    }

    @Override
    public void reloadListObjectOnView() {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        
        for(MotLuotBan t : this.dsT){
            model.addRow(
                    new Object[]{
                        t.getId(),
                        t.getThoigian().toLocalDateTime().format(dateTimeFormatter2),
                        t.getDathanhtoan(),
                        t.getUseridNhanvien()
                    }
            );
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
        this.from.setText("");
        this.to.setText("");
        
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        
        this.p = null;
        this.dsT = null;
    }

    @Override
    public MotLuotBan getChosenObject() {
        Integer sttHangDaChon = this.table.getSelectedRow();
        
        if(sttHangDaChon!=-1){
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            
            MotLuotBan t = new MotLuotBan(
                    Long.valueOf(model.getValueAt(sttHangDaChon, 0).toString()),
                    Timestamp.valueOf(LocalDateTime.parse(model.getValueAt(sttHangDaChon, 1).toString(), dateTimeFormatter2)),
                    Boolean.valueOf(model.getValueAt(sttHangDaChon, 2).toString()),
                    Long.valueOf(model.getValueAt(sttHangDaChon, 3).toString())
            );
            
            return t;
        }
        return null;
    }

    @Override
    public ListMotLuotBanViewParameter getParameterFromView() {
        return new ListMotLuotBanViewParameter(
//                LocalDateTime.parse(this.from.getText(), dateTimeFormatter1),
//                LocalDateTime.parse(this.to.getText(), dateTimeFormatter1)
                LocalDateTime.parse("00:00:00 "+ this.from.getText(), dateTimeFormatter2 ),
                LocalDateTime.parse("23:59:59 "+ this.to.getText(), dateTimeFormatter2)
        );
    }

    @Override
    public void setParameterAndReload(ListMotLuotBanViewParameter t) {
        this.p = t;
        this.reloadParameterOnView();
    }

    @Override
    public void reloadParameterOnView() {
        this.from.setText(p.getDateTimeFrom().format(dateTimeFormatter1));
        this.to.setText(p.getDateTimeTo().format(dateTimeFormatter1));
    }
    
    // Hàm inject trình XLSK (xử lý sự kiện)
    public void add_Listener_Button_Search(ActionListener e){
        this.search.addActionListener(e);
    }
    
    public void add_Listener_Button_GetDetails(ActionListener e){
        this.getDetails.addActionListener(e);
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
        from = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        getDetails = new javax.swing.JButton();
        search = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("From : ");

        from.setToolTipText("dd/MM/yyyy");
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        jLabel2.setText("to :");

        to.setToolTipText("dd/MM/yyyy");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "thoigian", "dathanhtoan", "idNhanVien"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        getDetails.setText("Get details");

        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getDetails)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getDetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For getDetails see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListMotLuotBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMotLuotBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMotLuotBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMotLuotBanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMotLuotBanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField from;
    private javax.swing.JButton getDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
    private List<MotLuotBan> dsT;
    private static DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    private ListMotLuotBanViewParameter p;
}
