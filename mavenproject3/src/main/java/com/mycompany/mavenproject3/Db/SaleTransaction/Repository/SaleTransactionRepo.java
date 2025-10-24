/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.SaleTransaction.Repository;

import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.RepoInterface;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author azoom
 */
public class SaleTransactionRepo 
        implements RepoInterface<SaleTransaction, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public SaleTransactionRepo() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public SaleTransaction getFromResultSet(ResultSet rs) {
        try {
            SaleTransaction t = new SaleTransaction(
                rs.getLong("id"),
                rs.getTimestamp("thoigian"),
                rs.getBoolean("dathanhtoan"),
                rs.getLong("UseridNhanvien")
            ); 
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SaleTransaction findById(Long id) {
        String sql = "SELECT id, thoigian, dathanhtoan, UseridNhanvien FROM MotLuotBan WHERE id = ? ;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                SaleTransaction t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<SaleTransaction> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM MotLuotBan WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<SaleTransaction> dsT = new ArrayList<>();
        
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
                SaleTransaction t = this.getFromResultSet(rs);
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
    public SaleTransaction create(SaleTransaction t) {
        String sql = "INSERT INTO MotLuotBan(thoigian, dathanhtoan, UseridNhanvien) VALUES (?, ?, ?);";

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
    public SaleTransaction update(Long id, SaleTransaction t) {
        t.setId(id);
        
        String sql = "UPDATE MotLuotBan SET thoigian = ?, dathanhtoan = ?, UseridNhanvien = ? WHERE id = ?;";
        
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
        String sql= "DELETE FROM MotLuotBan WHERE id = ?;";
        
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
    
    public List<SaleTransaction> findByTime(Timestamp from, Timestamp to){
        String sql="""
                    SELECT 
                        *
                        FROM MotLuotBan
                        WHERE 
                            thoigian BETWEEN ? AND ? 
                    ;
        """;
        
        List<SaleTransaction> dsT = new ArrayList<>();
        
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
                SaleTransaction t = this.getFromResultSet(rs);
                dsT.add(t);
            }
            
            return dsT;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SaleTransactionRepo motLuotBanRepo = new SaleTransactionRepo();
        
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        
        Timestamp from = Timestamp.valueOf(LocalDateTime.parse("00:00:00 "+ "25/09/2025", dateTimeFormatter2) );
        Timestamp to = Timestamp.valueOf(LocalDateTime.parse("00:00:00 "+ "30/09/2025", dateTimeFormatter2) );
        
        List<SaleTransaction> dsT = motLuotBanRepo.findByTime(from, to);
        
        System.out.println("{");
        for(SaleTransaction t : dsT){
            System.out.println("     " + t.toString());
        }
        System.out.println("}");
    }
}
