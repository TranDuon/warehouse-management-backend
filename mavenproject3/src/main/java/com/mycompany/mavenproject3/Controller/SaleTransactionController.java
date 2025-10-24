/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotBan;

import com.mycompany.mavenproject3.ControllerAndView.Home.HomeController;
import com.mycompany.mavenproject3.ControllerAndView.Interface.ControllerInterface;
import com.mycompany.mavenproject3.ControllerAndView.VatPham.SearchByNameVatPhamViewParameter;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBan;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBanId;
import com.mycompany.mavenproject3.Db.DsspBan.DsspBanService;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBan;
import com.mycompany.mavenproject3.Db.MotLuotBan.MotLuotBanService;
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
public class MotLuotBanController 
        implements ControllerInterface
{
    // thuộc tính dùng chung
    private User user;
    private MotLuotBanService motLuotBanService;
    private DsspBanService dsspBanService;
    private VatPhamService vatPhamService;
    
    // view do controller này quản lý
    private CreateMotLuotBanView createMotLuotBanView;
    private MotLuotBanView motLuotBanView;
    private SearchAndAddVatPhamView searchAndAddVatPhamView;
    private ListMotLuotBanView listMotLuotBanView;
    private DetailsMotLuotBanView detailsMotLuotBanView;
    
    
    // constructor
    public MotLuotBanController(User user) {
        this.user = user;
        this.motLuotBanService = new MotLuotBanService();
        this.dsspBanService = new DsspBanService();
        this.vatPhamService = new VatPhamService();
        
        this.createMotLuotBanView = new CreateMotLuotBanView();
        this.createMotLuotBanView.add_Listener_Button_Add(new Listener_CreateMotLuotBanView_Button_Add());
        this.createMotLuotBanView.add_Listener_Button_Create(new Listener_CreateMotLuotBanView_Button_Create());
        this.createMotLuotBanView.add_Listener_Button_Cancel(new Listener_CreateMotLuotBanView_Button_Cancel());
        
        this.motLuotBanView = new MotLuotBanView();
        this.motLuotBanView.add_Listener_Button_Create(new Listener_MotLuotBanView_Button_Create());
        this.motLuotBanView.add_Listener_Button_GetList(new Listener_MotLuotBanView_Button_GetList());
        
        this.searchAndAddVatPhamView = new SearchAndAddVatPhamView();
        this.searchAndAddVatPhamView.add_Listener_Button_Add(new Listener_SearchAndAddVatPhamView_Button_Add());
        this.searchAndAddVatPhamView.add_Listener_Button_Search(new Listener_SearchAndAddVatPhamView_Button_Search());
        
        this.listMotLuotBanView = new ListMotLuotBanView();
        this.listMotLuotBanView.add_Listener_Button_Search(new Listener_ListMotLuotBanView_Button_Search());
        this.listMotLuotBanView.add_Listener_Button_GetDetails(new Listener_ListMotLuotBanView_Button_GetDetails());
        
        this.detailsMotLuotBanView = new DetailsMotLuotBanView();
        
                
    }
    
    @Override
    public void showMainView() {
        this.motLuotBanView.showView();
    }

    @Override
    public void hideMainView() {
        this.motLuotBanView.hideView();
    }
    
    public ArrayList<DsspBanHasNameProduct> convertDsspBan(ArrayList<DsspBan> dsT){
        
        ArrayList<DsspBanHasNameProduct> dsT2 = new ArrayList<>();
        
        for(DsspBan t : dsT){
            VatPham vp1 = this.vatPhamService.findById(t.getId().getVatPhamid());
            DsspBanHasNameProduct t2 = new DsspBanHasNameProduct(
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
        createMotLuotBanView.showView();
    }

}

class Listener_MotLuotBanView_Button_GetList implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        listMotLuotBanView.showView();
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
        List<VatPhamWithSoLuongDat> dsT = createMotLuotBanView.getListObjectFromView();
        User user1 = user;
        
        MotLuotBan motLuotBan = new MotLuotBan(
                null, 
                Timestamp.from(Instant.now()), 
                Boolean.TRUE, 
                user1.getId()
        );
        
        motLuotBan = motLuotBanService.create(motLuotBan);
        
        List<DsspBan> listDsspBan = new ArrayList<>();
        
        for(VatPhamWithSoLuongDat motVatPhamWithSoLuong : dsT){
            VatPham tempVatPham = vatPhamService.findById(motVatPhamWithSoLuong.getVatPham().getId());
            
            DsspBan tempDsspBan = new DsspBan(
                    new DsspBanId(
                            motVatPhamWithSoLuong.getVatPham().getId(),
                            motLuotBan.getId()
                    ),
                    motVatPhamWithSoLuong.getSoLuongDat(),
                    tempVatPham.getGia()
            );
            
            tempDsspBan= dsspBanService.create(tempDsspBan);
            listDsspBan.add(tempDsspBan);
            
            tempVatPham.setSoluong(tempVatPham.getSoluong()-motVatPhamWithSoLuong.getSoLuongDat());
            tempVatPham = vatPhamService.update(tempVatPham.getId(), tempVatPham);
        }
        
        createMotLuotBanView.deleteContent();
    }

}

class Listener_CreateMotLuotBanView_Button_Cancel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createMotLuotBanView.deleteContent();
        showMainView();
        createMotLuotBanView.hideView();
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

    public Boolean isContain(List<VatPhamWithSoLuongDat> dsT, VatPham vatPham){
        for(VatPhamWithSoLuongDat t : dsT){
            if(t.getVatPham().getId()==vatPham.getId()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<VatPhamWithSoLuongDat> dsT = createMotLuotBanView.getListObjectFromView();
        
        VatPham vatPham = searchAndAddVatPhamView.getChosenObject();
        
        if(isContain(dsT, vatPham)==false ){
            dsT.add(
                    new VatPhamWithSoLuongDat(vatPham, 1)
            );

            createMotLuotBanView.setListObjectAndReload(dsT);
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
        ListMotLuotBanViewParameter p = listMotLuotBanView.getParameterFromView();
        
        List<MotLuotBan> dsT = motLuotBanService.findByTime(p.getDateTimeFrom_Timestamp(), p.getDateTimeTo_Timestamp());
        
        listMotLuotBanView.setListObjectAndReload(dsT);
    }

}

class Listener_ListMotLuotBanView_Button_GetDetails implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MotLuotBan t= listMotLuotBanView.getChosenObject();
        
        detailsMotLuotBanView.deleteContent();
        
        detailsMotLuotBanView.setObjectAndReload(t);

        ArrayList<DsspBan> dsT = (ArrayList<DsspBan>) dsspBanService.findByMotLuotBanId(t.getId());
        ArrayList<DsspBanHasNameProduct> dsT2 = convertDsspBan(dsT);
        detailsMotLuotBanView.setListObjectAndReload(dsT2);
        
        detailsMotLuotBanView.showView();
    }

}


}

