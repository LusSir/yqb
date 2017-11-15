package cn.uc.yqb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yqb.bean.Admin;
import cn.uc.yqb.bean.User;
import cn.uc.yqb.dao.AdminDao;
import cn.uc.yqb.utils.Constants;
import cn.uc.yqb.utils.MyBatisUtils;
import cn.uc.yqb.utils.Result;

public class AdminDaoImpl implements AdminDao {
	
	@Override
	public Result getAllAdmin() {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<Admin> list=session.selectList(Constants.selectAllAdmin);
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
	public Result loginAdmin(User user) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		User user1=session.selectOne(Constants.loginUser,user);
		session.close();
		if(user1!=null){
			SqlSession session1=MyBatisUtils.openSession();
			Admin admin=session1.selectOne(Constants.loginAdmin,user1.getId());
			session1.close();
			if(admin.isState()){
				result.setRetCode(Constants.RETCODE_SUCCESS);
				result.setRetMsg(true);
			}else{
				result.setRetCode(Constants.RETCODE_FAILED);
				result.setRetMsg(false);
			}
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);	
		}
		return result;
	}

	@Override
	public Result insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.insertAdmin, admin);
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(admin);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.deleteAdmin, id);
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
	public Result updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.updateAdmin, admin);
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(admin);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getAdminByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
