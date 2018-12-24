package com.choi.service.member;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.choi.members.Member;
import com.choi.members.MemberDAO;
import com.choi.service.Service;

public class MSigninServiceImpl implements Service {

	private MemberDAO dao;
	
	public MSigninServiceImpl() {
		// TODO Auto-generated constructor stub
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		dao = context.getBean("mdao", MemberDAO.class);
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		Member member = (Member)map.get("member");
		
		boolean signResult = dao.signProc(member);
		model.addAttribute("signResult", signResult);
	}

}
