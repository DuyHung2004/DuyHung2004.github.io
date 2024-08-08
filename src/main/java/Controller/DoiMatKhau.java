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
@WebServlet("/doimatkhau")

public class DoiMatKhau extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String matkhauhientai=request.getParameter("matkhauhientai");
        String matkhaumoi= request.getParameter("matkhaumoi");
        String matkhaunhaplai= request.getParameter("matkhaunhaplai");
        String matkhauhientaisha1= mahoa.toSHA1(matkhauhientai);
        String baoloi="";
        HttpSession session= request.getSession();
        Object o= session.getAttribute("khachHang");
        KhachHang khachHang= null;
        String url="";
        if (o!=null){
            khachHang= (KhachHang) o;
        }
        if (khachHang==null){
            baoloi+="ban chua dang nhap";
            url="/doimatkhau.jsp";
        }
        if (matkhaumoi.equals(matkhaunhaplai)==false){
            baoloi+="mat khau khong khop";
        }
        if(baoloi.length()>0){
            System.out.println(baoloi);
            url ="/doimatkhau.jsp";
        }
        else {
            if(!matkhauhientaisha1.equals(khachHang.getMatkhau())){
                baoloi+="mat khau hien tai khong chinh xac";
                url="/doimatkhau.jsp";
            } else{
                matkhaumoi= mahoa.toSHA1(matkhaumoi);
                khachHang.setMatkhau(matkhaumoi);
                KhachHangdal khachHangdal= new KhachHangdal();
                if(khachHangdal.changepassword(khachHang)){
                    baoloi="mat khau da thay doi";
                    url="/doimatkhau.jsp";
                }
            }
        }
        request.setAttribute("baoloi",baoloi);
        RequestDispatcher rq= getServletContext().getRequestDispatcher(url);
        rq.forward(request,response);
    }
}
