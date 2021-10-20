<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Late Night Scribbling</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- w3 bootstrap -->
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">
	<!-- Slick -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
<style>
title { text-decoration: line-through; }
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
	min-height: 100vh;
}
body::-webkit-scrollbar {
	display: none;
}
h3, h4 {
	margin: 10px 0 30px 0;
	letter-spacing: 10px;      
	font-size: 20px;
	color: #111;
}
.container {
	padding: 80px 120px;
	min-height: inherit;
}
.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 80%;
	height: 80%;
	opacity: 0.7;
}
.person:hover {
	border-color: #f1f1f1;
}
.carousel-inner img {
	-webkit-filter: grayscale(90%);
	filter: grayscale(90%); /* make all photos black and white */ 
	width: 100%; /* Set width to 100% */
	margin: auto;
}
.carousel-caption h3 {
	color: #fff !important;
}
@media (max-width: 600px) {
	.carousel-caption {
		display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
	}
}
.bg-1 {
	background: #2d2d30;
	color: #bdbdbd;
}
.bg-1 h3 { color: #fff; }
.bg-1 p { font-style: italic; }
.list-group-item:first-child {
	border-top-right-radius: 0;
	border-top-left-radius: 0;
}
.list-group-item:last-child {
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}
.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}
.thumbnail p {
	margin-top: 15px;
	color: #555;
}
.btn {
	padding: 10px 20px;
	background-color: #333;
	color: #f1f1f1;
	border-radius: 0;
	transition: .2s;
}
.btn:hover, .btn:focus {
	border: 1px solid #333;
	background-color: #fff;
	color: #000;
}
.modal-header, h4, .close {
	background-color: #333;
	color: #fff !important;
	text-align: center;
	font-size: 30px;
}
.modal-header, .modal-body {
	padding: 40px 50px;
}
.nav-tabs li a {
	color: #2d2d30;
}
#googleMap {
	width: 100%;
	height: 400px;
	-webkit-filter: grayscale(100%);
	filter: grayscale(100%);
}  
.navbar {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #fff;
	border: 0;
	font-size: 11px !important;
	letter-spacing: 4px;
	opacity: 0.9;
}
.navbar-fixed-top { border-bottom: 1px solid #ddd; }
.navbar-brand { 
	color: #2d2d30;
}
.navbar-nav>li>a {
	padding: 8px 0px 8px 2px;
	vertical-align: middle;
	text-align: center;
}
.nav>li>a:focus, .nav>li>a:hover {
    text-decoration: none;
    background-color: #2d2d30;
    color: #fff;
}
.open .dropdown-toggle {
	color: #fff;
	background-color: #555 !important;
}
.dropdown-menu li a {
	color: #000 !important;
}
.dropdown-menu li a:hover {
	background-color: red !important;
}
footer {
	background-color: #2d2d30;
	color: #f5f5f5;
	padding: 32px;
}
footer a {
	color: #f5f5f5;
}
footer a:hover {
	color: #777;
	text-decoration: none;
}  
.form-control {
	border-radius: 0;
}
textarea {
	resize: none;
}

/* 01 / 07 / 2021 */
.mysub, .infoBox, .editBox, .search-container { 
	width: 80%;
	min-width: 350px;
	display: flex; 
	flex-direction: column; 
}
.infoBox, .editBox { margin: 0 auto; }

/* 16 / 07 / 2021 */
.btn-dark { background-color: slategrey; color: white; }
.btn-light { background-color: lightsteelblue; color: slategrey; }
.btn-white { background-color: white; color: #777; }
  
/* 18 / 07 / 2021 */
.input-control { width: 100%; }
.inputbox, .deactivateBox, .forgotPassBox, .verifyCodeBox, .passChangeBox { 
	display: flex;
	flex-direction: column;
	-webkit-box-pack: center;
	justify-content: center;
	width: 360px; 
	margin: 0 auto;
  }
legend { display: none; }

/* 25 July 2021 */
input:focus { outline: none; }

.list-group { margin-bottom: 10px; }
.list-group-item select, .list-group-item .btn { font-size: 15px; line-height: 1.8; margin-bottom: -1px; }

.required-group, .gender-group, .post-group, .select-group, .login-group, .deact-group, .forgot-group, .verify-group, .passChange-group
{ display: flex; flex-direction: row; }
.required-group .required-item { width: 95%; border: none; }

/* 27 July 2021 */
.gender-group input[type=radio] { display: none; }
.gender-group input[type=radio]:checked+label { background-color: #333; color: #fff; }
.gender-group .btn:first-of-type { border: 1px solid #ddd; }
.gender-group .btn { font-size: 15px; line-height: 1.8; margin-bottom: 0px; border: 1px solid #ddd; border-left: none; }
.gender-group .gender-item { width: 33.3333334%; }

.post-group .post-group-item { width: 50%; }
.post-group btn { font-size: 15px; line-height: 1.8; }

.select-group .btn:first-of-type { border: 1px solid #ddd; }
.select-group .btn { border: 1px solid #ddd; border-left: none; height: 49px; }
.select-group .birth-year { width: 50%; }
.select-group .birth-month, .select-group .birth-date { width: 25%; }

/* 27 July 2021 */
.agreement-group input[type=checkbox] { display: none; }
.agreement-group label { display: flex; flex-direction: row; margin-bottom: 0px; }
.agreement-sub-group label { font-weight: normal; }
.isChecked + span { width: 92%; }

/* 28th July 2021 */
.modal-btn { border: none; background-color: white; font-weight: 550; padding: 0px; }
.modal-btn:hover { text-decoration: underline; }

/* 30th July 2021 */
.title-hidden { 
	width: 1px;
	height: 1px;
	overflow: hidden;
	font-size: 0;
	line-height: 0;
	position: absolute;
	left: -9999%;
}
 
 /* 2nd August 2021 */
.material-icons { 
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none; 
}

.navbar-bar { display: flex; justify-content: space-between; width: 75%; margin: 0 auto }
.navbar-right, .nav-search-bar { margin: 0px; display: flex; flex-direction: row; align-items: center; }
.search-icon { color: #2d2d30; margin-right: 5px; }
.search-icon:hover { text-decoration: none; color: #2d2d30; }
.navbar-header { float: left; }

.myboard { width: 80%; min-width: 850px; }

.login-group .isValid { margin-left: -25px; }
.login-sub-group { display: flex; flex-direction: row; justify-content: space-between; }
.login-group-item, .forgot-group-item, .deact-group-item, .forgot-group-item, .verify-group-item, .passChange-group-item
{ width: 100%; padding-right: 25px; border: none; }

/* 7th August 2021 */
.gender-box input[type=radio] { display: none; }
.gender-box input[type=radio]:checked+label { background-color: #333; color: #fff; }

/* 8th August 2021 */
.edit-group { display: flex; flex-direction: row; padding: 10px; border-bottom: 1px solid #ddd; flex-wrap: wrap; }
.edit-title { width: 20%; min-width: 100px; }
.address-box, .gender-box, .birth-box, .postcode-box { width: 60%; min-width: 300px; }
.gender-box, .birth-box, .postcode-box { display: flex; flex-direction: row; flex-wrap: wrap; }
.gender-item, .birth-item, .post-item { flex-grow: 1; }
.birth-item { height: 49px; }
.address-item { width: 100%; }

#upassword_edit { margin-top: 10px; }
.edit-button-group { display: flex; flex-direction: row; justify-content: center; margin-top: 20px; }
#pass-alert { display: none; }

/* 9th August 2021 */
.check-line { display: none; } 
.align-right { display: flex; justify-content: flex-end; }

.boxoffice-box { width: 100%; position: relative; padding: 0 30px; }
.boxoffice-rank { 
	line-height: 1;
	width: 20px;
	z-index: 2; 
	top: 12px;
	background-color: #333;
	color: #fff;
	padding: 2px;
	text-align: center;
	margin-left: 2px;
	position: absolute;
	border-radius: 2px;
}
.boxoffice-item { padding: 10px; }

.best-box { display: flex; flex-direction: row; justify-content: space-evenly; flex-wrap: wrap; }
.best-item { display: flex; flex-direction: column; }
@media screen and (min-width: 768px) {
	.best-item { width: 19%; }
}
@media screen and (max-width: 768px) {
	.best-item { width: 50%; }
}
.boxoffice-item img, .best-item img { width: 100%; margin: -10px 0px; }

.poster { z-index: 1; border-radius: 5px; overflow: hidden; }
.sub-desc { font-size: 12px; }
.more-btn-box { display: flex; flex-direction: row; justify-content: center; }

.main-panel:first-of-type { padding-top: 50px; }
.main-panel { 
	display: flex; 
	flex-direction: column;
	padding: 50px 0px; 
	overflow: hidden; 
	height: auto; 
	width: 70%; 
	margin: 0 auto;
}
.main-panel-box {
	display: flex; 
	flex-direction: row; 
	flex-wrap: wrap; 
	overflow: hidden; 
	height: auto; 
	width: 100%; 
	margin: 0 auto;
	align-items: center;
}
h3.panel-title { 
	padding: 10px 30px;
	letter-spacing: 2px;
	font-weight: bold;
	color: #343E97;
	width: 100%;
}
.btn-prev, .btn-next { 
	z-index: 2;
	background-color: transparent;
	border: none;
	font-size: 30px;
	margin: 0px;
	text-align: center;
	display: block;
    height: 48px;
    width: 48px;
}
.btn-prev.hidden, .btn-next.hidden { display: hidden; }
.btn-prev { background: url('resources/images/chevron_left_black.png') no-repeat; margin-right: -48px; }
.btn-next { background: url('resources/images/chevron_right_black.png') no-repeat; margin-left: -48px; }

/* 12th August 2021 */
.nav-tabs > li > a { margin: 0px; }
.search-header {
	padding-top: 50px;
	position: relative;
	margin: 0px;
	width: 100%;
	display: flex;
}
.search-panel { display: flex; flex-direction: column; min-height: 700px; }
.search-content { align-content: center; height: 100%; flex-grow: 1; }
.search-field { display: flex; flex-direction: row; }
.search-box { width: 60%; display: flex; flex-direction: column; }
.search-box-full { width: 100%; display: flex; flex-direction: column; }
.search-bar { border-bottom: 1px solid #ddd; display: flex; padding: 20px; }
.search-input { flex-grow: 1; border: none; }
.search-filter { 
	width: 40%; 
	display: flex;
	flex-direction: column;
	border-left: 1px solid #ddd;
	padding: 20px;
}
.search-filter-item { height: 100px; display: flex; flex-direction: row; padding-top: 10px; justify-content: space-between; }
.search-btn { 
	height: 35px;
    width: 90px;
    border-radius: 5px;
    background-color: #2d2d30;
    color: #fff;
    font-size: 12px;
    margin: 0px 2px; 
}
.flim-genre, .flim-nation { width: 48%; }
.release-year { display: flex; flex-direction: row; width: 100%; flex-basis: 100%; }
.release-year-item { width: 48%; }
.release-year-item + span { width: 4%; margin-top: 35px; vertical-align: middle; text-align: center; }
#release-year-to { margin-top: 32px; }
.btn-nav { 
	height: 35px;
	width: 90px;
	border-radius: 5px;
	background-color: #2d2d30;
	color: #fff;
    font-size: 12px;
    margin: 0px 2px;
}
.btn-nav-light { 
	height: 35px;
	width: 90px;
	border-radius: 5px;
	border: 1px solid #2d2d30;
	color: #2d2d30;
    font-size: 12px;
    margin: 0px 2px;
}

/* list */
.container-full { min-height: 100vh; padding-top: 50px; overflow: visible; }
.list-container {
	height: 100%;
	display: flex;
	overflow: hidden;
}
.left-list-bar {
    width: 13%;
    max-width: 240px;
    margin: 20px 20px 0px 0px;
    height: 100%;
    text-align: right;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
}
.list-bar-word { font-size: 25px; font-weight: bold; color: #2d2d30; }
.list-bar-title, .info-item-title {
	font-weight: bold;
	color: #343E97;
	font-size: 18px;
}
.list-bar-tag {
	font-weight: bold;
	border: 1px solid #96989a;
	border-radius: 20px;
	padding: 5px 10px;
	color: #343E97;
	margin-bottom: 5px;
}
.scribble-list-box {
	display: flex;
	flex-direction: column;
	flex-grow: 1;
}
.scribble-list-header {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	margin-top: 20px;
	padding-bottom: 10px;
	border-bottom: 1px solid #96989a;
	padding-right: 200px;
}
.scribble-list-content {
	flex-grow: 1;
	overflow: scroll;
	padding-right: 13%;
}
.list-sort, .list-search { display: flex; }
.divider { font-size: 20px; }
.scribble-list-header select { border: none; }
.scribble-content-item {
	padding: 25px;
	display: flex;
}
.scribble-item-info { width: 85%; }
.scribble-item-poster { width: 15%; text-align: center; }
.info-item { display: flex; justify-content: space-between; align-items: center; }
.info-item-rank, .info-item-tags { font-size: 12px; }
.info-item-tags { font-weight: bold; color: #343E97; }
.info-item-content { margin: 15px 0px; }
.info-item-foot { display: flex; justify-content: space-between; }
.favorite-icons { cursor: pointer; color: #2d2c31; }
.favorite-icons:hover { text-decoration: none; color: #96989a; }
#writer-img { background-color: #2d2c31; border-radius: 30px; width: 30px; height: 30px; border: none;  }
#writer-name { margin-left: 5px; font-weight: bold; }

/* detail */
.detail-container { overflow: scroll; height: 100%; }
.detail-container p, .detail-container span { line-height: 1.42857143; }
.scribble-box {
    width: 760px;
    margin: 0px auto;
    display: flex;
    flex-direction: column;
    height: 100%;
    padding: 100px 0px;
}
.scribble-head {
    display: flex;
    align-items: flex-end;
    padding: 15px 10px 10px 10px;
    position: relative;
}
.scribble-poster { width: 20%; border: 1px solid #96989a; min-height: 200px; }
.scribble-poster img { width: 100%; padding: 15px 10px 10px 10px; }
.scribble-subject { width: 80%; position: relative; }
.scribble-favorite {
	position: absolute;
    right: 50px;
    top: 22px;
    font-size: 25px;
    color: #2d2c31; 
}
.scribble-exit {
    position: absolute;
    right: 10px;
    top: 20px;
    font-size: 30px;
    color: #2d2c31; 
}
.scribble-favorite:hover, .scribble-exit:hover { color: #96989a; text-decoration: none; }
.scribble-date {
    font-size: 25px;
    color: #2d2c31;
    padding: 10px;
    margin-bottom: 0px;
    border: none;
    display: none;
    cursor: text;
}
.scribble-title {
    font-size: 32px;
    padding: 10px;
    color: #2d2c31;
    border: none;
}
.scribble-info {
    display: flex;
    flex-direction: column;
}
.scribble-row1 {
    display: flex;
    border-top: 1px solid #96989a;
    border-bottom: 1px solid #96989a;
    align-items: center;
}
.scribble-rate {
    width: 22%;
    text-align: center;
    border-right: 1px solid #96989a;
    padding: 10px;
    color: #2d2c31; 
}
.star { font-size: 15px; margin-bottom: 0px; line-height: inherit; vertical-align: middle; }
.scribble-kino {
	width: 58%;
	padding: 10px;
	postion: relative;
}
.detail-title, .detail-kino { margin-bottom: 0px; margin-block-start: 0px; color: #2d2c31; }
.scribble-writer { 
	display: flex; 
	width: 20%; 
	justify-content: flex-end; 
	align-items: center;
}
.writer-img { 
	background-color: #2d2c31; 
	border-radius: 30px; 
	width: 30px; 
	height: 30px; 
	border: none; 
	margin-right: 5px; 
}
.writer-name { 
	padding-right: 5px; 
	font-weight: bold;
	color: #343E97;
}
.scribble-row2 {
    display: flex;
    border-bottom: 1px solid #96989a;
}
.scribble-row2 > div { width: 50%; padding: 10px; }
.scribble-info-group {
	display: flex;
	color: #2d2c31;
}
.scribble-filmInfo {
    border-right: 1px solid #96989a;
}
.scribble-info-group:last-child {
    margin-bottom: 0px;
}
.scribble-info-title {
	width: 30%;
	padding-left: 30px;
}
.scribble-info-item {
	width: 70%;
	padding-right: 30px;
}
.scribble-tags {
    padding: 10px 40px;
    color: #2d2c31;
    border-bottom: 1px solid #96989a;
    display: flex;
    align-items: center;
}
.scribble-tag {
	font-weight: bold;
	border: 1px solid #96989a;
	border-radius: 20px;
	padding: 5px 10px;
	color: #343E97;
}
.scribble-content {
    flex-grow: 1;
    padding: 20px 40px;
    color: #2d2c31;
}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%
	Integer uno = null;
	if(request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno")!=null) {
		uno = (Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno");
	}
%>
<c:set var="url" value="${pageContext.request.requestURL}" />
<c:set var="member" value="${fn:replace(url, pageContext.request.requestURI, '/lnscribbling')}"/>
<nav class="navbar navbar-fixed-top">
	<div class="navbar-bar">
		<div class="navbar-header">
      		<h1 class="title-hidden">스크리블링</h1>
      		<h2 class="title-hidden">주메뉴</h2>
      		<a class="navbar-brand" href="${pageContext.request.contextPath}/main.do">Scribbling</a>
    	</div>
   		<ul class="nav navbar-nav navbar-right">
   			<li>
   				<div class="nav-search-bar">
   					<a href="${pageContext.request.contextPath}/search.do" class="material-icons search-icon">search</a>
   				</div>
   			</li>
   			<c:set var="uno" value="<%=uno%>"/>
   			<c:if test="${uno==null}">
				<li><a href='${member}/account/login_page' class="btn-nav-light">로그인</a></li>
   				<li><a href='${member}/account/join_page' class="btn-nav">회원가입</a></li>
      		</c:if>
        	<c:if test="${uno!=null}">
        		<li><a href='${pageContext.request.contextPath}/scribble/list' class="btn-nav">내 스크리블링</a></li>
      			<li><a href='${member}/account/info' class="btn-nav">마이페이지</a></li>
				<li><a href='${member}/account/logout' class="btn-nav">로그아웃</a></li>
      		</c:if>
     	</ul>
  	</div>
</nav>