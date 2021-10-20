package dto;

import java.util.List;

public class RestaurantDTO {
	private int restaurantNo;
	private int categoryDetailsNo;
	private int restaurantLevel;
	private String restaurantName;
	private String restaurantPhone;
	private String restaurantAddr;
	private String restaurantRoadAddr;
	private String gu;
	private String dong;
	private double restaurantLongitude;
	private double restaurantLatitude;
	private String restaurantRegDate;
	private int restaurantVisited;
	private List<ReviewDTO> reviewList;
	private List<String> hashTagName;
	private List<MenuDTO> menuList;
	private List<String> imgList;
	private String categoryName;
	private String categoryDetailsName;
	
	public RestaurantDTO() {}
	
	public RestaurantDTO(int restaurantLevel, String restaurantName, String restaurantPhone, String restaurantAddr,
			String restaurantRoadAddr, String gu, String dong, double restaurantLongitude, double restaurantLatitude,
			List<String> hashTagName, List<MenuDTO> menuList, List<String> imgList) {
		super();
		this.restaurantLevel = restaurantLevel;
		this.restaurantName = restaurantName;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddr = restaurantAddr;
		this.restaurantRoadAddr = restaurantRoadAddr;
		this.gu = gu;
		this.dong = dong;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
		this.hashTagName = hashTagName;
		this.menuList = menuList;
		this.imgList = imgList;
	}

	public RestaurantDTO(int categoryDetailsNo, int restaurantLevel, String restaurantName, String restaurantPhone,
			String restaurantAddr, String restaurantRoadAddr, String gu, String dong, double restaurantLongitude,
			double restaurantLatitude, List<String> hashTagName,
			List<MenuDTO> menuList, List<String> imgList) {
		super();
		this.categoryDetailsNo = categoryDetailsNo;
		this.restaurantLevel = restaurantLevel;
		this.restaurantName = restaurantName;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddr = restaurantAddr;
		this.restaurantRoadAddr = restaurantRoadAddr;
		this.gu = gu;
		this.dong = dong;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
		this.hashTagName = hashTagName;
		this.menuList = menuList;
		this.imgList = imgList;
	}
	
	//카테고리별로 뿌릴때 식당간단정보 
	public RestaurantDTO(int restaurantNo, int restaurantLevel, String restaurantName) {
		super();
		this.restaurantNo = restaurantNo;
		this.restaurantLevel = restaurantLevel;
		this.restaurantName = restaurantName;
	}
	
	//맛집상세에 따른 정보 
	public RestaurantDTO(int restaurantNo, int categoryDetailsNo, int restaurantLevel, String restaurantName,
			String restaurantPhone, String restaurantAddr, String restaurantRoadAddr, String gu, String dong,
			double restaurantLongitude, double restaurantLatitude, String restaurantRegDate, int restaurantVisited) {
		this(restaurantNo,restaurantLevel,restaurantName);
		this.categoryDetailsNo = categoryDetailsNo;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddr = restaurantAddr;
		this.restaurantRoadAddr = restaurantRoadAddr;
		this.gu = gu;
		this.dong = dong;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantRegDate = restaurantRegDate;
		this.restaurantVisited = restaurantVisited;
	}
	
	//맛집에 따른 리뷰 및 메뉴 
	public RestaurantDTO(int restaurantNo, int categoryDetailsNo, int restaurantLevel, String restaurantName,
			String restaurantPhone, String restaurantAddr, String restaurantRoadAddr, String gu, String dong,
			double restaurantLongitude, double restaurantLatitude, String restaurantRegDate, int restaurantVisited,
			List<ReviewDTO> reviewList, List<MenuDTO> menuList) {
		this(restaurantNo,categoryDetailsNo,restaurantLevel,restaurantName,restaurantPhone,restaurantAddr,restaurantRoadAddr,
				gu,dong,restaurantLongitude,restaurantLatitude,restaurantRegDate,restaurantVisited);
		this.reviewList = reviewList;
		this.menuList = menuList;
	}	

