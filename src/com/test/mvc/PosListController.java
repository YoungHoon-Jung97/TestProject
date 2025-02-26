/*=========================
 * HelloCotroller.java
 * -사용자 정의 컨트롤러
=========================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class PosListController implements Controller
{
	private IPositionDAO dao;
	
	public void setDao(IPositionDAO dao)
	{
		this.dao = dao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// Controller 가 수행해야 할 액션 코드
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("name")==null)			//-- 로그인이 되어있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		
		try
		{
			
			ArrayList<Position> positions = dao.list();
			mav.addObject("positions",positions);
			mav.setViewName("/WEB-INF/view/PosList.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	
		return mav;
	}


	
}