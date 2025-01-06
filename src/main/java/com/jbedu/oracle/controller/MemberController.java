package com.jbedu.oracle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbedu.oracle.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired // 의존성 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value="/join")
	public String join() {
		return "memberJoin";
	}

	@RequestMapping(value="/joinOk", method=RequestMethod.POST )
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		int mage = Integer.parseInt( request.getParameter("mage"));
		
		// 회원 가입 체크
		int idCheckFlag = dao.idCheckDao(mid);
		if(idCheckFlag==0) {
			dao.joinMemberDao(mid, mpw, mname, memail, mage);
		} else {
			model.addAttribute("msg", "이미 가입된 id 입니다.");
			model.addAttribute("url", "join");
			return "alert";
		}
		
		
		model.addAttribute("memberName", mname);	
		
		return "joinOk";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int loginFlag = dao.loginDao(mid, mpw);
		
		if(loginFlag == 1) {
			session.setAttribute("sessionId", mid);
			model.addAttribute("loginId", mid);
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인해 주세요.");
			model.addAttribute("url", "login");
			
			return "alert"	;
		}
		
		model.addAttribute("loginFlag", loginFlag);
		return "loginOk";
	}	
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session, Model model) {
		
		model.addAttribute("msg", "로그아웃 하시겠습니까?");
		model.addAttribute("url", "login");
		
		session.invalidate();
		
		return "alert";
	}	
}
