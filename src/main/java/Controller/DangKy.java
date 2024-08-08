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
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

@WebServlet("/dangky")
public class DangKy extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="";
        String tendangnhap= request.getParameter("tendangnhap");
        String matkhau= request.getParameter("matkhau");
        String matkhaunhaplai= request.getParameter("matkhaunhaplai");
        String hovaten= request.getParameter("hovaten");
        String gioitinh= request.getParameter("gioitinh");
        Date ngaysinh= Date.valueOf(request.getParameter("ngaysinh"));
        String diachi= request.getParameter("diachi");
        String sodienthoai= request.getParameter("sodienthoai");
        String email= request.getParameter("email");
        String baoloi="";
        request.setAttribute("tendangnhap",tendangnhap);
        request.setAttribute("hovaten",hovaten);
        request.setAttribute("gioitinh",gioitinh);
        request.setAttribute("ngaysinh",ngaysinh);
        request.setAttribute("diachi",diachi);
        request.setAttribute("sodienthoai",sodienthoai);
        request.setAttribute("email",email);
        KhachHangdal khachHangdal= new KhachHangdal();
        if (khachHangdal.kiemtratendangnhap(tendangnhap)==true) {
            baoloi += "ten dang nhap da ton tai <br/>";
        }
        if (!matkhau.equals(matkhaunhaplai)){
            baoloi+="mat khau khong khop";
        }
        if(baoloi.length()>0){
            System.out.println(baoloi);
            url ="/dangky.jsp";
        } else {
            Random random= new Random();
            String makhachhang= System.currentTimeMillis()+random.nextInt(1000)+"";
            System.out.println(makhachhang);
            matkhau= mahoa.toSHA1(matkhau);
            KhachHang khachHang= new KhachHang(makhachhang,tendangnhap,matkhau,hovaten,gioitinh,diachi,ngaysinh,sodienthoai,email);

            khachHangdal.insert(khachHang);
            url="/thanhcong.jsp";
        }
        request.setAttribute("baoloi",baoloi);
        RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}