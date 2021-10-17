package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RecommendService;
import service.RecommendServiceImpl;

public class RecommendController implements Controller {

	private RecommendService recommendService = new RecommendServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	public ModelAndView recByCommon(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		return null;
	}
	
	public ModelAndView recByLevel(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		return null;
	}
	
	public ModelAndView recByVisited(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		return null;
	
	}
	
	public ModelAndView recByTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		return null;
	
	}


}
