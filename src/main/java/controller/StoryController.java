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

import dto.StoryDTO;
import service.UserStoryService;
import service.UserStoryServiceImpl;

public class StoryController implements Controller {
	private UserStoryService userStoryService = new UserStoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		return null;
	}
	
	/**
	 * 전체검색
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}
	
	/**
	 * 키워드로 검색
	 * */
	public ModelAndView selectBy(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return null;
	}
	
	/**
	 * 폼 업데이트
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
	        userStoryService.insertStory(storyDTO);
			
			return new ModelAndView(request.getServletContext().getContextPath() + "/userStory/userStoryList.jsp", true);
	}
	
	/**
	 * 레코드 수정
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
	}
	
	/**
	 * 레코드 삭제
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		String modelNum = request.getParameter("modelNum");
//		String password =  request.getParameter("password");
//    	
//		String saveDir=request.getServletContext().getRealPath("/save");
//		
//    	elecService.delete(modelNum, password , saveDir);
//    	
//    	return new ModelAndView("front", true);
		
		return null;
	}
	


}
