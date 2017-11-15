package cn.uc.yqb.dao;

import cn.uc.yqb.bean.Admin;
import cn.uc.yqb.bean.User;
import cn.uc.yqb.utils.Result;

public interface AdminDao {
	
	Result getAllAdmin();
	
	Result loginAdmin(User user);

	Result insertAdmin(Admin admin);
	
	Result deleteAdmin(int id);
	
	Result updateAdmin(Admin admin);
	
	Result getAdminById(int id);
	
	Result getAdminByUserId(int userId);
	
}
