/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.VatPham;

import com.mycompany.mavenproject3.ControllerAndView.Home.HomeController;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ControllerInterface;
import com.mycompany.mavenproject3.Db.User.User;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;
import com.mycompany.mavenproject3.Db.VatPham.VatPhamService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author azoom
 */
public class VatPhamController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private VatPhamService vatPhamService;
    
    // view do controller này quản lý
    private VatPhamView vatPhamView;
    private CreateVatPhamView createView;
    private DeleteVatPhamView deleteView;
    private DetailsVatPhamView detailsView;
    private ListVatPhamView listView;
    private SearchByNameVatPhamView searchByNameView;
    private UpdateVatPhamView updateView;
    


    public VatPhamController(User user) {
        this.user = user;
        this.vatPhamService = new VatPhamService();
        
        this.vatPhamView = new VatPhamView();
        this.vatPhamView.add_Listener_Create_Button(new Listener_VatPhamView_WhenClick_Create());
        this.vatPhamView.add_Listener_GetList_Button(new Listener_VatPhamView_WhenClick_GetList());
        this.vatPhamView.add_Listener_SearchByName_Button(new Listener_VatPhamView_WhenClick_SearchByName());
        
        this.createView = new CreateVatPhamView();
        this.createView.add_Listener_Create_Button(new Listener_CreateView_WhenClick_Create());
        this.createView.add_Listener_Cacel_Button(new Listener_CreateView_WhenClick_Cancel());
                
        this.deleteView = new DeleteVatPhamView();
        this.deleteView.add_Listener_Delete_Button(new Listener_DeleteView_WhenClick_Delete());
        this.deleteView.add_Listener_Cancel_Button(new Listener_DeleteView_WhenClick_Cancel());
        
        this.detailsView = new DetailsVatPhamView();
        this.detailsView.add_Listener_Remove_Button(new Listener_DetailsView_WhenClick_Remove());
        this.detailsView.add_Listener_Update_Button(new Listener_DetailsView_WhenClick_Update());
        
        this.listView = new ListVatPhamView();
        this.listView.add_Listener_GetDetails_Button(new Listener_ListView_WhenClick_GetDetails());
        this.listView.add_Listener_GetList_Button(new Listener_ListView_WhenClick_GetList());
        
        this.searchByNameView = new SearchByNameVatPhamView();
        this.searchByNameView.add_Listener_Button_Search(new Listener_SearchByNameView_WhenClick_Search());
        this.searchByNameView.add_Listener_Button_GetDetails(new Listener_SearchByNameView_WhenClick_GetDetails());
        
        this.updateView = new UpdateVatPhamView();
        this.updateView.add_Listener_Button_Update(new Listener_Update_WhenClick_Update());
        this.updateView.add_Listener_Button_Cancel(new Listener_Update_WhenClick_Cancel());
    }

    @Override
    public void showMainView() {
        this.vatPhamView.showView();
    }

    @Override
    public void hideMainView() {
        this.vatPhamView.hideView();
    }
    
    /*
    
}
    
    
    
    */    
    
// 🟩🟩🟩🟩🟩 listener của VatPhamView
class Listener_VatPhamView_WhenClick_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        vatPhamView.hideView();
        createView.showView();
    }
}

class Listener_VatPhamView_WhenClick_GetList implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        vatPhamView.hideView();
        listView.showView();
    }

}

class Listener_VatPhamView_WhenClick_SearchByName implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        vatPhamView.hideView();
        searchByNameView.showView();
    }

}



// 🟩🟩🟩🟩🟩 listener của Create View  
class Listener_CreateView_WhenClick_Create  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        VatPham t = createView.getObjectFromView();
        t = vatPhamService.create(t);

        createView.deleteContent();
        detailsView.setObjectAndReload(t);

        // createView.hideView();
        detailsView.showView();

    }
}

class Listener_CreateView_WhenClick_Cancel  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createView.hideView();
        createView.deleteContent();

        vatPhamView.deleteContent();
        vatPhamView.showView();
    }
}

// 🟩🟩🟩🟩🟩 listener của Delete View
class Listener_DeleteView_WhenClick_Delete  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        VatPham t = deleteView.getObjectFromView();
        vatPhamService.delete(t.getId());
        deleteView.hideView();
        deleteView.deleteContent();

        // vatPhamView.deleteContent();
        // vatPhamView.showView();
    }
}

class Listener_DeleteView_WhenClick_Cancel  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        deleteView.hideView();
        deleteView.deleteContent();

        // vatPhamView.deleteContent();
        // vatPhamView.showView();
    }
}

// 🟩🟩🟩🟩🟩 listener của Details View
class Listener_DetailsView_WhenClick_Update implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        // detailsView.hideView();

        VatPham t = detailsView.getObjectFromView();
        t = vatPhamService.findById(t.getId());

        updateView.setObjectAndReload(t);
        updateView.showView();

    }
}

class Listener_DetailsView_WhenClick_Remove implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        // detailsView.hideView();

        VatPham t = detailsView.getObjectFromView();
        t = vatPhamService.findById(t.getId());

        deleteView.setObjectAndReload(t);
        deleteView.showView();
    }
}

// 🟩🟩🟩🟩🟩 listener của List View
class Listener_ListView_WhenClick_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        ListVatPhamViewParameter p = listView.getParameterFromView();
        List<VatPham> dsT = vatPhamService.getList(p.getSttPage(), p.getSizePage());
        listView.setListObjectAndReload(dsT);
    }
}

class Listener_ListView_WhenClick_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        VatPham t = listView.getChosenObject();
        t = vatPhamService.findById(t.getId());
        detailsView.deleteContent();
        detailsView.setObjectAndReload(t);
        detailsView.showView();
    }
}



// 🟩🟩🟩🟩🟩 listener của SearchByName View
class Listener_SearchByNameView_WhenClick_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        SearchByNameVatPhamViewParameter p = searchByNameView.getParameterFromView();
        
        List<VatPham> dsT = vatPhamService.findByName(p.getNameKeyword());
        
        searchByNameView.setListObjectAndReload(dsT);
    }

}

class Listener_SearchByNameView_WhenClick_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        VatPham t = searchByNameView.getChosenObject();
        
        detailsView.setObjectAndReload(t);
        detailsView.showView();
    }
}


// 🟩🟩🟩🟩🟩 listener của Update View
class Listener_Update_WhenClick_Update implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        VatPham t = updateView.getObjectFromView();
        
        t = vatPhamService.update(t.getId(), t);
        
        updateView.hideView();
        detailsView.setObjectAndReload(t);
        detailsView.showView();
    }

}

class Listener_Update_WhenClick_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        updateView.hideView();
        updateView.deleteContent();
        
        detailsView.showView();
    }

}


}
