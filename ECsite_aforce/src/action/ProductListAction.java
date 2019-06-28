package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ProductDAO;
import tool.Action;

public class ProductListAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session  = request.getSession();
		ProductDAO dao = new ProductDAO();

		//ログインしていなければログイン画面に飛ばす
		if(session.getAttribute("customer")==null) {
			return "login-in.jsp";
		}

//		キーワード検索
		String keyword = request.getParameter("keyword");
		//普通に商品一覧・検索ボタンを押したときは空文字が検索されているために商品すべて表示される
		if(keyword == null) {
			keyword="";
		}
		List<ProductBean> list = dao.search(keyword);


		session.setAttribute("list", list);

		return "product.jsp";
	}

}
