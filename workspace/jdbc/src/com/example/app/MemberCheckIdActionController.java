package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.app.dao.MemberDAO;

public class MemberCheckIdActionController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter out = resp.getWriter();
		
		JSONObject jsonObject = new JSONObject();
		try {
//									여기에서 나오는 리턴값이 boolean값이므로 check에 그 값을 넣어줌
			jsonObject.put("check", memberDAO.checkId(req.getParameter("memberIdentification")));
		} catch (JSONException e) {
			e.printStackTrace();
		}
//		서블릿상의 HTML로 제작(body태그 안에 들어감)Ajax는 인식함
		out.print(jsonObject.toString());
		out.close();
//		페이지 이동을 할게 아니니까 리턴 안함
		return null;
	}

}












