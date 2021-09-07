<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!-- 		Header 		 -->
<body>
	<div class="container mysub">
	<div class="deactivateBox">
		<h3 class="heading">회원탈퇴</h3>
		<form action="${pageContext.request.contextPath}/account/deactivate" method="post" id="deactivate">
		<fieldset>
			<legend>회원탈퇴</legend>
			<div class="list-group">
				<div class="panel">
					<p class="panel-heading">정말 탈퇴하시겠어요?</p>
				</div>
				<div class="list-group-item deact-group">
					<input type="password" id="deact_pw" name="upassword" class="deact-group-item" maxlength="13" placeholder="비밀번호" />
				</div>
			</div>
			<p id="deactivate-check" class="check-line">here</p>
			<div class="edit-button-group">
				<input type="submit" class="btn btn-dark input-control" value="탈퇴" />
				<a href="${pageContext.request.contextPath}/account/info" class="btn btn-light input-control">취소</a>
			</div>
		</fieldset>
	</form>
	</div>
</div>
<!--		Footer 		 -->
<%@ include file="/inc/footer.jsp" %>