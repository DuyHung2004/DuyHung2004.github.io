package Controller;

import dal.DonHangdal;
import dal.KhachHangdal;
import model.DonHang;
import model.KhachHang;
import util.mahoa;

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

@WebServlet("/filterOrders")
public class FilterOrders extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String baoloi="";
        String url="";
        ArrayList<DonHang> donHangs = null;
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;

        String date1= request.getParameter("fromDate");
        String date2= request.getParameter("toDate");
        if (date1.equals("")||date2.equals("")){
            DonHangdal donHangdal= new DonHangdal();
            url="/donhang.jsp";
            donHangs= null;
        }else {
        LocalDate fromDate1 = LocalDate.parse(date1);
        LocalDate toDate2= LocalDate.parse(date2);
        Date fromDate= Date.valueOf(fromDate1);
        Date toDate= Date.valueOf(toDate2);
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null){
            baoloi+="ban chua dang nhap";
            url="/donhang.jsp";
        }
        if (baoloi.length()>0){
            url="/donhang.jsp";
        }else {
            DonHangdal donHangdal= new DonHangdal();
            try {
                 donHangs= donHangdal.selectdate(khachHang.getMakhachhang(),fromDate,toDate);
                 url="/donhang.jsp";
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }}
        request.setAttribute("donhangs",donHangs);
        request.setAttribute("baoloi",baoloi);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doGet(request,response);
    }
}
