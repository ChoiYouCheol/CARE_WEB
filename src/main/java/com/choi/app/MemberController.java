package com.choi.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choi.members.Member;
import com.choi.service.Service;
import com.choi.service.member.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private Service service;
	private GenericXmlApplicationContext context;
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		context = new GenericXmlApplicationContext("classpath:context.xml");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("현재 시간 : " + formattedDate);

		return "home/home";
	}

	@RequestMapping(value="loginview")
	public String loginview() {
		return "member/loginview";
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);

		service = context.getBean("loginServiceImpl", Service.class);
		service.execute(model);

		Map<String, Object> map = model.asMap();
		boolean loginReuslt = (Boolean)map.get("loginResult");
		if(loginReuslt)
			return "redirect:home";
		else
			return "redirect:loginview";
	}

	@RequestMapping(value="signin_view")
	public String signin_view() {
		return "member/signin_view";
	}

	@RequestMapping(value="signin", method=RequestMethod.POST)
	public String signin(Member member, Model model) {

		model.addAttribute("member", member);

		service = new MSigninServiceImpl();
		service.execute(model);

		Map<String, Object> map = model.asMap();
		boolean loginReuslt = (Boolean)map.get("signResult");
		if(loginReuslt)
			return "redirect:home";
		else
			return "redirect:signin_view";
	}

	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request,Model model) {

		model.addAttribute("request", request);

		service = context.getBean("logoutServiceImpl", Service.class);
		service.execute(model);

		return "redirect:home";
	}

}
