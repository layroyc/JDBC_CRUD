package cn.Dao;

import cn.Entity.Admin;

public interface AdminDao {
  //登录--查询--返回一条数据  一个对象
	Admin selectByUsername(String username,String password);
}
