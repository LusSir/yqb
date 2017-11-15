package cn.uc.yqb.dao;

import cn.uc.yqb.bean.Type;
import cn.uc.yqb.utils.Result;

public interface TypeDao {

	Result getAllType();
	
	Result insertNews(Type type);
	
	Result deleteType(int id);
	
	Result updateType(int id);
	
	Result getTypeById(int id);
}
