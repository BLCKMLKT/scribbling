package com.company.service;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.company.dto.FilmVO;
import com.company.dto.KinoVO;
import com.company.dto.ScribbleVO;
import com.company.dto.SearchVO;
import com.company.dto.TagVO;
import com.company.mapper.FilmMapper;
import com.company.mapper.KinoMapper;
import com.company.mapper.ScribbleMapper;
import com.company.mapper.TagMapper;

@Service
public class ScribbleServiceImpl implements ScribbleService {
	@Autowired
	private ScribbleMapper smapper;
	@Autowired
	private FilmMapper fmapper;
	@Autowired
	private KinoMapper kmapper;
	@Autowired
	private TagMapper tmapper;
	
	@Transactional
	@Override
	public Integer scribbleInsert(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		try {
			// 1. films 테이블에서 fcode 찾기
			FilmVO fvo = new FilmVO();
			String param = request.getParameter("stitle");
			String fname = param.substring(0, param.length()-6); // 개봉연도 제거
			fvo.setFname(fname);
			fvo.setFrelease(Integer.parseInt(request.getParameter("srelease")));
			fvo.setFdirector(request.getParameter("sdirector"));
			fvo.setFcast(request.getParameter("scast"));
			fvo.setFimg(request.getParameter("sposter"));
			fvo.setFcode(fmapper.searchFilm(fvo)); // fcode 찾아오기
			if(fvo.getFcode()==null) { fmapper.insertFilm(fvo); } // 등록하기
			// 2. kinos 테이블에서 kcode 찾기
			KinoVO kvo = new KinoVO();
			kvo.setKname(request.getParameter("skino"));
			kvo.setKcode(kmapper.searchKino(kvo.getKname()));
			// 3. scribbles 테이블에 스크리블 등록
			ScribbleVO shvo = new ScribbleVO();
			shvo.setSdate(request.getParameter("sdate"));
			shvo.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
			shvo.setFvo(fvo); shvo.setKvo(kvo);
			String srateParam = request.getParameter("srate");
			if(srateParam!=null) { shvo.setSrate(Integer.parseInt(srateParam)); } 
			shvo.setScontent(request.getParameter("scontent"));
			shvo.setSip(InetAddress.getLocalHost().getHostAddress());
			smapper.insertScribble(shvo);
			// 4. tag_library에서 tid 찾기
			String[] tnames = request.getParameter("stags").split("\\|");
			TagVO tvo = new TagVO();
			tvo.setSno(shvo.getSno()); tvo.setFcode(shvo.getFvo().getFcode());
			for(int i=0; i<tnames.length; i++) {
				tvo.setTname(tnames[i]);
				tvo.setTid(tmapper.searchTaglib(tvo));
				if(tvo.getTid()==null) { tmapper.insertTaglib(tvo); }
				tmapper.insertTag(tvo);
			} // tid 찾기 or 태그 라이브러리에 등록하기 & 태그 등록하기
	    } catch(Exception e) {
	        e.printStackTrace();
	    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        return -1; // 오류 발생 시 빠져나가기
	    }
		return 1; // 성공 시
	}

	@Override
	public List<ScribbleVO> scribbleList(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		SearchVO shvo = new SearchVO();
		shvo.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
		shvo.setStartNum(0); shvo.setPageLmt(10); shvo.setOrder("lat");
		if(request.getParameter("startNum")!=null) { // 페이지 시작 번호
			shvo.setStartNum(Integer.parseInt(request.getParameter("startNum")));
		} 
		if(request.getParameter("page_limit")!=null) { // 한 페이지에 표시할 게시글 수
			shvo.setPageLmt(Integer.parseInt(request.getParameter("page_limit")));
		}
		if(request.getParameter("sort_order")!=null) { // 정렬
			shvo.setOrder(request.getParameter("sort_order"));
		}
		if(request.getParameter("search_option")!=null) { // 검색 조건
			shvo.setOption(request.getParameter("search_option"));
		}
		if(request.getParameter("search_input")!=null) { // 검색어
			shvo.setKeyword(request.getParameter("search_input"));
		}
		List<ScribbleVO> sList = smapper.listScribble(shvo);
		request.setAttribute("shvo", shvo); // 현재 설정 결과페이지에 넘기기
		return sList;
	}

	@Override
	public ScribbleVO scribbleDetail(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		Integer uno = (Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno");
		Integer sno = Integer.parseInt(request.getParameter("sno"));
		return smapper.detailScribble(uno, sno);
	}

	@Transactional
	@Override
	public int scribbleEdit(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		try {
			// 1. kinos 테이블에서 kcode 찾기
			KinoVO kvo = new KinoVO();
			kvo.setKname(request.getParameter("skino"));
			kvo.setKcode(kmapper.searchKino(kvo.getKname()));
			// 2. films 테이블에서 fcode 찾기
			FilmVO fvo = new FilmVO();
			String param = request.getParameter("stitle");
			String fname = param.substring(0, param.length()-6); // 개봉연도 제거
			int frelease = Integer.parseInt(param.substring(param.length()-5, param.length()-1));
			fvo.setFname(fname); fvo.setFrelease(frelease);
			fvo.setFcode(fmapper.searchFilm(fvo)); // fcode 찾아오기
			// 3. scribbles 테이블 수정
			ScribbleVO shvo = new ScribbleVO();
			shvo.setSno(Integer.parseInt(request.getParameter("sno")));
			shvo.setSdate(request.getParameter("sdate")); shvo.setFvo(fvo); shvo.setKvo(kvo);
			shvo.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
			String srateParam = request.getParameter("srate");
			if(srateParam!=null) { shvo.setSrate(Integer.parseInt(srateParam)); } 
			shvo.setScontent(request.getParameter("scontent"));
			shvo.setSip(InetAddress.getLocalHost().getHostAddress());
			smapper.editScribble(shvo);
			// 4. 태그 수정
			String[] tnames = request.getParameter("stags").split("\\|");
			TagVO tvo = new TagVO();
			tvo.setSno(shvo.getSno()); tvo.setFcode(shvo.getFvo().getFcode());
			tmapper.deleteTag(tvo); // 기존 태그 삭제
			for(int i=0; i<tnames.length; i++) {
				tvo.setTname(tnames[i]);
				tvo.setTid(tmapper.searchTaglib(tvo));
				if(tvo.getTid()==null) { tmapper.insertTaglib(tvo); }
				tmapper.insertTag(tvo);
			} // tid 찾기 or 태그 라이브러리에 등록하기 & 태그 등록하기
	    } catch(Exception e) {
	        e.printStackTrace();
	    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        return -1; // 오류 발생 시 빠져나가기
	    }
		return 1;
	}
}
