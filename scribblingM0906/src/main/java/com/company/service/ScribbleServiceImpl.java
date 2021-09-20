package com.company.service;

import java.net.InetAddress;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;
import com.company.dto.TagDto;
import com.company.mapper.FilmMapper;
import com.company.mapper.KinoMapper;
import com.company.mapper.ScribbleMapper;
import com.company.mapper.TagMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
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
			FilmDto fdto = new FilmDto();
			String param = request.getParameter("stitle");
			String fname = param.substring(0, param.length()-6); // 개봉연도 제거
			fdto.setFname(fname);
			fdto.setFrelease(Integer.parseInt(request.getParameter("srelease")));
			fdto.setFdirector(request.getParameter("sdirector"));
			fdto.setFcast(request.getParameter("scast"));
			fdto.setFimg(request.getParameter("sposter"));
			FilmDto temp = fmapper.searchFilm(fdto); // fcode 찾아오기
			if(temp==null) { fdto.setFcode(fmapper.insertFilm(fdto)); } // 등록하기
			else { fdto.setFcode(temp.getFcode()); }
			// 2. kinos 테이블에서 kcode 찾기
			String kname = request.getParameter("skino");
			Integer kcode = kmapper.searchKino(kname);
			// 3. scribbles 테이블에 스크리블 등록
			ScribbleDto sdto = new ScribbleDto();
			sdto.setSdate(request.getParameter("sdate"));
			sdto.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
			sdto.setFcode(fdto.getFcode());
			sdto.setKcode(kcode);
			String srateParam = request.getParameter("srate");
			if(srateParam!=null) { sdto.setSrate(Integer.parseInt(srateParam)); } 
			sdto.setScontent(request.getParameter("scontent"));
			sdto.setSip(InetAddress.getLocalHost().getHostAddress());
			sdto.setSno(smapper.insertScribble(sdto));
			
			// 4. tag_library에서 tid 찾기
			String[] tnames = request.getParameter("stags").split("\\|");
			Integer[] tids = new Integer[tnames.length];
			for(int i=0; i<tnames.length; i++) {
				Integer tid = tmapper.searchTaglib(tnames[i]);
				if(tid==null) { tid = tmapper.insertTaglib(tnames[i]); }
				tids[i] = tid;
			} // tid 찾기 or 태그 라이브러리에 등록하기
			TagDto tdto = new TagDto();
			tdto.setSno(sdto.getSno()); tdto.setFcode(sdto.getFcode());
			for(int i=0; i<tids.length; i++) {
				tdto.setTid(tids[i]);
				tmapper.insertTag(tdto);
			} // 태그 등록하기
	    } catch(Exception e) {
	        e.printStackTrace();
	    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        return -1; // 오류 발생 시 빠져나가기
	    }
		return 1; // 성공 시
	}
}
