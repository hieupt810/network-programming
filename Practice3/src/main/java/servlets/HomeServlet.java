package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NhanVienBo;
import model.NhanVien;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final NhanVienBo nhanVienBo = new NhanVienBo();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> nhanVienList = nhanVienBo.getAll();

        request.setAttribute("nhanVienList", nhanVienList);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/nhanvien.jsp").forward(request, response);
    }
}
