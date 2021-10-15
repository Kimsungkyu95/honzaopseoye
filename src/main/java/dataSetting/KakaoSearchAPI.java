package dataSetting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class KakaoSearchAPI {
	public JSONObject search(String gu, String dong, String value) {
		JSONObject restaurantObject = null;
		try {
			String temp = URLEncoder.encode(gu + " " + dong + " " + value + " 맛집", "UTF-8"); //한글 인코딩처리 필수
			String str = "https://dapi.kakao.com/v2/local/search/keyword.json?query="+temp;
			URL url = new URL(str);
			
			//URLConnection 생성
	        URLConnection conn = url.openConnection();
	        
	        // Authorization 정보 head에 넣어주기
	        conn.setRequestProperty("Authorization", "KakaoAK 9928b38057b1c51974e1664c4910ed86");
	        
	        // Content-Type 설정
	        //conn.setRequestProperty("Content-Type", "application/json");
	 

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            StringBuilder jsonData = new StringBuilder();
            
            while ((line = br.readLine()) != null) {
            	//System.out.println(line);
                jsonData.append(line);
            }
            
            //jsonData 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonData.toString());
            
            //documents 배열추출(JSONArray 형태) 
            JSONArray restaurantArray = (JSONArray) jsonObject.get("documents");
/*          
            for(int i=0; i < restaurantArray.size(); i++) {
            	System.out.println("==========================restaurant_" + i + "======================");
            	//JSONArray 안에서 JSONOject 추출
            	JSONObject restaurantObject = (JSONObject) restaurantArray.get(i);
            	
            	//JSONObject의 value 추출
            	System.out.println("address_name : " + restaurantObject.get("address_name"));
            	System.out.println("category_name : " + restaurantObject.get("category_name"));
            	System.out.println("phone : " + restaurantObject.get("phone"));
            	System.out.println("place_name : " + restaurantObject.get("place_name"));
            	System.out.println("place_url : " + restaurantObject.get("place_url"));
            	System.out.println("road_address_name : " + restaurantObject.get("road_address_name"));
            	System.out.println("longitude : " + restaurantObject.get("x"));
            	System.out.println("latitude : " + restaurantObject.get("y"));   

            }
*/
            restaurantObject = (JSONObject) restaurantArray.get(0);
            
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return restaurantObject;
		
	}
	
	public List<String> imgSearch(String dong, String CategoryDetailsName, String name) {
		List<String> imgUrlList = new ArrayList<String>();
		try {
			String temp = URLEncoder.encode(dong + " " + CategoryDetailsName +" " + name, "UTF-8"); //한글 인코딩처리 필수
			String str = "https://dapi.kakao.com/v2/search/image?query="+temp;
			URL url = new URL(str);
			
			//URLConnection 생성
	        URLConnection conn = url.openConnection();
	        
	        // Authorization 정보 head에 넣어주기
	        conn.setRequestProperty("Authorization", "KakaoAK 9928b38057b1c51974e1664c4910ed86");
	        
	        // Content-Type 설정
	        //conn.setRequestProperty("Content-Type", "application/json");
	 

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            StringBuilder jsonData = new StringBuilder();
            
            while ((line = br.readLine()) != null) {
            	//System.out.println(line);
                jsonData.append(line);
            }
            
            //jsonData 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonData.toString());
            
            //documents 배열추출(JSONArray 형태) 
            JSONArray imgArray = (JSONArray) jsonObject.get("documents");
            
            //imgurl 정보 뽑기         
            for(int i = 0; i < Math.min(3, imgArray.size()); i++) {
            	JSONObject imgObject = (JSONObject) imgArray.get(i);
            	String imgURL = (String)imgObject.get("image_url");
            	imgUrlList.add(imgURL);
            }
            
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return imgUrlList;
	}
	
	// 단위테스트
	public static void main(String [] args) {
		KakaoSearchAPI kakao = new KakaoSearchAPI();
		List<String> imgUrlList = kakao.imgSearch("잠실동", "디저트", "천쓥냉");
		System.out.println(imgUrlList);
		for(String img : imgUrlList) {
			System.out.println(img);
		}
	}
}
