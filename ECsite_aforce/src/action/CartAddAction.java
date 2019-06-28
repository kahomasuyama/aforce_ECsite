package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ItemBean;
import bean.ProductBean;
import tool.Action;

public class CartAddAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");

		HttpSession session = request.getSession();
		ItemBean itemBean = new ItemBean();

		//ログインしていなければログイン画面に飛ばす
		if(session.getAttribute("customer")==null) {
			return "login-in.jsp";
		}

//		idがnullの時
		if(request.getParameter("id")==null) {
			return "cart.jsp";
		}
		//商品個数受け取り
		int itemNumber = Integer.parseInt(request.getParameter("quantity"));
		if(itemNumber == 1) {
			itemBean.setCount(itemNumber = 1);
		}else if(itemNumber == 2) {
			itemBean.setCount(itemNumber = 2);
		}else if(itemNumber == 3) {
			itemBean.setCount(itemNumber = 3);
		}else if(itemNumber == 4) {
			itemBean.setCount(itemNumber = 4);
		}else if(itemNumber == 5) {
			itemBean.setCount(itemNumber = 5);
		}
		session.setAttribute("itemBean", itemBean);


		//カートに追加する商品番号を取得
		int id = Integer.parseInt(request.getParameter("id"));

		//sessionからカートの情報（ItemBean）を取得
		List<ItemBean> cart = (List<ItemBean>) session.getAttribute("cart");

		//カート情報がない時カートsessionを生成する
		if (cart == null) {
			cart = new ArrayList<ItemBean>();
			session.setAttribute("cart", cart);
//			int price =itemBean.getProduct().getPrice();
//			int count = itemBean.getCount();
//			int total = price * count;
//			session.setAttribute("total",total);
		}

		for (ItemBean i : cart) {
			//商品番号を使ってこれから追加する商品がカートに存在したとき、今のcount(数量)プラス１をしsetCountする
			//カート内の商品番号 == カートに追加したい商品番号
			if (i.getProduct().getId() == id) {
				i.setCount(i.getCount() + 1);
				return "cart.jsp";
			}
		}


		//これから追加する商品が存在しない場合の処理
		//セッション属性から商品のリストを取得
		List<ProductBean> list = (List<ProductBean>) session.getAttribute("list");
		for (ProductBean p : list) {
			if (p.getId() == id) {
//				itemBean.setCount(1);
				itemBean.setProduct(p);
				cart.add(itemBean);
			}
		}


		//カートがnullじゃないとき（商品情報がカートにあるとき？？）
		//合計金額を表示
//
//		int price =itemBean.getProduct().getPrice();
//		int count = itemBean.getCount();
//		int total = (int) session.getAttribute("total");
//		int totalPrice  =price * count + total;
//		System.out.println(total);
//		session.setAttribute("totalPrice", totalPrice);
////		if(cart != null) {
////			session.getAttribute("total");
////			int price2 =itemBean.getProduct().getPrice();
////			int count2 = itemBean.getCount();
////			int totalT  =price2 * count2 + total;
////			session.setAttribute("total", totalT);
//			itemBean.setTotalPrice(total);
//			session.setAttribute("total", total);
//			session.setAttribute("itemBean", itemBean);
//		}




		session.setAttribute("cart", cart);
		return "cart.jsp";
	}
}
