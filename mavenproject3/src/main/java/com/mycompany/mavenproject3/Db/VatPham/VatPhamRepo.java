/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.VatPham;

import com.mycompany.mavenproject3.Db.Interface.RepoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author azoom
 */
public class VatPhamRepo 
        implements RepoInterface<VatPham, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public VatPhamRepo() {
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public VatPham getFromResultSet(ResultSet rs) {
        try {
            VatPham t = new VatPham(
                rs.getLong("id"),
                rs.getString("ten"),
                rs.getLong("gia"),
                rs.getString("donvi"),
                rs.getString("mota"),
//                rs.getString("urlanh"),
                rs.getInt("soluong")
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VatPham findById(Long id) {
        String sql = "SELECT id, ten, gia, donvi, mota, soluong FROM VatPham WHERE id = ? ;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                VatPham t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<VatPham> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM VatPham WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<VatPham> dsT = new ArrayList<>();
        
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
                VatPham t = this.getFromResultSet(rs);
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
    public VatPham create(VatPham t) {
        String sql = "INSERT INTO VatPham(ten, gia, donvi, mota, soluong) VALUES (?, ?, ?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, t.getTen());
            ps.setLong(2, t.getGia());
            ps.setString(3, t.getDonvi());
            ps.setString(4, t.getMota());
//            ps.setString(5, t.getUrlanh());
            ps.setInt(5, t.getSoluong());
            
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
    public VatPham update(Long id, VatPham t) {
        t.setId(id);
        
        String sql = "UPDATE VatPham SET ten = ?, gia = ?, donvi = ?, mota = ?, soluong=? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, t.getTen());
            ps.setLong(2, t.getGia());
            ps.setString(3, t.getDonvi());
            ps.setString(4, t.getMota());
//            ps.setString(5, t.getUrlanh());
            ps.setInt(5, t.getSoluong());
            
            ps.setLong(6, t.getId());
            
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
        String sql= "DELETE FROM VatPham WHERE id = ?;";
        
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
    
    public List<VatPham> findByName(String name){
        String sql = 
                """
                SELECT *
                FROM vatpham
                WHERE 
                    ten COLLATE SQL_Latin1_General_Cp1253_CI_AI LIKE ? 
                    OR mota COLLATE SQL_Latin1_General_Cp1253_CI_AI LIKE ? ;""";

        List<VatPham> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setNString(1, "%" + name + "%");
            ps.setNString(2, "%" + name + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                VatPham t = this.getFromResultSet(rs);
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
        VatPhamRepo vatPhamRepo = new VatPhamRepo();
        System.out.println("Hello");
        List<VatPham> dsT = vatPhamRepo.getList(1, 10);
        for(int i=0; i<dsT.size(); i++){
            System.out.println(dsT.get(i).toString());
        }
        System.out.println("Hello2");
        
        List<VatPham> dsT2 = vatPhamRepo.findByName("sữa");
        for(int i=0; i<dsT2.size(); i++){
            System.out.println(dsT2.get(i).toString());
        }
    }

}
