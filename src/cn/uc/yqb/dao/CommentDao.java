package cn.uc.yqb.dao;

import cn.uc.yqb.utils.Result;

public interface CommentDao {
	
	Result getAllComment();
	
//	Result insertComment(News news);
	
	Result deleteComment(int id);
	
//	Result updateComment(int id);
	
	Result getCommentById(int id);
	
	Result getCommentByNews(String news);
	
}
