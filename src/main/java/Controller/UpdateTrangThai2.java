package Controller;

import dal.DonHangGuestdal;
import dal.DonHangdal;
import model.DonHang;
import model.DonHangGuest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateTrangThai2")
public class UpdateTrangThai2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/quanlydonhang.jsp";
        int donHangId = Integer.parseInt(request.getParameter("donHangId"));
        String trangthai = request.getParameter("trangthai");
        DonHangGuest donHangGuest= new DonHangGuest(donHangId);
        DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
        try {
            DonHangGuest donHang1= donHangGuestdal.selectById(donHangGuest);
            donHang1.setTrangthai(trangthai);
            donHangGuestdal.update(donHang1);
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
