package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.MenuDTO;
import dto.RestaurantDTO;
import service.AdminRestaurantService;
import service.AdminRestaurantServiceImpl;

public class AdminRestaurantController implements Controller {
	
	private AdminRestaurantService adminRestaurantService = new AdminRestaurantServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 맛집 insert
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int maxSize = 1024*1024*100; //100M
		String encoding = "UTF-8";
        String saveDir = request.getServletContext().getRealPath("/img/restaurantImage/") + request.getParameter("firstCategory") + "/" + request.getParameter("secondCategory") + "/" + request.getParameter("restaurantName");
        File folder = new File(saveDir);	

        
		//맛집이름 폴더 존재하지 않으면 생성
		if(!folder.exists()) {
			folder.mkdir(); //폴더 생성
		}		
		
		//MultipartRequest 객체생성 
        MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
        
        //파라미터 받기
        int restaurantLevel = Integer.parseInt(multi.getParameter("level"));
        String restaurantName = multi.getParameter("restaurantName");
        String restaurantPhone = multi.getParameter("phone");
        String restaurantAddr = multi.getParameter("jibunAddress");
        String restaurantRoadAddr = multi.getParameter("roadAddress");
        String categoryDetailsName = multi.getParameter("secondCategory");
        String [] addrList = restaurantAddr.split(" ");
        String gu = null;
        String dong = null;
        if(addrList.length > 0) {
        	gu = addrList[1];
        	dong = addrList[2];        	
        }
        Double restaurantLongitude = Double.parseDouble(multi.getParameter("longitude")); //null들어오는 경우?
        Double restaurantLatitude = Double.parseDouble(multi.getParameter("latitude"));
        
        //해시태그 배열 받아오기
        String [] hashTagArr = multi.getParameterValues("hashTag");
        List<String> hashTagName = new ArrayList<String>();
        for(String hashtag : hashTagArr) {
        	if(!hashtag.equals("")) {
        		hashTagName.add(hashtag);
        		//System.out.println(hashtag);
        	}
        }
        
        //메뉴 배열받아오기
        String [] menuNameArr = multi.getParameterValues("menuName");
        String [] menuPriceArr = multi.getParameterValues("menuPrice");
        List<MenuDTO> menuList = new ArrayList<MenuDTO>();
        for(int i=0; i < menuNameArr.length; i++) {
        	if(menuNameArr[i].equals("")) {
        		break;
        	}
        	menuList.add(new MenuDTO(menuNameArr[i], Integer.parseInt(menuPriceArr[i])));
        	//System.out.println(menuNameArr[i] + ", " + menuPriceArr[i]);
        }
        
        
        //업로드한 맛집이름 디렉토리에 있는 이미지 이름 모두 가져오기
        List<String> imgList = new ArrayList<String>();
        File dir = new File(saveDir);
        if(dir.isDirectory()) {
        	 File files [] = dir.listFiles();
        	 for(int i = 0; i < files.length; i++) {
        		 String fileName = files[i].toString();
        		 System.out.println(fileName);
        		 imgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
        	 }
        }
        
        RestaurantDTO restaurantDTO = new RestaurantDTO(0, restaurantLevel, restaurantName, restaurantPhone, restaurantAddr, restaurantRoadAddr, gu, dong, restaurantLongitude, restaurantLatitude, hashTagName, menuList, imgList);
        adminRestaurantService.insert(restaurantDTO, categoryDetailsName);
        
