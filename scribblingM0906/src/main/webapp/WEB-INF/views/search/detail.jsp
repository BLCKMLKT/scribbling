<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<!-- 		Header 		 -->
<div class="container-full">
	<div class="detail-container">
		<div class="scribble-box">
			<div class="scribble-head">
				<div class="scribble-poster">
					<img src="${pageContext.request.contextPath}/" alt=""/>
				</div>
				<div class="scribble-subject">
					<p class="scribble-date">0000/00/00</p>
					<p class="scribble-title detail-title">영화 제목</p>
				</div>
				<a href="" class="material-icons scribble-favorite">favorite_border</a>
				<a href="" class="material-icons scribble-exit">close</a>
			</div>
			<div class="scribble-info">
				<div class="scribble-row1">
					<div class="scribble-rate">
						<span class="material-icons star">star_border</span>
						<span class="material-icons star">star_border</span>
						<span class="material-icons star">star_border</span>
						<span class="material-icons star">star_border</span>
						<span class="material-icons star">star_border</span>
					</div>
					<div class="scribble-kino">
						<p class="detail-kino">영화관</p>
					</div>
					<div class="scribble-writer">
						<span class="writer-img"><img src="" alt="" /></span>
						<span class="writer-name">anonymous</span>
					</div>
				</div>
				<div class="scribble-row2">
					<div class="scribble-filmInfo">
						<p class="scribble-info-group">
							<span class="scribble-info-title">개봉일</span>
							<span class="scribble-info-item">0000.00.00</span>
						</p>
						<p class="scribble-info-group">
							<span class="scribble-info-title">국가</span>
							<span class="scribble-info-item">ㅇㅇㅇㅇ</span>
						</p>
						<p class="scribble-info-group">
							<span class="scribble-info-title">감독</span>
							<span class="scribble-info-item">ㅇㅇㅇ</span>
						</p>
					</div>
					<div class="scribble-cast scribble-info-group">
						<div class="scribble-info-title">
							<span>출연진</span>
						</div>
						<div class="scribble-info-item">
							<p>ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ</p>
						</div>
					</div>
				</div>
			</div>
			<div class="scribble-tags">
				<span class="scribble-tag"># tag1</span>
			</div>
			<div class="scribble-content">
				<p>스크리블 내용</p>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('.scribble-date').css('display', 'block');
	});
</script>
<!--		Footer 		 -->
<%@ include file="../inc/footer.jsp" %>

