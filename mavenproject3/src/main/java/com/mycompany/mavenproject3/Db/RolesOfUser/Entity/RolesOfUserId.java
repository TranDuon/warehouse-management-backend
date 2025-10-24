/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.RolesOfUser.Entity;


/**
 *
 * @author azoom
 */
public class RolesOfUserId {
    private Long Userid;
    private Long Roleid;
    public RolesOfUserId(Long userid, Long roleid) {
        Userid = userid;
        Roleid = roleid;
    }
    public RolesOfUserId() {
    }

    public Long getUserid() {
        return Userid;
    }

    public void setUserid(Long Userid) {
        this.Userid = Userid;
    }

    public Long getRoleid() {
        return Roleid;
    }

    public void setRoleid(Long Roleid) {
        this.Roleid = Roleid;
    }

}