		ModelAndView mv = new ModelAndView("front?key=adminRestaurant&methodName=pagingSelect", true);
		return mv;

	}
	
	/**
	 * 맛집 상세정보 검색 & 수정페이지
	 * */
	public ModelAndView selectByRestaurantNo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	
		int restaurantNo = Integer.parseInt(request.getParameter("restaurantNo"));
		
		//맛집 정보 받아오기
		RestaurantDTO restaurantDTO = adminRestaurantService.selectByRestaurantNo(restaurantNo);
		
		//해시태그 전체 테이블 데이터 받아오기
		List<String> hashTagList = adminRestaurantService.selectAllHashTag();
		
		//request에 담아서 update.jsp로 이동
		request.setAttribute("restaurantDTO", restaurantDTO);
		request.setAttribute("hashTagList", hashTagList);
		
		ModelAndView mv = new ModelAndView("adminRestaurant/restaurantDetail.jsp");
		return mv;
	}
	
	/**
	 * 맛집 리스트 페이징
	 * */
	public ModelAndView pagingSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String pageNo = request.getParameter("pageNo");
		if(pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		String selectKey = request.getParameter("selectKey");
		if(selectKey == null || selectKey.equals("")) {
			selectKey = "restaurantName";
		}
		String selectValue = request.getParameter("selectValue");
		if(selectValue == null || selectValue.equals("")) {
			selectValue = "";
		}
		
		List<RestaurantDTO> restaurantList = adminRestaurantService.pagingSelect(Integer.parseInt(pageNo), selectKey, selectValue);
		
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("selectKey", selectKey);
		request.setAttribute("selectValue", selectValue);
		request.setAttribute("restaurantList", restaurantList);
		
		ModelAndView mv = new ModelAndView("adminRestaurant/adminRestaurantList.jsp");	
		return mv;
	}
	
	/**
	 * 맛집 update
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println(request.getParameter("secondCategory"));
		
		int maxSize = 1024*1024*100; //100M
		String encoding = "UTF-8";
        String saveDir = request.getServletContext().getRealPath("/img/restaurantImage/") + request.getParameter("firstCategory") + "/" + request.getParameter("secondCategory") + "/" + request.getParameter("restaurantName");
        File folder = new File(saveDir);
        
		//맛집이름 폴더 존재하지 않으면 생성
        
		if(!folder.exists()) {
			folder.mkdir(); //폴더 생성
		}else { //폴더 존재하는 경우
			File [] fileList = folder.listFiles();
			for(File file : fileList) {
				file.delete(); //폴더내 파일 삭제
			}
		}		
		
		//MultipartRequest 객체생성 
        MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
        
        //파라미터 받기
        int restaurantNo = Integer.parseInt(multi.getParameter("restaurantNo"));
        int restaurantLevel = Integer.parseInt(multi.getParameter("level"));
        String restaurantName = multi.getParameter("restaurantName");
        String restaurantPhone = multi.getParameter("phone");
        String restaurantAddr = multi.getParameter("jibunAddress");
        String restaurantRoadAddr = multi.getParameter("roadAddress");
        String categoryDetailsName = multi.getParameter("secondCategory");
        String [] addrList = restaurantAddr.split(" ");
        String gu = null;
        String dong = null;
        if(addrList.length > 0) {
        	gu = addrList[1];
        	dong = addrList[2];        	
        }
        Double restaurantLongitude = Double.parseDouble(multi.getParameter("longitude")); //null들어오는 경우?
        Double restaurantLatitude = Double.parseDouble(multi.getParameter("latitude"));
        
        //해시태그 배열 받아오기
        String [] hashTagArr = multi.getParameterValues("hashTag");
        List<String> hashTagName = new ArrayList<String>();
        for(String hashtag : hashTagArr) {
        	if(!hashtag.equals("")) {
        		hashTagName.add(hashtag);
        		//System.out.println(hashtag);
        	}
        }
        
        //메뉴 배열받아오기
        String [] menuNameArr = multi.getParameterValues("menuName");
        String [] menuPriceArr = multi.getParameterValues("menuPrice");
        List<MenuDTO> menuList = new ArrayList<MenuDTO>();
        for(int i=0; i < menuNameArr.length; i++) {
        	if(menuNameArr[i].equals("")) {
        		break;
        	}
        	menuList.add(new MenuDTO(menuNameArr[i], Integer.parseInt(menuPriceArr[i])));
        	//System.out.println(menuNameArr[i] + ", " + menuPriceArr[i]);
        }
        
        
        //업로드한 맛집이름 디렉토리에 있는 이미지 이름 모두 가져오기
        List<String> imgList = new ArrayList<String>();
        File dir = new File(saveDir);
        if(dir.isDirectory()) {
        	 File files [] = dir.listFiles();
        	 for(int i = 0; i < files.length; i++) {
        		 String fileName = files[i].toString();
        		 imgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
        	 }
        }
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantNo(restaurantNo);
        restaurantDTO.setRestaurantLevel(restaurantLevel);
        restaurantDTO.setRestaurantName(restaurantName);
        restaurantDTO.setRestaurantPhone(restaurantPhone);
        restaurantDTO.setRestaurantAddr(restaurantAddr);
        restaurantDTO.setRestaurantRoadAddr(restaurantRoadAddr);
        restaurantDTO.setCategoryDetailsName(categoryDetailsName);
        restaurantDTO.setGu(gu);
        restaurantDTO.setDong(dong);
        restaurantDTO.setRestaurantLongitude(restaurantLongitude);
        restaurantDTO.setRestaurantLatitude(restaurantLatitude);
        restaurantDTO.setHashTagName(hashTagName);
        restaurantDTO.setMenuList(menuList);
        restaurantDTO.setImgList(imgList);
        adminRestaurantService.update(restaurantDTO, categoryDetailsName);
        
        ModelAndView mv = new ModelAndView("front?key=adminRestaurant&methodName=pagingSelect", true);
		return mv;
	}
	
	/**
	 * register 페이지 띄우기
	 * */
	public ModelAndView goRegisterPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
				
		List<String> hashTagList = adminRestaurantService.selectAllHashTag();
		request.setAttribute("hashTagList", hashTagList);
		
		ModelAndView mv = new ModelAndView("adminRestaurant/registerRestaurant.jsp");
		return mv;
	}
	

}
