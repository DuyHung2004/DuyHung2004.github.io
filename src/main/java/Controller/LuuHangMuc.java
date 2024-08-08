package Controller;

import dal.Categoriesdal;
import dal.Productsdal;
import model.Categories;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/luuhangmuc")
public class LuuHangMuc extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/edithangmuc.jsp";
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String descrip= request.getParameter("descrip");
        Categoriesdal categoriesdal= new Categoriesdal();
        Categories categories= categoriesdal.selectById(new Categories(id));
        categories.setName(name);
        categories.setDescription(descrip);
        categoriesdal.update(categories);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
