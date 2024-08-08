package Controller;

import dal.ChiTietDonHangdal;
import dal.DonHangdal;
import dal.KhachHangdal;
import dal.Productsdal;
import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.Products;
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
import java.util.Random;

@WebServlet("/muaHang2")

public class DatHang2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url ="";
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        int soluong= Integer.parseInt(request.getParameter("soluong"));
        String hinhthucthanhtoan= request.getParameter("hinhthucthanhtoan");
        String diachinhanhang= request.getParameter("diachinhanhang");
        KhachHang khachHang= null;
        String id= request.getParameter("id")+"";
        System.out.println(id);
        Productsdal productsdal= new Productsdal();
        Products products1= new Products(id);
        Products products= productsdal.selectById(products1);
        System.out.println(products);
        String baoloi="";
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null){
            baoloi+="ban chua dang nhap";
        }
        if(baoloi.length()>0){
            System.out.println(baoloi);
            url ="/index.jsp";
        }
        else {
            Random random= new Random();
            String madonhang= System.currentTimeMillis()+random.nextInt(10000)+"";;
            String trangthai= "xetduyet";
            double sotienthanhtoan= products.getPrice()*soluong;
            LocalDate date= LocalDate.now();
            Date ngaydathang= Date.valueOf(date);
            LocalDate date1= date.plusDays(4);
            Date ngaygiaohang= Date.valueOf(date1);
            DonHang donHang= new DonHang(madonhang,khachHang,trangthai,hinhthucthanhtoan,sotienthanhtoan,ngaydathang,ngaygiaohang);
            DonHangdal donHangdal= new DonHangdal();
            try {
                donHangdal.insert(donHang);
            String machitietdonhang= System.currentTimeMillis()+random.nextInt(20000)+"";
                ChiTietDonHang chiTietDonHang= new ChiTietDonHang(machitietdonhang,donHang,products,soluong, products.getPrice(), sotienthanhtoan, diachinhanhang);
                ChiTietDonHangdal chiTietDonHangdal= new ChiTietDonHangdal();
                chiTietDonHangdal.insert(chiTietDonHang);
                url="/dathangthanhcong.jsp";
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}
