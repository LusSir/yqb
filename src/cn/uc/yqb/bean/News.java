package cn.uc.yqb.bean;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{
	//新闻主键   id
	private int id;
	//新闻关联的类型  id
	private int type;
	//新闻标题
	private String title;
	//新闻来源
	private String source;
	//新闻作者
	private String author;
	//新闻内容
	private String content;
	//创建时间
	private Date creatTime;
	//评论人数
	private int commCount;
	//阅读人数
	private int readCount;
	//分享人数
	private int shareCount;
	//是否热推
	private boolean hot;
	//是否被举报
	private boolean report;
	
	public News() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getCommCount() {
		return commCount;
	}
	public void setCommCount(int commCount) {
		this.commCount = commCount;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public boolean isReport() {
		return report;
	}
	public void setReport(boolean report) {
		this.report = report;
	}

	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", type=" + type + ", title=" + title + ", source=" + source + ", author=" + author
				+ ", content=" + content + ", creatTime=" + creatTime + ", commCount=" + commCount + ", readCount="
				+ readCount + ", shareCount=" + shareCount + ", hot=" + hot + ", report=" + report + "]";
	}
	
	
}
