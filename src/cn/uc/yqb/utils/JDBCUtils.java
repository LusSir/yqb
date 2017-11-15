package cn.uc.yqb.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
     //封装数据库连接对象获取的方法以及关闭相关数据库操作工具类对象的方法
	//1.声明数据库连接的4要素
	static final String driverName="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost:3306/yiqibang";
	static final String user="root";
	static final String password="123456";
	
	static {
		//加载驱动类
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//返回一个连接对象-从驱动管理器获取连接
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConn(PreparedStatement ps, Connection conn, ResultSet rs) throws Exception {
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
