/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.Db.Product.Service;

import com.mycompany.mavenproject3.Db.Product.Repository.ProductRepo;
import com.mycompany.mavenproject3.Db.Product.Entity.Product;
import java.util.List;


import com.mycompany.mavenproject3.Db.Interface.ServiceInterface;

/**
 *
 * @author azoom
 */
public class ProductService 
        implements ServiceInterface<Product, Long>
{
    private ProductRepo vatPhamRepo;

    public ProductService() {
        this.vatPhamRepo = new ProductRepo();
    }
    
    

    @Override
    public Product findById(Long id) {
        return this.vatPhamRepo.findById(id);
    }

    @Override
    public List<Product> getList(Integer sttPage, Integer sizePage) {
        return this.vatPhamRepo.getList(sttPage, sizePage);
    }
    @Override

    public Product create(Product t) {
        return this.vatPhamRepo.create(t);
    }

    @Override
    public Product update(Long id, Product t) {
        return this.vatPhamRepo.update(id, t);
    }

    @Override
    public Boolean delete(Long id) {
        return this.vatPhamRepo.delete(id);
    }
    
    public List<Product> findByName(String name){
        return this.vatPhamRepo.findByName(name);
    }
    
    
}
