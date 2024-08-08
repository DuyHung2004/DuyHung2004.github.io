package Controller;

import dal.Productsdal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/upload")
@MultipartConfig
public class UpLoad extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        filePart.write(uploadPath + File.separator + fileName);

        String filePath = "images" + File.separator + fileName;

        Productsdal productsdal = new Productsdal();
        String idproduct = request.getParameter("idproduct");
        try {
            int ketqua = productsdal.updateimage(filePath, idproduct);
            if (ketqua > 0) {
                response.sendRedirect("editsanpham.jsp?id=" + idproduct);
            } else {
                response.getWriter().println("Cập nhật ảnh thất bại.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Có lỗi xảy ra: " + e.getMessage());
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1).replace("\"", "");
            }
        }
        return "";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
