package dataSetting;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageCrawlingTest {

	public static void main(String[] args) {
		
		String URL = "https://place.map.kakao.com/27288738";
		
		try {
			Connection conn = Jsoup.connect(URL);
			Document html = conn.get(); //HTML 파싱. conn.post()
			Elements listPhotos = html.select(".photo_area");
			System.out.println(listPhotos.size());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
