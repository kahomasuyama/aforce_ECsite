package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ItemBean;
import tool.Action;

public class CartRemoveAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession();

		int id=Integer.parseInt(request.getParameter("id"));

		List<ItemBean> cart=(List<ItemBean>)session.getAttribute("cart");
//		ItemBean itemBean = new ItemBean();
//		itemBean.setCount(1); //+++
//		session.setAttribute("itemBean",itemBean);

//		countを消すためにItemBeanの情報も消せばよい？？？→BeanのsetCountを１にする？？？
		for (ItemBean i : cart) {
			if (i.getProduct().getId()==id) {
				cart.remove(i);
				break;
			}
		}
//		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
//		ItemBean itemBean = new ItemBean();
//		itemBean.setCount(itemNumber=1);
//		session.setAttribute("itemNumber", itemNumber);
////		session.setAttribute(i.getCount());

		return "cart.jsp";
	}
}
