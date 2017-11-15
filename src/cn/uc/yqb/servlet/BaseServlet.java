package cn.uc.yqb.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
//@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数action,明确用户到底要请求servlet的哪一个操作(方法)
		String action=request.getParameter("action");
		if(action==null||"".equals(action)){//没有获取到action,说明用户请求的时候没有添加action参数
			
			response.getWriter().println("请求参数非法,必须携带action表明意图");
		}else{
			System.out.println("用户要进行的操作:"+action);
			//使用当前的类名.getMethod(参数)来获得某个方法
			try {
				Method method = this.getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
				if(method!=null){
						method.invoke(this,request,response);
				}
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
