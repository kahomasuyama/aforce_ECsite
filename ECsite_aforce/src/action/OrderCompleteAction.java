package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class OrderCompleteAction  extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
//		HttpSession session = request.getSession();
//		session.removeAttribute("cart");
		return "orderComplete.jsp";
	}
}