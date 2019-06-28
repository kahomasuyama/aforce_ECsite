package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ItemBean;
import bean.ProductBean;
import tool.Action;

public class CartItemNumberAction extends Action{
//	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();

//		selectタグの数量変更
		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		ItemBean itemBean = new ItemBean();
		ProductBean product = new ProductBean();

		if(itemNumber==1) {
			itemBean.setCount(itemNumber=1);
		}else if(itemNumber==2) {
			itemBean.setCount(itemNumber=2);
		}else if(itemNumber ==3) {
			itemBean.setCount(itemNumber=3);
		}
		session.setAttribute("itemBean", itemBean);

//		//カートの情報（ItemBean）を取得
		session.getAttribute("cart");

		session.getAttribute("itemBean");
//		合計金額表示
		int count = itemBean.getCount();
		int price = product.getPrice();

		int total = price * count;
		System.out.println(total);
		itemBean.setTotalPrice(total);
		session.setAttribute("itemBean", itemBean);

//		List<ItemBean> list = (List<ItemBean>) session.getAttribute("list");
//		for(ItemBean total : list) {
//			int price = itemBean.getProduct().getPrice();
//			int count = itemBean.getCount();
//			total = total + (price * count);
//			itemBean.setTotalPrice(total);
//		}

		return "cart.jsp";

	}
}
