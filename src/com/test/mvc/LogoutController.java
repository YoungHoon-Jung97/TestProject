/*=========================
 * LogoutController.java
 * -사용자 정의 컨트롤러
 * -로그아웃 액션 처리
 * 	→ 처리 이후 다시 로그인 폼을 요청할 수 있도록 안내
=========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class LogoutController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// Controller 가 수행해야 할 액션 코드
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("name");
		session.removeAttribute("admin");
		
		//로그아웃 뷰 페이지 지정 기능
		// → 안전하게 로그아웃 처리되었습니다.
		//	로그인 페이지로 돌아가기
		
		//바로 로그인 페이지를 다시 요청할 수 있도록 안내
		mav.setViewName("redirect:loginform.action");
	
		return mav;
	}


	
}