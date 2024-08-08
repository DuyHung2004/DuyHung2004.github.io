package Controller;

import dal.DonHangGuestdal;
import dal.KhachHangdal;
import dal.Productsdal;
import model.DonHangGuest;
import model.KhachHang;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/xulytrangthai")

public class XuLyTrangThai extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/quanlynguoidung.jsp";
        String makhachhang= request.getParameter("makhachhang");
        KhachHang khachHang= new KhachHang(makhachhang);
        KhachHangdal khachHangdal= new KhachHangdal();
        KhachHang khachHang1= khachHangdal.selectById(khachHang);
        if (khachHang1.isTrangthaixacthuc()){
            khachHang1.setTrangthaixacthuc(false);
        } else {
            khachHang1.setTrangthaixacthuc(true);
        }
        khachHangdal.update(khachHang1);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
