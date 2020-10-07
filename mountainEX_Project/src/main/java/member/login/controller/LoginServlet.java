package member.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.login.model.MemberBean;


@WebServlet("/member/login/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		if ( !email.equals("j@jjj.mail") ) {
			request.getRequestDispatcher("login.jsp").forward(request, response);;
			return;
		}
		
		MemberBean memberBean = new MemberBean();
		
		memberBean.setEmail(email);
		memberBean.setPwd(pwd);
		
		request.getSession().setAttribute("memberBean", memberBean);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		MemberBean attribute = (MemberBean)request.getSession().getAttribute("memberBean");
		System.out.println(attribute.getEmail());
		
		
		return;
	}

}
