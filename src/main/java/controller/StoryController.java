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
	 * 스토리 전체 검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<StoryDTO> storyList = userStoryService.selectAll();
		
		for(StoryDTO storyDTO : storyList) {
			List<String> storyImgList = new ArrayList<String>();
			File file = new File(request.getServletContext().getRealPath("/img/storySave") + "/" + storyDTO.getStoryTitle());
			
			if(file.exists()) {
				File files [] = file.listFiles();
				if(files.length>=1) {
					for(int i = 0; i < 1; i++) {
			       		 String fileName = files[i].toString();
			       		storyImgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
			       	 }
				}else {
					storyImgList.add(request.getServletContext().getContextPath()+"img/storySave/디저트.png");
				}
			}else {
				storyImgList.add(request.getServletContext().getContextPath()+"img/storySave/디저트.png");
			}
			
			storyDTO.setStoryImgList(storyImgList);
		}
		
		request.setAttribute("list", storyList); // ${requestScope.list}
		
		return new ModelAndView("userStory/userStoryList.jsp");
	}
	
	/**
	 * 스토리 번호로 검색
	 * */
	public ModelAndView selectByStoryNo(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String storyNo =  request.getParameter("storyNo");
    	StoryDTO storyDTO = userStoryService.selectByStoryNo(Integer.parseInt(storyNo), true);
    	
    	//스토리 사진 가져오기
    	File file = new File(request.getServletContext().getRealPath("/img/storySave") + "\\" + storyDTO.getStoryTitle());
    	List<String> storyImgList = new ArrayList<String>();
    	if(file.exists()) {
			File files [] = file.listFiles();
			if(files.length>=1) {
				for(int i = 0; i < files.length; i++) {
		       		 String fileName = files[i].toString();
		       		storyImgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
		       	 }
			}else {
				storyImgList.add(request.getServletContext().getContextPath()+"img/storySave/디저트.png");
			}
		}else {
			storyImgList.add(request.getServletContext().getContextPath()+"img/storySave/디저트.png");
		}
    	
    	
    	request.setAttribute("story", storyDTO);
    	request.setAttribute("storyImgList", storyImgList);
    	
    	return new ModelAndView("userStory/userStoryDetails.jsp");
	}
	
	/**
	 * 스토리 레코드 삽입
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	       String saveDir=request.getServletContext().getRealPath("/img/storySave") + "\\" + request.getParameter("storyTitle");
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
			
			String loginId = (String)request.getSession().getAttribute("loginId");
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
	        
	        StoryDTO storyDTO = new StoryDTO(loginId, storyTitle, restaurantName, storyContent, password, storyImgList);
	        userStoryService.insertStory(storyDTO);
			
			return new ModelAndView("front?key=userStory&methodName=selectAll", true);
	}
	
	/**
	 * 스토리 레코드 수정
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String saveDir = request.getServletContext().getRealPath("/img/storySave") + "/" + request.getParameter("storyTitle");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		File folder = new File(saveDir);

		if(!folder.exists()) {
			folder.mkdir();
		}else { //폴더 존재하는 경우
			File [] fileList = folder.listFiles();
			for(File file : fileList) {
				file.delete();
			}
		}

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		int storyNo = Integer.parseInt(m.getParameter("storyNo"));
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
		
		StoryDTO storyDTO = new StoryDTO(storyNo, storyTitle, restaurantName, storyContent, password, storyImgList);
		
		userStoryService.updateStory(storyDTO);
		
		return new ModelAndView("front?key=userStory&methodName=selectAll", true);
	}
	
	/**
	 * 스토리 레코드 삭제
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String saveDir = request.getServletContext().getRealPath("/img/storySave") + "/" + request.getParameter("storyTitle");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		File folder = new File(saveDir);

		if(!folder.exists()) {
			folder.mkdir();
		}else { //폴더 존재하는 경우
			File [] fileList = folder.listFiles();
			for(File file : fileList) {
				file.delete();
			}
		}

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		
		String storyNo = m.getParameter("storyNo");
		String password =  m.getParameter("password");
		
		userStoryService.delete(Integer.parseInt(storyNo), password, saveDir);
    	
		return new ModelAndView("front?key=userStory&methodName=selectAll", true);
	}
}
