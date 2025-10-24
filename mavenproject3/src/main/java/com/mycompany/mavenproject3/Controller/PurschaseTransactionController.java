/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotNhap;

import com.mycompany.mavenproject3.ControllerAndView.Home.HomeController;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ControllerInterface;
import com.mycompany.mavenproject3.ControllerAndView.VatPham.SearchByNameVatPhamViewParameter;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBan;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBanId;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBanService;
import com.mycompany.mavenproject3.Db.DsspNhap.DsspNhap;
import com.mycompany.mavenproject3.Db.DsspNhap.DsspNhapId;
import com.mycompany.mavenproject3.Db.DsspNhap.DsspNhapService;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBan;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBanService;
import com.mycompany.mavenproject3.Db.MotLuotNhap.MotLuotNhap;
import com.mycompany.mavenproject3.Db.MotLuotNhap.MotLuotNhapService;
import com.mycompany.mavenproject3.Db.User.User;
import com.mycompany.mavenproject3.Db.VatPham.VatPham;
import com.mycompany.mavenproject3.Db.VatPham.VatPhamService;
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
public class MotLuotNhapController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private MotLuotNhapService motLuotNhapService;
    private DsspNhapService dsspNhapService;
    private VatPhamService vatPhamService;
    
    // view do controller này quản lý
    private CreateMotLuotNhapView createMotLuotNhapView;
    private MotLuotNhapView motLuotNhapView;
    private SearchAndAddVatPhamView searchAndAddVatPhamView;
    private ListMotLuotNhapView listMotLuotNhapView;
    private DetailsMotLuotNhapView detailsMotLuotNhapView;
    
    
    // constructor
    public MotLuotNhapController(User user) {
        this.user = user;
        this.motLuotNhapService = new MotLuotNhapService();
        this.dsspNhapService = new DsspNhapService();
        this.vatPhamService = new VatPhamService();
        
        this.createMotLuotNhapView = new CreateMotLuotNhapView();
        this.createMotLuotNhapView.add_Listener_Button_Add(new Listener_CreateMotLuotBanView_Button_Add());
        this.createMotLuotNhapView.add_Listener_Button_Create(new Listener_CreateMotLuotBanView_Button_Create());
        this.createMotLuotNhapView.add_Listener_Button_Cancel(new Listener_CreateMotLuotBanView_Button_Cancel());
        
        this.motLuotNhapView = new MotLuotNhapView();
        this.motLuotNhapView.add_Listener_Button_Create(new Listener_MotLuotBanView_Button_Create());
        this.motLuotNhapView.add_Listener_Button_GetList(new Listener_MotLuotBanView_Button_GetList());
        
        this.searchAndAddVatPhamView = new SearchAndAddVatPhamView();
        this.searchAndAddVatPhamView.add_Listener_Button_Add(new Listener_SearchAndAddVatPhamView_Button_Add());
        this.searchAndAddVatPhamView.add_Listener_Button_Search(new Listener_SearchAndAddVatPhamView_Button_Search());
        
        this.listMotLuotNhapView = new ListMotLuotNhapView();
        this.listMotLuotNhapView.add_Listener_Button_Search(new Listener_ListMotLuotBanView_Button_Search());
        this.listMotLuotNhapView.add_Listener_Button_GetDetails(new Listener_ListMotLuotBanView_Button_GetDetails());
        
        this.detailsMotLuotNhapView = new DetailsMotLuotNhapView();
        
                
    }
    
    @Override
    public void showMainView() {
        this.motLuotNhapView.showView();
    }

    @Override
    public void hideMainView() {
        this.motLuotNhapView.hideView();
    }
    
    public ArrayList<DsspNhapHasNameProduct> convertDsspNhap(ArrayList<DsspNhap> dsT){
        
        ArrayList<DsspNhapHasNameProduct> dsT2 = new ArrayList<>();
        
        for(DsspNhap t : dsT){
            VatPham vp1 = this.vatPhamService.findById(t.getId().getVatPhamid());
            DsspNhapHasNameProduct t2 = new DsspNhapHasNameProduct(
                    t, 
                    vp1.getTen()
            );
            dsT2.add(t2);
        }
        return dsT2;
    }
    
    /*
    
}




*/
// At this view
class Listener_MotLuotBanView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createMotLuotNhapView.showView();
    }

}

