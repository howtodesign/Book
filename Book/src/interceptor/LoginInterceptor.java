package interceptor;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	// 로그인 필요한 페이지 이전에 실행할 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginId") != null &&
				session.getAttribute("loginId").toString().length()>0){
			return true;
		}else{
			response.sendRedirect("main.do");
			return false;
		}
	}

	
}
=======


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class LoginInterceptor extends HandlerInterceptorAdapter{



	// 로그인 필요한 페이지 이전에 실행할 메소드

	@Override

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)

			throws Exception {

		HttpSession session = request.getSession();

		if(session.getAttribute("loginId") != null &&

				session.getAttribute("loginId").toString().length()>0){

			return true;

		}else{

			response.sendRedirect("main.do");

			return false;

		}

	}



	

}
>>>>>>> jyh
