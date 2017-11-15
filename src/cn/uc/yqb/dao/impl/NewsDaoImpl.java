package cn.uc.yqb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yqb.bean.News;
import cn.uc.yqb.dao.NewsDao;
import cn.uc.yqb.utils.Constants;
import cn.uc.yqb.utils.MyBatisUtils;
import cn.uc.yqb.utils.Result;

public class NewsDaoImpl implements NewsDao {

	@Override
	public Result getAllNews() {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<News> list=session.selectList(Constants.selectAllNews);
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
	public Result insertNews(News news) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.insertNews,news);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(news);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result deleteNews(int id) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.deleteNews, id);
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
	public Result updateNews(News news) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.updateNews, news);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(news);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result getNewsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getNewsByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getNewsByPage(int num) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<News> list=session.selectList(Constants.selectNewsByPage,num);
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

}
