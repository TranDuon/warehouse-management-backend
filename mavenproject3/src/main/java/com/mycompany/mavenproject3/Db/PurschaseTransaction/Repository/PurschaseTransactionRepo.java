/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.PurschaseTransaction.Repository;

import com.mycompany.mavenproject3.Db.PurschaseTransaction.Entity.PurschaseTransaction;
import com.mycompany.mavenproject3.Db.Interface.RepoInterface;
import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class PurschaseTransactionRepo 
        implements RepoInterface<PurschaseTransaction, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public PurschaseTransactionRepo() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public PurschaseTransaction getFromResultSet(ResultSet rs) {
        try {
            PurschaseTransaction t = new PurschaseTransaction(
                    rs.getLong("id"),
                    rs.getTimestamp("thoigian"),
                    rs.getBoolean("dathanhtoan"),
                    rs.getLong("UseridNhanvien")
            );
            return t;
        }
        catch (SQLException ex) {
            Logger.getLogger(PurschaseTransactionRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PurschaseTransaction findById(Long id) {
        String sql = "SELECT id, thoigian, dathanhtoan, UseridNhanvien FROM MotLuotNhap WHERE id = ?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                PurschaseTransaction t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<PurschaseTransaction> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM MotLuotNhap WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<PurschaseTransaction> dsT = new ArrayList<>();
        
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
                PurschaseTransaction t = this.getFromResultSet(rs);
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
    public PurschaseTransaction create(PurschaseTransaction t) {
        String sql = "INSERT INTO MotLuotNhap(thoigian, dathanhtoan, UseridNhanvien) VALUES (?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setTimestamp(1, t.getTimestamp());
            ps.setBoolean(2, t.getIsPaid());
            ps.setLong(3, t.getUseridEmployee());
            
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
    public PurschaseTransaction update(Long id, PurschaseTransaction t) {
        t.setId(id);
        
        String sql = "UPDATE MotLuotNhap SET thoigian = ?, dathanhtoan = ?, UseridNhanvien = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setTimestamp(1, t.getTimestamp());
            ps.setBoolean(2, t.getIsPaid());
            ps.setLong(3, t.getUseridEmployee());
            
            ps.setLong(4, t.getId());
            
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
        String sql= "DELETE FROM MotLuotNhap WHERE id = ?;";
        
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
    
    public List<PurschaseTransaction> findByTime(Timestamp from, Timestamp to){
        String sql="""
                    SELECT 
                        *
                        FROM MotLuotNhap
                        WHERE 
                            thoigian BETWEEN ? AND ? 
                    ;
        """;
        
        List<PurschaseTransaction> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setTimestamp(1, from);
            ps.setTimestamp(2, to);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                PurschaseTransaction t = this.getFromResultSet(rs);
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
