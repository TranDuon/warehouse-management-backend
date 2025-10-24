/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.Home;

import com.mycompany.mavenproject3.ControllerAndView.Interface.ControllerInterface;
import com.mycompany.mavenproject3.ControllerAndView.Login.LoginController;
import com.mycompany.mavenproject3.ControllerAndView.Login.LoginView;
import com.mycompany.mavenproject3.ControllerAndView.MotLuotBan.MotLuotBanController;
import com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap.MotLuotNhapController;
import com.mycompany.mavenproject3.ControllerAndView.VatPham.VatPhamController;
import com.mycompany.mavenproject3.Db.User.User;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author azoom
 */
public class HomeController 
        implements ControllerInterface
{
    
    // thuộc tính dùng chung
    private User user;
    
    // view do controller này quản lý
    private HomeView homeView;
    
    // controller liên kết với controller này
    private VatPhamController vatPhamController;
    private MotLuotBanController motLuotBanController;
    private MotLuotNhapController motLuotNhapController;

    public HomeController(User user) {
        this.user = user;
        
        
        this.homeView = new HomeView();
        
        this.vatPhamController = new VatPhamController(user);
        this.homeView.add_Listener_VatPham_Button(new Listener_HomeView_WhenClick_VatPham());
        
        this.motLuotBanController = new MotLuotBanController(user);
        this.homeView.add_Listener_MotLuotBan_Button(new Listener_HomeView_WhenClick_MotLuotBan());
        
        this.motLuotNhapController = new MotLuotNhapController(user);
        this.homeView.add_Listener_MotLuotNhap_Button(new Listener_HomeView_WhenClick_MotLuotNhap());
        
        this.homeView.showView();
    }

    @Override
    public void showMainView() {
        this.homeView.showView();
    }

    @Override
    public void hideMainView() {
        this.homeView.hideView();
    }/*
    
     
}
    
    
    */
    
    
    
// Listener của home view
class Listener_HomeView_WhenClick_VatPham  implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        vatPhamController.showMainView();
    }
}

class Listener_HomeView_WhenClick_MotLuotBan implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {        
        motLuotBanController.showMainView();
    }
}

class Listener_HomeView_WhenClick_MotLuotNhap implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            motLuotNhapController.showMainView();
        }
}
    
    
}
