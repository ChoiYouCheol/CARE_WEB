package com.choi.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.choi.service.Service;

public class MLogoutServiceImpl implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		
		//�ֳ����̼ǿ��� ����ϴ� ��Ʈ����Ʈ ����.
		session.removeAttribute("logintime");
	}

}
