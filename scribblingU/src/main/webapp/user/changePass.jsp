<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!-- 		Header 		 -->
<body>
	<div class="container mysub">
	<div class="passChangeBox">
		<h3 class="heading">비밀번호 변경</h3>
		<form action="${pageContext.request.contextPath}/account/edit_password" method="post" id="passChange_form">
			<fieldset>
				<legend>비밀번호 변경</legend>
				<div class="list-group">
					<div class="panel">
						<p class="panel-heading">새 비밀번호를 입력하세요.</p>
					</div>
					<div class="list-group-item passChange-group">
						<input type="password" id="new_pw" name="upassword_new" class="passChange-group-item" placeholder="영문,숫자,특문 포함 10~13자리" maxlength="13" />
					</div>
					<div class="list-group-item passChange-group">
						<input type="password" id="new_pw_confirm" name="upassword_conf" class="passChange-group-item" placeholder="새 비밀번호 확인" maxlength="13" />
					</div>
				</div>
				<p id="new-pw-check" class="check-line">here</p>
				<div class="edit-button-group">
					<input type="submit" class="btn btn-dark input-control" value="확인" />
				</div>
			</fieldset>
		</form>
	</div>
</div>
<!--		Footer 		 -->
<%@ include file="/inc/footer.jsp" %>
<script>
var regPass = /^(?=[\w\d!@#$%^&*]*[a-z])(?=[\w\d!@#$%^&*]*\d)(?=[\w\d!@#$%^&*]*[!@#$%^&*])[\w\d!@#$%^&*]{10,16}$/; // 비밀번호
var regDupl = /(\w)\1\1/; // 비밀번호 3자리 중복
$("#passChange_form").submit(function() {
	if($("#new_pw").val() == "") {
		$("#new-pw-check").css('display', 'block');
		$("#new-pw-check").html("새 비밀번호를 입력해주세요."); 
		return false;
	} else if($("#new_pw_confirm").val() == "") {
		$("#new-pw-check").css('display', 'block');
		$("#new-pw-check").html("새 비밀번호 확인을 입력해주세요."); 
		return false;
	} else if(!regPass.test($("#new_pw").val())) { 
		$("#new-pw-check").css('display', 'block');
		$("#new-pw-check").html("영문,숫자,특문 포함 10~13자리로 입력해주세요."); 
		return false;
	} else if(regDupl.test($("#new_pw").val())) { 
		$("#new-pw-check").css('display', 'block');
		$("#new-pw-check").html("3자리 이상 같은 글자가 반복됩니다.");  
		return false;
	} else if($("#new_pw").val()!=$("#new_pw_confirm").val()) { 
		$("#new-pw-check").css('display', 'block');
		$("#new-pw-check").html("새 비밀번호 확인이 일치하지 않습니다."); 
		return false;
	}
});
</script>