package com.choi.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choi.boards.Board;
import com.choi.service.Service;
import com.choi.service.board.BBoardInfoServiceImpl;
import com.choi.service.board.BBoardListServiceImpl;
import com.choi.service.board.BBoardModifyServiceImpl;
import com.choi.service.board.BBoardWriteServiceImpl;
import com.choi.service.board.BIncreaseHitServiceImpl;

@Controller
public class BoardController {

	private Service service;
	
	@RequestMapping(value="boardview")
	public String boardview(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request);
		
		service = new BBoardListServiceImpl();
		service.execute(model);
		
		return "board/boardview";
	}
	
	@RequestMapping(value="writeboard_view")
	public String writeboard_view(HttpServletRequest request) {
		return "board/writeboard_view";
	}
	
	@RequestMapping(value="writeboard", method=RequestMethod.POST)
	public String writeboard(Model model, Board board) {
		
		model.addAttribute("board", board);
		
		service = new BBoardWriteServiceImpl();
		service.execute(model);
		
		return "redirect:boardview";
	}
	
	@RequestMapping(value="showABoard")
	public String showABoard(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		service = new BIncreaseHitServiceImpl();
		service.execute(model);
		
		service = new BBoardInfoServiceImpl();
		service.execute(model);
		
		return "board/showABoard";
	}
	
	@RequestMapping(value="modifyboard", method=RequestMethod.POST)
	public String modifyboard(Model model, Board board) {
		
		model.addAttribute("board", board);
		
		service = new BBoardModifyServiceImpl();
		service.execute(model);
		
		return "redirect:boardview";
	}
}




