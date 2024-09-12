<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.PhonebookVO" %>
<%@ page import="controller.PhonebookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 수정</title>
</head>
<body>
    <h2>전화번호부 수정</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        PhonebookDAO dao = new PhonebookDAO();
        PhonebookVO vo = dao.getPhonebookById(id);
    %>
    <form action="PhonebookServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= vo.getId() %>">
        Name: <input type="text" name="name" value="<%= vo.getName() %>" required><br>
        Phone Number: <input type="text" name="hp" value="<%= vo.getHp() %>" required><br>
        Memo: <textarea name="memo" rows="4" cols="50"><%= vo.getMemo() %></textarea><br>
        <input type="submit" value="수정">
    </form>
    <a href="PhonebookServlet?action=list">전체 목록</a>
</body>
</html>
