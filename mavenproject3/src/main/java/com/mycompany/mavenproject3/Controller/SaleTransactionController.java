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
import com.mycompany.mavenproject3.Db.SaleTransaction.Entity.SaleTransaction;
import com.mycompany.mavenproject3.Db.SaleTransaction.Service.SaleTransactionService;
import com.mycompany.mavenproject3.Db.User.Entity.User;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import com.mycompany.mavenproject3.Db.Product.Service.ProductService;
import com.mycompany.mavenproject3.View.SaleTransaction.CreateSaleTransactionView;
import com.mycompany.mavenproject3.View.SaleTransaction.DetailsSaleTransactionView;
import com.mycompany.mavenproject3.View.SaleTransaction.ListSaleTransactionView;
import com.mycompany.mavenproject3.View.SaleTransaction.ListSaleTransactionViewParameter;
import com.mycompany.mavenproject3.View.SaleTransaction.ProductWithSaleQuantity;
import com.mycompany.mavenproject3.View.SaleTransaction.SaleOrderItemHasNameProduct;
import com.mycompany.mavenproject3.View.SaleTransaction.SaleTransactionView;
import com.mycompany.mavenproject3.View.SaleTransaction.SearchAndAddSaleProductView;
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
public class SaleTransactionController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private SaleTransactionService saleTransactionService;
    private SaleOrderItemService saleOrderItemService;
    private ProductService productService;
    
    // view do controller này quản lý
    private CreateSaleTransactionView createSaleTransactionView;
    private SaleTransactionView saleTransactionView;
    private SearchAndAddSaleProductView searchAndAddSaleProductView;
    private ListSaleTransactionView listSaleTransactionView;
    private DetailsSaleTransactionView detailsSaleTransactionView;
    
    
    // constructor
    public SaleTransactionController(User user) {
        this.user = user;
        this.saleTransactionService = new SaleTransactionService();
        this.saleOrderItemService = new SaleOrderItemService();
        this.productService = new ProductService();
        
        this.createSaleTransactionView = new CreateSaleTransactionView();
        this.createSaleTransactionView.add_Listener_Button_Add(new Listener_CreateSaleTransactionView_Button_Add());
        this.createSaleTransactionView.add_Listener_Button_Create(new Listener_CreateSaleTransactionView_Button_Create());
        this.createSaleTransactionView.add_Listener_Button_Cancel(new Listener_CreateSaleTransactionView_Button_Cancel());
        
        this.saleTransactionView = new SaleTransactionView();
        this.saleTransactionView.add_Listener_Button_Create(new Listener_SaleTransactionView_Button_Create());
        this.saleTransactionView.add_Listener_Button_GetList(new Listener_SaleTransactionView_Button_GetList());
        
        this.searchAndAddSaleProductView = new SearchAndAddSaleProductView();
        this.searchAndAddSaleProductView.add_Listener_Button_Add(new Listener_SearchAndAddSaleProductView_Button_Add());
        this.searchAndAddSaleProductView.add_Listener_Button_Search(new Listener_SearchAndAddSaleProductView_Button_Search());
        
        this.listSaleTransactionView = new ListSaleTransactionView();
        this.listSaleTransactionView.add_Listener_Button_Search(new Listener_ListSaleTransactionView_Button_Search());
        this.listSaleTransactionView.add_Listener_Button_GetDetails(new Listener_ListSaleTransactionView_Button_GetDetails());
        
        this.detailsSaleTransactionView = new DetailsSaleTransactionView();
        
                
    }
    
    @Override
    public void showMainView() {
        this.saleTransactionView.showView();
    }

    @Override
    public void hideMainView() {
        this.saleTransactionView.hideView();
    }
    
    public ArrayList<SaleOrderItemHasNameProduct> convertDsspBan(ArrayList<SaleOrderItem> dsT){
        
        ArrayList<SaleOrderItemHasNameProduct> dsT2 = new ArrayList<>();
        
        for(SaleOrderItem t : dsT){
            Product vp1 = this.productService.findById(t.getId().getVatPhamid());
            SaleOrderItemHasNameProduct t2 = new SaleOrderItemHasNameProduct(
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
class Listener_SaleTransactionView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createSaleTransactionView.showView();
    }

}

class Listener_SaleTransactionView_Button_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        listSaleTransactionView.showView();
    }

}

