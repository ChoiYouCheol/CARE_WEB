package com.choi.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.choi.members.MemberDAO;
import com.choi.service.Service;

public class MLoginServiceImpl implements Service{
	
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		boolean loginResult = dao.loginProc(id, pwd);
		model.addAttribute("loginResult", loginResult);
		if(loginResult) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
		}
	}

}
