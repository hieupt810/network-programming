package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchPhongBan")
public class SearchPhongBanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/searchPhongBan.jsp?searchKeyword=" + searchKeyword);
        } else {
            response.sendRedirect(request.getContextPath() + "/searchPhongBan.jsp");
        }
    }
}
