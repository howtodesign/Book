package interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null && loginId.length()>0) {
			return true;
		}
	response.sendRedirect("main.do");
	return false;
	}
	
	
}
