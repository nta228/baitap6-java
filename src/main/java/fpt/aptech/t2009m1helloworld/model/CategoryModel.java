package fpt.aptech.t2009m1helloworld.model;

import fpt.aptech.t2009m1helloworld.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean save(Category obj);
    boolean update(int id, Category updateObj);
    boolean delete(int id);
    List<Category> findAll();
    Category findById(int id);
}
