/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Controller;

import com.mycompany.mavenproject3.Controller.HomeController;
import com.mycompany.mavenproject3.Controller.ControllerInterface;
import com.mycompany.mavenproject3.View.Product.SearchByNameProductViewParameter;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItem;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Entity.SaleOrderItemId;
import com.mycompany.mavenproject3.Db.SaleOrderItem.Service.SaleOrderItemService;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItem;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Entity.PurschaseOrderItemId;
import com.mycompany.mavenproject3.Db.PurschaseOrderItem.Service.PurschaseOrderItemService;
import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import com.mycompany.mavenproject3.Db.SaleTransaction.Service.SaleTransactionService;
import com.mycompany.mavenproject3.Db.PurschaseTransaction.Entity.PurschaseTransaction;
import com.mycompany.mavenproject3.Db.PurschaseTransaction.Service.PurschaseTransactionService;
import com.mycompany.mavenproject3.Db.User.Entity.User;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import com.mycompany.mavenproject3.Db.Product.Service.ProductService;
import com.mycompany.mavenproject3.View.PurschaseTransaction.CreatePurschaseTransactionView;
import com.mycompany.mavenproject3.View.PurschaseTransaction.DetailsPurschaseTransactionView;
import com.mycompany.mavenproject3.View.PurschaseTransaction.ListPurschaseTransactionView;
import com.mycompany.mavenproject3.View.PurschaseTransaction.ListPurschaseTransactionViewParameter;
import com.mycompany.mavenproject3.View.PurschaseTransaction.ProductWithPurschaseQuantity;
import com.mycompany.mavenproject3.View.PurschaseTransaction.PurschaseOrderItemHasNameProduct;
import com.mycompany.mavenproject3.View.PurschaseTransaction.PurschaseTransactionView;
import com.mycompany.mavenproject3.View.PurschaseTransaction.SearchAndAddPurschaseProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azoom
 */
public class PurschaseTransactionController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private PurschaseTransactionService purschaseTransactionService;
    private PurschaseOrderItemService purschaseOrderItemService;
    private ProductService productService;
    
    // view do controller này quản lý
    private CreatePurschaseTransactionView createPurschaseTransactionView;
    private PurschaseTransactionView purschaseTransactionView;
    private SearchAndAddPurschaseProductView searchAndAddPurschaseProductView;
    private ListPurschaseTransactionView listPurschaseTransactionView;
    private DetailsPurschaseTransactionView detailsPurschaseTransactionView;
    
    
    // constructor
    public PurschaseTransactionController(User user) {
        this.user = user;
        this.purschaseTransactionService = new PurschaseTransactionService();
        this.purschaseOrderItemService = new PurschaseOrderItemService();
        this.productService = new ProductService();
        
        this.createPurschaseTransactionView = new CreatePurschaseTransactionView();
        this.createPurschaseTransactionView.add_Listener_Button_Add(new Listener_CreatePurschaseTransactionView_Button_Add());
        this.createPurschaseTransactionView.add_Listener_Button_Create(new Listener_CreatePurschaseTransactionView_Button_Create());
        this.createPurschaseTransactionView.add_Listener_Button_Cancel(new Listener_CreatePurschaseTransactionView_Button_Cancel());
        
        this.purschaseTransactionView = new PurschaseTransactionView();
        this.purschaseTransactionView.add_Listener_Button_Create(new Listener_PurschaseTransactionView_Button_Create());
        this.purschaseTransactionView.add_Listener_Button_GetList(new Listener_PurschaseTransactionView_Button_GetList());
        
        this.searchAndAddPurschaseProductView = new SearchAndAddPurschaseProductView();
        this.searchAndAddPurschaseProductView.add_Listener_Button_Add(new Listener_SearchAndAddPurschaseProductView_Button_Add());
        this.searchAndAddPurschaseProductView.add_Listener_Button_Search(new Listener_SearchAndAddPurschaseProductView_Button_Search());
        
        this.listPurschaseTransactionView = new ListPurschaseTransactionView();
        this.listPurschaseTransactionView.add_Listener_Button_Search(new Listener_ListPurschaseTransactionView_Button_Search());
        this.listPurschaseTransactionView.add_Listener_Button_GetDetails(new Listener_ListPurschaseTransactionView_Button_GetDetails());
        
        this.detailsPurschaseTransactionView = new DetailsPurschaseTransactionView();
        
                
    }
    
    @Override
    public void showMainView() {
        this.purschaseTransactionView.showView();
    }

    @Override
    public void hideMainView() {
        this.purschaseTransactionView.hideView();
    }
    
    public ArrayList<PurschaseOrderItemHasNameProduct> convertDsspNhap(ArrayList<PurschaseOrderItem> dsT){
        
        ArrayList<PurschaseOrderItemHasNameProduct> dsT2 = new ArrayList<>();
        
        for(PurschaseOrderItem t : dsT){
            Product vp1 = this.productService.findById(t.getId().getProductid());
            PurschaseOrderItemHasNameProduct t2 = new PurschaseOrderItemHasNameProduct(
                    t, 
                    vp1.getName()
            );
            dsT2.add(t2);
        }
        return dsT2;
    }
    
    /*
    
}




*/
// At this view
class Listener_PurschaseTransactionView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createPurschaseTransactionView.showView();
    }

}

