package com.jbedu.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import com.jbedu.oracle.dto.BoardDto;

public interface BoardDao {

	public void writeDao(String bid, String bname, String btitle, String bcontent); //게시판 글쓰기
	public ArrayList<BoardDto> listDao();
	public BoardDto contentDao(String bnum);
	
}
