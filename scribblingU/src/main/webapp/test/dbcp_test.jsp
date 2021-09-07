<%@page import="java.sql.Connection"%>
<%@page import="com.company.dbmanager.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>HTML BASIC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>   
    </head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		DBManager db = new DBManager();
		Connection conn = null;
		try {
			conn = db.connection();
			if(conn!=null) { out.println("연동 성공!"); }
		} catch(Exception e) { e.printStackTrace(); out.println("연동 실패!"); 
		} finally { if(conn!=null) { try{ conn.close(); } catch(Exception e) { e.printStackTrace(); } } }
	%>
</body>
</html>