package cn.uc.yqb.utils;

public class Constants {
	
	//响应码
	public static final int RETCODE_SUCCESS=0;
	public static final int RETCODE_FAILED=2000;
	
	//定义映射文件.xml的包的根路径
	public static final String root="cn.uc.yqb.mapper";
	
	//定义mapper映射文件的名称
	public static final String userMapper=".UserMapper";
	public static final String adminMapper=".AdminMapper";
	public static final String newsMapper=".NewsMapper";
	public static final String commentMapper=".CommentMapper";
	public static final String typeMapper=".TypeMapper";
	
	//定义操作的sql语句的id名称
	public static final String selectAll=".selectAll";
	public static final String insert=".insert";
	public static final String delete=".delete";
	public static final String update=".update";
	public static final String login=".login";
	public static final String selectById=".selectById";
	public static final String selectByPage=".selectByPage";
	
	//User用户的操作语句路径
	public static final String selectAllUser=root+userMapper+selectAll;
	public static final String insertUser=root+userMapper+insert;
	public static final String deleteUser=root+userMapper+delete;
	public static final String updateUser=root+userMapper+update;
	public static final String loginUser=root+userMapper+login;
	public static final String selectUserById=root+userMapper+selectById;
	
	//Admin管理员的操作语句路径
	public static final String selectAllAdmin=root+adminMapper+selectAll;
	public static final String insertAdmin=root+adminMapper+insert;
	public static final String deleteAdmin=root+adminMapper+delete;
	public static final String updateAdmin=root+adminMapper+update;
	public static final String loginAdmin=root+adminMapper+login;
	public static final String selectAdminById=root+adminMapper+selectById;
	
	//News新闻的操作语句路径
	public static final String selectAllNews=root+newsMapper+selectAll;
	public static final String insertNews=root+newsMapper+insert;
	public static final String deleteNews=root+newsMapper+delete;
	public static final String updateNews=root+newsMapper+update;
	public static final String selectNewsById=root+newsMapper+selectById;
	public static final String selectNewsByPage=root+newsMapper+selectByPage;
	
	//Comment评论的操作语句路径
	public static final String selectAllComment=root+commentMapper+selectAll;
	public static final String insertComment=root+commentMapper+insert;
	public static final String deleteComment=root+commentMapper+delete;
	public static final String updateComment=root+commentMapper+update;
	public static final String selectCommentById=root+adminMapper+selectById;
	
	//Type类型的操作语句路径
	public static final String selectAllType=root+typeMapper+selectAll;
	public static final String insertType=root+typeMapper+insert;
	public static final String deleteType=root+typeMapper+delete;
	public static final String updateType=root+typeMapper+update;
	public static final String selectTypeById=root+typeMapper+selectById;
}