package fpt.aptech.t2009m1helloworld.model.seeder;

import fpt.aptech.t2009m1helloworld.model.CategoryModel;
import fpt.aptech.t2009m1helloworld.model.MySqlCategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        this.categoryModel = new MySqlCategoryModel();
    }

    public void seedData() {
    }
}
