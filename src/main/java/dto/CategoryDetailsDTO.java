package dto;

import java.util.List;

public class CategoryDetailsDTO {
	private int categoryDetailsNo;
	private String categoryDetailsName;
	private List<RestaurantDTO>restaurantList;
	
	public CategoryDetailsDTO() {}
	
	
	
	public CategoryDetailsDTO(int categoryDetailsNo, String categoryDetailsName) {
		super();
		this.categoryDetailsNo = categoryDetailsNo;
		this.categoryDetailsName = categoryDetailsName;
	}



	public CategoryDetailsDTO(int categoryDetailsNo, String categoryDetailsName, List<RestaurantDTO> restaurantList) {
		this(categoryDetailsNo,categoryDetailsName);
		this.restaurantList = restaurantList;
	}

	public int getCategoryDetailsNo() {
		return categoryDetailsNo;
	}

	public void setCategoryDetailsNo(int categoryDetailsNo) {
		this.categoryDetailsNo = categoryDetailsNo;
	}

	public String getCategoryDetailsName() {
		return categoryDetailsName;
	}

	public void setCategoryDetailsName(String categoryDetailsName) {
		this.categoryDetailsName = categoryDetailsName;
	}

	public List<RestaurantDTO> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<RestaurantDTO> restaurantList) {
		this.restaurantList = restaurantList;
	}
	
	
}
