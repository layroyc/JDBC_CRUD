package cn.Dao;

import java.util.ArrayList;
import cn.Entity.Book;

public interface BookDao {
	//���
	int insert(Book book);
	//ȫ��
	ArrayList<Book> selectAll();
   //�������Ʋ�ѯ
	Book selectbooks (String bname);
	//ɾ��
	int delete(int id);
	//�޸�
	Book selectbooks (int id);
	int update(Book b,int id);

}
