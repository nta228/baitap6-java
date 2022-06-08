package fpt.aptech.t2009m1helloworld.controller.admin.category;

import fpt.aptech.t2009m1helloworld.entity.Category;
import fpt.aptech.t2009m1helloworld.model.CategoryModel;
import fpt.aptech.t2009m1helloworld.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public CreateCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = this.categoryModel.findAll();
        req.setAttribute("categories",categories);
        req.setAttribute("action",1);
        req.getRequestDispatcher("/admin/categories/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            // lấy giá trị từ form gửi lên.
            String name = req.getParameter("name");
//            int status = Integer.parseInt(req.getParameter("status"));
            // Khởi tạo đối tượng account từ thông tin truyền lên.
            Category category = Category.CategoryBuilder.aCategory()
                    .withName(name)
//                    .withStatus(CategoryStatus.of(status))
                    .build();
            if(category.isValid()){
                boolean result = categoryModel.save(category);
                if (result) {
                    resp.sendRedirect("/admin/categories/list");
                } else {
                    throw new Exception("Can't save category");
                }
            } else {
                req.setAttribute("action", 1);
                req.setAttribute("errors", category.getErrors());
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("categories", category);
                req.getRequestDispatcher("/admin/categories/form.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }
    }
}
