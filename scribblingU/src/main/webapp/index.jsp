<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String member = request.getRequestURL() + "";
	member = member.replace(request.getRequestURI(), "")+"/scribbling";
%>
<script>location.href='<%=member%>/main.do'</script>
