<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="container">
		<div class="scribble-box">
			<form action="${pageContext.request.contextPath}/scribble/write" method="post" id="scribble-form">
				<fieldset>
					<div class="scribble-head">
						<div class="scribble-poster">
							<img src="" alt=""/>
			<!-- 포스터 -->	<input type="hidden" id="sposter" name="sposter" /> 
						</div>
						<div class="scribble-subject">
							<p id="date-placeholder">언제 영화를 보셨나요?</p>
			<!-- 날짜 -->		<input type="date" class="scribble-date" min="1950-01-01" name="sdate" required/>
			<!-- 제목 -->		<input type="text" class="scribble-title input-box" id="stitle" name="stitle" placeholder="어떤 영화를 보셨나요?" required/>
							<div class="scribble-title-result result-set"></div>
						</div>
						<a href="<c:url value="/scribble/list" />" class="material-icons scribble-exit">close</a>
					</div>
					<div class="scribble-info">
						<div class="scribble-row1">
							<div class="scribble-rate">
			<!-- 평점 -->			<input type="radio" id="rate1" name="srate" value="1" /><label for="rate1" class="material-icons star">star_border</label>
								<input type="radio" id="rate2" name="srate" value="2" /><label for="rate2" class="material-icons star">star_border</label>
								<input type="radio" id="rate3" name="srate" value="3" /><label for="rate3" class="material-icons star">star_border</label>
								<input type="radio" id="rate4" name="srate" value="4" /><label for="rate4" class="material-icons star">star_border</label>
								<input type="radio" id="rate5" name="srate" value="5" /><label for="rate5" class="material-icons star">star_border</label>
							</div>
							<div class="scribble-kino">
			<!-- 극장 -->			<input type="text" id="kino" name="skino" class="input-box" placeholder="어디서 보셨나요?" readonly required/>
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
			<!-- 개봉연도 -->			<input type="text" id="srelease" name="srelease" class="scribble-info-item" readonly/>
								</p>
								<p class="scribble-info-group">
									<span class="scribble-info-title">감독</span>
			<!-- 감독 -->				<input type="text" id="sdirector" name="sdirector" class="scribble-info-item" readonly/>
								</p>
							</div>
							<div class="scribble-info-group">
								<div class="scribble-info-title">
									<span>출연진</span>
									<input type="hidden" id="scast" name="scast" />
								</div>
								<div class="scribble-info-item scribble-cast">
			<!-- 출연진 -->		</div>
							</div>
						</div>
					</div>
					<div class="scribble-tag">
						<div class="tag-box">
			<!-- 태그 -->		<input type="hidden" id="scribble-tags" name="stags" />
							<input type="text" id="scribble-tag" class="input-box" placeholder="#이_영화는_어떤_느낌?" />
							<div class="scribble-tag-result tag-result-set">
								<input type="button" class="list-group-item" value="태그 추가하기"/>
							</div>
						</div>
					</div>
					<div class="scribble-content">
			<!-- 평 -->	<textarea id="scribble" name="scontent" rows="5" cols="95" placeholder="영화는 어땠나요?" required></textarea>
					</div>
					<div class="scribble-foot">
						<input type="submit" class="btn btn-round-light" value="scribble it!" />
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script src="<c:url value="/resources/script/scribble_write.js"/>"></script>
</div>
<!-- profile -->
<%@ include file="../inc/profile.jsp" %>
