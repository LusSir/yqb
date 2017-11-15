package cn.uc.yqb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yqb.dao.impl.CommentDaoImpl;
import cn.uc.yqb.utils.Result;
import cn.uc.yqb.utils.WriteResultToClient;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	CommentDaoImpl commentDao=new CommentDaoImpl();
	public void deleteComment(HttpServletRequest request, HttpServletResponse response) {
		int commentid=Integer.parseInt(request.getParameter("comid"));
		Result result = commentDao.deleteComment(commentid);
		WriteResultToClient.writeMethod(result, response);
	}
}
