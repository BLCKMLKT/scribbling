package com.company.service;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.company.dto.FilmVO;
import com.company.dto.KinoVO;
import com.company.dto.ScribbleVO;
import com.company.dto.ScribbleListvo;
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
	public Integer insertScribble(HttpServletRequest request) throws Exception {
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
			ScribbleVO svo = new ScribbleVO();
			svo.setSdate(request.getParameter("sdate"));
			svo.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
			svo.setFvo(fvo); svo.setKvo(kvo);
			String srateParam = request.getParameter("srate");
			if(srateParam!=null) { svo.setSrate(Integer.parseInt(srateParam)); } 
			svo.setScontent(request.getParameter("scontent"));
			svo.setSip(InetAddress.getLocalHost().getHostAddress());
			smapper.insertScribble(svo);
			// 4. tag_library에서 tid 찾기
			String[] tnames = request.getParameter("stags").split("\\|");
			TagVO tvo = new TagVO();
			tvo.setSno(svo.getSno()); tvo.setFcode(svo.getFvo().getFcode());
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
		int startNum = 0; int pageLmt = 10;
		Integer uno = (Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno");
		if(request.getParameter("startNum")!=null) {
			startNum = Integer.parseInt(request.getParameter("startNum"));
		}
		if(request.getParameter("pageLmt")!=null) {
			pageLmt = Integer.parseInt(request.getParameter("pageLmt"));
		}
		List<ScribbleVO> sList = smapper.listScribble(uno, startNum, pageLmt);
//		if(sList!=null) {
//			for(int i=0; i<sList.size(); i++) {
//				ScribbleVO temp = sList.get(i);
//				List<String> tList = tmapper.listTags(temp.getSno());
//				temp.setTags(tList);
//			}
//		}
		return sList;
	}

	@Override
	public ScribbleVO scribbleDetail(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		Integer uno = (Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno");
		Integer sno = Integer.parseInt(request.getParameter("sno"));
		return smapper.detailScribble(uno, sno);
	}
}
