package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.ModelAndView;
import dto.StoryDTO;
import service.StoryService;
import service.StoryServiceImpl;

public class StoryController implements Controller {
	
	private StoryService storyService = new StoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		return null;
	}
	
	/**
	 * �뒪�넗由� �쟾泥닿��깋
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}
	
	/**
	 * �긽�꽭蹂닿린 寃��깋
	 * */
	public ModelAndView selectBy(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return null;
	}
	
	/**
	 * �닔�젙�븯湲� �뤌�쑝濡� 媛�湲�
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return null;
	}
	
	/**
	 * �뒪�넗由� �벑濡�
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	       String saveDir=request.getServletContext().getRealPath("/storySave");
			int maxSize = 1024*1024*100; 
			String encoding="UTF-8";
			
			File folder = new File(saveDir);
			if(!folder.exists()) {
				try {
					folder.mkdir();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
				
			MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			
			String storyTitlePhoto =  m.getParameter("storyTitlePhoto");
			String storyTitle =  m.getParameter("storyTitle");
			
			String storyPhoto =  m.getParameter("storyPhoto0");
			String restaurantTitle =  m.getParameter("restaurantTitle0");
			String storyPhotoContent = m.getParameter("storyphotoContent0");
			
			String password =  m.getParameter("password");
			
			
//			StoryDTO storyDTO = new StoryDTO(0, 0, storyTitle, password);
//			
//			elecService.insert(electronics);
			
			return new ModelAndView("front", true);
	}
	
	/**
	 * �뒪�넗由� �닔�젙
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}
	
	/**
	 * �뒪�넗由� �궘�젣
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}
	


}
