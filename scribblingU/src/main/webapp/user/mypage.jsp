<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/header.jsp" %>
<!--		HEADER		  -->
<div class="container mysub">
	<div class="infoBox">
		<h3 class="heading">내정보</h3>
		<table class="table table-responsive info-table">
			<caption class="title-hidden">내정보</caption>
			<tbody>
				<tr><th scope="row">이메일</th><td>${dto.uemail}</td></tr>
				<tr><th scope="row">이름</th><td>${dto.uname}</td></tr>
				<tr><th scope="row">생년월일</th><td>${dto.ubirth}</td></tr>
				<tr><th scope="row">성별</th>
					<c:choose>
						<c:when test="${dto.ugender eq 'f'}"><td>여자</td></c:when>
						<c:when test="${dto.ugender eq 'm'}"><td>남자</td></c:when>
						<c:when test="${dto.ugender eq 'n'}"><td>선택안함</td></c:when>
					</c:choose>
				</tr>
				<tr><th scope="row">주소</th><td>(${dto.upostcode}) ${dto.uaddress}</td></tr>
			</tbody>
			<tfoot>
				<tr><td colspan="2" class="text-center"><a href="${pageContext.request.contextPath}/account/edit_page" class="btn btn-white">수정</a></td></tr>
			</tfoot>
		</table>
	</div>
</div>
<!--		FOOTER		  -->
<%@ include file="/inc/footer.jsp" %>