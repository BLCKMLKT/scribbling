<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!--		HEADER		  -->
<div class="container mysub">
	<div class="inputbox">
		<h3 class="heading">회원가입</h3>
		<form action="${pageContext.request.contextPath}/account/join" method="post" id="register">
		<fieldset>
			<legend>회원가입</legend>
			<div class="list-group">
				<div class="list-group-item required-group">
					<input type="text" id="useremail" name="useremail" class="required-item" placeholder="이메일(example@gmail.com)" />
					<div class="material-icons isValid"></div>
				</div>
				<p id="id-check" class="check-line"></p>
				<div class="list-group-item required-group">
					<input type="password" id="userpw1" name="userpw1" class="required-item" maxlength="13" placeholder="비밀번호(10자 이상 영문+숫자+특수문자)" />
					<div class="material-icons isValid"></div>
				</div>
				<div class="list-group-item required-group">
					<input type="password" id="userpw2" name="userpw2" class="required-item" maxlength="13" placeholder="비밀번호 확인"/>
					<div class="material-icons isValid"></div>
				</div>
				<p id="pw-check" class="check-line"></p>
			</div>
			<div class="list-group">
				<div class="list-group-item required-group">
					<input type="text" id="username" name="username" class="required-item" placeholder="이름(2자 이상)" />
					<div class="material-icons isValid"></div>
				</div>
				<div class="select-group input-control">
					<select class="birth-year btn btn-white" id="sel1" name="useryear">
						<option>출생년도</option>
						<c:forEach var="i" begin="1950" end="2021" step="1">
							<option>${i}</option>
						</c:forEach>
					</select>
					<select class="birth-month btn btn-white" id="sel2" name="usermonth">
						<option>월</option>
						<c:forEach var="i" begin="1" end="12" step="1">
							<option>${i}</option>
						</c:forEach>
					</select>
					<select class="birth-date btn btn-white" id="sel3" name="userdate">
						<option>일</option>
						<c:forEach var="i" begin="1" end="31" step="1">
							<option>${i}</option>
						</c:forEach>
					</select>
				</div>
				<div class="gender-group input-control">
					<input type="radio" id="gender1" name="usergender" value="m"><label for="gender1" class="gender-item btn btn-white">남자</label>
					<input type="radio" id="gender2" name="usergender" value="f"><label for="gender2" class="gender-item btn btn-white">여자</label>
					<input type="radio" id="gender3" name="usergender" value="n"><label for="gender3" class="gender-item btn btn-white">선택안함</label>
				</div>
			</div>
			<div class="list-group address-group">
				<div class="post-group">
					<input type="text" id="postcode" name="postcode" class="post-group-item list-group-item" placeholder="우편번호" readonly />
					<input type="button" id="add_search" value="우편번호 검색" class="post-group-item btn btn-dark" />
				</div>
				<input type="text" id="address1" name="address1" class="list-group-item input-control" placeholder="주소" readonly/>
				<div class="list-group-item required-group">
					<input type="text" id="address2" name="address2" class="required-item" placeholder="상세주소" />
					<div class="material-icons isValid"></div>
				</div>
			</div>
			<div class="list-group agreement-group">
				<div class="agreement-all list-group-item">
					<input type="checkbox" id="agree_all" name="agree_all" />
					<label for="agree_all">
						<span class="material-icons isChecked">radio_button_unchecked</span>
						<span>전체 약관에 동의합니다.</span>
					</label>
				</div>
				<div class="agreement-sub-group">
					<div class="agreement-sub-item list-group-item">
						<input type="checkbox" id="agreement" name="agreement" />
						<label for="agreement">
							<span class="material-icons isChecked" id="agreement-check">radio_button_unchecked</span>
							<span><input type="button" class="modal-btn" id="serviceTermsModal" value="서비스 이용약관" data-toggle="modal" data-target="#serviceTerms" />
							에 동의합니다. (필수)</span>
						</label>
					</div>
					<div class="agreement-sub-item list-group-item">
						<input type="checkbox" id="privacy" name="privacy" />
						<label for="privacy">
							<span class="material-icons isChecked" id="privacy-check">radio_button_unchecked</span>
							<span><input type="button" class="modal-btn" id="privacyTermsModal" value="개인정보 수집 및 이용" data-toggle="modal" data-target="#privacyTerms" />
							에 동의합니다. (필수)</span>
						</label>
					</div>
					<div class="agreement-sub-item list-group-item">
						<input type="checkbox" id="marketing" name="marketing" />
						<label for="marketing">
							<span class="material-icons isChecked" id="marketing-check">radio_button_unchecked</span>
							<span><input type="button" class="modal-btn" id="marketingTermsModal" value="알림 이벤트 정보 수신" data-toggle="modal" data-target="#marketingTerms" />
							에 동의합니다. (선택)</span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="submit" id="submit_btn" class="btn btn-dark input-control" value="계정 만들기" />
			</div>
		</fieldset>
	</form>
  </div>
</div>
<div id="serviceTerms" class="modal fade" role="dialog"></div>
<div id="privacyTerms" class="modal fade" role="dialog"></div>
<div id="marketingTerms" class="modal fade" role="dialog"></div>
<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){
	$("#add_search").on('click', function(){
		new daum.Postcode({
			oncomplete: function(data) {
				$("#postcode").val(data.zonecode); $("#address1").val(data.address); 
				$("#address2").focus();
			}
		}).open();
	});
});
</script>
<script src="${pageContext.request.contextPath}/user/script/register_validation.js"></script>
<!--		FOOTER		  -->
<%@ include file="/inc/footer.jsp" %>