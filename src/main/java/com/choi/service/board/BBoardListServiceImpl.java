package com.choi.service.board;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.choi.boards.Board;
import com.choi.boards.BoardDAO;
import com.choi.service.Service;

public class BBoardListServiceImpl implements Service{
	
	private BoardDAO dao;
	
	public BBoardListServiceImpl() {
		// TODO Auto-generated constructor stub
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		dao = context.getBean("bdao", BoardDAO.class);
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		ArrayList<Board> boardlist = dao.boardlist();
		
		model.addAttribute("boardlist", boardlist);
	}

}
