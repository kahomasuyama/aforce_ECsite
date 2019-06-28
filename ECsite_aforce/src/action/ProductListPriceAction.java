package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;
import tool.Action;

public class ProductListPriceAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session  = request.getSession();
		ProductDAO dao = new ProductDAO();

//		価格帯検索
		String priceRange = request.getParameter("priceRange");
		List<ProductBean> list2 = new ArrayList<>();
		if(priceRange.equals("300")) {
			list2 = dao.searchPrice1(priceRange);
		}else if(priceRange.equals("600")) {
			list2 = dao.searchPrice2(priceRange);
		}else {
			list2 = dao.searchPrice3(priceRange);
		}
		System.out.println(priceRange);


		session.setAttribute("list2", list2);

		return "productPrice.jsp";
	}

}