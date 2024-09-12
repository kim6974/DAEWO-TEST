<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.PhonebookVO" %>
<%@ page import="controller.PhonebookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 삭제</title>
</head>
<body>
    <h2>전화번호부 삭제</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        PhonebookDAO dao = new PhonebookDAO();
        PhonebookVO vo = dao.getPhonebookById(id);
    %>
    <p>ID: <%= vo.getId() %></p>
    <p>Name: <%= vo.getName() %></p>
    <p>Phone Number: <%= vo.getHp() %></p>
    <p>Memo: <%= vo.getMemo() %></p>
    <form action="PhonebookServlet" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= vo.getId() %>">
        <input type="submit" value="삭제">
    </form>
    <a href="PhonebookServlet?action=list">전체 목록</a>
</body>
</html>
