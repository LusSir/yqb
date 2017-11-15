package cn.uc.yqb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yqb.bean.Comment;
import cn.uc.yqb.dao.CommentDao;
import cn.uc.yqb.utils.Constants;
import cn.uc.yqb.utils.MyBatisUtils;
import cn.uc.yqb.utils.Result;

public class CommentDaoImpl implements CommentDao {

	@Override
	public Result getAllComment() {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<Comment> list=session.selectList(Constants.selectAllComment);
		session.commit();
		session.close();
		if(list!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(list);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result deleteComment(int id) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.deleteComment, id);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result getCommentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getCommentByNews(String news) {
		// TODO Auto-generated method stub
		return null;
	}

}
