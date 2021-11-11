<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Late Night Scribbling</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
	body {font-family: "Lato", sans-serif; height: 100vh; }
	.sidebar {
		height: 100%;
	    width: 60px;
	    position: fixed;
	    z-index: 1;
	    top: 0;
	    left: 0;
	    padding-top: 16px;
	    border-right: 0.5px solid #2d2c31;
	}
	.sidebar .sidebar-menu {
	  padding: 6px 8px 6px 16px;
	  font-size: 20px;
	  text-decoration: none;
	  color: #2d2c31;
	  display: block;
	  margin-bottom: 10px;
	}
	.sidebar a:hover {
	  color: #47289e;
	}
	.main {
	  margin-left: 60px; /* Same as the width of the sidenav */
	  padding: 0px 10px;
	  height: 100%;
	}
	@media screen and (max-height: 450px) {
	  .sidebar {padding-top: 15px;}
	  .sidebar a {font-size: 18px;}
	}
	.profile {
	    background-color: #2d2c31;
	    width: 40px;
	    height: 40px;
	    position: fixed;
	    right: 1%;
	    bottom: 2%;
	    z-index: 2;
	    border-radius: 40px;
	    float: right;
	}
	.profile:hover {
		border: 1px solid #ddd;
	}
	.scribble-box {
	    width: 760px;
	    margin: 0px auto;
	    display: flex;
	    flex-direction: column;
	    height: 100%;
	    min-height: 100vh;
	    padding: 100px 0px;
	}
	.scribble-box input::placeholder, .scribble-box textarea::placeholder { color: #96989a; }
	.scribble-head {
	    display: flex;
	    align-items: flex-end;
	    padding: 15px 10px 10px 10px;
	    position: relative;
	}
	.scribble-poster { width: 20%; border: 1px solid #96989a; min-height: 200px; }
	.scribble-poster img { width: 100%; padding: 15px 10px 10px 10px; }
	.scribble-subject { width: 80%; position: relative; }
	.scribble-exit {
	    position: absolute;
	    right: 10px;
	    top: 20px;
	    font-size: 30px;
	    color: #2d2c31; 
	}
	.scribble-edit {
		position: absolute;
	    right: 40px;
	    top: 23px;
	    font-size: 24px;
	    color: #2d2c31; 
	}
	.scribble-delete {
		position: absolute;
	    right: 70px;
	    top: 23px;
	    font-size: 24px;
	    color: #2d2c31; 
	}
	.scribble-exit:hover, .scribble-edit:hover, .scribble-delete:hover { color: #96989a; text-decoration: none; }
	.scribble-date {
	    font-size: 25px;
	    color: #2d2c31;
	    padding: 10px;
	    margin-bottom: 0px;
	    border: none;
	    display: none;
	    cursor: text;
	}
	.scribble-date:focus-visible {
		border: none;
		outline: none;
	}
	#date-placeholder {
	    font-size: 25px;
	    color: #96989a;
	    padding: 10px;
	    margin-bottom: 0px;
	}
	input[type="date"]::-webkit-calendar-picker-indicator {
	  cursor: pointer;
	  opacity: 0.8;
	  filter: invert(0.5);
	  margin-left: -5px;
	  height: 30px;
	}
	.scribble-title {
	    font-size: 32px;
	    padding: 10px;
	    color: #2d2c31;
	    border: none;
	    width: 100%;
	}
	.scribble-title-result {
		position: absolute;
		width: 356px;
		display: none;
	}
	.scribble-title:focus + .scribble-title-result, .scribble-title-result:hover {
		display: flex;
		flex-direction: column;
	}
	.scribble-info {
	    display: flex;
	    flex-direction: column;
	}
	.scribble-row1 {
	    display: flex;
	    border-top: 1px solid #96989a;
	    border-bottom: 1px solid #96989a;
	}
	.scribble-rate {
	    width: 22%;
	    text-align: center;
	    border-right: 1px solid #96989a;
	    padding: 10px;
	    color: #96989a; 
	}
	.scribble-kino {
		width: 78%;
		padding: 10px;
		postion: relative;
	}
	#kino { border: none; color: #2d2c31; }
	.scribble-kino-list {
		position: absolute;
		max-height: 150px;
		display: none;
		background-color: #fff;
		border: 1px solid #96989a;
		overflow: hidden;
	}
	.scribble-kino-list a {
		padding: 5px;
		color: #2d2c31;
		cursor: pointer;
	}
	.scribble-kino-list a:hover {
		color: #fff;
		background-color: #96989a;
		text-decoration: none;
	}
	#kino:focus + .scribble-kino-list, .scribble-kino-list:hover {
		display: flex;
	}
	.kino-brand-section, .kino-province-section, .kino-district-section, .kino-section {
		display: flex;
		flex-direction: column;
	}
	.kino-province-section, .kino-district-section, .kino-section {
		overflow-y: scroll;
		-ms-overflow-style: none; /* IE and Edge */
    	scrollbar-width: none; /* Firefox */
	}
	.kino-province-section::-webkit-scrollbar, .kino-district-section::-webkit-scrollbar, .kino-section::-webkit-scrollbar {
	    display: none; /* Chrome, Safari, Opera*/
	}
	.kino-brand-section, .kino-province-section, .kino-district-section {
		border-right: 1px solid #96989a;
	}
	.scribble-row2 {
	    display: flex;
	    border-bottom: 1px solid #96989a;
	}
	.scribble-row2 input[type=text] { border: none; }
	.scribble-row2 input[type=text]:focus { outline: none; }
	.scribble-row2 textarea { border: none; resize: none; width: 100%; }
	.scribble-row2 > div { width: 50%; padding: 10px; }
	.scribble-info-group {
		display: flex;
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
	.scribble-tag {
	    padding: 10px 40px;
	    color: #2d2c31;
	    border-bottom: 1px solid #96989a;
	    display: flex;
	    align-items: center;
	}
	.input-box {
		border: none;
	}
	.tag-btn {
		font-weight: bold;
		cursor: pointer;
		border: 1px solid #96989a;
		border-radius: 15px;
		padding: 5px 10px;
		color: #343E97;
		margin: 0px 5px 0px 0px;
	}
	.scribble-tag-result {
		display: none;
		position: absolute;
		width: fit-content;
	}
	#scribble-tag:focus + .scribble-tag-result, .scribble-tag-result:hover {
		display: flex;
		flex-direction: column;
	}
	.scribble-content {
	    flex-grow: 1;
	    padding: 20px 40px;
	    color: #2d2c31;
	}
	#scribble {
		resize: none;
		height: auto;
		border: none;
	}
	.scribble-foot {
	    text-align: center;
	}
	.btn-round-light {
		border: 1px solid #96989a;
		background-color: transparent;
		border-radius: 30px;
	}
	.btn-round-light:hover {
		background-color: #2d2c31;
		color: white;
	}
	.calendar-menu {
	    position: absolute;
	    left: 60px;
	    border: 1px solid #ddd;
	    width: 100px;
	    height: 70px;
	    top: 54px;
	    padding: 0px;
	    display: none;
	    margin: 0px;
	}
	.calendar-menu-item {
		list-style: none;
	    padding: 1px 0px;
	  		text-align: center;
	  		flex-grow: 1;
	}
	.calendar-icon:hover { width: 160px; }
	.calendar-icon:hover .calendar-menu {
		display: flex;
		flex-direction: column;
	}
	.scribble-rate input[type=radio] { display: none; }
	.star { cursor: pointer; font-size: 15px; margin-bottom: 0px; line-height: inherit; vertical-align: middle; }
	
	.detail-title, .detail-kino { margin-bottom: 0px; margin-block-start: 0px; }
	
	/* scribble-list */
	.list-container {
		height: 100%;
		display: flex;
		overflow: hidden;
	}
	.left-list-bar {
	    width: 20%;
	    max-width: 200px;
	    height: 100%;
	    margin: 20px 0px 0px 10px;
	}
	.list-bar-title, .info-item-title {
		font-weight: bold;
		color: #343E97;
		font-size: 18px;
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
		margin-top: 50px;
		padding-bottom: 10px;
		border-bottom: 1px solid #96989a;
		padding-right: 200px;
	}
	.scribble-list-content {
		flex-grow: 1;
		overflow: scroll;
		padding-right: 200px;
	}
	.list-sort, .list-search { display: flex; }
	#list-search { display: flex; justify-content: space-between; width: 100%; }
	.divider { font-size: 20px; }
	.scribble-list-header select { border: none; }
	.search-input { 
		border-radius: 15px; 
		border: 1px solid #96989a; 
		padding: 0px 30px 0px 5px;
	}
	.search-input:focus { outline: none; }
	.search-btn { 
		margin-left: -30px; 
		border: none; 
		background-color: transparent; 
		padding: 0px;
	}
	.scribble-content-item {
		padding: 25px;
		display: flex;
	}
	.scribble-item-info { width: 85%; display: flex; flex-direction: column; }
	.scribble-item-poster { width: 15%; text-align: center; }
	.scribble-item-poster img { border-radius: 5px; }
	.info-item { display: flex; justify-content: space-between; align-items: center; }
	.info-item-rank, .info-item-tags { font-size: 12px; }
	.info-item-tags { font-weight: bold; color: #343E97; }
	.info-item-content { margin: 15px 0px; flex-grow: 1; }
	.info-item-foot { display: flex; justify-content: space-between; }
	.info-item-favorite { display: flex; justify-content: end; }
	.favorite-icon { font-size: 18px; color: #343E97; align-self: center; }
	.favorite { width: 30px; color: #343E97; font-weight: bold; text-align: right; }
	.favorite-icons { cursor: pointer; color: #2d2c31; }
	.favorite-icons:hover { text-decoration: none; color: #96989a; }
	#writer-img { background-color: #2d2c31; border-radius: 30px; width: 30px; height: 30px; border: none;  }
	#writer-name { margin-left: 5px; font-weight: bold; }
		
	/* detail */
	.tag-view {
	    font-weight: bold;
	    border: 1px solid #96989a;
	    border-radius: 15px;
	    padding: 5px 10px;
	    color: #343E97;
	    margin: 0px 5px 0px 0px;
	}
	.star-view { 
		font-size: 15px; 
		margin-bottom: 0px; 
		line-height: inherit; 
		vertical-align: middle; 
		color: #2d2c31;
	}
	
	/* delete */
	.password-check {
		display: flex;
		border-top: 1px solid #96989a;
		padding-top: 20px;
	}
	.password-left { width: 20%; }
	.password-right { width: 80%; }
	#password { border-radius: 0; }
	.password-desc { color: #96989a; margin-top: 5px; }
	.btn-round-dim {
		border: 1px solid #96989a;
		background-color: #96989a;
		border-radius: 30px;
		color: white;
	}
	.btn-round-light:hover {
		background-color: #2d2c31;
		color: white;
	}
  </style>
</head>
<body>
	<div class="sidebar">
	  <a href="<c:url value="/main.do" />" class="sidebar-menu"><span class="material-icons sidebar-icon">home</span></a>
	  <div class="calendar-icon">
	  	<a href="<c:url value="/calendar/monthly" />" class="sidebar-menu"><span class="material-icons sidebar-icon">date_range</span></a>
	  	<div class="calendar-menu">
	  		<a class="calendar-menu-item btn btn-round-light" href="<c:url value="/calendar/monthly" />">월별</a>
			<a class="calendar-menu-item btn btn-round-light" href="<c:url value="/calendar/weekly" />">주차별</a>
		</div>
	  </div>
	  <a href="<c:url value="/scribble/list" />" class="sidebar-menu"><span class="material-icons sidebar-icon">format_list_bulleted</span></a>
	  <a href="<c:url value="/scribble/write" />" class="sidebar-menu"><span class="material-icons sidebar-icon">edit</span></a>
	</div>
