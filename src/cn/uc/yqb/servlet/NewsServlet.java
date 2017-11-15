package cn.uc.yqb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yqb.bean.News;
import cn.uc.yqb.dao.NewsDao;
import cn.uc.yqb.dao.impl.NewsDaoImpl;
import cn.uc.yqb.utils.Result;
import cn.uc.yqb.utils.WriteResultToClient;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	NewsDao newsDao=new NewsDaoImpl();
	public void getAllNews(HttpServletRequest request,HttpServletResponse response){
		Result result=newsDao.getAllNews();
		WriteResultToClient.writeMethod(result, response);
	}
	public void insertNews(HttpServletRequest request,HttpServletResponse response){
		String title=request.getParameter("title");
		String source=request.getParameter("source");
		String author =request.getParameter("author");
		String content =request.getParameter("content");
		String editorValue=request.getParameter("editorValue");
		int typeid=Integer.parseInt(request.getParameter("typeid"));
	    boolean ifHot=Boolean.parseBoolean(request.getParameter("ifHot"));
		News news=new News();
	    news.setAuthor(author);
	    news.setContent(editorValue);
	    news.setCreatTime(new Date());
	    news.setHot(ifHot);
	    news.setSource(source);
	    news.setTitle(title);
	    news.setContent(content);
	    news.setType(typeid);
		Result result=newsDao.insertNews(news);
		WriteResultToClient.writeMethod(result, response);
	}
	public void deleteNews(HttpServletRequest request,HttpServletResponse response){
		int newsid=Integer.parseInt(request.getParameter("id"));
		Result result = newsDao.deleteNews(newsid);
		WriteResultToClient.writeMethod(result, response);
	}
	public void updateNews(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String source=request.getParameter("source");
		String author =request.getParameter("author");
		String content =request.getParameter("content");
		String editorValue=request.getParameter("editorValue");
		int  typeid=Integer.parseInt(request.getParameter("typeid"));
	    boolean ifHot=Boolean.parseBoolean(request.getParameter("ifHot"));
		News news=new News();
		news.setId(id);
	    news.setAuthor(author);
	    news.setContent(editorValue);
	    news.setCreatTime(new Date());
	    news.setHot(ifHot);
	    news.setSource(source);
	    news.setTitle(title);
	    news.setContent(content);
	    news.setType(typeid);
		Result result=newsDao.updateNews(news);
		WriteResultToClient.writeMethod(result, response);
	}
	
	public void getNewsByPage(HttpServletRequest request,HttpServletResponse response,int num){
		Result result=newsDao.getNewsByPage(num);
		WriteResultToClient.writeMethod(result, response);
	}
}
