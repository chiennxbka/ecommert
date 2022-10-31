package com.example.ecommerce;

import java.io.*;
import java.util.List;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.util.HibernateXmlUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (Session session = HibernateXmlUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CartItem> criteriaQuery = builder.createQuery(CartItem.class);
            Root<CartItem> root = criteriaQuery.from(CartItem.class);
            criteriaQuery.select(root);
            List<CartItem> items = session.createQuery(criteriaQuery).getResultList();
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            for (CartItem item : items) {
                out.println("Cart item code: " + item.getProductCode() + " nam trong cart co ma khach hang la: " + item.getCart().getCustomerNumber());
                out.println("<br></br>");
            }
            out.println("</body></html>");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void destroy() {
    }
}