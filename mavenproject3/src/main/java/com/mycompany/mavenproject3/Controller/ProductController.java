/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Controller;

import com.mycompany.mavenproject3.Controller.HomeController;
import com.mycompany.mavenproject3.Controller.ControllerInterface;
import com.mycompany.mavenproject3.Db.User.Entity.User;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import com.mycompany.mavenproject3.Db.Product.Service.ProductService;
import com.mycompany.mavenproject3.View.Product.CreateProductView;
import com.mycompany.mavenproject3.View.Product.DeleteProductView;
import com.mycompany.mavenproject3.View.Product.DetailsProductView;
import com.mycompany.mavenproject3.View.Product.ListProductView;
import com.mycompany.mavenproject3.View.Product.ListProductViewParameter;
import com.mycompany.mavenproject3.View.Product.ProductView;
import com.mycompany.mavenproject3.View.Product.SearchByNameProductView;
import com.mycompany.mavenproject3.View.Product.SearchByNameProductViewParameter;
import com.mycompany.mavenproject3.View.Product.UpdateProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author azoom
 */
public class ProductController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private ProductService productService;
    
    // view do controller này quản lý
    private ProductView productView;
    private CreateProductView createProductView;
    private DeleteProductView deleteProductView;
    private DetailsProductView detailsProductView;
    private ListProductView listProductView;
    private SearchByNameProductView searchByNameProductView;
    private UpdateProductView updateProductView;
    


    public ProductController(User user) {
        this.user = user;
        this.productService = new ProductService();
        
        this.productView = new ProductView();
        this.productView.add_Listener_Create_Button(new Listener_ProductView_WhenClick_Create());
        this.productView.add_Listener_GetList_Button(new Listener_ProductView_WhenClick_GetList());
        this.productView.add_Listener_SearchByName_Button(new Listener_ProductView_WhenClick_SearchByName());
        
        this.createProductView = new CreateProductView();
        this.createProductView.add_Listener_Create_Button(new Listener_CreateProductView_WhenClick_Create());
        this.createProductView.add_Listener_Cacel_Button(new Listener_CreateProductView_WhenClick_Cancel());
                
        this.deleteProductView = new DeleteProductView();
        this.deleteProductView.add_Listener_Delete_Button(new Listener_DeleteProductView_WhenClick_Delete());
        this.deleteProductView.add_Listener_Cancel_Button(new Listener_DeleteProductView_WhenClick_Cancel());
        
        this.detailsProductView = new DetailsProductView();
        this.detailsProductView.add_Listener_Remove_Button(new Listener_DetailsProductView_WhenClick_Remove());
        this.detailsProductView.add_Listener_Update_Button(new Listener_DetailsProductView_WhenClick_Update());
        
        this.listProductView = new ListProductView();
        this.listProductView.add_Listener_GetDetails_Button(new Listener_ListProductView_WhenClick_GetDetails());
        this.listProductView.add_Listener_GetList_Button(new Listener_ListProductView_WhenClick_GetList());
        
        this.searchByNameProductView = new SearchByNameProductView();
        this.searchByNameProductView.add_Listener_Button_Search(new Listener_SearchByNameProductView_WhenClick_Search());
        this.searchByNameProductView.add_Listener_Button_GetDetails(new Listener_SearchByNameProductView_WhenClick_GetDetails());
        
        this.updateProductView = new UpdateProductView();
        this.updateProductView.add_Listener_Button_Update(new Listener_SearchByNameProductView_WhenClick_Update());
        this.updateProductView.add_Listener_Button_Cancel(new Listener_SearchByNameProductView_WhenClick_Cancel());
    }

    @Override
    public void showMainView() {
        this.productView.showView();
    }

    @Override
    public void hideMainView() {
        this.productView.hideView();
    }
    
    /*
    
}
    
    
    
    */    
    
// 🟩🟩🟩🟩🟩 listener của ProductView
class Listener_ProductView_WhenClick_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        productView.hideView();
        createProductView.showView();
    }
}

class Listener_ProductView_WhenClick_GetList implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        productView.hideView();
        listProductView.showView();
    }

}

class Listener_ProductView_WhenClick_SearchByName implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        productView.hideView();
        searchByNameProductView.showView();
    }

}



// 🟩🟩🟩🟩🟩 listener của Create View  
class Listener_CreateProductView_WhenClick_Create  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Product t = createProductView.getObjectFromView();
        t = productService.create(t);

        createProductView.deleteContent();
        detailsProductView.setObjectAndReload(t);

        // createView.hideView();
        detailsProductView.showView();

    }
    }

class Listener_CreateProductView_WhenClick_Cancel  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createProductView.hideView();
        createProductView.deleteContent();

        productView.deleteContent();
        productView.showView();
    }
}

// 🟩🟩🟩🟩🟩 listener của Delete View
class Listener_DeleteProductView_WhenClick_Delete  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Product t = deleteProductView.getObjectFromView();
        productService.delete(t.getId());
        deleteProductView.hideView();
        deleteProductView.deleteContent();

        // vatPhamView.deleteContent();
        // vatPhamView.showView();
    }
    }

class Listener_DeleteProductView_WhenClick_Cancel  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        deleteProductView.hideView();
        deleteProductView.deleteContent();

        // vatPhamView.deleteContent();
        // vatPhamView.showView();
    }
}

// 🟩🟩🟩🟩🟩 listener của Details View
class Listener_DetailsProductView_WhenClick_Update implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        // detailsView.hideView();

        Product t = detailsProductView.getObjectFromView();
        t = productService.findById(t.getId());

        updateProductView.setObjectAndReload(t);
        updateProductView.showView();

    }
    }

class Listener_DetailsProductView_WhenClick_Remove implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        // detailsView.hideView();

        Product t = detailsProductView.getObjectFromView();
        t = productService.findById(t.getId());

        deleteProductView.setObjectAndReload(t);
        deleteProductView.showView();
    }
    }

// 🟩🟩🟩🟩🟩 listener của List View
class Listener_ListProductView_WhenClick_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        ListProductViewParameter p = listProductView.getParameterFromView();
        List<Product> dsT = productService.getList(p.getPageNum(), p.getSizePage());
        listProductView.setListObjectAndReload(dsT);
    }
    }

class Listener_ListProductView_WhenClick_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        Product t = listProductView.getChosenObject();
        t = productService.findById(t.getId());
        detailsProductView.deleteContent();
        detailsProductView.setObjectAndReload(t);
        detailsProductView.showView();
    }
    }



// 🟩🟩🟩🟩🟩 listener của SearchByName View
class Listener_SearchByNameProductView_WhenClick_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        SearchByNameProductViewParameter p = searchByNameProductView.getParameterFromView();
        
        List<Product> dsT = productService.findByName(p.getNameKeyword());
        
        searchByNameProductView.setListObjectAndReload(dsT);
    }

}

class Listener_SearchByNameProductView_WhenClick_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Product t = searchByNameProductView.getChosenObject();
        
        detailsProductView.setObjectAndReload(t);
        detailsProductView.showView();
    }
    }


// 🟩🟩🟩🟩🟩 listener của Update View
class Listener_SearchByNameProductView_WhenClick_Update implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Product t = updateProductView.getObjectFromView();
        
        t = productService.update(t.getId(), t);
        
        updateProductView.hideView();
        detailsProductView.setObjectAndReload(t);
        detailsProductView.showView();
    }

}

class Listener_SearchByNameProductView_WhenClick_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        updateProductView.hideView();
        updateProductView.deleteContent();
        
        detailsProductView.showView();
    }

}


}
