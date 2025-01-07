package com.jbedu.oracle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbedu.oracle.dao.BoardDao;
import com.jbedu.oracle.dao.MemberDao;
import com.jbedu.oracle.dto.BoardDto;
import com.jbedu.oracle.dto.MemberDto;

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
		} 

		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		MemberDto memberDto = dao.memberInfoDao(sessionId);
			
		model.addAttribute("loginId", sessionId);
		model.addAttribute("memberName", memberDto.getMname());
		
		return "writeForm";
	}
	
	@RequestMapping(value="/write")
	public String Write(HttpServletRequest request, Model model) {
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.writeDao(bid, bname, btitle, bcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request, Model model) {

		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> boardDtos = dao.listDao();
		model.addAttribute("boardList", boardDtos);
		
		return "boardList";
	}
}
