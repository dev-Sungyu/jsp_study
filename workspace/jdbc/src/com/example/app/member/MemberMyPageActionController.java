package com.example.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Action;
import com.example.app.Result;
import com.example.app.dao.MemberDAO;
import com.example.app.domain.MemberVO;

public class MemberMyPageActionController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
//	memberId가 원래 Long 타입인데 get 메소드를 썼으니까 최상위 객체인 Object로 업캐스팅됨 그래서 사용할떄는 다운캐스팅을 하고 사용해야함
		req.setAttribute("memberVO", memberDAO.select((Long)req.getSession().getAttribute("memberId")));
		
		result.setPath("myPage.jsp");
		result.setRedirect(false);
		return result;
	}

}
