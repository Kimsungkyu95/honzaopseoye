package dto;

import java.util.List;

public class CategoryDTO {
	private int categoryNo;
	private String categoryName;
	private List<CategoryDetailsDTO> categoryDetailsList;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
