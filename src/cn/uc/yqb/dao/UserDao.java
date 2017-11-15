package cn.uc.yqb.dao;

import cn.uc.yqb.bean.User;
import cn.uc.yqb.utils.Result;

public interface UserDao {
	
	Result getAllUser();
	
	Result loginUser(User user);
	
	Result insertUser(User user);
	
	Result deleteUser(int id);
	
	Result updateUser(int id);
	
	Result getUserById(int id);
	
	Result getUserByUserName(String username);
	
	Result getUserByNickName(String nickname);
	
}
