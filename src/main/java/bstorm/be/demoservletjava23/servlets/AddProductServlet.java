package bstorm.be.demoservletjava23.servlets;

import bstorm.be.demoservletjava23.domain.dtos.ProductDTO;
import bstorm.be.demoservletjava23.domain.entities.Product;
import bstorm.be.demoservletjava23.domain.forms.ProductForm;
import bstorm.be.demoservletjava23.domain.forms.TypeForm;
import bstorm.be.demoservletjava23.services.ProductService;
import bstorm.be.demoservletjava23.services.ProductServiceImpl;
import bstorm.be.demoservletjava23.services.TypeService;
import bstorm.be.demoservletjava23.services.TypeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {

    TypeService typeService = new TypeServiceImpl();
    ProductService productService = new ProductServiceImpl();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getMany();

        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductForm productForm;
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        Integer productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        if (request.getParameter("wantToAddType") != null) {
            String typeName = request.getParameter("typeName");
            TypeForm typeForm = new TypeForm(typeName);
            productForm = new ProductForm(productName, productDescription,productQuantity, typeForm);
        } else {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            productForm = new ProductForm(productName, productDescription, productQuantity, typeId);
        }
        try {
            productService.add(productForm.toEntity());
            response.sendRedirect(request.getContextPath() + "/product");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("WEB-INF/pages/productForm.jsp").forward(request, response);
        }


    }

}