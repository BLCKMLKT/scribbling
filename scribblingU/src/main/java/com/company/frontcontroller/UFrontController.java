package com.company.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.ucontroller.UAction;
import com.company.ucontroller.UDeactivateAction;
import com.company.ucontroller.UEditAction;
import com.company.ucontroller.UEditInfoAction;
import com.company.ucontroller.UEditPassAction;
import com.company.ucontroller.UForgotPass;
import com.company.ucontroller.UIdCheckAction;
import com.company.ucontroller.UInfoAction;
import com.company.ucontroller.ULoginAction;
import com.company.ucontroller.ULoginConfirmAction;
import com.company.ucontroller.ULogoutAction;
import com.company.ucontroller.URegisterAction;

@WebServlet("/account/*")
public class UFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UFrontController() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { action(request, response); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { action(request, response); }
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String viewPage = ""; UAction command = null;
		String path = request.getRequestURI().substring(request.getContextPath().length());
		// out.println(path);
		if(path.equals("/account/login_page")) { // 로그인 view
			viewPage = "/user/login.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response);
		} else if(path.equals("/account/login")) { // 로그인 action
			command = new ULoginAction(); command.execute(request, response);
		} else if(path.equals("/account/login_confirm")) { // 로그인 - 아이디/비밀번호 일치 확인 action
			command = new ULoginConfirmAction(); command.execute(request, response);
		} else if(path.equals("/account/forgot_pass")) { // 비밀번호 찾기 view
			viewPage = "/user/forgotPass.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response);
		} else if(path.equals("/account/send_code")) { // 비밀번호 찾기 - 코드 전송 action
			command = new UForgotPass(); command.execute(request, response);
		} else if(path.equals("/account/verify_code")) { // 비밀번호 찾기 - 코드 인증 view
			viewPage = "/user/verifyCode.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response);
		} else if(path.equals("/account/change_pass")) { // 비밀번호 찾기 - 비밀번호 변경 view
			viewPage = "/user/changePass.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response);
		} else if(path.equals("/account/join_page")) { // 회원가입 view
			viewPage = "/user/register.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response); 
		} else if(path.equals("/account/join")) { // 회원가입 action
			command = new URegisterAction(); command.execute(request, response);
		} else if(path.equals("/account/welcome")) { // 회원가입 완료 view
			viewPage = "/user/welcome.jsp";
			request.getRequestDispatcher(viewPage).forward(request, response); 
		} else if(path.equals("/account/id_check")) { // 회원가입 - 아이디 중복 확인 action
			command = new UIdCheckAction(); command.execute(request, response);
		} else if(path.equals("/account/info")) { // 마이페이지 - 회원 정보 view
			viewPage = "/user/mypage.jsp";  
			command = new UInfoAction(); command.execute(request, response);
			request.getRequestDispatcher(viewPage).forward(request, response); 
		} else if(path.equals("/account/edit_page")) { // 마이페이지 - 회원 정보 수정 view
			viewPage = "/user/editInfo.jsp";
			command = new UEditInfoAction(); command.execute(request, response);
			request.getRequestDispatcher(viewPage).forward(request, response); 
		} else if(path.equals("/account/edit")) { // 마이페이지 - 회원 정보 수정 action
			command = new UEditAction(); command.execute(request, response);
		} else if(path.equals("/account/edit_password")) { // 마이페이지 - 비밀번호 변경 action / 비밀번호 찾기 - 비밀번호 변경 action
			command = new UEditPassAction(); command.execute(request, response);
		} else if(path.equals("/account/logout")) { // 로그아웃 action
			command = new ULogoutAction(); command.execute(request, response);
		} else if(path.equals("/account/deactivate_page")) { // 회원 탈퇴 view
			viewPage = "/user/deactivate.jsp";  
			request.getRequestDispatcher(viewPage).forward(request, response); 
		} else if(path.equals("/account/deactivate")) { // 회원 탈퇴 action
			command = new UDeactivateAction(); command.execute(request, response);
		}
	}
}
