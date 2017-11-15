package cn.uc.yqb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.uc.yqb.bean.Admin;
import cn.uc.yqb.bean.User;
import cn.uc.yqb.dao.AdminDao;
import cn.uc.yqb.dao.impl.AdminDaoImpl;
import cn.uc.yqb.utils.Result;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	AdminDao adminDao=new AdminDaoImpl();
    public void loginAdmin(HttpServletRequest request,HttpServletResponse response){
    
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	String code=request.getParameter("code");
    	
    	HttpSession session=request.getSession();
    	String ccode=String.valueOf(session.getAttribute("ccode"));
    	User user=new User(username,password);
    	Result result =adminDao.loginAdmin(user);
    	
    	if(code.equals(ccode)){
    		System.out.println(result.isRetMsg());
    		if(result.isRetMsg()){
    			try {
					response.sendRedirect(request.getContextPath()+"/index.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}else{
    			session.setAttribute("tip", "用户名或密码错误");
    			try {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}else{
    			session.setAttribute("tip", "验证码错误");
    			try {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	}
    
    }
    public void getAllAdmin(HttpServletRequest request,HttpServletResponse response){
    	System.out.println("getAllAdmin");
    	Result result=adminDao.getAllAdmin();
    	String jsonObj = JSONObject.fromObject(result).toString();
    	try {
			//获取响应工具，并向客户端输出结果
			response.getWriter().println(jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
