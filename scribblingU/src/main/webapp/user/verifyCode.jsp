<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!-- 		Header 		 -->
<body>
	<div class="container mysub">
	<div class="verifyCodeBox">
		<h3 class="heading">인증번호 확인</h3>
		<div class="list-group">
			<div class="panel">
				<p class="panel-heading">인증번호를 입력하세요.</p>
			</div>
			<div class="list-group-item verify-group">
				<input type="text" id="verify_code" name="verify_code" class="verify-group-item" maxlength="6" />
			</div>
		</div>
		<p id="verify-code-check" class="check-line">here</p>
		<div class="edit-button-group">
			<input type="button" class="btn btn-dark input-control" id="verifyCode" value="인증번호 확인" />
			<a href="javascript:history.go(-1);" class="btn btn-light input-control">취소</a>
		</div>
	</div>
</div>
<!--		Footer 		 -->
<%@ include file="/inc/footer.jsp" %>
<script>
var vcode = ${vcode};
$("#verifyCode").click(function() {
	if($("#verify_code").val() == vcode) {
		location.href='${pageContext.request.contextPath}/account/change_pass';
	} else {
		$("#verify-code-check").html('인증번호가 일치하지 않습니다.');
	}
});
</script>