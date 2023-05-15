package bstorm.be.demoservletjava23.servlets;

import bstorm.be.demoservletjava23.services.ProductService;
import bstorm.be.demoservletjava23.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteProduct", urlPatterns = "/deleteProduct")

public class DeleteProductServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            productService.delete(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/product");
    }

}