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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int maxSize = 1024*1024*100; //100M
		String encoding = "UTF-8";
        String saveDir = request.getServletContext().getRealPath("/img/restaurantImage/") + request.getParameter("firstCategory") + "\\" + request.getParameter("secondCategory") + "\\" + request.getParameter("restaurantName");
        File forder = new File(saveDir);	
		//맛집이름 폴더 존재하지 않으면 생성
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
        Double restaurantLongitude = Double.parseDouble(multi.getParameter("longitude"));
        Double restaurantLatitude = Double.parseDouble(multi.getParameter("latitude"));
        
        //해시태그 배열 받아오기
        List<String> hashTagName = Arrays.asList(multi.getParameterValues("hashTag"));
        
        System.out.println(hashTagName);
        
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
        
        RestaurantDTO restaurantDTO = new RestaurantDTO(0, 0, restaurantName, restaurantPhone, restaurantAddr, restaurantRoadAddr, gu, dong, restaurantLongitude, restaurantLatitude, hashTagName, null, imgList);
        
        
        System.out.println(imgList);
		return null;

	}
	

}
