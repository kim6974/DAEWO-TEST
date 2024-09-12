package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PhonebookServlet")
public class PhonebookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        PhonebookDAO dao = new PhonebookDAO();

        if ("insert".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String hp = request.getParameter("hp");
            String memo = request.getParameter("memo");
            PhonebookVO vo = new PhonebookVO(id, name, hp, memo);
            dao.insertPhonebook(vo);
            response.sendRedirect("PhonebookServlet?action=list");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String hp = request.getParameter("hp");
            String memo = request.getParameter("memo");
            PhonebookVO vo = new PhonebookVO(id, name, hp, memo);
            dao.updatePhonebook(vo);
            response.sendRedirect("PhonebookServlet?action=list");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletePhonebook(id);
            response.sendRedirect("PhonebookServlet?action=list");

        } else if ("search".equals(action)) {
            String keyword = request.getParameter("keyword");
            request.setAttribute("phonebooks", dao.searchPhonebooks(keyword));
            request.getRequestDispatcher("search.jsp").forward(request, response);

        } else if ("view".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("phonebook", dao.getPhonebookById(id));
            request.getRequestDispatcher("view.jsp").forward(request, response);

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("phonebook", dao.getPhonebookById(id));
            request.getRequestDispatcher("edit.jsp").forward(request, response);

        } else if ("list".equals(action)) {
            request.setAttribute("phonebooks", dao.getAllPhonebooks());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
