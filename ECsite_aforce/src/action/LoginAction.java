package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import bean.ProductBean;
import dao.CustomerDAO;
import dao.ProductDAO;
import tool.Action;


public class LoginAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");

		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		CustomerDAO dao = new CustomerDAO();

		CustomerBean customer = dao.search(login, password);

//管理者のための商品情報取得
		ProductDAO productdao = new ProductDAO();
		String keyword="";

		List<ProductBean> list = productdao.search(keyword);
		session.setAttribute("list", list);

//ログイン＆パスワード情報があるときはSUCCESS、ないときはERROR
		if(customer != null) {
			if(customer.getLogin().equals("admin")  && customer.getPassword().equals("admin")) {
				return "admin.jsp";
			}else {
				//ログイン状態保持？？
				session.setAttribute("customer", customer);
				return "product.jsp";
			}
		}else {

			return "login-error.jsp";
		}
	}

}
