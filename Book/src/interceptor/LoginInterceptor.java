package interceptor;
<<<<<<< HEAD

import java.io.IOException;

=======

>>>>>>> refs/remotes/origin/dev
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

<<<<<<< HEAD
=======
	// 로그인 필요한 페이지 이전에 실행할 메소드
>>>>>>> refs/remotes/origin/dev
	@Override
<<<<<<< HEAD
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
=======
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
>>>>>>> refs/remotes/origin/dev
		HttpSession session = request.getSession();
<<<<<<< HEAD
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null && loginId.length()>0) {
=======
		if(session.getAttribute("loginId") != null &&
				session.getAttribute("loginId").toString().length()>0){
>>>>>>> refs/remotes/origin/dev
			return true;
<<<<<<< HEAD
=======
		}else{
			response.sendRedirect("main.do");
			return false;
>>>>>>> refs/remotes/origin/dev
		}
<<<<<<< HEAD
	response.sendRedirect("main.do");
	return false;
=======
>>>>>>> refs/remotes/origin/dev
	}
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/dev
	
<<<<<<< HEAD
	
}
=======
}
>>>>>>> refs/remotes/origin/dev
