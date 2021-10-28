package com.company.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.ScribbleVO;
import com.company.service.ScribbleService;

@Controller
@RequestMapping("/scribble/*")
public class ScribbleController {
	@Autowired
	private ScribbleService sservice;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write_view() {
		return "/scribble/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public void write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Integer result = sservice.scribbleInsert(request);
		if(result!=null&&result==1) { // 성공 페이지로 연결
			out.println("<script>alert('성공'); location.href='" + request.getContextPath() + "/scribble/list';</script>");
		} else { out.println("<script>alert('실패'); history.go(-1);</script>"); }
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit_view(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("svo", sservice.scribbleDetail(request));
		return "/scribble/edit";
	}
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Integer result = sservice.scribbleEdit(request);
		if(result!=null&&result==1) { // 성공 페이지로 연결
			out.println("<script>alert('성공'); location.href='" + request.getContextPath() + "/scribble/detail';</script>");
		} else { out.println("<script>alert('실패'); history.go(-1);</script>"); }
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("svo", sservice.scribbleDetail(request));
		return "/scribble/detail";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<ScribbleVO> list = sservice.scribbleList(request);
		request.setAttribute("list", list);
		return "/scribble/list";
	}
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String list_search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<ScribbleVO> list = sservice.scribbleList(request);
		request.setAttribute("list", list);
		return "/scribble/list";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete_view() {
		return "/scribble/delete";
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete() {
		
	}
}
