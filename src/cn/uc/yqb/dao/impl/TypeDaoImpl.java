package cn.uc.yqb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import cn.uc.yqb.bean.Type;
import cn.uc.yqb.dao.TypeDao;
import cn.uc.yqb.utils.Constants;
import cn.uc.yqb.utils.MyBatisUtils;
import cn.uc.yqb.utils.Result;

public class TypeDaoImpl implements TypeDao {

	@Override
	public Result getAllType() {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<Type> list=session.selectList(Constants.selectAllType);
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
	public Result insertNews(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getTypeById(int id) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		Type type=session.selectOne(Constants.selectTypeById,id);
		session.close();
		if(type!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(type);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		
		return result;
	}

}
