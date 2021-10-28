var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1;
var yyyy = today.getFullYear();
if(dd < 10){ dd = '0' + dd }
if(mm < 10){ mm = '0' + mm }
today = yyyy + '-' + mm + '-' + dd;
var dTitle = $("<a>").html("시/군/구").attr('class', 'kino-district');
var kTitle = $("<a>").html("극장명").attr('class', 'kino');

function getContextPath() { // contextPath 구하는 함수
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function star(tg, status, color) {
	tg.html(status); tg.css('color', color);
	tg.prevAll('.star').html(status); tg.prevAll('.star').css('color', color);			
}
function auto_resize(comp) { // textarea auto resize
	$(comp).css('height', 'auto');
	var adjustHeight = (12 + comp.scrollHeight) + 'px';
	$(comp).css('height', adjustHeight);
}
function clicked(target) { // button click
	var tclass= target.attr('class');
	target.css({'background-color':'#2d2c31', 'color':'#fff'});
	target.nextAll("." + tclass).css({'background-color':'#fff', 'color':'#2d2c31'});
	target.prevAll("." + tclass).css({'background-color':'#fff', 'color':'#2d2c31'});
} 
$('.scribble-date').attr('max', today);
$('.scribble-date').css('display', 'block');

$(function() {
	if($('.tag-btn').length==5) { $('#scribble-tag').hide(); }
});
$(document).ready(function() {
	$('input[name=srate]').val(srate).prop('checked', true);
	star($('input[name=srate]').val(srate), 'star', '#2d2c31');
});
$(".star").on('click' ,function() {
	$(".star").off('mouseenter mouseleave');
	if($(this).text()=='star_border') {
		star($(this), 'star', '#2d2c31');
	} else if($(this).text()=='star') {
		$(this).nextAll('.star').html('star_border');
		$(this).nextAll('.star').css('color', '#96989a');
	}
});
$('#scribble').on('keyup', function() { auto_resize(this); });
$('#scribble').on('keydown', function() { auto_resize(this); });
$('.result-set input[type=button]').on('click', function() {
	$(this).closest('.result-set').prev('input[type=text]').val($(this).val());
});
$('.kino-brand').on('click', function() {
	kbrand = $(this).text(); clicked($(this)); 
	$.ajax({
		url: getContextPath()+"/find/kinoProvince", type:"get", dataType:"json",
		success:function(data){
			$('.kino-province-section').html(''); // 기존 리스트 비우기
			$('.kino-district-section').html(dTitle);
			$('.kino-section').html(kTitle);
			for(var i=0; i<data.length; i++) {
				var a = $("<a>").attr('class', 'kino-province').html(data[i]);
				$('.kino-province-section').append(a);
			}
		}, data:{"kbrand":kbrand},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}	
	});
}); // select kino brand
$(document).on('click', '.kino-province', function() {
	kprovince = $(this).text(); 
	if(kprovince!="시/도") {
		clicked($(this)); 
		$.ajax({
			url: getContextPath()+"/find/kinoDistrict", type:"get", dataType:"json",
			success:function(data){
				$('.kino-district-section').html(''); // 기존 리스트 비우기
				$('.kino-section').html(kTitle);
				for(var i=0; i<data.length; i++) {
					var a = $("<a>").attr('class', 'kino-district').html(data[i]);
					$('.kino-district-section').append(a);
				}
			}, data:{"kbrand":kbrand, "kprovince":kprovince},
			error:function(xhr, textStatus, errorThrown){
				alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
			}	
		});
	}
}); // select kino province
$(document).on('click', '.kino-district', function() {
	kdistrict = $(this).text();
	if(kdistrict!="시/군/구") {
		clicked($(this)); 
		$.ajax({
			url: getContextPath()+"/find/kino", type:"get", dataType:"json",
			success:function(data){
				$('.kino-section').html(''); // 기존 리스트 비우기
				for(var i=0; i<data.length; i++) {
					var a = $("<a>").attr('class', 'kino').html(data[i]);
					$('.kino-section').append(a);
				}
			}, data:{"kbrand":kbrand, "kprovince":kprovince, "kdistrict":kdistrict},
			error:function(xhr, textStatus, errorThrown){
				alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
			}	
		});
	}
}); // select kino district
$(document).on('click', '.kino', function() {
	var kino = $(this).text();
	if(kino!="극장명") { clicked($(this)); $('#kino').val(kino); }
}); // select kino
$(document).on('click', '.tag-result-set input[type=button]', function() {
	var dup = false;
	var tag = $(this).val();
	var input = $('#scribble-tag').val().replace(/\s/g, '_'); // replaceAll 기능을 정규식으로 대체
	$('.tag-btn').each(function() {
		var target = $(this).text().replace("# ", "");
		if(target==tag||target==input) { dup = true; $('#scribble-tag').val(""); return false; }
	});
	
	if(dup) { return; }
	else if(tag!="태그 추가하기") {
		var span = $('<span>').attr('class', 'tag-btn').html("# " + tag);
		$('.tag-box').before(span);
		return;
	} else if(input!=""&&!dup){
		var span = $('<span>').attr('class', 'tag-btn').html("# " + input);
		$('.tag-box').before(span);
		$('#scribble-tag').val("");
	}
	if($('.tag-btn').length==5) { $('#scribble-tag').hide(); }
}); // insert tags
$(document).on('click', '.tag-btn', function() { 
	$(this).remove(); 
	if($('.tag-btn').length<5) { $('#scribble-tag').show(); }
});	// delete tag
$('#scribble-tag').on('input', function() {
	var tag = $(this).val();
	if(tag=="") { $('.tag-result-set').html(''); return; }
	$.ajax({
		url: getContextPath()+"/find/tag", type:"get", dataType:"json",
		success:function(data){
			$('.tag-result-set').html('');
			if(data.length==0) { 
				var input = $("<input>").attr({'type':'button', 'class':'list-group-item'}).val('태그 추가하기');
				$('.tag-result-set').html(input); 
			}
			for(var i=0; i<data.length; i++) {
				var input = $("<input>").attr({'type':'button', 'class':'list-group-item tag-result'}).val(data[i]);
				$('.tag-result-set').append(input);
			}
		}, data:{"tag":tag},
		error:function(xhr, textStatus, errorThrown){
			alert(textStatus + "(HTTP- " + xhr.status + " / " + errorThrown);
		}	
	});
}); // call tags
$(document).on('submit', '#scribble-edit-form', function() {
	$('.tag-btn').each(function() {
		var target = $(this).text().replace("# ", "");
		$('#scribble-tags').val($('#scribble-tags').val() + target + "|");
	});
	var poster = $('.scribble-poster img').attr('src');
	$('#sposter').val(poster);
	
	if($('.scribble-rate input[type=radio]').is(':checked')==false) {
		alert('별점을 입력해주세요.'); return false;
	}
}); // star rate check & submit

