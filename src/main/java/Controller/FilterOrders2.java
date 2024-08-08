package Controller;

import dal.DonHangGuestdal;
import dal.DonHangdal;
import model.DonHang;
import model.DonHangGuest;
import model.KhachHang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/filterOrders2")
public class FilterOrders2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String baoloi="";
        String url="/quanlydonhang.jsp";
        ArrayList<DonHang> donHangs = null;
        ArrayList<DonHangGuest> donHangGuests= null;
        DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        String date1= request.getParameter("fromDate");
        String date2= request.getParameter("toDate");
        String makhachhang= request.getParameter("makhachhang");
        System.out.println(date1+date2+makhachhang);
        if (date1.equals("")||date2.equals("")){
            DonHangdal donHangdal = new DonHangdal();
            if (makhachhang.equals("")) {
                donHangs = null;
                System.out.println("a");
            }
            else {
                try {
                    System.out.println("b");
                    donHangGuests=donHangGuestdal.selectAll();
                    donHangs=donHangdal.selectidkhachhang(makhachhang);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
        LocalDate fromDate1 = LocalDate.parse(date1);
        LocalDate toDate2= LocalDate.parse(date2);
        if (fromDate1.isAfter(toDate2)){
            baoloi="Loi Ngay Thang";
        }else{
        Date fromDate= Date.valueOf(fromDate1);
        Date toDate= Date.valueOf(toDate2);
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null||!khachHang.getTendangnhap().equals("admin")){
            baoloi+="ban chua dang nhap";
        }
        if (baoloi.length()>0){
            url="/quanlydonhang.jsp";
        }else {DonHangdal donHangdal= new DonHangdal();
            if (makhachhang.equals("")){
                try {
                    System.out.println("c");
                     donHangGuests= donHangGuestdal.selectdate(fromDate,toDate);
                    donHangs= donHangdal.selectdatequanly(fromDate,toDate);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    System.out.println("d");
                    donHangGuests=donHangGuestdal.selectAll();
                    donHangs=donHangdal.selectdatequanly(fromDate,toDate);
                    donHangs.addAll(donHangdal.selectidkhachhang(makhachhang));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }}}
        request.setAttribute("donHangGuests",donHangGuests);
        request.setAttribute("donhangs",donHangs);
        request.setAttribute("baoloi",baoloi);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doGet(request,response);
    }
}
