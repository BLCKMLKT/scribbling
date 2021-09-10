package com.company.service;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;
import com.company.mapper.FilmMapper;
import com.company.mapper.ScribbleMapper;
import com.company.mapper.TagMapper;

@Service
public class ScribbleServiceImpl implements ScribbleService {
	@Autowired
	private ScribbleMapper smapper;
	
	@Override
	public ScribbleDto insertScribble(HttpServletRequest request, FilmDto fdto, Integer kcode) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ScribbleDto sdto = new ScribbleDto();
		sdto.setSdate(request.getParameter("sdate"));
		sdto.setUno((Integer) request.getSession().getServletContext().getContext("/lnscribbling").getAttribute("uno"));
		sdto.setFcode(fdto.getFcode());
		sdto.setKcode(kcode);
		String srateParam = request.getParameter("srate");
		if(srateParam!=null) { sdto.setSrate(Integer.parseInt(srateParam)); } 
		sdto.setScontent(request.getParameter("scontent"));
		sdto.setSip(InetAddress.getLocalHost().getHostAddress());
		sdto = smapper.insertScribble(sdto);
		return sdto;
	}
}