// at CreateSaleTransactionView
class Listener_CreateSaleTransactionView_Button_Add implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        searchAndAddSaleProductView.showView();
    }

}

class Listener_CreateSaleTransactionView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ProductWithSaleQuantity> dsT = createSaleTransactionView.getListObjectFromView();
        User user1 = user;
        
        SaleTransaction motLuotBan = new SaleTransaction(
                null, 
                Timestamp.from(Instant.now()), 
                Boolean.TRUE, 
                user1.getId()
        );
        
        motLuotBan = saleTransactionService.create(motLuotBan);
        
        List<SaleOrderItem> listDsspBan = new ArrayList<>();
        
        for(ProductWithSaleQuantity motVatPhamWithSoLuong : dsT){
            Product tempVatPham = productService.findById(motVatPhamWithSoLuong.getProduct().getId());
            
            SaleOrderItem tempDsspBan = new SaleOrderItem(
                    new SaleOrderItemId(
                            motVatPhamWithSoLuong.getProduct().getId(),
                            motLuotBan.getId()
                    ),
                    motVatPhamWithSoLuong.getQuantity(),
                    tempVatPham.getPrice()
            );
            
            tempDsspBan= saleOrderItemService.create(tempDsspBan);
            listDsspBan.add(tempDsspBan);
            
            tempVatPham.setQuantity(tempVatPham.getQuantity()-motVatPhamWithSoLuong.getQuantity());
            tempVatPham = productService.update(tempVatPham.getId(), tempVatPham);
        }
        
        createSaleTransactionView.deleteContent();
    }

}

class Listener_CreateSaleTransactionView_Button_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createSaleTransactionView.deleteContent();
        showMainView();
        createSaleTransactionView.hideView();
    }
    
}


// at searchAndAddView
class Listener_SearchAndAddSaleProductView_Button_Search implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchByNameProductViewParameter t = searchAndAddSaleProductView.getParameterFromView();
        
        List<Product> listVp1 = productService.findByName(t.getNameKeyword());
        
        searchAndAddSaleProductView.setListObjectAndReload(listVp1);
    }

}

class Listener_SearchAndAddSaleProductView_Button_Add implements ActionListener {

    public Boolean isContain(List<ProductWithSaleQuantity> dsT, Product vatPham){
        for(ProductWithSaleQuantity t : dsT){
            if(t.getProduct().getId()==vatPham.getId()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<ProductWithSaleQuantity> dsT = createSaleTransactionView.getListObjectFromView();
        
        Product vatPham = searchAndAddSaleProductView.getChosenObject();
        
        if(isContain(dsT, vatPham)==false ){
            dsT.add(
                    new ProductWithSaleQuantity(vatPham, 1)
            );

            createSaleTransactionView.setListObjectAndReload(dsT);
        }
        else{
            // doesnt do
        }
    }

}

// at list SaleTransactionView
class Listener_ListSaleTransactionView_Button_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ListSaleTransactionViewParameter p = listSaleTransactionView.getParameterFromView();
        
        List<SaleTransaction> dsT = saleTransactionService.findByTime(p.getDateTimeFrom_Timestamp(), p.getDateTimeTo_Timestamp());
        
        listSaleTransactionView.setListObjectAndReload(dsT);
    }

}

class Listener_ListSaleTransactionView_Button_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SaleTransaction t= listSaleTransactionView.getChosenObject();
        
        detailsSaleTransactionView.deleteContent();
        
        detailsSaleTransactionView.setObjectAndReload(t);

        ArrayList<SaleOrderItem> dsT = (ArrayList<SaleOrderItem>) saleOrderItemService.findBySaleTransactionId(t.getId());
        ArrayList<SaleOrderItemHasNameProduct> dsT2 = convertDsspBan(dsT);
        detailsSaleTransactionView.setListObjectAndReload(dsT2);
        
        detailsSaleTransactionView.showView();
    }

}


}

