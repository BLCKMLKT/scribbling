var regEmail = /^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\w+\.)+\w+$/; // 이메일
function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function valid(tag) {
	var valid = "sentiment_very_satisfied";
	tag.html(valid);
	tag.css('color', 'DodgerBlue');
	$('#login-check').css('display', 'none');
}
function invalid(tag) {
	var invalid = "sentiment_very_dissatisfied";
	tag.html(invalid);
	tag.css('color', 'Crimson');
}
function blank(tag) {
	tag.html("");
	tag.css('color', 'Black');
	$('#login-check').css('display', 'none');
}
function check_line(tag, message) {
	tag.css('display', 'block');
	tag.html(message);
}
function login_confirm() {
	$.ajax({
		url: getContextPath()+"/account/login_confirm", type:"get", dataType:"json",
		success:function(data){
			var email_confirm = data.uemail;
			var password_confirm = data.upassword;
			console.log(data.uemail + " / " + data.upassword);
			if(email_confirm=="notFound") { 
				check_line($('#login-check'), '일치하는 정보가 없습니다.');
			} else if (password_confirm=="notMatch") { 
				check_line($('#login-check'), '비밀번호가 일치하지 않습니다.');
			} else if (email_confirm=="found"&&password_confirm=="match") { 
				$('#login-check').css('display', 'none');
				$("#login").submit();
			}
		}, data:{"login_email":$("#login_email").val(), "login_pw":$("#login_pw").val()},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}
	});
}
$("#login_submit_btn").click(function() {
	if( $("#login_email").val()=="" )  { 
		$("#login_email").focus(); 
		invalid($("#login_email + .isValid")); 
		check_line($('#login-check'), "이메일을 입력해주세요.");
	} else if( $("#login_pw").val()=="" ) { 
		$("#login_pw").focus(); invalid($("#login_pw + .isValid")); 
		check_line($('#login-check'), "비밀번호를 입력해주세요.");
	} else { login_confirm(); }
});
//$("#login").submit(function(){
//	if( $("#login_email").val()=="" )  { 
//		$("#login_email").focus(); 
//		invalid($("#login_email + .isValid")); 
//		check_line($('#login-check'), "이메일을 입력해주세요.");
//		return false; 
//	} else if( $("#login_pw").val()=="" ) { 
//		$("#login_pw").focus(); invalid($("#login_pw + .isValid")); 
//		check_line($('#login-check'), "비밀번호를 입력해주세요.");
//		return false; 
//	} else { return login_confirm(); }
//});

$("#login_email").on('input', function(){
	if( $("#login_email").val()=="" ) { blank($("#login_email + .isValid")); } // 이메일 빈칸 검사
	else if(!regEmail.test($("#login_email").val())) { // 이메일 유효성 검사
		invalid($("#login_email + .isValid"));
		check_line($('#login-check'), "이메일 형식으로 입력해주세요.");
	} else { valid($("#login_email + .isValid")); } // 이메일 유효
});
$("#login_pw").on('input', function(){
	if( $("#login_pw").val()=="" ) { blank($("#login_pw + .isValid")); } // 비밀번호
	else { valid($("#login_pw + .isValid")); }
});