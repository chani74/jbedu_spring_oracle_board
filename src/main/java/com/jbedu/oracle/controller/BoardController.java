package com.jbedu.oracle.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/write_form")
	public String write_form(Model model , HttpSession session) {
		String sessionId = (String) session.getAttribute("sessionId");
		
		if (sessionId == null) {
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			return "alert";
		} else {
			model.addAttribute("loginId", sessionId);
			model.addAttribute("mname", sessionId);
			
		}
		
		
		return "writeForm";
	}
}
