package Controller;

import dal.DonHangGuestdal;
import dal.KhachHangdal;
import dal.Productsdal;
import model.DonHangGuest;
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
import java.sql.SQLException;

@WebServlet("/xulydangnhap")
public class DangNhap extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="";
        String tendangnhap= request.getParameter("tendangnhap");
        String matkhau= request.getParameter("matkhau");
        matkhau= mahoa.toSHA1(matkhau);
        KhachHang khachHang= new KhachHang();
        khachHang.setTendangnhap(tendangnhap);
        khachHang.setMatkhau(matkhau);
        KhachHangdal khachHangdal= new KhachHangdal();
        khachHang= khachHangdal.selectdangnhap(khachHang);
        System.out.println(khachHang);

        if(khachHang!=null){
            if (khachHang.getTendangnhap().equals("admin")){
                HttpSession session= request.getSession();
                session.setAttribute("khachHang",khachHang);
                url="/admin.jsp";
            }else {
                KhachHangdal khachHangdal1= new KhachHangdal();
               KhachHang KhachHang1 = khachHangdal1.selectBytendangnhap(tendangnhap);
                if (KhachHang1.isTrangthaixacthuc() == false) {
                    request.setAttribute("baoloi","tai khoan cua ban da bi khoa");
                    url = "/dangnhap.jsp";
                } else {
                    HttpSession session= request.getSession();
                    session.setAttribute("khachHang",khachHang);
                    url = "/index.jsp";
                }
            }
        } else {
            request.setAttribute("baoloi","ten dang nhap hoac mat khau chua chinh xac");
            url="/dangnhap.jsp";
        }
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
}
