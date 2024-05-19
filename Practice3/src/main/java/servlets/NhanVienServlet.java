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

@WebServlet("/nhanVien")
public class NhanVienServlet extends HttpServlet {
    private final NhanVienBo nhanVienBo = new NhanVienBo();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteNhanVien(request, response);
                    break;
                default:
                    showNhanVienList(request, response);
            }
        } else {
            showNhanVienList(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addNhanVien(request, response);
                    break;
                case "edit":
                    updateNhanVien(request, response);
                    break;
                default:
                    showNhanVienList(request, response);
            }
        } else {
            showNhanVienList(request, response);
        }
    }

    private void showNhanVienList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NhanVien> nhanVienList = nhanVienBo.getAll();
        request.setAttribute("nhanVienList", nhanVienList);
        request.getRequestDispatcher("/nhanVienList.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/addNhanVienForm.jsp").forward(request, response);
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");

        NhanVien newNhanVien = new NhanVien();
        newNhanVien.setHoten(hoTen);
        newNhanVien.setDiachi(diaChi);

        nhanVienBo.add(newNhanVien);

        response.sendRedirect(request.getContextPath() + "/nhanVien");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        NhanVien nhanVien = nhanVienBo.getById(id);

        request.setAttribute("nhanVien", nhanVien);
        request.getRequestDispatcher("/editNhanVienForm.jsp").forward(request, response);
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");

        NhanVien existingNhanVien = nhanVienBo.getById(id);

        existingNhanVien.setHoten(hoTen);
        existingNhanVien.setDiachi(diaChi);

        nhanVienBo.edit(existingNhanVien, id);

        response.sendRedirect(request.getContextPath() + "/nhanVien");
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        nhanVienBo.delete(id);

        response.sendRedirect(request.getContextPath() + "/nhanVien");
    }
}
