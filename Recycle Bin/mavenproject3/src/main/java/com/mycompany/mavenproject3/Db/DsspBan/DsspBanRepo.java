/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspBan;

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
public class DsspBanRepo 
        implements RepoInterface<DsspBan, DsspBanId>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public DsspBanRepo() {
    }
    
    
    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    @Override
    public DsspBan getFromResultSet(ResultSet rs) {
        try {
            DsspBan t = new DsspBan(
                new DsspBanId(
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
    public DsspBan findById(DsspBanId id) {
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
                DsspBan t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }
    
    @Override
    public List<DsspBan> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM DsspBan WHERE 1=1 ORDER BY MotLuotBanid DESC, VatPhamid DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<DsspBan> dsT = new ArrayList<>();
        
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
                DsspBan t = this.getFromResultSet(rs);
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
    public DsspBan create(DsspBan t) {
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
            ps.setInt(3, t.getSoluong());
            ps.setLong(4, t.getGia());
            
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
    public DsspBan update(DsspBanId id, DsspBan t) {
        String sql = "UPDATE DsspBan SET soluong = ?, gia = ? WHERE VatPhamid = ? AND MotLuotBanid = ?;";

        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, t.getSoluong());
            ps.setLong(2, t.getGia());
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
    public Boolean delete(DsspBanId id) {
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

    public Boolean deleteByVatphamid(Long vatPhamid){
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

    public Boolean deleteByMotluotbanid(Long motluotbanid){
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

    List<DsspBan> findByMotLuotBanId(Long motLuotBanId) {
        String sql = "SELECT * FROM DsspBan WHERE MotLuotBanid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motLuotBanId);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<DsspBan> dsT = new ArrayList<>();
            
            while(rs.next()== true){
                DsspBan t = this.getFromResultSet(rs);
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
