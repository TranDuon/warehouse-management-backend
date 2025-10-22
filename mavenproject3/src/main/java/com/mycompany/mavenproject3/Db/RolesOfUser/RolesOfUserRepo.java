/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.RolesOfUser;

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
public class RolesOfUserRepo 
        implements RepoInterface<RolesOfUser, RolesOfUserId>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public RolesOfUserRepo() {
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public RolesOfUser getFromResultSet(ResultSet rs) {
        try {
            RolesOfUser t = new RolesOfUser(
                new RolesOfUserId(
                    rs.getLong("Userid"),
                    rs.getLong("Roleid")
                )
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RolesOfUser findById(RolesOfUserId id) {
        String sql = "SELECT Userid, Roleid FROM RolesOfUser WHERE Userid = ? AND Roleid = ?;";
        
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getUserid());
            ps.setLong(2, id.getRoleid());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                RolesOfUser t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
        
    }

    @Override
    public List<RolesOfUser> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT Userid, Roleid FROM RolesOfUser WHERE 1=1 ORDER BY Userid DESC Roleid DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY;";

        List<RolesOfUser> dsT = new ArrayList<>();
        
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
                RolesOfUser t = this.getFromResultSet(rs);
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
    public RolesOfUser create(RolesOfUser t) {
        String sql = "INSERT INTO RolesOfUser(Userid, Roleid) VALUES (?, ?);";

        // PK là FK nên không được set null

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, t.getId().getUserid());
            ps.setLong(2, t.getId().getRoleid());
            
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
    public RolesOfUser update(RolesOfUserId id, RolesOfUser t) {
        String sql = "UPDATE RolesOfUser SET  WHERE Userid = ? AND Roleid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, t.getId().getUserid());
            ps.setLong(2, t.getId().getRoleid());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean delete(RolesOfUserId id) {
        String sql = "DELETE FROM RolesOfUser WHERE Userid = ? AND Roleid = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id.getUserid());
            ps.setLong(2, id.getRoleid());
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<RolesOfUser> findByUserid(Long userId) {
        String sql = "SELECT Userid, Roleid FROM RolesOfUser WHERE Userid = ?;";
        
        ArrayList<RolesOfUser> dsT= new ArrayList<>();

        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, userId);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                RolesOfUser t = this.getFromResultSet(rs);
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
