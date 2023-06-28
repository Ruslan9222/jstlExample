package by.radevich.jstlexample.servlet;

import by.radevich.jstlexample.model.Product;
import by.radevich.jstlexample.service.ProductService;
import by.radevich.jstlexample.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductServiceImpl();
    }


    @Override
    //findAll, findByID, delete
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var findParam = req.getParameter("find");
        var deletParam = req.getParameter("delete");
        //localhost:8080/products?find=1
        //localhost:8080/products?delete=1
        //localhost:8080/products
        if(isPresent(findParam)){
            req.setAttribute("product", service.findById(findParam));
            req.getRequestDispatcher("product.jsp").forward(req,resp);
        }else if(isPresent(deletParam)){
            service.delete(deletParam);
            System.out.println("All products: " + service.fiendAll());
            req.getRequestDispatcher("Success.jsp").forward(req, resp);
        } else {
            System.out.println("All products: " + service.fiendAll());
            req.getRequestDispatcher("Success.jsp").forward(req, resp);
        }

    }
    //    @Override
//    //findAll, findByID, delete
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Product first = new Product();
//        first.setName("apples");
//        first.setPrice(25);
//
//        Product second = new Product();
//        second.setName("bananas");
//        second.setPrice(30);
//
//        service.save(first);
//        System.out.println("First: " + service.findById(first.getId()));
//        service.save(second);
//        System.out.println("All products: " + service.fiendAll());
//
//        second.setPrice(50);
//        second.setName("pipipi");
//        service.save(second);
//        System.out.println("All products: " + service.fiendAll());
//        service.delete(first.getId());
//        System.out.println("All products: " + service.fiendAll());
//        req.getRequestDispatcher("Success.jsp").forward(req, resp);
//    }

    @Override
    //create, update
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = getProductFromRequest(req);
        service.save(product);
        System.out.println("All products: " + service.fiendAll());
        req.getRequestDispatcher("Success.jsp").forward(req, resp);
    }

    private Product getProductFromRequest(HttpServletRequest req) {
        var id = req.getParameter("id");
        var name = req.getParameter("name");
        var price = req.getParameter("price");
        Product product = new Product();
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        if (isPresent(id)) {
            product.setId(id);
        }
        return product;
    }

    private boolean isPresent(String id) {
        return id != null && id.isEmpty();
    }
}
