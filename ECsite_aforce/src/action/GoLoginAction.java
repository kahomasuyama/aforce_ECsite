package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class GoLoginAction extends Action{
		public String execute(HttpServletRequest request,HttpServletResponse response)throws Exception{
			return "login-in.jsp";
		}
}
