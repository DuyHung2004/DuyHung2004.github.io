package Controller;

import dal.DonHangGuestdal;
import dal.Productsdal;
import model.DonHangGuest;
import model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/muaHang")

public class DatHang extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url="/dathangthanhcong.jsp";
        String id=  request.getParameter("id")+"";
        System.out.println(id);
        String diachinhanhang= request.getParameter("diachinhanhang");
        String hovaten= request.getParameter("hovaten");
        String sodienthoai= request.getParameter("sodienthoai");
        int soluong= Integer.parseInt(request.getParameter("soluong"));
        String hinhthucthanhtoan= request.getParameter("hinhthucthanhtoan");
        LocalDate date= LocalDate.now();
        Date ngaydathang= Date.valueOf(date);
        LocalDate date1= date.plusDays(4);
        Date ngaygiaohang= Date.valueOf(date1);
        Productsdal productsdal= new Productsdal();
        Products products= productsdal.selectById(new Products(id));
        double sotien=soluong*products.getPrice();
        DonHangGuest donHangGuest= new DonHangGuest(products,hovaten,diachinhanhang,sodienthoai,soluong,hinhthucthanhtoan,"xet duyet",sotien,ngaydathang,ngaygiaohang);
        System.out.println(products);
        DonHangGuestdal donHangGuestdal= new DonHangGuestdal();
        try {
            donHangGuestdal.insert(donHangGuest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
