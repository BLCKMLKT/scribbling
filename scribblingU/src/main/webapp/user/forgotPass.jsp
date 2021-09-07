<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!-- 		Header 		 -->
<body>
	<div class="container mysub">
	<div class="forgotPassBox">
		<h3 class="heading">비밀번호 찾기</h3>
		<form action="${pageContext.request.contextPath}/account/send_code" method="post" id="forgotPass">
		<fieldset>
			<legend>비밀번호 찾기</legend>
			<div class="list-group">
				<div class="panel">
					<p class="panel-heading">비밀번호를 찾으실 이메일 주소를 입력하세요.</p>
				</div>
				<div class="list-group-item forgot-group">
					<input type="text" id="pwfind_email" name="uemail" class="forgot-group-item" placeholder="이메일 주소" />
				</div>
			</div>
			<p id="forgot-check" class="check-line">here</p>
			<div class="edit-button-group">
				<input type="submit" class="btn btn-dark input-control" value="비밀번호 찾기" />
				<a href="javascript:history.go(-1);" class="btn btn-light input-control">돌아가기</a>
			</div>
		</fieldset>
	</form>
	</div>
</div>
<!--		Footer 		 -->
<%@ include file="/inc/footer.jsp" %>