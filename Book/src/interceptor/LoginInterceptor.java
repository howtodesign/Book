package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import repository.MemberDAO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private MemberDAO dao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginId") != null &&
				session.getAttribute("loginId").toString().length()>0){
			String flag = dao.getFlag((String)session.getAttribute("loginId"));
			if(flag==null){
				response.sendRedirect("memberCheck.do");
				return false;
			}
			if(flag.equals("b")){
				response.sendRedirect("memberBan.do");
				return false;
			}
			return true;
		}else{
			response.sendRedirect("memberCheck.do");
			return false;
		}
	}
}
