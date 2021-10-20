package cn.Dao;

import java.util.ArrayList;
import cn.Entity.Book;

public interface BookDao {
	//添加
	int insert(Book book);
	//全查
	ArrayList<Book> selectAll();
   //输入名称查询
	Book selectbooks (String bname);
	//删除
	int delete(int id);
	//修改
	Book selectbooks (int id);
	int update(Book b,int id);

}
