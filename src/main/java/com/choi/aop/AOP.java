package com.choi.aop;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.ui.Model;

@Aspect
public class AOP {
	
	@Around("within(com.choi.service.member.MLoginServiceImpl)")
	public void create_logintime(ProceedingJoinPoint joinPoint) {
		try {
			joinPoint.proceed();
			
			Model model = null;
			for(Object o : joinPoint.getArgs()) {
				if(o instanceof Model)
					model = (Model)o;
			}
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			boolean loginResult = (Boolean)map.get("loginResult");
			if(loginResult) {
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("loginUser");
				System.out.println("aspect _ login -> around id : " + id);
				session.setAttribute("logintime", new Timestamp(System.currentTimeMillis()));
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Around("within(com.choi.service.member.MLogoutServiceImpl)")
	public void create_logouttime(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("aop around create_logouttime execute...");
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
