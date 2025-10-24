/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseOrderItem.Repository;

import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItem;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItemId;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItem;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItemId;
import com.mycompany.mavenproject3.Db.Interface.RepoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azoom
 */
public class PurschaseOrderItemRepo 
        implements RepoInterface<PurschaseOrderItem, PurschaseOrderItemId>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public PurschaseOrderItem getFromResultSet(ResultSet rs) {
        try {
            PurschaseOrderItem t = new PurschaseOrderItem(
                new PurschaseOrderItemId(
                    rs.getLong("VatPhamid"),
                    rs.getLong("MotLuotNhapid")
                ),
                rs.getInt("soluong"),
                rs.getLong("gia")
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurschaseOrderItem findById(PurschaseOrderItemId id) {
        String sql = "SELECT VatPhamid, MotLuotNhapid, soluong, gia FROM DsspNhap WHERE VatPhamid=? AND MotLuotNhapid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getProductid());
            ps.setLong(2, id.getPurschaseTransactionid());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                PurschaseOrderItem t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<PurschaseOrderItem> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM DsspNhap WHERE 1=1 ORDER BY MotLuotNhapid DESC, VatPhamid DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<PurschaseOrderItem> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, ((sttPage-1)*sizePage));
            ps.setInt(2, sizePage);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                PurschaseOrderItem t = this.getFromResultSet(rs);
                dsT.add(t);
            }
            
            return dsT;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurschaseOrderItem create(PurschaseOrderItem t) {
        String sql = "INSERT INTO DsspNhap(VatPhamid, MotLuotNhapid, soluong, gia) VALUES (?, ?, ?, ?);";

        // PK là FK nên không được set null

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, t.getId().getProductid());
            ps.setLong(2, t.getId().getPurschaseTransactionid());
            ps.setInt(3, t.getQuantity());
            ps.setLong(4, t.getPrice());
            
            ps.executeUpdate();
            
            // PK là FK nên không tạo được khóa mới

            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurschaseOrderItem update(PurschaseOrderItemId id, PurschaseOrderItem t) {
        String sql = "UPDATE DsspNhap SET soluong = ?, gia = ? WHERE VatPhamid = ? AND MotLuotNhapid = ?;";

        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, t.getQuantity());
            ps.setLong(2, t.getPrice());
            ps.setLong(3, t.getId().getProductid());
            ps.setLong(4, t.getId().getPurschaseTransactionid());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean delete(PurschaseOrderItemId id) {
        String sql = "DELETE FROM DsspNhap WHERE VatPhamid = ? AND MotLuotNhapid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getProductid());
            ps.setLong(2, id.getPurschaseTransactionid());
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;  
    }
    
    public Boolean deleteByProductid(Long vatPhamid){
        String sql = "DELETE FROM DsspNhap WHERE VatPhamid = ? ;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, vatPhamid);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false; 
    }

    public Boolean deleteByPurschaseTransactionid(Long motluotnhapid){
        String sql = "DELETE FROM DsspNhap WHERE MotLuotNhapid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motluotnhapid);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false; 
    }

    public List<PurschaseOrderItem> findByPurschaseTransactionId(Long motLuotNhapId) {
        String sql = "SELECT * FROM DsspNhap WHERE MotLuotNhapid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motLuotNhapId);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<PurschaseOrderItem> dsT = new ArrayList<>();
            
            while(rs.next()== true){
                PurschaseOrderItem t = this.getFromResultSet(rs);
                dsT.add(t);
            }
            
            return dsT;
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

}
