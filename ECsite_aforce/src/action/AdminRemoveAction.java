package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import tool.Action;

public class AdminRemoveAction extends Action{
//	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));


		ProductDAO productDAO = new ProductDAO();
		productDAO.delete(id);

//		TODO この書き方で！！！！！！！！！！！！！！！！！！！！！！setしてないですcartと比べる、deleteしたあとどうなるか？
		session.removeAttribute("product");

		return "admin.jsp";
	}
}
