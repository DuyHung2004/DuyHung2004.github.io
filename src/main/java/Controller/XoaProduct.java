package Controller;

import dal.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/xoasanpham")
public class XoaProduct extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/quanlysanpham.jsp";
        String baoloi="";
        String id= request.getParameter("id");
        Productsdal productsdal= new Productsdal();
        Products products= productsdal.selectById(new Products(id));
        ChiTietDonHangdal chiTietDonHangdal= new ChiTietDonHangdal();
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null||!khachHang.getTendangnhap().equals("admin")){
            baoloi+="ban chua dang nhap";
        } if(baoloi.length()>0){
            System.out.println(baoloi);

        }else {
        try {
            ArrayList<ChiTietDonHang> chiTietDonHangs=chiTietDonHangdal.selectbyproduct(id);
            DonHangdal donHangdal= new DonHangdal();
            ArrayList<DonHang> donHangs= new ArrayList<DonHang>();
            for (ChiTietDonHang c: chiTietDonHangs){
                donHangs.add(c.getDonhang());
            }
            DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
            ArrayList<DonHangGuest> donHangGuests= donHangGuestdal.selectidproduct(id);
            for (ChiTietDonHang c: chiTietDonHangs){
                chiTietDonHangdal.delete(c);
            }
            for (DonHangGuest c: donHangGuests){
                donHangGuestdal.delete(c);
            }
            for (DonHang donHang: donHangs){
                donHangdal.delete(donHang);
            }
            productsdal.delete(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }}
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
