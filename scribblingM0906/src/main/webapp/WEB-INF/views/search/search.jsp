<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<!-- 		Header 		 -->
<div class="container search-container">
	<div class="search-panel"> <!-- tab -->
		<ul class="nav nav-tabs search-header">
			<li class="search-word-item active"><a data-toggle="tab" href="#film_title">영화명</a></li>
			<li class="search-word-item"><a data-toggle="tab" href="#film_tag">태그</a></li>
			<li class="search-word-item"><a data-toggle="tab" href="#scribbler">멤버</a></li>
		</ul>
		<div class="tab-content search-content">
			<div id="film_title" class="tab-pane fade in active">
				<form action="#" method="get" id="search_word_form">
				<fieldset class="search-field">
				<legend>검색</legend>
					<div class="search-box">
						<div class="search-bar">
							<span class="material-icons">search</span>
							<input type="text" id="searchword" name="film_title" class="search-input" placeholder="어떤 영화의 스크리블을 찾으시나요?" />
						</div>
						<div class="search-result">
							<p>검색어를 입력해주세요.</p>
						</div>
					</div>
					<div class="search-filter">
						<div class="search-filter-item">
							<div class="release-year">
								<div class="release-year-item">
									<label for="release-year">개봉연도</label>
									<select id="release-year-from" name="release-year-from" class="form-control">
										<option>1800</option>
									</select>
								</div>
								<span>~</span>
								<div class="release-year-item">
									<select id="release-year-to" name="release-year-to" class="form-control">
										<option>2021</option>
									</select>
								</div>
							</div>
						</div>
						<div class="search-filter-item">
							<div class="flim-nation">
								<label for="film_nation">국가</label>
								<select id="film_nation" name="film_nation" class="form-control">
									<option>한국</option>
									<option>미국/캐나다</option>
									<option>유럽</option>
									<option>중국</option>
								</select>
							</div>
							<div class="flim-genre">
								<label for="film_genre">장르</label>
								<select id="film_genre" name="film_genre" class="form-control">
									<option>로맨스</option>
									<option>스릴러</option>
									<option>액션</option>
									<option>판타지</option>
								</select>
							</div>
						</div>
						<div class="search-btn-box">
							<input type="submit" class="btn search-btn" value="검색" />
						</div>
					</div>
				</fieldset>
				</form>
			</div> <!-- tab1 -->
			<div id="film_tag" class="tab-pane fade">
			    <form action="#" method="get" id="search_tag_form">
				<fieldset class="search-field">
				<legend>검색</legend>
					<div class="search-box">
						<div class="search-bar">
							<span class="material-icons">tag</span>
							<input type="text" id="searchtag" name="tag" class="search-input" placeholder="어떤_느낌의_스크리블을_찾으시나요?" />
						</div>
						<div class="search-result">
							<p>검색어를 입력해주세요.</p>
						</div>
					</div>
					<div class="search-filter">
						<div class="search-tag-item">
							<input type="text" name="tags" />
							<input type="button" value="# 개그" />
						</div>
						<div class="search-btn-box">
							<input type="submit" class="btn search-btn" value="검색" />
						</div>
					</div>
				</fieldset>
				</form>
			</div> <!-- tab2 -->
			<div id="scribbler" class="tab-pane fade">
			     <form action="#" method="get" id="search_tag_form">
				<fieldset class="search-field">
				<legend>검색</legend>
					<div class="search-box-full">
						<div class="search-bar">
							<span class="material-icons">face</span>
							<input type="text" id="searchtag" name="tag" class="search-input" placeholder="어떤 사람의 스크리블을 찾으시나요?" />
							<div class="search-btn-box">
								<input type="submit" class="btn search-btn" value="검색" />
							</div>
						</div>
						<div class="search-result">
							<p>검색어를 입력해주세요.</p>
						</div>
					</div>
				</fieldset>
				</form>
			</div> <!-- tab3 -->
		</div>
	</div>
</div>
<script>
$(function(){
	$(".search-icon, #search-bar").css('display', 'none');
})
</script>
<!--		Footer 		 -->
<%@ include file="../inc/footer.jsp" %>

