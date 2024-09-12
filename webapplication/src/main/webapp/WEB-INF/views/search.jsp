<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="controller.PhonebookVO" %>
<%@ page import="controller.PhonebookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 검색</title>
</head>
<body>
    <h2>전화번호부 검색</h2>
    <form action="PhonebookServlet" method="post">
        <input type="hidden" name="action" value="search">
        Keyword: <input type="text" name="keyword" required><br>
        <input type="submit" value="검색">
    </form>
    <%
        List<PhonebookVO> results = (List<PhonebookVO>) request.getAttribute("phonebooks");
        if (results != null && !results.isEmpty()) {
    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Memo</th>
            <th>Action</th>
        </tr>
        <%
            for (PhonebookVO vo : results) {
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
    <% } else { %>
    <p>검색 결과가 없습니다.</p>
    <% } %>
    <a href="input.jsp">새로운 입력</a>
    <a href="PhonebookServlet?action=list">전체 목록</a>
</body>
</html>
