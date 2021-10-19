package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	 * 레코드 삽입
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	       String saveDir=request.getServletContext().getRealPath("/img/storySave") + "/" + request.getParameter("storyTitle");
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
			
			String storyTitle =  m.getParameter("storyTitle");
			String restaurantName =  m.getParameter("restaurantName");
			String storyContent = m.getParameter("storyContent");
			String password =  m.getParameter("password");
			
			//업로드한 맛집이름 디렉토리에 있는 이미지 이름 모두 가져오기
	        List<String> storyImgList = new ArrayList<String>();
	        File dir = new File(saveDir);
	        if(dir.isDirectory()) {
	        	 File files [] = dir.listFiles();
	        	 for(int i = 0; i < files.length; i++) {
	        		 String fileName = files[i].toString();
	        		 storyImgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
	        	 }
	        }
	        
	        StoryDTO storyDTO = new StoryDTO(storyTitle, restaurantName, storyContent, password, storyImgList);
	        storyService.insertStory(storyDTO);
			
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
