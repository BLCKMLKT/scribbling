<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!--		HEADER		  -->
<div class="container mysub">
	<div class="editBox">
		<h3 class="heading">내정보변경</h3>
		<form action="${pageContext.request.contextPath}/account/edit" method="post" id="info_edit_form">
			<fieldset>
				<legend>내정보변경</legend>
					<div class="edit-group">
						<span class="edit-title">이메일</span>
						<input type="text" id="uemail_edit" name="uemail" class="list-group-item" value="${dto.uemail}" readonly />
					</div>
					<div class="edit-group">
						<span class="edit-title">비밀번호</span>
						<div class="password-box">
							<input type="password" class="password-item list-group-item" maxlength="13" id="upassword_orig" name="upassword_orig" placeholder="기존 비밀번호" />
							<input type="password" class="password-item list-group-item" maxlength="13" id="upassword_new" name="upassword_new" placeholder="새 비밀번호" />
							<input type="password" class="password-item list-group-item" maxlength="13" id="upassword_conf" name="upassword_conf" placeholder="새 비밀번호 확인" />
							<p id="pass-alert"></p>
							<input type="button" id="upassword_edit" class="btn btn-dark" value="변경" />
						</div>
					</div>
					<div class="edit-group password-box">
						<span class="edit-title">이름</span>
						<input type="text" id="uname_edit" name="uname" class="list-group-item" value="${dto.uname}" readonly />
					</div>
					<div class="edit-group">
						<span class="edit-title">생년월일</span>
						<div class="birth-box">
							<select class="birth-item birth-year btn btn-white" id="sel11" name="useryear">
								<option>출생년도</option>
								<c:forEach var="i" begin="1950" end="2021" step="1">
									<c:choose>
										<c:when test="${i eq birth[0]}"><option selected>${i}</option></c:when>
										<c:otherwise><option>${i}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<select class="birth-item birth-month btn btn-white" id="sel12" name="usermonth">
								<option>월</option>
								<c:forEach var="i" begin="1" end="12" step="1">
									<c:choose>
										<c:when test="${i eq birth[1]}"><option selected>${i}</option></c:when>
										<c:otherwise><option>${i}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<select class="birth-item birth-date btn btn-white" id="sel13" name="userdate">
								<option>일</option>
								<c:forEach var="i" begin="1" end="31" step="1">
									<c:choose>
										<c:when test="${i eq birth[2]}"><option selected>${i}</option></c:when>
										<c:otherwise><option>${i}</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="edit-group">
						<span class="edit-title">성별</span>
						<div class="gender-box">
							<input type="radio" id="gender11" name="usergender" value="m">
							<label for="gender11" class="gender-item btn btn-white">남자</label>
							<input type="radio" id="gender12" name="usergender" value="f">
							<label for="gender12" class="gender-item btn btn-white">여자</label>
							<input type="radio" id="gender13" name="usergender" value="n">
							<label for="gender13" class="gender-item btn btn-white">선택안함</label>
						</div>
					</div>
					<div class="edit-group">
						<span class="edit-title">우편번호</span>
						<div class="postcode-box">
							<input type="text" id="postcode_edit" name="postcode" value="${dto.upostcode}" class="post-item list-group-item" placeholder="우편번호" readonly />
							<input type="button" id="add_search_edit" value="우편번호 검색" class="post-item btn btn-dark" />
						</div>
					</div>
					<div class="edit-group">
						<span class="edit-title">주소</span>
						<div class="address-box">
							<input type="text" id="address11" name="address1" class="address-item list-group-item" placeholder="주소" value="${address[0]}" readonly />
							<input type="text" id="address12" name="address2" class="address-item list-group-item" value="${address[1]}" placeholder="상세주소" />
						</div>
					</div>
					<div class="edit-group align-right">
						<a href="${pageContext.request.contextPath}/account/deactivate_page" class="btn btn-dark">회원탈퇴</a>
					</div>
					<div class="edit-button-group">
						<input type="submit" class="btn btn-dark" value="수정완료">
						<a href="javascript:history.go(0);" class="btn btn-white">취소</a>
					</div>	
			</fieldset>
		</form>
	</div>
</div>
<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/user/script/editInfo_validation.js"></script>
<script>
$(function(){
	$("#add_search_edit").on('click', function(){
		new daum.Postcode({
			oncomplete: function(data) {
				$("#postcode_edit").val(data.zonecode); $("#address11").val(data.address); 
				$("#address12").focus();
			}
		}).open();
	});
});
var gender = '${dto.ugender}';
</script>
<!--		FOOTER		  -->
<%@ include file="/inc/footer.jsp" %>