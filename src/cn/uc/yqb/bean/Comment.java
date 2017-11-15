package cn.uc.yqb.bean;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	
	private int id;
	//评论新闻  ——id
	private int news;
	//评论用户 ——id
	private int user;
	//评论内容
	private String content;
	//评论时间
	private Date creatTime;
	//点赞人数
	private int zanScount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNews() {
		return news;
	}
	public void setNews(int news) {
		this.news = news;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public int getZanScount() {
		return zanScount;
	}
	public void setZanScount(int zanScount) {
		this.zanScount = zanScount;
	}
	
	
}
