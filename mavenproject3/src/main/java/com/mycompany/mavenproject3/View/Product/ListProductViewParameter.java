/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.View.Product;

/**
 *
 * @author azoom
 */
public class ListProductViewParameter {
    private Integer pageNum;
    private Integer sizePage;

    public ListProductViewParameter() {
    }

    public ListProductViewParameter(Integer sttPage, Integer sizePage) {
        this.pageNum = sttPage;
        this.sizePage = sizePage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSizePage() {
        return sizePage;
    }

    public void setSizePage(Integer sizePage) {
        this.sizePage = sizePage;
    }
    
    
}
