<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 입력</title>
</head>
<body>
    <h2>전화번호부 입력</h2>
    <form action="PhonebookServlet" method="post">
        <input type="hidden" name="action" value="insert">
        ID: <input type="text" name="id" required><br>
        Name: <input type="text" name="name" required><br>
        Phone Number: <input type="text" name="hp" required><br>
        Memo: <textarea name="memo" rows="4" cols="50"></textarea><br>
        <input type="submit" value="저장">
    </form>
    <a href="PhonebookServlet?action=list">전체 목록</a>
    <a href="PhonebookServlet?action=search">검색</a>
</body>
</html>
