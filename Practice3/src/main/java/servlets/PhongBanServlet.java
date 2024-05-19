package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.PhongBanBo;
import model.PhongBan;

@WebServlet("/phongBan")
public class PhongBanServlet extends HttpServlet {
    private final PhongBanBo phongBanBo = new PhongBanBo();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (action != null) {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePhongBan(request, response);
                    break;
                default:
                    showPhongBanList(request, response);
            }
        } else {
            showPhongBanList(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (action != null) {
            switch (action) {
                case "add":
                    addPhongBan(request, response);
                    break;
                case "edit":
                    updatePhongBan(request, response);
                    break;
                default:
                    showPhongBanList(request, response);
            }
        } else {
            showPhongBanList(request, response);
        }
    }

    private void showPhongBanList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PhongBan> phongBanList = phongBanBo.getAll();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("phongBanList", phongBanList);
        request.getRequestDispatcher("/phongBanList.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/addPhongBanForm.jsp").forward(request, response);
    }

    private void addPhongBan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String tenpb = request.getParameter("tenpb");
        String mota = request.getParameter("mota");

        PhongBan newPhongBan = new PhongBan();
        newPhongBan.setTenpb(tenpb);
        newPhongBan.setMota(mota);

        phongBanBo.add(newPhongBan);

        response.sendRedirect(request.getContextPath() + "/phongBan");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        PhongBan phongBan = phongBanBo.getById(id);
        request.setAttribute("phongBan", phongBan);
        request.getRequestDispatcher("/editPhongBanForm.jsp").forward(request, response);
    }

    private void updatePhongBan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String tenpb = request.getParameter("tenpb");
        String mota = request.getParameter("mota");

        PhongBan existingPhongBan = phongBanBo.getById(id);
        existingPhongBan.setTenpb(tenpb);
        existingPhongBan.setMota(mota);

        phongBanBo.edit(existingPhongBan, id);

        response.sendRedirect(request.getContextPath() + "/phongBan");
    }

    private void deletePhongBan(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        phongBanBo.delete(id);
        response.sendRedirect(request.getContextPath() + "/phongBan");
    }
}
