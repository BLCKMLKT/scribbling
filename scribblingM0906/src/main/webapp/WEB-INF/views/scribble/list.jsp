<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="list-container">
		<div class="left-list-bar">
			<span class="list-bar-title">내 스크리블링</span>
		</div>
		<div class="scribble-list-box">
			<div class="scribble-list-header">
				<div class="list-sort">
					<select class="sort-order" name="sort_order">
						<option>최신순</option>
						<option>오래된순</option>
						<option>별점높은순</option>
						<option>별점낮은순</option>
					</select>
					<span class="divider"> | </span>
					<select class="page-limit" name="page_limit">
						<option>5</option>
						<option>10</option>
						<option>15</option>
						<option>20</option>
					</select>
				</div>
				<div class="list-search">
					<select class="search-option" name="search_option">
						<option>영화명</option>
						<option>영화관명</option>
						<option>대표태그</option>
					</select>
					<input type="text" class="search-input" name="search_input" />
					<input type="button" class="material-icons search-btn" value="search" />
				</div>
			</div>
			<div class="scribble-list-content">
				<div class="scribble-content-item">
					<div class="scribble-item-info">
						<div class="info-item">
							<a class="info-item-title" href="<c:url value="/scribble/detail" />">블랙위도우</a>
							<span class="into-item-dateplace">2021.07.07 · 영등포CGV</span>
						</div>
						<div class="info-item">
							<span class="info-item-rank">★ ★ ★ ★ ★</span>
							<span class="info-item-tags">#여성히어로 #마블시리즈 #코믹스원작</span>
						</div>
						<div class="info-item-content">
							<p>어벤져스의 히어로 블랙 위도우, 나타샤 로마노프는 자신의 과거와 연결된 레드룸의 거대한 음모와 실체를 깨닫게 된다. 상대의 능력을 복제하는 빌런 테스크마스터와 새로운 위도우들의...</p>
						</div>
						<div class="info-item-foot">
							<div class="info-item-writer">
								<img src="../images/poster-place.png" id="writer-img" alt="" />
								<span id="writer-name">anonymous</span>
							</div>
							<div class="favorite"><a class="material-icons favorite-icons">favorite_border</a></div>
						</div>
					</div>
					<div class="scribble-item-poster">
						<img src="" alt="" />
					</div>
				</div>
			</div>
			<div class="paging">
				<div class="prev"></div>
				<div class="pages"></div>
				<div class="next"></div>
			</div>
		</div>
	</div>
</div>
<!-- profile -->
<%@ include file="../inc/profile.jsp" %>

<%-- <td colspan="3" class="text-center">
	<ul class="pagination">
		<c:if test="${pageStart>listbtnLimit}">
			<li><a href="list.do?pagenum=${pageStart-1}">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${pageStart}" end="${pageEnd}" step="1">
			<c:choose>
				<c:when test="${param.pagenum==i}"><c:set var="currPage" value="active" /></c:when>
				<c:otherwise><c:set var="currPage" value="" /></c:otherwise>
			</c:choose>
			<li class="${currPage}"><a href="list.do?pagenum=${i}">${i}</a></li>
		</c:forEach>
		<c:if test="${pageEnd<pageAll}">
			<li><a href="list.do?pagenum=${pageEnd+1}">다음</a></li>
		</c:if>
	</ul>
</td>
<td class="text-right">
	<a href="write_view.do?pagenum=${param.pagenum}" class="btn btn-dark">글쓰기</a>
</td> --%>
