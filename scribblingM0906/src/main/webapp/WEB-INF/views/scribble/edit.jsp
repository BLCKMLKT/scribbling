<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="container">
		<div class="scribble-box">
			<form action="${pageContext.request.contextPath}/scribble/edit" method="post" id="scribble-edit-form">
				<fieldset>
					<div class="scribble-head">
						<input type="hidden" name="sno" value="${param.sno}"/>
						<div class="scribble-poster">
							<img src="${svo.fvo.fimg}" alt="${svo.fvo.fname}"/>
						</div>
						<div class="scribble-subject">
							<input type="date" class="scribble-date" min="1950-01-01" name="sdate" value="${svo.sdate}" />
							<input type="text" class="scribble-title input-box" name="stitle" value="${svo.fvo.fname}(${svo.fvo.frelease})" readonly/> <!-- 그냥 텍스트로 -->
						</div>
						<a href="<c:url value="/scribble/list" />" class="material-icons scribble-exit">close</a>
					</div>
					<div class="scribble-info">
						<div class="scribble-row1">
							<div class="scribble-rate">
								<input type="radio" id="rate1" name="srate" value="1" /><label for="rate1" class="material-icons star">star_border</label>
								<input type="radio" id="rate2" name="srate" value="2" /><label for="rate2" class="material-icons star">star_border</label>
								<input type="radio" id="rate3" name="srate" value="3" /><label for="rate3" class="material-icons star">star_border</label>
								<input type="radio" id="rate4" name="srate" value="4" /><label for="rate4" class="material-icons star">star_border</label>
								<input type="radio" id="rate5" name="srate" value="5" /><label for="rate5" class="material-icons star">star_border</label>
							</div>
							<div class="scribble-kino">
								<input type="text" id="kino" name="skino" class="input-box" value="${svo.kvo.kname}" />
								<div class="scribble-kino-list">
									<div class="kino-brand-section">
										<input type="hidden" id="kbrand" name="kbrand" />
										<a class="kino-brand">CGV</a>
										<a class="kino-brand">롯데시네마</a>
										<a class="kino-brand">메가박스</a>
										<a class="kino-brand">씨네Q</a>
										<a class="kino-brand">기타</a>
									</div>
									<div class="kino-province-section">
										<a class="kino-province">시/도</a>
									</div>
									<div class="kino-district-section">
										<a class="kino-district">시/군/구</a>
									</div>
									<div class="kino-section">
										<a class="kino">극장이름</a>
   									</div>
								</div>
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
						<c:forEach var="tag" items="${svo.tags}">
							<span class="tag-btn"># ${tag.tname}</span> 
						</c:forEach>
						<div class="tag-box">
							<input type="hidden" id="scribble-tags" name="stags" required/>
							<input type="text" id="scribble-tag" class="input-box" placeholder="#이 영화는 어떤 느낌?"/>
							<div class="scribble-tag-result tag-result-set"></div>
						</div>
					</div>
					<div class="scribble-content">
						<textarea id="scribble" name="scontent" rows="5" cols="95">${svo.scontent}</textarea>
					</div>
					<div class="scribble-foot">
						<input type="submit" class="btn btn-round-light" value="edit it!" />
					</div>
				</fieldset>
			</form>
		</div>
	</div>
<script> var srate = '${svo.srate}'; </script>
<script src="<c:url value="/resources/script/scribble_edit.js"/>" ></script>
</div>
<!-- profile -->
<%@ include file="../inc/profile.jsp" %>
