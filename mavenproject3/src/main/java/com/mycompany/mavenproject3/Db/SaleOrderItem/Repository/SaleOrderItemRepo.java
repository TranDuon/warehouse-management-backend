/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleOrderItem.Repository;

import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItemId;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItem;
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
public class SaleOrderItemRepo 
        implements RepoInterface<SaleOrderItem, SaleOrderItemId>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public SaleOrderItemRepo() {
    }
    
    
    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    @Override
    public SaleOrderItem getFromResultSet(ResultSet rs) {
        try {
            SaleOrderItem t = new SaleOrderItem(
                new SaleOrderItemId(
                    rs.getLong("VatPhamid"),
                    rs.getLong("MotLuotBanid")
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
    public SaleOrderItem findById(SaleOrderItemId id) {
        String sql = "SELECT VatPhamid, MotLuotBanid, soluong, gia FROM DsspBan WHERE VatPhamid=? AND MotLuotBanid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getVatPhamid());
            ps.setLong(2, id.getMotLuotBanid());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                SaleOrderItem t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }
    
    @Override
    public List<SaleOrderItem> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM DsspBan WHERE 1=1 ORDER BY MotLuotBanid DESC, VatPhamid DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<SaleOrderItem> dsT = new ArrayList<>();
        
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
                SaleOrderItem t = this.getFromResultSet(rs);
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
    public SaleOrderItem create(SaleOrderItem t) {
        String sql = "INSERT INTO DsspBan(VatPhamid, MotLuotBanid, soluong, gia) VALUES (?, ?, ?, ?);";

        // PK là FK nên không được set null

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, t.getId().getVatPhamid());
            ps.setLong(2, t.getId().getMotLuotBanid());
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
    public SaleOrderItem update(SaleOrderItemId id, SaleOrderItem t) {
        String sql = "UPDATE DsspBan SET soluong = ?, gia = ? WHERE VatPhamid = ? AND MotLuotBanid = ?;";

        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, t.getQuantity());
            ps.setLong(2, t.getPrice());
            ps.setLong(3, t.getId().getVatPhamid());
            ps.setLong(4, t.getId().getMotLuotBanid());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    
    @Override
    public Boolean delete(SaleOrderItemId id) {
        String sql = "DELETE FROM DsspBan WHERE VatPhamid = ? AND MotLuotBanid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getVatPhamid());
            ps.setLong(2, id.getMotLuotBanid());
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;   
    }

    public Boolean deleteByProductid(Long vatPhamid){
        String sql = "DELETE FROM DsspBan WHERE VatPhamid = ? ;";
        
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

    public Boolean deleteBySaleTransactionid(Long motluotbanid){
        String sql = "DELETE FROM DsspBan WHERE MotLuotBanid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motluotbanid);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false; 
    }

    public List<SaleOrderItem> findBySaleTransactionId(Long motLuotBanId) {
        String sql = "SELECT * FROM DsspBan WHERE MotLuotBanid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motLuotBanId);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<SaleOrderItem> dsT = new ArrayList<>();
            
            while(rs.next()== true){
                SaleOrderItem t = this.getFromResultSet(rs);
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
