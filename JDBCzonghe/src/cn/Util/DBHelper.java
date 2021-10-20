package cn.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {
	//创建保存配置信息的对象 Properties  的特点以键值对保存信息，并且类型是String
	   private static Properties prop = new Properties();
		static{
			//静态代码块 只执行一次 当这个类被调用的时候 静态代码块就开始加载执行
				InputStream in=null;
				try {
					//读取配置文件，指定配置文件位置
					in = DBHelper.class.getResourceAsStream("/mysql_jdbc.properties");
					//将流中信息加载到prop中保存
					prop.load(in);
					//1.加载驱动
					Class.forName(prop.getProperty("driver"));
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			//提供获取连接功能
			public static Connection getConn() throws SQLException{
				//2.获取连接
				Connection conn= DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				return conn;
			}
			//提供关闭资源的功能--针对于查询
			public static void close(ResultSet rs,PreparedStatement ps,Connection con) throws SQLException{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			}
			
			//方法重载--针对于增删改
			public static void close(PreparedStatement ps,Connection con) throws SQLException{
				if(ps!=null) ps.close();
				if(con!=null) con.close();
}
}