class Listener_MotLuotBanView_Button_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        listMotLuotNhapView.showView();
    }

}

// at CreateMotLuotBanView
class Listener_CreateMotLuotBanView_Button_Add implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        searchAndAddVatPhamView.showView();
    }

}

class Listener_CreateMotLuotBanView_Button_Create implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<VatPhamWithSoLuongNhap> dsT = createMotLuotNhapView.getListObjectFromView();
        User user1 = user;
        
        MotLuotNhap motLuotNhap = new MotLuotNhap(
                null, 
                Timestamp.from(Instant.now()), 
                Boolean.TRUE, 
                user1.getId()
        );
        
        motLuotNhap = motLuotNhapService.create(motLuotNhap);
        
        List<DsspNhap> listDsspNhap = new ArrayList<>();
        
        for(VatPhamWithSoLuongNhap motVatPhamWithSoLuong : dsT){
            VatPham tempVatPham = vatPhamService.findById(motVatPhamWithSoLuong.getVatPham().getId());
            
            DsspNhap tempDsspNhap = new DsspNhap(
                    new DsspNhapId(
                            motVatPhamWithSoLuong.getVatPham().getId(),
                            motLuotNhap.getId()
                    ),
                    motVatPhamWithSoLuong.getSoLuongNhap(),
                    tempVatPham.getGia()
            );
            
            tempDsspNhap= dsspNhapService.create(tempDsspNhap);
            listDsspNhap.add(tempDsspNhap);
            
            tempVatPham.setSoluong(tempVatPham.getSoluong()+motVatPhamWithSoLuong.getSoLuongNhap());
            tempVatPham = vatPhamService.update(tempVatPham.getId(), tempVatPham);
        }
        
        createMotLuotNhapView.deleteContent();
    }

}

class Listener_CreateMotLuotBanView_Button_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createMotLuotNhapView.deleteContent();
        showMainView();
        createMotLuotNhapView.hideView();
    }
    
}


// at searchAndAddView
class Listener_SearchAndAddVatPhamView_Button_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchByNameVatPhamViewParameter t = searchAndAddVatPhamView.getParameterFromView();
        
        List<VatPham> listVp1 = vatPhamService.findByName(t.getNameKeyword());
        
        searchAndAddVatPhamView.setListObjectAndReload(listVp1);
    }

}

class Listener_SearchAndAddVatPhamView_Button_Add implements ActionListener {

    public Boolean isContain(List<VatPhamWithSoLuongNhap> dsT, VatPham vatPham){
        for(VatPhamWithSoLuongNhap t : dsT){
            if(t.getVatPham().getId()==vatPham.getId()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<VatPhamWithSoLuongNhap> dsT = createMotLuotNhapView.getListObjectFromView();
        
        VatPham vatPham = searchAndAddVatPhamView.getChosenObject();
        
        if(isContain(dsT, vatPham)==false ){
            dsT.add(
                    new VatPhamWithSoLuongNhap(vatPham , 1)
            );
            createMotLuotNhapView.setListObjectAndReload(dsT);
        }
        else{
            // doesnt do
        }
    }

}

// at list MotLuotBanView
class Listener_ListMotLuotBanView_Button_Search implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ListMotLuotNhapViewParameter p = listMotLuotNhapView.getParameterFromView();
        
        List<MotLuotNhap> dsT = motLuotNhapService.findByTime(p.getDateTimeFrom_Timestamp(), p.getDateTimeTo_Timestamp());
        
        listMotLuotNhapView.setListObjectAndReload(dsT);
    }

}

class Listener_ListMotLuotBanView_Button_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MotLuotNhap t= listMotLuotNhapView.getChosenObject();
        
        detailsMotLuotNhapView.deleteContent();
        
        detailsMotLuotNhapView.setObjectAndReload(t);

        ArrayList<DsspNhap> dsT = (ArrayList<DsspNhap>) dsspNhapService.findByMotLuotNhapId(t.getId());
        ArrayList<DsspNhapHasNameProduct> dsT2 = convertDsspNhap(dsT);
        detailsMotLuotNhapView.setListObjectAndReload(dsT2);
        
        detailsMotLuotNhapView.showView();
    }

}


}

