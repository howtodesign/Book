package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginId") != null &&
			session.getAttribute("loginId").toString().length()>0 &&
			session.getAttribute("flagAdmin") !=null &&
			session.getAttribute("flagAdmin").toString().equals("admin11")){
			return true;
		}else{
			response.sendRedirect("main.do");
			return false;
		}
	}

	
}
