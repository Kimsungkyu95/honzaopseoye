/*
package dataSetting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadSmallExcel {
	
	public static void main(String[] args) {
		XSSFWorkbook workbook = null;
		KakaoSearchAPI kakao = new KakaoSearchAPI();
		JSONArray restaurantArray = null;
		JSONObject restaurantObject = null;
		RestaurantDBSetting rdbs = new RestaurantDBSetting();
		ImageCrawling imageCrawl = new ImageCrawling();
		try {
			//엑셀파일 읽어들이기
			FileInputStream fis= new FileInputStream("resources/seoul_district_small.xlsx");
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0); //0번째 시트 가져옴
			int rows = sheet.getPhysicalNumberOfRows(); //시트의 총 row 수
			
			for(int i = 0; i < rows; i++) { 
				XSSFRow row = sheet.getRow(i);
				if(row != null) { //row가 비어있지 않은 경우만
					int cells = row.getPhysicalNumberOfCells(); //i번째 row의 cell 개수
					
					//첫번째 셀이 string 타입인 경우만. 빈칸나오면 바로 for문 중지.
					if(row.getCell(0).getCellType() != CellType.STRING) {
						break;
					}
					
					String gu = row.getCell(0).getStringCellValue(); //구 가져오기

					for(int j = 1; j <= cells; j++) {
						XSSFCell cell = row.getCell(j); //j번째 cell의 값을 가져옴
						if(cell != null) { //cell이 비어 있지 않은 경우만
							if(cell.getCellType() != CellType.STRING) { //셀이 string 타입인 경우만. 빈칸나오면 바로 for문 중지
								break;
							}						
//							System.out.println("================================================");
							String dong = cell.getStringCellValue(); //동 가져오기
*/
////////////////////////////////restaurantObject 하나 받아오기//////////////////////////////////////////////////////////////////////////
/*
							restaurantObject = kakao.search(gu, dong, "디저트");	//세부 카테고리 교체						
							
							//이미지 api호출해서 이미지URL 리스트 받아오기
//							String placeName = (String)restaurantObject.get("place_name");
//							List<String> imgUrlList = kakao.imgSearch(dong, "디저트", placeName); //세부 카테고리 교체
							
							String placeUrl = (String)restaurantObject.get("place_url");
							List<String> imgUrlList = imageCrawl.imageCrawling(placeUrl);
							
							
							//데이터베이스 insert 및 이미지 폴더에 이미지 삽입
							int result = rdbs.restaurantInsert(restaurantObject, imgUrlList, gu, dong, "디저트", "디저트", 1); //대 카테고리 / 소 카테고리 / 소 카테고리 번호
							if(result > 0) {
								System.out.println(i + "번째 구 " + j + "번째 동 " + "맛집 데이터 삽입에 성공하였습니다.");
							}else {
								System.out.println(i + "번째 구 " + j + "번째 동 " + "맛집 데이터 삽입에 실패하였습니다.");
							}
*/							
////////////////////////////////////restaurantArray 받아오기///////////////////////////////////////////////////////////
/*							restaurantArray = kakao.searchArr(gu, dong, "한정식");
							for(int k = 0; k < Math.min(5, restaurantArray.size()) ; k++) {
								JSONObject jsonObj = (JSONObject)restaurantArray.get(k);
								
								String placeUrl = (String)jsonObj.get("place_url");
								List<String> imgUrlList = imageCrawl.imageCrawling(placeUrl);
								
								//데이터베이스 insert 및 이미지 폴더에 이미지 삽입
								int result = rdbs.restaurantInsert(jsonObj, imgUrlList, gu, dong, "한식", "한정식", 10); //대 카테고리 / 소 카테고리 / 소 카테고리 번호
								
								if(result > 0) {
									System.out.println(i + "번째 구 " + j + "번째 동 " + k + "번째 맛집 데이터 삽입에 성공하였습니다.");
								}else {
									System.out.println(i + "번째 구 " + j + "번째 동 " + k + "번째 맛집 데이터 삽입에 실패하였습니다.");
								}
							}
								            	
						}
					}
				
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
*/
