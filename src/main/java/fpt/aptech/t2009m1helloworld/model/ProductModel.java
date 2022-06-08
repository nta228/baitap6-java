package fpt.aptech.t2009m1helloworld.model;

import fpt.aptech.t2009m1helloworld.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product obj);
    boolean update(int id, Product updateObj);
    boolean delete(int id);
    List<Product> findAll();
    Product findById(int id);
    Product findByProductName(String productName);
}
