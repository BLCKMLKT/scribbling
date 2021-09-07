var regPass = /^(?=[\w\d!@#$%^&*]*[a-z])(?=[\w\d!@#$%^&*]*\d)(?=[\w\d!@#$%^&*]*[!@#$%^&*])[\w\d!@#$%^&*]{10,16}$/; // 비밀번호
var regDupl = /(\w)\1\1/; // 비밀번호 3자리 중복
function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function invalid(tag, message) {
	tag.css('display', 'block'); 
	tag.html(message); 
	tag.focus();
}
function pass_edit() {
	$.ajax({
		url:getContextPath()+"/account/edit_password", type:"get", dataType:"json",
		success:function(data){
			var result = data.result;
			var message = data.message;
			// console.log(result + " / " + message);
			if(result=="fail") { invalid($("#pass-alert"), message); }
			else if(result=="success") { $("#pass-alert").html("비밀번호 변경에 성공했습니다."); }
			else { alert('오류'); }
		}, data:{"upassword_orig":$("#upassword_orig").val(), "upassword_new":$("#upassword_new").val(), "upassword_conf":$("#upassword_conf").val()},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}
	});
}
$(function() {
	if(gender=='m') { $("#gender11").prop('checked', 'checked'); }
	else if(gender=='f') { $("#gender12").prop('checked', 'checked'); }
	else if(gender=='n') { $("#gender13").prop('checked', 'checked'); }
});
$("#upassword_edit").on('click', function(){
	console.log($("#upassword_orig").val() + " / " + $("#upassword_new").val() + " / " + $("#upassword_conf").val());
	if($("#upassword_orig").val()=="") { invalid($("#pass-alert"), "기존 비밀번호를 입력해주세요."); } 
	else if($("#upassword_new").val()=="") { invalid($("#pass-alert"), "새 비밀번호를 입력해주세요."); }
	else if($("#upassword_conf").val()=="") { invalid($("#pass-alert"), "새 비밀번호 확인을 입력해주세요."); }
	else if($("#upassword_orig").val()==$("#upassword_new").val()) { invalid($("#pass-alert"), "새 비밀번호가 기존 비밀번호와 같습니다."); }
	else if(!regPass.test($("#upassword_new").val())) { invalid($("#pass-alert"), "영문,숫자,특문 포함 10~13자리로 입력해주세요."); }
	else if(regDupl.test($("#upassword_new").val())) { invalid($("#pass-alert"), "3자리 이상 같은 글자가 반복됩니다."); }
	else { pass_edit(); }
});
