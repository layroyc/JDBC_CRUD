package cn.Dao;

import cn.Entity.Admin;

public interface AdminDao {
  //��¼--��ѯ--����һ������  һ������
	Admin selectByUsername(String username,String password);
}
