package cn.test;

import java.sql.Connection;
import java.sql.SQLException;

import cn.Util.DBHelper;

public class Test {
public static void main(String[] args) throws SQLException {
	  Connection coon=DBHelper.getConn();
	  System.out.println(coon);
}
}
