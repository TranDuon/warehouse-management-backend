/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleInvoice.Repository;

import com.mycompany.mavenproject3.Db.SaleInvoice.Entity.SaleInvoice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.mavenproject3.Db.Interface.RepoInterface;

/**
 *
 * @author azoom
 */
public class SaleInvoiceRepo 
        implements RepoInterface<SaleInvoice, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public SaleInvoiceRepo() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public SaleInvoice getFromResultSet(ResultSet rs) {
        try {
            SaleInvoice t = new SaleInvoice(
                rs.getLong("id"),
                rs.getTimestamp("thoigian"),
                rs.getLong("sotien"),
                rs.getBoolean("lathanhtoantienmat"),
                rs.getLong("Motluotbanid")
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SaleInvoice findById(Long id) {
        String sql = "SELECT id, thoigian, sotien, lathanhtoantienmat, MotLuotBanid FROM HoaDonBan WHERE id =? ;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                SaleInvoice t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<SaleInvoice> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM HoaDonBan WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<SaleInvoice> dsT = new ArrayList<>();
        
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
                SaleInvoice t = this.getFromResultSet(rs);
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
    public SaleInvoice create(SaleInvoice t) {
        String sql = "INSERT INTO HoaDonBan(thoigian, sotien, lathanhtoantienmat, MotLuotBanid) VALUES (?, ?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setTimestamp(1, t.getTimestamp());
            ps.setLong(2, t.getAmount());
            ps.setBoolean(3, t.getIsCashPayment());
            ps.setLong(4, t.getSaleTransactionId());
            
            ps.executeUpdate();
            
            try
            /*resource*/(
                ResultSet rs = ps.getGeneratedKeys();
            )
            {
                if(rs.next()==true){
                    Long id1 = (Long)rs.getLong(1);
                    return this.findById(id1);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SaleInvoice update(Long id, SaleInvoice t) {
        t.setId(id);
        
        String sql = "UPDATE HoaDonBan SET thoigian = ?, sotien = ?, lathanhtoantienmat = ?, MotLuotBanid = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setTimestamp(1, t.getTimestamp());
            ps.setLong(2, t.getAmount());
            ps.setBoolean(3, t.getIsCashPayment());
            ps.setLong(4, t.getSaleTransactionId());
            
            ps.setLong(5, t.getId());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        String sql= "DELETE FROM HoaDonBan WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
