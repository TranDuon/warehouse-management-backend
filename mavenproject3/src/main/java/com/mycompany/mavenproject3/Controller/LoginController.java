/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Controller;

import com.mycompany.mavenproject3.Controller.HomeController;
import com.mycompany.mavenproject3.View.Home.HomeView;
import com.mycompany.mavenproject3.Controller.ControllerInterface;
import com.mycompany.mavenproject3.Db.User.Entity.User;
import com.mycompany.mavenproject3.Db.User.Dto.UserDto;
import com.mycompany.mavenproject3.Db.User.Service.UserService;
import com.mycompany.mavenproject3.View.Login.LoginView;
import com.mycompany.mavenproject3.View.Login.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author azoom
 */
public class LoginController 
        implements ControllerInterface
{
    
    private UserService userService;
    
    private User user= null;
    
    private LoginView loginView;
    
    private RegisterView registerView;
    
    private HomeController homeController= null;
    
    class Listener_LoginView_WhenClick_Register_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            loginView.deleteContent();
            registerView.setVisible(true);
        }
        
    }

    class Listener_RegisterView_WhenClick_Register_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User user1 = registerView.getUser();
            user1 = userService.create(user1);
            
            registerView.deleteContent();
            registerView.hideView();
            
            loginView.deleteContent();
            loginView.showView();
        }
        
    }
    
    class Listener_LoginView_WhenClick_Login_Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UserDto userDto1 = loginView.getUserDto();
            User user1 = userService.findByUsernamePassword(userDto1);
            if(user1!= null){
                loginView.deleteContent();
                loginView.hideView();
                
                user = user1;
                initHomeController();
            }
            else {
                System.out.println("invalid");
            }
        }
        
    }
    
    
    public LoginController() {
        this.userService = new UserService();
        
        this.loginView = new LoginView();        
        this.loginView.add_Listener_Login_Button(new Listener_LoginView_WhenClick_Login_Button() );
        this.loginView.add_Listener_Register_Button(new Listener_LoginView_WhenClick_Register_Button() );
        
        this.registerView = new RegisterView();
        this.registerView.add_Listener_Register_Button(new Listener_RegisterView_WhenClick_Register_Button() );
         
    }

    public static void main(String[] args) {
        LoginController loginController1 = new LoginController();
    }

    
    private void initHomeController(){
        this.homeController = new HomeController(this.user);
    }

    @Override
    public void showMainView() {
        this.loginView.setVisible(true);
    }

    @Override
    public void hideMainView() {
        this.loginView.setVisible(false);
    }
            
    
}
