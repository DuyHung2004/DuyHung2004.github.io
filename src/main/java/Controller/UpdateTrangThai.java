package Controller;

import dal.DonHangGuestdal;
import dal.DonHangdal;
import dal.Productsdal;
import model.DonHang;
import model.DonHangGuest;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/updateTrangThai")
public class UpdateTrangThai extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/quanlydonhang.jsp";
        String donHangId = request.getParameter("donHangId");
        String trangthai = request.getParameter("trangthai");
        DonHangdal donHangdal= new DonHangdal();
        DonHang donHang= new DonHang(donHangId);
        try {
            DonHang donHang1= donHangdal.selectById(donHang);
            donHang1.setTrangthai(trangthai);
            donHangdal.update(donHang1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
