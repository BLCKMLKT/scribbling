package com.company.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.FilmDto;
import com.company.dto.ScribbleDto;
import com.company.dto.TagDto;
import com.company.mapper.TagMapper;
import com.google.gson.Gson;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper mapper;
	
	@Override
	public void findTag(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String tag = request.getParameter("tag");
		List<String> list = mapper.findTag(tag);
		String json = new Gson().toJson(list);
		out.println(json);
	}

	@Override
	public void insertTag(HttpServletRequest request, ScribbleDto sdto) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String[] tnames = request.getParameter("stags").split("|");
		Integer[] tids = new Integer[tnames.length];
		TagDto tdto = new TagDto();
		for(int i=0; i<tnames.length; i++) {
			Integer tid = mapper.searchTaglib(tnames[i]);
			if(tid==null) { tid = mapper.insertTaglib(tnames[i]); }
			tids[i] = tid;
		}
		tdto.setSno(sdto.getSno()); tdto.setFcode(sdto.getFcode());
		for(int i=0; i<tids.length; i++) {
			tdto.setTid(tids[i]);
			mapper.insertTag(tdto);
		}
	}
}
