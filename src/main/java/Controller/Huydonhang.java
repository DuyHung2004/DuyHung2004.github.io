package Controller;

import dal.DonHangGuestdal;
import dal.DonHangdal;
import dal.Productsdal;
import model.DonHang;
import model.DonHangGuest;
import model.KhachHang;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/huydonhang")
public class Huydonhang extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="";
        String madonhang= request.getParameter("madonhang");

        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        String baoloi="";
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null){
            baoloi+="ban chua dang nhap";
        }if (baoloi.length()>0){
            url="/chitietdonhang.jsp";
        } else {
            DonHangdal donHangdal= new DonHangdal();
            DonHang donHang= new DonHang(madonhang);
            try {
                DonHang donHang1= donHangdal.selectById(donHang);
                donHang1.setTrangthai("da huy");
                donHang1.setNgaygiaohang(null);
                donHangdal.update(donHang1);
                url="/chitietdonhang.jsp?madonhang="+madonhang;
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
        doGet(request, response);
    }
}
