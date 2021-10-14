<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file= "./inc/header.jsp" %>
<!-- 		Header 		 -->
<div class="container-full">
	<div class="main-panel">
		<h3 class="panel-title">박스오피스 순위</h3>
		<div class="boxoffice-box">
		<c:forEach var="bovo" items="${boxoffice}" varStatus="status">
			<div class="boxoffice-item">
				<span class="boxoffice-rank">${status.index+1}</span>
				<p class="poster"><img src="${bovo.fimg}" class="img-rounded" alt="" /></p>
				<p class="title">${bovo.fname}</p>
			</div>
		</c:forEach>
		</div>
	</div>
	<hr class="solid">
	<div class="main-panel">
		<h3 class="">스크리블 인기 영화</h3>
		<div class="best-box">
			<div class="best-item">
				<p class="poster"><img src="https://pbs.twimg.com/media/E7C_SL-X0AA28LZ?format=jpg&name=4096x4096" class="img-rounded" alt="" /></p>
				<p><span class="hashtag">#aa</span><span class="hashtag">#bb</span><span class="hashtag">#cc</span></p>
				<p class="title">Slowacid Mark</p>
				<p class="sub-desc"><span class="release-date">2021</span><span class="country">TEN</span></p>
			</div>
			<div class="best-item">
				<p class="poster"><img src="https://pbs.twimg.com/media/E7C-pEUWYAYBbDV?format=jpg&name=4096x4096" class="img-rounded" alt="" /></p>
				<p><span class="hashtag">#aa</span><span class="hashtag">#bb</span><span class="hashtag">#cc</span></p>
				<p class="title">Slowacid Haechan</p>
				<p class="sub-desc"><span class="release-date">2021</span><span class="country">TEN</span></p>
			</div>
			<div class="best-item">
				<p class="poster"><img src="https://pbs.twimg.com/media/E7C_DVBX0AQGADi?format=jpg&name=4096x4096" class="img-rounded" alt="" /></p>
				<p><span class="hashtag">#aa</span><span class="hashtag">#bb</span><span class="hashtag">#cc</span></p>
				<p class="title">Slowacid Jungwoo</p>
				<p class="sub-desc"><span class="release-date">2021</span><span class="country">TEN</span></p>
			</div>
			<div class="best-item">
				<p class="poster"><img src="https://pbs.twimg.com/media/E695OkeUcAI2Rt6?format=jpg&name=4096x4096" class="img-rounded" alt="" /></p>
				<p><span class="hashtag">#aa</span><span class="hashtag">#bb</span><span class="hashtag">#cc</span></p>
				<p class="title">HelloFuture Jeno</p>
				<p class="sub-desc"><span class="release-date">2021</span><span class="country">TEN</span></p>
			</div>
			<div class="best-item">
				<p class="poster"><img src="https://pbs.twimg.com/media/E8BynHjVcAIsyf9?format=jpg&name=4096x4096" class="img-rounded" alt="" /></p>
				<p><span class="hashtag">#aa</span><span class="hashtag">#bb</span><span class="hashtag">#cc</span></p>
				<p class="title">Paint Me Naked</p>
				<p class="sub-desc"><span class="release-date">2021</span><span class="country">TEN</span></p>
			</div>
		</div>
		<div class="col-sm-12"><a class="more-btn">더보기</a></div>
	</div>
	<hr class="solid">
	<div class="container main-panel">
		<h2>테스트</h2>
	</div>
</div>
<script>
$(function(){
    $('.boxoffice-box').slick({
        slide: 'div',        //슬라이드 되어야 할 태그 ex) div, li 
        infinite : false,     //무한 반복 옵션     
        slidesToShow : 5,        // 한 화면에 보여질 컨텐츠 개수
        slidesToScroll : 1,        //스크롤 한번에 움직일 컨텐츠 개수
        speed : 100,     // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
        arrows : true,         // 옆으로 이동하는 화살표 표시 여부
        dots : true,         // 스크롤바 아래 점으로 페이지네이션 여부
        //autoplay : true,            // 자동 스크롤 사용 여부
        //autoplaySpeed : 10000,         // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
        //pauseOnHover : true,        // 슬라이드 이동    시 마우스 호버하면 슬라이더 멈추게 설정
        vertical : false,        // 세로 방향 슬라이드 옵션
        prevArrow : "<button type='button' class='material-icons btn-prev'>arrow_circle_left</button>",        // 이전 화살표 모양 설정
        nextArrow : "<button type='button' class='material-icons btn-next'>arrow_circle_right</button>",        // 다음 화살표 모양 설정
        dotsClass : "slick-dots",     //아래 나오는 페이지네이션(점) css class 지정
        draggable : true,     //드래그 가능 여부 
        
        responsive: [ // 반응형 웹 구현 옵션
            {  
                breakpoint: 960, //화면 사이즈 960px
                settings: {
                    //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
                    slidesToShow:3 
                } 
            },
            { 
                breakpoint: 768, //화면 사이즈 768px
                settings: {    
                    //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
                    slidesToShow:2 
                } 
            }
        ]

    });
  })
</script>
<!--		Footer 		 -->
<%@ include file="./inc/footer.jsp" %>
