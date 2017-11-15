package cn.uc.yqb.dao;

import cn.uc.yqb.bean.News;
import cn.uc.yqb.utils.Result;

public interface NewsDao {
	
	Result getAllNews();
	
	Result insertNews(News news);
	
	Result deleteNews(int id);
	
	Result updateNews(News news);
	
	Result getNewsById(int id);
	
	Result getNewsByPage(int num);
	
	Result getNewsByTitle(String title);
	
	Result getNewsByTypeId(int typeId);
	
}
