package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;
import tool.Action;

public class AdminAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProductDAO dao = new ProductDAO();
		ProductBean productBean = new ProductBean();
		HttpSession session = request.getSession();

		String productName = request.getParameter("newProductName");
		Integer price = Integer.parseInt(request.getParameter("newPrice"));
		String priceRange = request.getParameter("newPriceRange");

		if(priceRange.equals("300")) {
			productBean.setPriceRange("1");
		}else if(priceRange.equals("600")) {
			productBean.setPriceRange("2");
		}else {
			productBean.setPriceRange("3");
		}

		productBean.setName(productName);
		productBean.setPrice(price);

		dao.insert(productBean);

		List<ProductBean> list = dao.search("");
		session.setAttribute("list", list);

		return "admin.jsp";
	}

}
