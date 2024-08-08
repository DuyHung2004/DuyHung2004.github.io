package Controller;

import dal.KhachHangdal;
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

@WebServlet("/thaydoithongtin")

public class ThayDoiThongTin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="";
        String baoloi="";
        String hoten= request.getParameter("hoten")+"";
        String diachi= request.getParameter("diachi")+"";
        Date ngaysinh= Date.valueOf(request.getParameter("ngaysinh"));
        String sodienthoai= request.getParameter("sodienthoai")+"";
        String gioitinh= request.getParameter("gioitinh");
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null){
            baoloi+="ban chua dang nhap";
        } if(baoloi.length()>0){
            System.out.println(baoloi);
            url ="/thaydoithongtin.jsp";
        }else {
            System.out.println("aaa"+ khachHang);
            khachHang.setHoten(hoten);
            khachHang.setDiachi(diachi);
            khachHang.setNgaysinh(ngaysinh);
            khachHang.setSodienthoai(sodienthoai);
            khachHang.setGioitinh(gioitinh);
            KhachHangdal khachHangdal= new KhachHangdal();
            khachHangdal.update(khachHang);
            baoloi= "thong tin da thay doi";
            url= "/thaydoithongtin.jsp";
        }
        request.setAttribute("baoloi",baoloi);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}
