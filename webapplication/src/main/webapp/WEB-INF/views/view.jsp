<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.PhonebookVO" %>
<%@ page import="controller.PhonebookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 상세 보기</title>
</head>
<body>
    <h2>전화번호부 상세 보기</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        PhonebookDAO dao = new PhonebookDAO();
        PhonebookVO vo = dao.getPhonebookById(id);
        if (vo != null) {
    %>
    <p>ID: <%= vo.getId() %></p>
    <p>Name: <%= vo.getName() %></p>
    <p>Phone Number: <%= vo.getHp() %></p>
    <p>Memo: <%= vo.getMemo() %></p>
    <a href="PhonebookServlet?action=edit&id=<%= vo.getId() %>">Edit</a>
    <a href="PhonebookServlet?action=delete&id=<%= vo.getId() %>">Delete</a>
    <a href="PhonebookServlet?action=list">전체 목록</a>
    <% } else { %>
    <p>해당 ID를 가진 전화번호부가 없습니다.</p>
    <% } %>
</body>
</html>
