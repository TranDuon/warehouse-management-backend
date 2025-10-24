/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.MotLuotBan;

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
public class MotLuotBanRepo 
        implements RepoInterface<MotLuotBan, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public MotLuotBanRepo() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public MotLuotBan getFromResultSet(ResultSet rs) {
        try {
            MotLuotBan t = new MotLuotBan(
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
    public MotLuotBan findById(Long id) {
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
                MotLuotBan t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<MotLuotBan> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM MotLuotBan WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<MotLuotBan> dsT = new ArrayList<>();
        
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
                MotLuotBan t = this.getFromResultSet(rs);
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
    public MotLuotBan create(MotLuotBan t) {
        String sql = "INSERT INTO MotLuotBan(thoigian, dathanhtoan, UseridNhanvien) VALUES (?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getUseridNhanvien());
            
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
    public MotLuotBan update(Long id, MotLuotBan t) {
        t.setId(id);
        
        String sql = "UPDATE MotLuotBan SET thoigian = ?, dathanhtoan = ?, UseridNhanvien = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getUseridNhanvien());
            
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
    
    public List<MotLuotBan> findByTime(Timestamp from, Timestamp to){
        String sql="""
                    SELECT 
                        *
                        FROM MotLuotBan
                        WHERE 
                            thoigian BETWEEN ? AND ? 
                    ;
        """;
        
        List<MotLuotBan> dsT = new ArrayList<>();
        
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
                MotLuotBan t = this.getFromResultSet(rs);
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
        MotLuotBanRepo motLuotBanRepo = new MotLuotBanRepo();
        
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        
        Timestamp from = Timestamp.valueOf(LocalDateTime.parse("00:00:00 "+ "25/09/2025", dateTimeFormatter2) );
        Timestamp to = Timestamp.valueOf(LocalDateTime.parse("00:00:00 "+ "30/09/2025", dateTimeFormatter2) );
        
        List<MotLuotBan> dsT = motLuotBanRepo.findByTime(from, to);
        
        System.out.println("{");
        for(MotLuotBan t : dsT){
            System.out.println("     " + t.toString());
        }
        System.out.println("}");
    }
}
