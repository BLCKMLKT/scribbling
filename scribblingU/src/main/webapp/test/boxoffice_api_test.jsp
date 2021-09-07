<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>HTML BASIC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>   
    </head>
<body>
</body>
<script>
$("").on('click', function() {
	$.ajax({
		url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json", 
		type:"get", dataType:"json",
		success:function(data){
			
		}, data:{
			"key":"dabd87756e9bed1f64e135108b92f184", 
			"login_pw":$("#login_pw").val()
		},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}
	});
});
</script>
</html>