<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="list-container">
		<div class="left-list-bar">
			<span class="list-bar-title">내 스크리블링</span>
		</div>
		<div class="scribble-list-box">
			<div class="scribble-list-header">
				<form id="list-search" action="<c:url value="/scribble/list" />" method="post">
					<div class="list-sort">
						<select class="sort-order" name="sort_order">
							<option value="lat">최신순</option>
							<option value="old">오래된순</option>
							<option value="hig">별점높은순</option>
							<option value="low">별점낮은순</option>
						</select>
						<span class="divider"> | </span>
						<select class="page-limit" name="page_limit">
							<option value="5">5</option>
							<option value="10">10</option>
							<option value="15">15</option>
							<option value="20">20</option>
						</select>
					</div>
					<div class="list-search">
						<select class="search-option" name="search_option">
							<option value="fname">영화명</option>
							<option value="kname">영화관명</option>
							<option value="tname">대표태그</option>
						</select>
						<input type="text" class="search-input" name="search_input" value="${shvo.keyword}"/>
						<input type="button" class="material-icons search-btn" value="search" />
					</div>
				</form>
			</div>
			<div class="scribble-list-content">
			<c:forEach var="slvo" items="${list}" varStatus="status">
				<div class="scribble-content-item">
					<div class="scribble-item-info">
						<div class="info-item">
							<a class="info-item-title" href="<c:url value="/scribble/detail?sno=${slvo.sno}" />">${slvo.fvo.fname}</a>
							<span class="into-item-dateplace">${slvo.sdate} · ${slvo.kvo.kname}</span>
						</div>
						<div class="info-item">
							<span class="info-item-rank">
							<c:forEach var="i" begin="1" end="${slvo.srate}" step="1">★ </c:forEach>
							<c:forEach var="i" begin="1" end="${5-slvo.srate}" step="1">☆ </c:forEach>
							</span>
							<span class="info-item-tags">
							<c:forEach var="tag" items="${slvo.tags}">#${tag.tname} </c:forEach>
							</span>
						</div>
						<div class="info-item-content">
							<p><c:choose>
								<c:when test="${slvo.scontent.length()>50}">${fn:substring(slvo.scontent, 0, 50)}...</c:when>
								<c:otherwise>${slvo.scontent}</c:otherwise>
							</c:choose></p>
						</div>
						<div class="info-item-foot">
							<span class="info-item-publishdate">${fn:substring(slvo.spublishdate, 0, 19)}</span>
							<span class="info-item-favorite">
								<span class="material-icons favorite-icon">favorite</span>
								<span class="favorite">0</span>
							</span>
						</div>
					</div>
					<div class="scribble-item-poster">
						<img src="${slvo.fvo.fimg}" alt="${slvo.fvo.fname}" />
					</div>
				</div>
				</c:forEach>
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
<script>
var order = '${shvo.order}';
var pageLmt = '${shvo.pageLmt}';
var option = '${shvo.option}';
$('.search-btn').on('click', function() {
	$('#list-search').submit();
});
$('.sort-order, .page-limit').on('change', function() {
	$('#list-search').submit();
});
$(document).ready(function() {
	if(order!='') { $('.sort-order').val(order).prop('selected', true); } 
	if(pageLmt!='') { $('.page-limit').val(pageLmt).prop('selected', true); }
	if(option!='') { $('.search-option').val(option).prop('selected', true); }
});
</script>

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
