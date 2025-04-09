package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.web.model.SpringDAO;

public class Ex02Controller implements Controller{

	private SpringDAO dao;
	
	public Ex02Controller(SpringDAO dao) {
		this.dao=dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//SpringDAO dao = new SpringDAO();
		dao.test();
		
		int count = dao.count();

		ModelAndView mv = new ModelAndView("ex02");
		mv.addObject("count",count);
		
		return mv;
	}

}
