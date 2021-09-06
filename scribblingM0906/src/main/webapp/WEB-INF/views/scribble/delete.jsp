<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<!-- HEADER -->
<div class="container mysub">
	<h3>MULTIBOARD 삭제</h3>
	<form action="${pageContext.request.contextPath}/delete.do?bno=${param.bno}" method="post" id="form_delete">
		<fieldset>
			<legend></legend>
			<div class="form-group">
				<label for="bpass">비밀번호</label>
				<input type="password" class="form-control" id="bpass" name="bpass" maxlength="4" />
				<span>(*) 삭제 시 필수입니다.</span>
			</div>
			<div class="form-group text-right">
				<input type="submit" class="btn btn-dark" value="확인" />
				<a href="javascript:history.go(-1);" class="btn btn-default">취소</a>
			</div>
		</fieldset>
	</form>
</div>
<script>
	$((function(){
		$("#form_delete").submit(function(){
			if($("#bpass").val()=="") { alert("빈칸입니다.\n확인해주세요."); $("#bpass").focus(); return false;
		});
	});
</script>
<!-- FOOTER -->
<%@ include file="../inc/footer.jsp" %>