/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Controller;

import com.mycompany.mavenproject3.Controller.ControllerInterface;
import com.mycompany.mavenproject3.Controller.LoginController;
import com.mycompany.mavenproject3.View.Login.LoginView;
import com.mycompany.mavenproject3.Controller.SaleTransactionController;
import com.mycompany.mavenproject3.Controller.PurschaseTransactionController;
import com.mycompany.mavenproject3.Controller.ProductController;
import com.mycompany.mavenproject3.Db.User.Entity.User;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import com.mycompany.mavenproject3.View.Home.HomeView;
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
    private ProductController vatPhamController;
    private SaleTransactionController motLuotBanController;
    private SaleTransactionController motLuotNhapController;

    public HomeController(User user) {
        this.user = user;
        
        
        this.homeView = new HomeView();
        
        this.vatPhamController = new ProductController(user);
        this.homeView.add_Listener_VatPham_Button(new Listener_HomeView_WhenClick_VatPham());
        
        this.motLuotBanController = new SaleTransactionController(user);
        this.homeView.add_Listener_MotLuotBan_Button(new Listener_HomeView_WhenClick_MotLuotBan());
        
        this.motLuotNhapController = new SaleTransactionController(user);
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
