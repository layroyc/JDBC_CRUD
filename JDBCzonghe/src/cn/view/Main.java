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
		System.out.println("===============请登录====================");
		System.out.println("请输入用户名：");
		String username=sc.next();
		System.out.println("请输入密码：");
		String password=sc.next();
		Admin admin=dao.selectByUsername(username, password);
		if(admin!=null){
			//用户存在
			System.out.println("恭喜你登录成功！");
			while(true){
			System.out.println("=========================================");
			System.out.println("=========欢迎来到图书管理系统==============");
			System.out.println("====选择功能：1.添加  2.全查  3.输入名称查询  4.修改  5.删除  6.退出====");
			System.out.println("=========================================");
			
			int select=sc.nextInt();
			if(select==1){
				System.out.println("你选择了添加");
				System.out.println("请输入书名：");
				String bname = sc.next();
				System.out.println("请输入作者：");
				String bauthor = sc.next();
				System.out.println("请输入价格：");
				int bprice= sc.nextInt();
				System.out.println("请输入类别：");
				String btype= sc.next();
				System.out.println("请输入备注：");
				String bmark= sc.next();
				Book b = new Book(bname,bauthor,bprice,btype,bmark);
				int a = e.insert(b);
				if(a>0){
					System.out.println("恭喜你添加成功！");
				}else{
					System.out.println("添加失败！");
				}
			}else if(select==2){
				System.out.println("你选择了全查");
				ArrayList<Book> book=e.selectAll();
				for (Book book2 : book) {
					System.out.println(book2);
				}
			}else if(select==3){
				System.out.println("你选择了输入名称查询");
				System.out.println("请输入要查询的书名：");
				String s=sc.next();
				BookDao bki=new BookDaoImpl();
				Book book=bki.selectbooks(s);
				System.out.println(book);
			}else if(select==4){
				System.out.println("你选择了修改");
				System.out.println("请输入要修改书的id：");
				int id= sc.nextInt();
				Book book=e.selectbooks(id);

				System.out.println("请输入你要修改的序号：1.书名  2.作者  3.类型  4.价格  5.备注");
				int a=sc.nextInt();
				String bname=book.getBname();
				String bauthor=book.getBauthor();
				String btype=book.getBtype();
				int bprice=book.getBprice();
				String bmark=book.getBmark();

				if(a==1){
					System.out.println("请输入书名：");
					bname=sc.next();
				}else if(a==2){
					System.out.println("请输入作者：");
					bauthor=sc.next();
				}else if(a==3){
					System.out.println("请输入类型");
					btype=sc.next();
				}else if(a==4){
					System.out.println("请输入价格：");
					bprice=sc.nextInt();
				}else if(a==5){
					System.out.println("请输入备注：");
					bmark=sc.next();
				}
				Book b=new Book(bname, bauthor, btype,bprice, bmark);
				int i=e.update(b,id);

				if(i>0){
					System.out.println("恭喜你修改成功！");
				}else{
					System.out.println("修改失败！");
				}	
			}else if(select==5){
				System.out.println("你选择了删除");
				Scanner sc3= new Scanner(System.in);
				System.out.println("请输入id：");
				int c=sc3.nextInt();
				int b=e.delete(c); 
				if(b>0){	
					System.out.println("删除成功！");
				}else{
					System.out.println("删除失败");
				}
			}else if(select==6){
				System.out.println("退出！");
				  break;
			}else{
				System.out.println("你选择的序号无效！");
			}
		  }
		}else{
			System.out.println("用户名、密码错误,请重新输入");
		}
		}
	}