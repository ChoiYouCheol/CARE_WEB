package com.choi.service.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.choi.boards.Board;
import com.choi.boards.BoardDAO;
import com.choi.service.Service;

public class BBoardInfoServiceImpl implements Service {
	
	private BoardDAO dao;

	public BBoardInfoServiceImpl() {
		// TODO Auto-generated constructor stub
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		dao = context.getBean("bdao", BoardDAO.class);
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int bid = Integer.parseInt(request.getParameter("bid"));
		Board board = dao.aboardInfo(bid);
		model.addAttribute("board", board);
	}

}
