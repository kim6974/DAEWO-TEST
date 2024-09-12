<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="controller.PhonebookVO" %>
<%@ page import="controller.PhonebookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 전화번호부</title>
</head>
<body>
    <h2>전체 전화번호부</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Memo</th>
            <th>Action</th>
        </tr>
        <%
            PhonebookDAO dao = new PhonebookDAO();
            List<PhonebookVO> list = dao.getAllPhonebooks();
            for (PhonebookVO vo : list) {
        %>
        <tr>
            <td><%= vo.getId() %></td>
            <td><%= vo.getName() %></td>
            <td><%= vo.getHp() %></td>
            <td><%= vo.getMemo() %></td>
            <td>
                <a href="PhonebookServlet?action=view&id=<%= vo.getId() %>">View</a>
                <a href="PhonebookServlet?action=edit&id=<%= vo.getId() %>">Edit</a>
                <a href="PhonebookServlet?action=delete&id=<%= vo.getId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    <a href="input.jsp">새로운 입력</a>
    <a href="PhonebookServlet?action=search">검색</a>
</body>
</html>
