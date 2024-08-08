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

@WebServlet("/xoahangmuc")
public class XoaCategori extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/quanlyhangmuc.jsp";
        String baoloi="";
       int  id = Integer.parseInt(request.getParameter("id"));
       Productsdal productsdal = new Productsdal();
       Categoriesdal categoriesdal = new Categoriesdal();
        Categories categories= categoriesdal.selectById(new Categories(id));
       ArrayList<Products> products= productsdal.selectcid(id);
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
       for (Products products1: products){
           ChiTietDonHangdal chiTietDonHangdal= new ChiTietDonHangdal();
           try {
               ArrayList<ChiTietDonHang> chiTietDonHangs=chiTietDonHangdal.selectbyproduct(products1.getId());
               DonHangdal donHangdal= new DonHangdal();
               ArrayList<DonHang> donHangs= new ArrayList<DonHang>();
               for (ChiTietDonHang c: chiTietDonHangs){
                   donHangs.add(c.getDonhang());
               }
               DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
               ArrayList<DonHangGuest> donHangGuests= donHangGuestdal.selectidproduct(products1.getId());
               for (ChiTietDonHang c: chiTietDonHangs){
                   chiTietDonHangdal.delete(c);
               }
               for (DonHangGuest c: donHangGuests){
                   donHangGuestdal.delete(c);
               }
               for (DonHang donHang: donHangs){
                   donHangdal.delete(donHang);
               }
               productsdal.delete(products1);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
       }}
       categoriesdal.delete(categories);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
