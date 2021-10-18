package dto;

public class MenuDTO {
	private int menuNo;
	private int restaurantNo;
	private String menuName;
	private int menuPrice;
	
	public MenuDTO() { }

	public MenuDTO(int menuNo, int restaurantNo, String menuName, int menuPrice) {
		super();
		this.menuNo = menuNo;
		this.restaurantNo = restaurantNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	
	public MenuDTO(String menuName, int menuPrice) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}
	
	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
}
