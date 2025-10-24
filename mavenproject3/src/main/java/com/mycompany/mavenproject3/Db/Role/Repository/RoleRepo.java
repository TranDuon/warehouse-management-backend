/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.Role;

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
public class RoleRepo 
        implements RepoInterface<Role, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public RoleRepo() {
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Role getFromResultSet(ResultSet rs) {
        try {
            Role t = new Role(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("mota")
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findById(Long id) {
        String sql = "SELECT id, name, mota FROM Role;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                Role t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<Role> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT id, name, mota FROM Role WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<Role> dsT = new ArrayList<>();
        
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
                Role t = this.getFromResultSet(rs);
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
    public Role create(Role t) {
        String sql = "INSERT INTO Role(name, mota) VALUES (?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, t.getName());
            ps.setString(2, t.getMota());
            
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
    public Role update(Long id, Role t) {
        t.setId(id);
        
        String sql = "UPDATE Role SET name = ?, mota = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, t.getName());
            ps.setString(2, t.getMota());
            
            ps.setLong(3, t.getId());
            
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
        String sql= "DELETE FROM Role WHERE id = ?;";
        
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

    public Role findByName(String name){
        String sql = "SELECT * FROM Role WHERE name=?";

        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                Role t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

}
