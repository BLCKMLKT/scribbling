<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/sidebar.jsp" %>
<!-- HEADER -->
<div class="main">
	<div class="container">
		<div class="scribble-box">
			<h3>스크리블 삭제</h3>
			<form action="${pageContext.request.contextPath}/scribble/delete?sno=${param.sno}" method="post" id="form_delete">
				<div class="password-check">
					<div class="password-left">
						<label for="password">계정 비밀번호</label>
					</div>
					<div class="password-right">
						<input type="password" id="password" name="upassword" class="list-group-item" />
						<p class="password-desc"> * 스크리블 삭제 시 필수입니다.</p>
						<div class="form-group text-right">
							<input type="submit" class="btn btn-round-light" value="확인" />
							<a href="javascript:history.go(-1);" class="btn btn-round-dim">취소</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
	$(function(){
		$("#form_delete").submit(function(){
			if($("#bpass").val()=="") { alert("빈칸입니다.\n확인해주세요."); $("#password").focus(); return false; }
		});
	});
</script>
<!-- FOOTER -->
<%@ include file="../inc/profile.jsp" %>