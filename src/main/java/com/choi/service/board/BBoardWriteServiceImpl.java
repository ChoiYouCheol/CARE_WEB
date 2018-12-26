package com.choi.service.board;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.choi.boards.Board;
import com.choi.boards.BoardDAO;
import com.choi.service.Service;

public class BBoardWriteServiceImpl implements Service {

	private BoardDAO dao;

	public BBoardWriteServiceImpl() {
		// TODO Auto-generated constructor stub
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		dao = context.getBean("bdao", BoardDAO.class);
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		Board board = (Board)map.get("board");
		boolean writeResult = dao.boardwrite(board);
		model.addAttribute("writeResult", writeResult);
	}

}
