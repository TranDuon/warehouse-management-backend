/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.User;

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
public class UserRepo 
        implements RepoInterface<User, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public UserRepo() {
    }

    
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public User getFromResultSet(ResultSet rs) {
        try {
            User t = new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("sodienthoai"),
                rs.getBoolean("enabled")
            );
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT id, username, password, email, sodienthoai, enabled FROM [User] WHERE id = ?;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                User t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<User> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM User WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<User> dsT = new ArrayList<>();
        
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
                User t = this.getFromResultSet(rs);
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
    public User create(User t) {
        String sql = "INSERT INTO [User](username, password, email, sodienthoai, enabled) VALUES (?, ?, ?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setBoolean(5, t.getEnabled());
            
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
    public User update(Long id, User t) {
        t.setId(id);
        
        String sql = "UPDATE [User] SET username = ?, password = ?, email = ?, sodienthoai = ?, enabled = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, t.getUsername());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSodienthoai());
            ps.setBoolean(5, t.getEnabled());
            
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
        String sql= "DELETE FROM [User] WHERE id = ?;";
        
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

    public User findByUsername(String username){
        String sql= "SELECT * FROM [User] WHERE username= ? ";

        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                User t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;

    }

    public User findByUsernamePassword(UserDto userDto) {
        String sql = "SELECT id, username, password, email, sodienthoai, enabled FROM [User] WHERE username = ? AND password = ? ;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, userDto.getUsername());
            ps.setString(2, userDto.getPassword());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                User t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }
}