class Listener_PurschaseTransactionView_Button_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        listPurschaseTransactionView.showView();
    }

}

// at CreateMotLuotBanView
class Listener_CreatePurschaseTransactionView_Button_Add implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        searchAndAddPurschaseProductView.showView();
    }

}

class Listener_CreatePurschaseTransactionView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ProductWithPurschaseQuantity> dsT = createPurschaseTransactionView.getListObjectFromView();
        User user1 = user;
        
        PurschaseTransaction motLuotNhap = new PurschaseTransaction(
                null, 
                Timestamp.from(Instant.now()), 
                Boolean.TRUE, 
                user1.getId()
        );
        
        motLuotNhap = purschaseTransactionService.create(motLuotNhap);
        
        List<PurschaseOrderItem> listDsspNhap = new ArrayList<>();
        
        for(ProductWithPurschaseQuantity motVatPhamWithSoLuong : dsT){
            Product tempVatPham = productService.findById(motVatPhamWithSoLuong.getVatPham().getId());
            
            PurschaseOrderItem tempDsspNhap = new PurschaseOrderItem(
                    new PurschaseOrderItemId(
                            motVatPhamWithSoLuong.getVatPham().getId(),
                            motLuotNhap.getId()
                    ),
                    motVatPhamWithSoLuong.getSoLuongNhap(),
                    tempVatPham.getPrice()
            );
            
            tempDsspNhap= purschaseOrderItemService.create(tempDsspNhap);
            listDsspNhap.add(tempDsspNhap);
            
            tempVatPham.setQuantity(tempVatPham.getQuantity()+motVatPhamWithSoLuong.getSoLuongNhap());
            tempVatPham = productService.update(tempVatPham.getId(), tempVatPham);
        }
        
        createPurschaseTransactionView.deleteContent();
    }

}

class Listener_CreatePurschaseTransactionView_Button_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createPurschaseTransactionView.deleteContent();
        showMainView();
        createPurschaseTransactionView.hideView();
    }
    
}


// at searchAndAddView
class Listener_SearchAndAddPurschaseProductView_Button_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchByNameProductViewParameter t = searchAndAddPurschaseProductView.getParameterFromView();
        
        List<Product> listVp1 = productService.findByName(t.getNameKeyword());
        
        searchAndAddPurschaseProductView.setListObjectAndReload(listVp1);
    }

}

class Listener_SearchAndAddPurschaseProductView_Button_Add implements ActionListener {

    public Boolean isContain(List<ProductWithPurschaseQuantity> dsT, Product vatPham){
        for(ProductWithPurschaseQuantity t : dsT){
            if(t.getVatPham().getId()==vatPham.getId()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<ProductWithPurschaseQuantity> dsT = createPurschaseTransactionView.getListObjectFromView();
        
        Product vatPham = searchAndAddPurschaseProductView.getChosenObject();
        
        if(isContain(dsT, vatPham)==false ){
            dsT.add(
                    new ProductWithPurschaseQuantity(vatPham , 1)
            );
            createPurschaseTransactionView.setListObjectAndReload(dsT);
        }
        else{
            // doesnt do
        }
    }

}

// at list MotLuotBanView
class Listener_ListPurschaseTransactionView_Button_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ListPurschaseTransactionViewParameter p = listPurschaseTransactionView.getParameterFromView();
        
        List<PurschaseTransaction> dsT = purschaseTransactionService.findByTime(p.getDateTimeFrom_Timestamp(), p.getDateTimeTo_Timestamp());
        
        listPurschaseTransactionView.setListObjectAndReload(dsT);
    }

}

class Listener_ListPurschaseTransactionView_Button_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PurschaseTransaction t= listPurschaseTransactionView.getChosenObject();
        
        detailsPurschaseTransactionView.deleteContent();
        
        detailsPurschaseTransactionView.setObjectAndReload(t);

        ArrayList<PurschaseOrderItem> dsT = (ArrayList<PurschaseOrderItem>) purschaseOrderItemService.findByMotLuotNhapId(t.getId());
        ArrayList<PurschaseOrderItemHasNameProduct> dsT2 = convertDsspNhap(dsT);
        detailsPurschaseTransactionView.setListObjectAndReload(dsT2);
        
        detailsPurschaseTransactionView.showView();
    }

}


}

