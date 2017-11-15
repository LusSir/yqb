
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import cn.uc.yqb.bean.News;
import cn.uc.yqb.bean.User;
import cn.uc.yqb.dao.AdminDao;
import cn.uc.yqb.dao.NewsDao;
import cn.uc.yqb.dao.TypeDao;
import cn.uc.yqb.dao.impl.AdminDaoImpl;
import cn.uc.yqb.dao.impl.NewsDaoImpl;
import cn.uc.yqb.dao.impl.TypeDaoImpl;
import cn.uc.yqb.utils.Result;

public class Test1 {

//	@Test
//	public void test() {
//		AdminDao adminDao = new AdminDaoImpl();
//		User user = new User("root", "root");
//		Result result = adminDao.loginAdmin(user);
//		System.out.println(result.getRetCode());
//		Assert.assertEquals(true, result.isRetMsg());
//	}
	
//	@Test
//	public void test(){
//		AdminDao adminDao = new AdminDaoImpl();
//		Result result=adminDao.getAllAdmin();
//		System.out.println(result.getRetData());
//		Assert.assertEquals(true, result.isRetMsg());
//	}
	
/*	@Test
	public void test(){
		NewsDao newsDao = new NewsDaoImpl();
		Result result=newsDao.getAllNews();
		System.out.println(result.getRetData());
		Assert.assertEquals(true, result.isRetMsg());
	}*/
	
/*	@Test
	public void test(){
		TypeDao typeDao=new TypeDaoImpl();
		Result result=typeDao.getAllType();
		System.out.println(result.getRetData());
		Assert.assertEquals(true, result.isRetMsg());
	}
*/
/*	@Test
	public void test(){
		NewsDao newsDao = new NewsDaoImpl();
		News news =new News();
		news.setCommCount(0);
		news.setContent("敲尼玛");
		news.setCreatTime(new Date());
		news.setAuthor("敲尼玛");
		news.setHot(false);
		news.setReadCount(0);
		news.setShareCount(0);
		news.setSource("网易新闻");
		news.setTitle("敲里吗");
		news.setType(1);
		Result result=newsDao.insertNews(news);
		System.out.println(result.getRetData());
		Assert.assertEquals(true, result.isRetMsg());
	}*/
	
	
/*	@Test
	public void test(){
		TypeDao type=new TypeDaoImpl();
		Result result=type.getTypeById(1);
		System.out.println(result.getRetData());
		Assert.assertEquals(true, result.isRetMsg());
	}*/
	
	@Test
	public void test(){
		NewsDao newsDao = new NewsDaoImpl();
		News news =new News();
		news.setId(17);
		news.setCommCount(0);
		news.setContent("敲尼玛");
		news.setCreatTime(new Date());
		news.setAuthor("敲尼玛");
		news.setHot(false);
		news.setReadCount(0);
		news.setShareCount(0);
		news.setSource("网易新闻11");
		news.setTitle("敲里吗");
		news.setType(1);
		Result result=newsDao.updateNews(news);
		System.out.println(result.getRetData());
		Assert.assertEquals(true, result.isRetMsg());
	}
	
}
