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
		
		//애노테이션에서 사용하던 어트리뷰트 삭제.
		session.removeAttribute("logintime");
	}

}
