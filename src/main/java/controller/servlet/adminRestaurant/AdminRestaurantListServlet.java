package controller.servlet.adminRestaurant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class AdminRestaurantListServlet
 */
@WebServlet("/adminRestaurantList")
public class AdminRestaurantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		GridModel gridModel1 = new GridModel(1, "레스토랑1", "010-1111-1111", "서울 송파구", "한식", "고기", "2021-10-19", 5);
		GridModel gridModel2 = new GridModel(2, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel3 = new GridModel(3, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel4 = new GridModel(4, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel5 = new GridModel(5, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel6 = new GridModel(6, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel7 = new GridModel(7, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel8 = new GridModel(8, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel9 = new GridModel(9, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel10 = new GridModel(10, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel11 = new GridModel(11, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		GridModel gridModel12 = new GridModel(12, "레스토랑2", "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", 3);
		List<GridModel> gridModels = new ArrayList<GridModel>();
		
		gridModels.add(gridModel1);
		gridModels.add(gridModel2);
		gridModels.add(gridModel3);
		gridModels.add(gridModel4);
		gridModels.add(gridModel5);
		gridModels.add(gridModel6);
		gridModels.add(gridModel7);
		gridModels.add(gridModel8);
		gridModels.add(gridModel9);
		gridModels.add(gridModel10);
		gridModels.add(gridModel11);
		gridModels.add(gridModel12);
		
		for(int i = 13; i < 2000; i++) {
			gridModels.add(new GridModel(i, "레스토랑" + i, "010-2222-2222", "서울 강남구", "중식", "중화요리", "2021-10-20", i));
		}
		
		JSONArray jsonArray = JSONArray.fromObject(gridModels);
		
		String json = "{'page':1,'total':'3','records':'1','rows':"+jsonArray+"}";
		JSONObject jsonObject = (JSONObject)JSONSerializer.toJSON(json);
		
		PrintWriter out = response.getWriter();
//		out.print(jsonObject);
		out.print(jsonArray);
	}

}
