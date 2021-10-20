package cn.view;
import java.util.ArrayList;
import java.util.Scanner;

import cn.Dao.AdminDao;
import cn.Dao.AdminDaoImpl;
import cn.Dao.BookDao;
import cn.Dao.BookDaoImpl;
import cn.Entity.Admin;
import cn.Entity.Book;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AdminDao dao=new AdminDaoImpl();
		BookDao e = new BookDaoImpl();
		System.out.println("===============���¼====================");
		System.out.println("�������û�����");
		String username=sc.next();
		System.out.println("���������룺");
		String password=sc.next();
		Admin admin=dao.selectByUsername(username, password);
		if(admin!=null){
			//�û�����
			System.out.println("��ϲ���¼�ɹ���");
			while(true){
			System.out.println("=========================================");
			System.out.println("=========��ӭ����ͼ�����ϵͳ==============");
			System.out.println("====ѡ���ܣ�1.���  2.ȫ��  3.�������Ʋ�ѯ  4.�޸�  5.ɾ��  6.�˳�====");
			System.out.println("=========================================");
			
			int select=sc.nextInt();
			if(select==1){
				System.out.println("��ѡ�������");
				System.out.println("������������");
				String bname = sc.next();
				System.out.println("���������ߣ�");
				String bauthor = sc.next();
				System.out.println("������۸�");
				int bprice= sc.nextInt();
				System.out.println("���������");
				String btype= sc.next();
				System.out.println("�����뱸ע��");
				String bmark= sc.next();
				Book b = new Book(bname,bauthor,bprice,btype,bmark);
				int a = e.insert(b);
				if(a>0){
					System.out.println("��ϲ����ӳɹ���");
				}else{
					System.out.println("���ʧ�ܣ�");
				}
			}else if(select==2){
				System.out.println("��ѡ����ȫ��");
				ArrayList<Book> book=e.selectAll();
				for (Book book2 : book) {
					System.out.println(book2);
				}
			}else if(select==3){
				System.out.println("��ѡ�����������Ʋ�ѯ");
				System.out.println("������Ҫ��ѯ��������");
				String s=sc.next();
				BookDao bki=new BookDaoImpl();
				Book book=bki.selectbooks(s);
				System.out.println(book);
			}else if(select==4){
				System.out.println("��ѡ�����޸�");
				System.out.println("������Ҫ�޸����id��");
				int id= sc.nextInt();
				Book book=e.selectbooks(id);

				System.out.println("��������Ҫ�޸ĵ���ţ�1.����  2.����  3.����  4.�۸�  5.��ע");
				int a=sc.nextInt();
				String bname=book.getBname();
				String bauthor=book.getBauthor();
				String btype=book.getBtype();
				int bprice=book.getBprice();
				String bmark=book.getBmark();

				if(a==1){
					System.out.println("������������");
					bname=sc.next();
				}else if(a==2){
					System.out.println("���������ߣ�");
					bauthor=sc.next();
				}else if(a==3){
					System.out.println("����������");
					btype=sc.next();
				}else if(a==4){
					System.out.println("������۸�");
					bprice=sc.nextInt();
				}else if(a==5){
					System.out.println("�����뱸ע��");
					bmark=sc.next();
				}
				Book b=new Book(bname, bauthor, btype,bprice, bmark);
				int i=e.update(b,id);

				if(i>0){
					System.out.println("��ϲ���޸ĳɹ���");
				}else{
					System.out.println("�޸�ʧ�ܣ�");
				}	
			}else if(select==5){
				System.out.println("��ѡ����ɾ��");
				Scanner sc3= new Scanner(System.in);
				System.out.println("������id��");
				int c=sc3.nextInt();
				int b=e.delete(c); 
				if(b>0){	
					System.out.println("ɾ���ɹ���");
				}else{
					System.out.println("ɾ��ʧ��");
				}
			}else if(select==6){
				System.out.println("�˳���");
				  break;
			}else{
				System.out.println("��ѡ��������Ч��");
			}
		  }
		}else{
			System.out.println("�û������������,����������");
		}
		}
	}