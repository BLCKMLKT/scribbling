<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/sidebar.jsp" %>
<!-- sidebar -->
<div class="main">
	<div class="container">
		<div class="scribble-box">
			<form action="" method="post" id="scribble-form">
				<fieldset>
					<div class="scribble-head">
						<div class="scribble-poster">
							<img src="${pageContext.request.contextPath}/" alt=""/>
						</div>
						<div class="scribble-subject">
							<p id="date-placeholder">언제 영화를 보셨나요?</p>
							<input type="date" class="scribble-date" min="1950-01-01" name="sdate" />
							<input type="text" class="scribble-title input-box" name="stitle" placeholder="어떤 영화를 보셨나요?" />
							<div class="scribble-title-result result-set">
								<input type="button" class="list-group-item" id="button1" value="result1"/>
								<input type="button" class="list-group-item" value="result2"/>
								<input type="button" class="list-group-item" value="result3"/>
							</div>
						</div>
						<a href="<c:url value="/scribble/list" />" class="material-icons scribble-exit">close</a>
					</div>
					<div class="scribble-info">
						<div class="scribble-row1">
							<div class="scribble-rate">
								<input type="radio" id="rate1" name="srate" value="1" /><label for="rate1" class="material-icons star">star_border</label>
								<input type="radio" id="rate2" name="srate" value="2" /><label for="rate2" class="material-icons star">star_border</label>
								<input type="radio" id="rate3" name="srate" value="3" /><label for="rate3" class="material-icons star">star_border</label>
								<input type="radio" id="rate4" name="srate" value="4" /><label for="rate4" class="material-icons star">star_border</label>
								<input type="radio" id="rate5" name="srate" value="5" /><label for="rate5" class="material-icons star">star_border</label>
							</div>
							<div class="scribble-kino">
								<input type="text" id="kino" name="skino" class="input-box" placeholder="어디서 보셨나요?" />
								<div class="scribble-kino-result result-set">
									<input type="button" class="list-group-item" value="result1"/>
									<input type="button" class="list-group-item" value="result2"/>
									<input type="button" class="list-group-item" value="result3"/>
								</div>
							</div>
						</div>
						<div class="scribble-row2">
							<div class="scribble-filmInfo">
								<p class="scribble-info-group">
									<span class="scribble-info-title">개봉일</span>
									<span class="scribble-info-item">0000.00.00</span>
								</p>
								<p class="scribble-info-group">
									<span class="scribble-info-title">국가</span>
									<span class="scribble-info-item">ㅇㅇㅇㅇ</span>
								</p>
								<p class="scribble-info-group">
									<span class="scribble-info-title">감독</span>
									<span class="scribble-info-item">ㅇㅇㅇ</span>
								</p>
							</div>
							<div class="scribble-cast scribble-info-group">
								<div class="scribble-info-title">
									<span>출연진</span>
								</div>
								<div class="scribble-info-item">
									<p>ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ ㅇㅇㅇ</p>
								</div>
							</div>
						</div>
					</div>
					<div class="scribble-tag">
						<span class="tag-btn"># 사극</span> <!-- 테스트용 -->					
						<div class="tag-box">
							<input type="hidden" id="scribble-tags" name="tags" />
							<input type="text" id="scribble-tag" class="input-box" placeholder="#이_영화는_어떤_느낌?" />
							<div class="scribble-tag-result tag-result-set">
								<input type="button" class="list-group-item" value="result1"/>
								<input type="button" class="list-group-item" value="result2"/>
								<input type="button" class="list-group-item" value="태그 추가하기"/>
							</div>
						</div>
					</div>
					<div class="scribble-content">
						<textarea id="scribble" name="scontent" rows="5" cols="95" placeholder="영화는 어땠나요?"></textarea>
					</div>
					<div class="scribble-foot">
						<input type="submit" class="btn btn-round-light" value="scribble it!" />
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script>
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1;
		var yyyy = today.getFullYear();
		if(dd < 10){ dd = '0' + dd }
	    if(mm < 10){ mm = '0' + mm }
		today = yyyy + '-' + mm + '-' + dd;
		$('.scribble-date').attr('max', today);

		function star(tg, status, color) {
			tg.html(status); tg.css('color', color);
			tg.prevAll('.star').html(status); tg.prevAll('.star').css('color', color);			
		}
		$(".star").on('mouseenter', function() { star($(this), 'star', '#2d2c31'); });
		$(".star").on('mouseleave', function() { star($(this), 'star_border', '#96989a'); });
		$(".star").click(function() {
			$(".star").off('mouseenter mouseleave');
			if($(this).text()=='star_border') {
				star($(this), 'star', '#2d2c31');
			} else if($(this).text()=='star') {
				$(this).nextAll('.star').html('star_border');
				$(this).nextAll('.star').css('color', '#96989a');
			}
		});
		
		$("#date-placeholder").hover(function() {
			$(this).css('display', 'none');
			$('.scribble-date').css('display', 'block');
		});
		
		function auto_resize(comp) {
			$(comp).css('height', 'auto');
			var adjustHeight = (12 + comp.scrollHeight) + 'px';
			$(comp).css('height', adjustHeight);
		}
		$('#scribble').on('keyup', function() {
			auto_resize(this);
		});
		$('#scribble').on('keydown', function() {
			auto_resize(this);
		});
		
		$('.result-set input[type=button]').on('click', function() {
			$(this).closest('.result-set').prev('input[type=text]').val($(this).val());
		});
		
		$('.tag-result-set input[type=button]').on('click', function() {
			if($(this).val()!="태그 추가하기") {
				var span = $('<span>');
				span.attr('class', 'tag-btn');
				span.html("# " + $(this).val());
				$('.tag-box').before(span);
			} else if($('#scribble-tag').val()!=""){
				var span = $('<span>');
				span.attr('class', 'tag-btn');
				span.html("# " + $('#scribble-tag').val().replace(' ', '_'));
				$('.tag-box').before(span);
				$('#scribble-tag').val("");
			}
		});
		$(document).on('click', '.tag-btn', function() {
			console.log('clicked');
			$(this).remove();
		});			
	</script>
</div>
<!-- profile -->
<%@ include file="../inc/profile.jsp" %>
