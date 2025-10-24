/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.mavenproject3.ControllerAndView.Login.LoginController;

/**
 *
 * @author azoom
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        FlatLightLaf.setup();
        
        LoginController loginController = new LoginController();
        loginController.showMainView();
    }
}
