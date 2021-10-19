package controller.servlet.adminRestaurant;
/*{name:'restaurantNo', width:60},
{name:'restaurantName', width:90},
{name:'phone', width:100},
{name:'restaurantAddr', width:80},
{name:'category', width:150, align:"right"},
{name:'categoryDetails', width:80, align:"right"},
{name:'regdate', width:80, align:"right"},
{name:'visited', width:80, align:"right"}*/
public class GridModel {
	private int restaurantNo;
	private String restaurantName;
	private String phone;
	private String restaurantAddr;
	private String category;
	private String categoryDetails;
	private String regDate;
	private int visited;
	
	public GridModel(int restaurantNo, String restaurantName, String phone, String restaurantAddr, String category,
			String categoryDetails, String regDate, int visited) {
		super();
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.phone = phone;
		this.restaurantAddr = restaurantAddr;
		this.category = category;
		this.categoryDetails = categoryDetails;
		this.regDate = regDate;
		this.visited = visited;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestaurantAddr() {
		return restaurantAddr;
	}

	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(String categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}
	
	
	
}
