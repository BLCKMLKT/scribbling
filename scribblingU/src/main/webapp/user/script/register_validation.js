var regEmail = /^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\w+\.)+\w+$/; // 이메일
var regPass = /^(?=[\w\d!@#$%^&*]*[a-z])(?=[\w\d!@#$%^&*]*\d)(?=[\w\d!@#$%^&*]*[!@#$%^&*])[\w\d!@#$%^&*]{10,16}$/; // 비밀번호
var regDupl = /(\w)\1\1/; // 비밀번호 3자리 중복
var regName = /^[가-힣a-zA-Z]{2,}$/; // 이름
var allValid = false; var eValid = false; var p1Valid = false; var p2Valid = false;
var nValid = false; var bValid = false; var gValid = false; var aValid = false; var tValid = false;
$("#submit_btn").attr("disabled", !allValid);
function getContextPath() { // contextPath 구하는 함수
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function valid(tag) {
	var valid = "sentiment_very_satisfied";
	tag.html(valid);
	tag.css('color', 'DodgerBlue');
}
function invalid(tag) {
	var invalid = "sentiment_very_dissatisfied";
	tag.html(invalid);
	tag.css('color', 'Crimson');
}
function blank(tag) {
	tag.html("");
	tag.css('color', 'Black');
}
function checked(tag, tagChecked) {
	var isChecked = "check_circle_outline";
	var unChecked = "radio_button_unchecked";
	if(tagChecked) { tag.html(isChecked); tag.css('color', 'DodgerBlue'); }
	else { tag.html(unChecked); tag.css('color', '#777'); }
}
function validation() { // 유효성 검사
	allValid = eValid && p1Valid && p2Valid && nValid && bValid && gValid && aValid && tValid;
	$("#submit_btn").attr("disabled", !allValid);
}
function check_line(tag, message) {
	tag.css('display', 'block');
	tag.html(message);
}
function check_blank(tag) {
	tag.css('display', 'none');
}
function isDupl(msg) {
	// console.log('msg : ' + msg);
	if(msg=='dupl') {
		eValid = false; invalid($("#useremail + .isValid"));
		check_line($("#id-check"), "중복된 이메일입니다.");
	} else if(msg=='notDupl') { 
		eValid = true; valid($("#useremail + .isValid"));
		check_blank($("#id-check"));
	}
	validation();
}
function idDupl_check() {
	$.ajax({
		url:getContextPath()+"/account/id_check", type:"get", dataType:"json",
		data:{"useremail":$("#useremail").val()},
		async:true,
		success:function(data) {
			var result = data.result;
			isDupl(result);
		},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}
	});
}

$("#useremail").on('input', function(){
	if( $("#useremail").val()=="" ) {  // 이메일 빈칸 검사
		eValid = false; blank($("#useremail + .isValid"));
		check_blank($("#id-check")); 
	} else if(!regEmail.test($("#useremail").val())) { // 이메일 유효성 검사
		eValid = false; invalid($("#useremail + .isValid")); 
		check_line($("#id-check"), "이메일이 유효하지 않습니다.");
	} else {
		idDupl_check();
	} validation();
});
$("#userpw1").on('input', function(){
	if( $("#userpw1").val()=="" ) { // 비밀번호
		p1Valid = false; blank($("#userpw1 + .isValid")); 
		check_blank($("#pw-check"));
	} else if(!regPass.test($("#userpw1").val())) { 
		p1Valid = false; invalid($("#userpw1 + .isValid"));
		check_line($("#pw-check"), "비밀번호가 유효하지 않습니다.");
	} else if(regDupl.test($("#userpw1").val())) { 
		p1Valid = false; invalid($("#userpw1 + .isValid")); 
		check_line($("#pw-check"), "3자리 이상 같은 글자가 반복됩니다.");
	} else { 
		p1Valid = true; valid($("#userpw1 + .isValid"));
		check_blank($("#pw-check"));
	} validation();
});
$("#userpw2").on('input', function(){
	if( $("#userpw2").val()=="" ) { // 비밀번호 확인 
		p2Valid = false; blank($("#userpw2 + .isValid")); 
		check_blank($("#pw-check"));
	} else if($("#userpw2").val()!=$("#userpw1").val()) { 
		p2Valid = false; invalid($("#userpw2 + .isValid"));
		check_line($("#pw-check"), "비밀번호 확인이 일치하지 않습니다.");
	} else { 
		p2Valid = true; valid($("#userpw2 + .isValid")); 
		check_blank($("#pw-check"));
	} validation();
});
$("#username").on('input', function(){
	if( $("#username").val()=="" ) { nValid = false; blank($("#username + .isValid")); } // 이름
	else if(!regName.test($("#username").val())) { nValid = false; invalid($("#username + .isValid")); }
	else { nValid = true; valid($("#username + .isValid")); }
	validation();
});
$(".select-group select").on('change', function(){
	if( $("#sel1").val()=="출생년도" ) { bValid = false; } // 출생연도
	else if( $("#sel2").val()=="월" ) { bValid = false; } // 출생월
	else if( $("#sel3").val()=="일" ) { bValid = false; } // 출생일
	else { bValid = true; }
	validation();
});
$(".gender-group input").on('click', function(){
	if($("#gender1").is(':checked')) { gValid = true; }
	else if($("#gender2").is(':checked')) { gValid = true; }
	else if($("#gender3").is(':checked')) { gValid = true; }
	else { gValid = false; }
	validation();
});
$("#address2").on('input', function(){
	if( $("#address1").val()=="" ) { aValid = false; }
	else if( $("#address2").val()=="" ) { aValid = false; blank($("#address2 + .isValid")); }
	else { aValid = true; valid($("#address2 + .isValid")); }
	validation();
});

$("#agree_all").on('click', function(){ // 약관 전체 동의
	var agree_all = $("#agree_all").is(":checked");
	$(".agreement-sub-group input").prop("checked", agree_all);
	checked($(".agreement-all .isChecked"), agree_all);
	checked($(".agreement-sub-item .isChecked"), agree_all);
	tValid = agree_all; validation();
});
$(".agreement-sub-item > input").on('click', function(){ // 개별 동의
	var allChecked = true;
	$(".agreement-sub-item > input").each(function(){
		allChecked = allChecked && $(this).is(":checked");
		// console.log('1. ' + this + allChecked);
    });
	checked($(".agreement-all .isChecked"), allChecked);
	$("#agree_all").prop("checked", allChecked);
	if( $("#agreement").is(":checked") == false ) { tValid = false; }
	else if( $("#privacy").is(":checked") == false ) { tValid = false; }
	else { tValid = true; }
	validation();
});
$("#agreement").on('click', function(){
	var isChecked = $("#agreement").is(':checked');
	// console.log(isChecked);
	checked($("#agreement-check"), isChecked);
});
$("#privacy").on('click', function(){
	var isChecked = $("#privacy").is(':checked');
	// console.log(isChecked);
	checked($("#privacy-check"), isChecked);
});
$("#marketing").on('click', function(){
	var isChecked = $("#marketing").is(':checked');
	// console.log(isChecked);
	checked($("#marketing-check"), isChecked);
});
// Terms modal
$("#serviceTermsModal").on('click', function(){
	$("#serviceTerms").load("../user/terms/serviceTerms.html");
});
$("#privacyTermsModal").on('click', function(){
	$("#privacyTerms").load("../user/terms/privacyTerms.html");
});
$("#marketingTermsModal").on('click', function(){
	$("#marketingTerms").load("../user/terms/marketingTerms.html");
});