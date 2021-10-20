<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="container">
		<div class="scribble-box">
			<div class="scribble-head">
				<div class="scribble-poster">
					<img src="${svo.fvo.fimg}" alt="${svo.fvo.fname}"/>
				</div>
				<div class="scribble-subject">
					<p class="scribble-date">${svo.sdate}</p>
					<p class="scribble-title detail-title">${svo.fvo.fname}</p>
				</div>
				<a href="<c:url value="/scribble/edit?sno=${svo.sno}" />" class="material-icons scribble-edit">edit</a>
				<a href="<c:url value="/scribble/list" />" class="material-icons scribble-exit">close</a>
			</div>
			<div class="scribble-info">
				<div class="scribble-row1">
					<div class="scribble-rate">
						<c:forEach var="i" begin="1" end="${svo.srate}">
							<span class="material-icons star-view">star</span>
						</c:forEach>
						<c:forEach var="i" begin="1" end="${5-svo.srate}">
							<span class="material-icons star-view">star_border</span>
						</c:forEach>
					</div>
					<div class="scribble-kino">
						<p class="detail-kino">${svo.kvo.kname}</p>
					</div>
				</div>
				<div class="scribble-row2">
					<div class="scribble-filmInfo">
						<p class="scribble-info-group">
							<span class="scribble-info-title">개봉연도</span>
							<span class="scribble-info-item">${svo.fvo.frelease}</span>
						</p>
						<p class="scribble-info-group">
							<span class="scribble-info-title">감독</span>
							<span class="scribble-info-item">${svo.fvo.fdirector}</span>
						</p>
					</div>
					<div class="scribble-cast scribble-info-group">
						<div class="scribble-info-title">
							<span>출연진</span>
						</div>
						<div class="scribble-info-item">
							<p>${svo.fvo.fcast}</p>
						</div>
					</div>
				</div>
			</div>
			<div class="scribble-tag">
				<c:forEach var="tag" items="${svo.tags}"><span class="tag-view"># ${tag.tname} </span></c:forEach>
			</div>
			<div class="scribble-content">
				<p>${svo.scontent}</p>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('.scribble-date').css('display', 'block');
	});
</script>
<!-- profile -->
<%@ include file="../inc/profile.jsp" %>

