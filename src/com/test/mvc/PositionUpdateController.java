/*=========================
 * PositionUpdateController.java
 * -사용자 정의 컨트롤러
=========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 의 Controller 인터페이스를 구형하는 방법을 통해
//	사용자 정의 컨트롤러 클래스를 구성한다.

public class PositionUpdateController implements Controller
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
		
		if (session.getAttribute("name") == null)		//로그인 안되어 있을 경우
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if(session.getAttribute("admin")==null)	//관리자 아이디로 다시 로그인
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		String positionId = request.getParameter("id");
		String positonName = request.getParameter("name");
		String strMinBasicPay = request.getParameter("minBasicPay");
		int minBasicPay = Integer.parseInt(strMinBasicPay);
		
		try
		{
			Position pos = dao.searchName(positonName);
			
			if (pos == null)
			{
				
				Position position = new Position();
				
				position.setMinBasicPay(minBasicPay);
				position.setPositionId(positionId);
				position.setPositionName(positonName);
				
				
				dao.modify(position);
				
				mav.setViewName("redirect:positionlist.action");
				return mav;
			}
			
			String message = "이미 존재로 수정할 수 없습니다.";
			mav.addObject("message", message);
			mav.setViewName("redirect:positionlist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}


	
}