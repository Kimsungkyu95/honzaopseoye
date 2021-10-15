package dataSetting;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;

public class RestaurantDBSetting {
	
	public int restaurantInsert(JSONObject restaurantObject, List<String> imgUrlList, String gu, String dong, String categoryName, String categoryDetailsName, int categoryDetailsNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into restaurant values(restaurant_seq.nextval,?, 1, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, 0)";
		int result = 0;
		int img_result = 0;
		
		//쿼리 값 
		String placeName = (String)restaurantObject.get("place_name");
		String phone = (String)restaurantObject.get("phone");
		String addressName = (String)restaurantObject.get("address_name");
		String roadAddressName = (String)restaurantObject.get("road_address_name");
		Double longitude = Double.parseDouble((String)restaurantObject.get("x"));
		Double latitude = Double.parseDouble((String)restaurantObject.get("y"));
		
		try {
			conn = DbSettingUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryDetailsNo); //카테고리 상세번호
			ps.setString(2, placeName); //맛집이름
			ps.setString(3, phone); //전화번호
			ps.setString(4, addressName); //지번주소
			ps.setString(5, roadAddressName); //도로명주소
			ps.setString(6, gu); //구
			ps.setString(7, dong); //동
			ps.setDouble(8, longitude); //경도
			ps.setDouble(9, latitude); //위도
			result = ps.executeUpdate();
			
			img_result = imgInsert(conn, imgUrlList, placeName, categoryName, categoryDetailsName);
//			if(img_result > 0) {
//				System.out.println("이미지 삽입에 성공하였습니다");				
//			}else {
//				System.out.println("이미지 삽입에 실패하였습니다");
//			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbSettingUtil.close(conn, ps, null);
		}
		return result;
	}
	
	public int imgInsert(Connection conn , List<String> imgUrlList, String placeName, String categoryName, String categoryDetailsName) throws Exception {
		PreparedStatement ps = null;
		String sql = "insert into restaurant_img values(restaurant_img_seq.nextval, restaurant_seq.currval, ?)";
		int result = 0;
		URL url = null;
		
		File forder = new File("C:/Edu/webProgramming/webWork/honzaopseoye/src/main/webapp/img/restaurantImage/" + categoryName + "/" + categoryDetailsName + "/" + placeName);
		
		//폴더 존재하지 않으면 생성!
		if(!forder.exists()) {
			try {
				forder.mkdir(); //폴더 생성
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//이미지 삽입 및, db에 insert
		try {	
			ps = conn.prepareStatement(sql);
			String imgName = "";
			for(int i=0; i < imgUrlList.size(); i++) {
				
				//이미지 저장
				url = new URL(imgUrlList.get(i));
				BufferedImage image = ImageIO.read(url);
				
				imgName = placeName + i + ".jpg";
				
				File file = new File("C:/Edu/webProgramming/webWork/honzaopseoye/src/main/webapp/img/restaurantImage/"+ categoryName + "/" + categoryDetailsName+ "/" + placeName + "/" + imgName);
				ImageIO.write(image, "jpg", file);
				
				//insert 쿼리실행
				ps.setString(1, imgName);			
				result = ps.executeUpdate();
			}
			
		}finally {
			DbSettingUtil.close(null, ps, null);
		}
		return result;
	}
	
	//단위 테스트
	public static void main(String [] args) {
//		RestaurantDBSetting rdbs = new RestaurantDBSetting();
//
//		int result = rdbs.restaurantInsert();
//		if(result > 0) {
//			System.out.println("insert에 성공하였습니다.");
//		}else {
//			System.out.println("insert에 성공하였습니다.");
//		}
	}
}
