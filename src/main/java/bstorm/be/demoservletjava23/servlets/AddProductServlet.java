package bstorm.be.demoservletjava23.servlets;

import bstorm.be.demoservletjava23.domain.dtos.ProductDTO;
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
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> product = productService.getMany()
                .stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());

        request.setAttribute("product", product);
        request.getRequestDispatcher("WEB-INF/pages/product.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}