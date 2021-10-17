/*
package dataSetting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImageCrawling {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:\\Edu\\util\\chromedriver.exe"; //드라이버 경로

	public List<String> imageCrawling(String url) {
		List<String> imgUrlList = new ArrayList<String>();
		
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		}catch (Exception e) {
			e.printStackTrace();
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(url);
		
		try {Thread.sleep(2000);}catch (Exception e) {
		}
		
		List<WebElement> listPhotos = driver.findElements(By.className("list_photo"));
		for(WebElement we : listPhotos) {
			List<WebElement> linkPhotos = we.findElements(By.className("link_photo"));
			for(WebElement linkPhoto : linkPhotos) {
				String imgUrl = linkPhoto.getAttribute("style").substring(23, linkPhoto.getAttribute("style").length()-3);
				imgUrlList.add("https:" + imgUrl);
			}
		}
		
		return imgUrlList;

	}
	
	public static void main(String args []) {
		ImageCrawling ic = new ImageCrawling();
		List<String> urlList = ic.imageCrawling("https://place.map.kakao.com/7912367");
		for(String url : urlList) {
			System.out.println(url);
		}
	}

}
*/