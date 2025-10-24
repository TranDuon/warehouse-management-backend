/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.DsspNhap;

import com.mycompany.mavenproject3.Db.DsspBan.DsspBan;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBanId;
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
public class DsspNhapRepo 
        implements RepoInterface<DsspNhap, DsspNhapId>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public DsspNhap getFromResultSet(ResultSet rs) {
        try {
            DsspNhap t = new DsspNhap(
                new DsspNhapId(
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
    public DsspNhap findById(DsspNhapId id) {
        String sql = "SELECT VatPhamid, MotLuotNhapid, soluong, gia FROM DsspNhap WHERE VatPhamid=? AND MotLuotNhapid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getVatPhamid());
            ps.setLong(2, id.getMotLuotNhapid());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                DsspNhap t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<DsspNhap> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM DsspNhap WHERE 1=1 ORDER BY MotLuotNhapid DESC, VatPhamid DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<DsspNhap> dsT = new ArrayList<>();
        
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
                DsspNhap t = this.getFromResultSet(rs);
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
    public DsspNhap create(DsspNhap t) {
        String sql = "INSERT INTO DsspNhap(VatPhamid, MotLuotNhapid, soluong, gia) VALUES (?, ?, ?, ?);";

        // PK là FK nên không được set null

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, t.getId().getVatPhamid());
            ps.setLong(2, t.getId().getMotLuotNhapid());
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
    public DsspNhap update(DsspNhapId id, DsspNhap t) {
        String sql = "UPDATE DsspNhap SET soluong = ?, gia = ? WHERE VatPhamid = ? AND MotLuotNhapid = ?;";

        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, t.getSoluong());
            ps.setLong(2, t.getGia());
            ps.setLong(3, t.getId().getVatPhamid());
            ps.setLong(4, t.getId().getMotLuotNhapid());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean delete(DsspNhapId id) {
        String sql = "DELETE FROM DsspNhap WHERE VatPhamid = ? AND MotLuotNhapid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getVatPhamid());
            ps.setLong(2, id.getMotLuotNhapid());
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;  
    }
    
    public Boolean deleteByVatphamid(Long vatPhamid){
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

    public Boolean deleteByMotluotnhapid(Long motluotnhapid){
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

    List<DsspNhap> findByMotLuotNhapId(Long motLuotNhapId) {
        String sql = "SELECT * FROM DsspNhap WHERE MotLuotNhapid=?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, motLuotNhapId);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<DsspNhap> dsT = new ArrayList<>();
            
            while(rs.next()== true){
                DsspNhap t = this.getFromResultSet(rs);
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
