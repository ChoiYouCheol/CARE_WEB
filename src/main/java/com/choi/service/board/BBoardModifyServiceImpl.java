package com.choi.service.board;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.choi.boards.Board;
import com.choi.boards.BoardDAO;
import com.choi.service.Service;

public class BBoardModifyServiceImpl implements Service {

	private BoardDAO dao;

	public BBoardModifyServiceImpl() {
		// TODO Auto-generated constructor stub
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		dao = context.getBean("bdao", BoardDAO.class);
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		System.err.println("BoardModifyServ execute..");
		
		Map<String, Object> map = model.asMap();
		Board board = (Board) map.get("board");
		
		System.err.println("BoardModifyServ Board.bid = " + board.getBid());
		
		boolean modifyResult = dao.boardmodify(board);
		if(modifyResult) System.err.println("Modify Success!");
	}

}
