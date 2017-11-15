package cn.uc.yqb.bean;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
	//管理员 主键  id
	private int id;
	//管理员关联的用户  id  
	private int user;
	//管理员账号状态
	private boolean state;
	//管理员等级
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setRank(int int1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", user=" + user + ", state=" + state + ", level=" + level + "]";
	}
	
}
