package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.MenuDTO;
import dto.ReviewDTO;
import dto.StoryDetailsDTO;
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
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int maxSize = 1024*1024*100; //100M
		String encoding = "UTF-8";
        String saveDir = request.getServletContext().getRealPath("/img/restaurantImage/") + request.getParameter("firstCategory") + "\\" + request.getParameter("secondCategory") + "\\" + request.getParameter("restaurantName");
        File forder = new File(saveDir);	
		//폴더 존재하지 않으면 생성!
		if(!forder.exists()) {
			try {
				forder.mkdir(); //폴더 생성
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
        MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
        String restaurantName = multi.getParameter("restaurantName");
        String restaurantPhone = multi.getParameter("phone");
        String restaurantAddr = multi.getParameter("jibunAddress");
        String restaurantRoadAddr = multi.getParameter("roadAddress");
        String [] addrList = restaurantAddr.split(" ");
        String gu = null;
        String dong = null;
        if(addrList.length > 0) {
        	gu = addrList[1];
        	dong = addrList[2];        	
        }
        String restaurantLongitude = multi.getParameter("longitude");
        String restaurantLatitude = multi.getParameter("latitude");
        
        List<String> imgList = new ArrayList<String>();
        Enumeration<String> files = multi.getFileNames();
        while(files.hasMoreElements()) {
        	imgList.add(files.nextElement());
        }
        System.out.println(imgList);
		return null;
        /*
    	private int restaurantNo;
	private int categoryDetailsNo;
	private int restaurantLevel;
	private String restaurantName;
	private String restaurantPhone;
	private String restaurantAddr; 서울 송파구 잠실동 22
	private String restaurantRoadAddr;
	private String gu;
	private String dong;
	private int restaurantLongitude;
	private int restaurantLatitude;
	private String restaurantRegDate;
	private int restaurantVisited;
	private List<ReviewDTO> reviewList;
	private List<StoryDetailsDTO> storyDetailsList;
	private List<String>hashTagName;
	private List<MenuDTO> menuList;
	private List<String> imgList;*/
	}
	

}
