package cn.uc.yqb.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yqb.dao.TypeDao;
import cn.uc.yqb.dao.impl.TypeDaoImpl;
import cn.uc.yqb.utils.Result;
import cn.uc.yqb.utils.WriteResultToClient;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/TypeServlet")
public class TypeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	TypeDao typeDao=new TypeDaoImpl();
	public void getAllType(HttpServletRequest request,HttpServletResponse response){
		Result result=typeDao.getAllType();
		WriteResultToClient.writeMethod(result, response);
	}
	
	public void getTypeById(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		Result result=typeDao.getTypeById(id);
		WriteResultToClient.writeMethod(result, response);
	}
}