	public RestaurantDTO(int restaurantNo, int categoryDetailsNo, int restaurantLevel, String restaurantName,
			String restaurantPhone, String restaurantAddr, String restaurantRoadAddr, String gu, String dong,
			double restaurantLongitude, double restaurantLatitude, String restaurantRegDate, int restaurantVisited,
			String categoryName, String categoryDetailsName) {
		this(restaurantNo,categoryDetailsNo,restaurantLevel,restaurantName,restaurantPhone,restaurantAddr,restaurantRoadAddr,
				gu,dong,restaurantLongitude,restaurantLatitude,restaurantRegDate,restaurantVisited);
		this.categoryName = categoryName;
		this.categoryDetailsName = categoryDetailsName;
	}
	//맛집 좌표와 이름 
	public RestaurantDTO(String restaurantName, double restaurantLongitude, double restaurantLatitude) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantLatitude = restaurantLatitude;
	}

	public RestaurantDTO(int restaurantNo, int categoryDetailsNo, int restaurantLevel, String restaurantName,
			String restaurantPhone, String restaurantAddr, String restaurantRoadAddr, String gu, String dong,
			double restaurantLongitude, double restaurantLatitude, String restaurantRegDate, int restaurantVisited,
			List<ReviewDTO> reviewList, List<MenuDTO> menuList,
			String categoryName, String categoryDetailsName) {
		this(restaurantNo,categoryDetailsNo,restaurantLevel,restaurantName,restaurantPhone,restaurantAddr,restaurantRoadAddr,
				gu,dong,restaurantLongitude,restaurantLatitude,restaurantRegDate,restaurantVisited);
		this.reviewList = reviewList;
		this.menuList = menuList;
		this.categoryName = categoryName;
		this.categoryDetailsName = categoryDetailsName;
	}
	
	

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	

	public int getRestaurantLevel() {
		return restaurantLevel;
	}

	public void setRestaurantLevel(int restaurantLevel) {
		this.restaurantLevel = restaurantLevel;
	}

	public List<MenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantAddr() {
		return restaurantAddr;
	}

	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public double getRestaurantLongitude() {
		return restaurantLongitude;
	}

	public void setRestaurantLongitude(int restaurantLongitude) {
		this.restaurantLongitude = restaurantLongitude;
	}

	public double getRestaurantLatitude() {
		return restaurantLatitude;
	}

	public void setRestaurantLatitude(int restaurantLatitude) {
		this.restaurantLatitude = restaurantLatitude;
	}

	public String getRestaurantRegDate() {
		return restaurantRegDate;
	}

	public void setRestaurantRegDate(String restaurantRegDate) {
		this.restaurantRegDate = restaurantRegDate;
	}

	public int getRestaurantVisited() {
		return restaurantVisited;
	}

	public void setRestaurantVisited(int restaurantVisited) {
		this.restaurantVisited = restaurantVisited;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public List<String> getHashTagName() {
		return hashTagName;
	}

	public void setHashTagName(List<String> hashTagName) {
		this.hashTagName = hashTagName;
	}

	public int getCategoryDetailsNo() {
		return categoryDetailsNo;
	}

	public void setCategoryDetailsNo(int categoryDetailsNo) {
		this.categoryDetailsNo = categoryDetailsNo;
	}

	public String getRestaurantRoadAddr() {
		return restaurantRoadAddr;
	}

	public void setRestaurantRoadAddr(String restaurantRoadAddr) {
		this.restaurantRoadAddr = restaurantRoadAddr;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public void setRestaurantLongitude(double restaurantLongitude) {
		this.restaurantLongitude = restaurantLongitude;
	}

	public void setRestaurantLatitude(double restaurantLatitude) {
		this.restaurantLatitude = restaurantLatitude;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDetailsName() {
		return categoryDetailsName;
	}

	public void setCategoryDetailsName(String categoryDetailsName) {
		this.categoryDetailsName = categoryDetailsName;
	}
	
	
	
	
	
}
