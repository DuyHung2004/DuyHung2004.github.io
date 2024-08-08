package Controller;

import dal.Categoriesdal;
import dal.Productsdal;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/xulytimkiem")
public class XuLyTimKiem extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/index.jsp";
        String timkiem= request.getParameter("timkiem");
        if (timkiem.equals("")){
            System.out.println("a");
        }else {
            System.out.println("b");
        Productsdal productsdal= new Productsdal();
        ArrayList<Products> products= productsdal.selectAll();
        ArrayList<Products> products1= new ArrayList<Products>();
        for (Products product: products){
            if (product.getName().indexOf(timkiem)!=-1){
                System.out.println("c");
                products1.add(product);
            }
        }
        request.setAttribute("products1",products1);}
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
