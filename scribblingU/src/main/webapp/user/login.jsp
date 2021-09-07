<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!-- 		Header 		 -->
<%
	String cookie = request.getHeader("Cookie");
	Cookie[] cookies = null; String myEmail = ""; String checked = "unchecked";
	if(cookie!=null) { 
		cookies = request.getCookies(); 
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("remember")) { checked = cookies[i].getValue(); }
			if(cookies[i].getName().equals("uemail")) { myEmail = cookies[i].getValue(); }
		}
	}
	if(!checked.equals("checked")) { checked="unchecked"; myEmail = ""; }
%>
<div class="container mysub">
	<div class="inputbox">
		<h3 class="heading">로그인</h3>
		<form action="<c:url value="/account/login"/>" method="post" id="login">
		<fieldset>
			<legend>로그인</legend>
			<div class="list-group">
				<div class="list-group-item login-group">
					<input type="text" id="login_email" name="login_email" class="login-group-item" value="${myEmail}" placeholder="이메일(example@gmail.com)" />
					<div class="material-icons isValid"></div>
				</div>
				<div class="list-group-item login-group">
					<input type="password" id="login_pw" name="login_pw" class="login-group-item" maxlength="13" placeholder="비밀번호" />
					<div class="material-icons isValid"></div>
				</div>
			</div>
			<p id="login-check" class="check-line">here</p>
			<div class="login-sub-group">
				<span class="id-remember"><input type="checkbox" id="remember" name="remember" ${checked} /> 아이디 저장</span>
				<span class="id-pw-search text-right">
					<a href="<c:url value="/account/forgot_pass"/>">비밀번호 찾기</a>
				</span>
			</div>
			<div class="list-group">
				<input type="button" class="btn btn-dark list-group-item input-control" id="login_submit_btn" value="로그인" />
			</div>
			<div class="list-group sns-login">
				<a href="<c:url value=""/>" class="btn btn-light list-group-item input-control">카카오 로그인</a>
			</div>
			
		</fieldset>
	</form>
	</div>
</div>
<script src="<c:url value="/user/script/login_validation.js"/>"></script>
<!--		Footer 		 -->
<%@ include file="/inc/footer.jsp" %>