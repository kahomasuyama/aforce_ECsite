package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session  = request.getSession();
		if(session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");
			return "logout-success.jsp";
		}
		return "logout-error.jsp";
	}
}
