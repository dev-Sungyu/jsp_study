package com.example.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.member.MemberJoinActionController;
import com.example.app.member.MemberLoginActionController;
import com.example.app.member.MemberMyPageActionController;

public class MemberFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String uri = req.getRequestURI();
      String target = uri  // day01/a/login.me
            .replaceAll(req.getContextPath() + "/"     // day01/a/를 없애겠다.
                  , "") // login.me가 남음
            .split(".")  // split .을 기준으로 배열을 만든다.
            [0];  // {login, me}가 남음 그 중 0번째 방이므로 login이 나온다
      Result result = null;
		
		if(target.equals("join")) {
			result = new Result();
			result.setPath("/join.jsp");
			result.setRedirect(false);
			
		}else if(target.equals("checkIdAction")) {
//			Ajax라서 페이지 이동이 없기에 result에 안담음
			new MemberCheckIdActionController().execute(req, resp);
			
		}else if(target.equals("joinAction")) {
			result = new MemberJoinActionController().execute(req, resp);
//			 로그인 페이지로 이동하는것
		}else if(target.equals("login")) {
			result = new Result();
			result.setPath(req.getContextPath() + "/login.jsp");
			result.setRedirect(true);
//			로그인 페이지에서 아이디 비밀번호 작성후 로그인 버튼을 누른 것
		}else if(target.equals("loginAction")) {
			result = new MemberLoginActionController().execute(req, resp);
			
		}else if(target.equals("myPageAction")) {
			result = new MemberMyPageActionController().execute(req, resp);
		}else {
			
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {		// forward 방식으로 보내줌
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}





