package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.RecommendDTO;
import service.RecommendService;
import service.RecommendServiceImpl;

public class RecommendController implements Controller {

	private RecommendService recommendService = new RecommendServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	public ModelAndView recByScore(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		list= recommendService.recByScore();
		request.setAttribute("list", list);
	
		return new ModelAndView("recommend/recommendList.jsp");
	}
	
	public ModelAndView recByLevel(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String levelNo = request.getParameter(null);
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		list= recommendService.recByLevel(Integer.parseInt(levelNo));
		request.setAttribute("list", list);
	
		return new ModelAndView("recommend/recommendList.jsp");
	}
	
	public ModelAndView recByVisited(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		list= recommendService.recByVisited();
		request.setAttribute("list", list);
	
		return new ModelAndView("recommend/recommendList.jsp");
	}
	
	public ModelAndView recByTag(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String tagNo = request.getParameter(null);
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		list= recommendService.recByTag(Integer.parseInt(tagNo));
		request.setAttribute("list", list);
	
		return new ModelAndView("recommend/recommendList.jsp");
	}


}