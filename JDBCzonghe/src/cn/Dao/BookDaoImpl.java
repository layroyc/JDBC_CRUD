package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.Entity.Book;
import cn.Util.DBHelper;

public class BookDaoImpl implements BookDao {
	//添加
	public int insert(Book book) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			//书写sql语句
			conn=DBHelper.getConn();
			String sql1 = "insert into book(bname,bauthor,bprice,btype,bmark) values (?,?,?,?,?)";
			//创建preparedStatement,执行sql
			ps=conn.prepareStatement(sql1);
			ps.setString(1, book.getBname());
			ps.setString(2, book.getBauthor());
			ps.setInt(3, book.getBprice());
			ps.setString(4,book.getBtype());
			ps.setString(5,book.getBmark());
			i=ps.executeUpdate();
			System.out.println(i);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入有问题！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return i;
	}
	//全查
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			con=DBHelper.getConn();
			String sql2="select * from book";
			ps=con.prepareStatement(sql2);
			ResultSet rs=ps.executeQuery(); 
			Book e=null;
			while(rs.next()){
				e=new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6)
						); 
				list.add(e);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}	
		return list;
	}
	//输入名称查询
	public Book selectbooks(String bname){
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Book book=null;
		try {
			con=DBHelper.getConn();
			String sql2="select * from book where bname=?";
			ps=con.prepareStatement(sql2);
			ps.setString(1, bname);
			rs=ps.executeQuery(); 

			while(rs.next()){
			  book=new Book(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getString(5),
					rs.getString(6)
					  );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return book;	
	}
	//删除
	public int delete(int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int a=0;
		try {
			con=DBHelper.getConn();
			String sql3="delete from book where id=?";
			ps=con.prepareStatement(sql3);
			ps.setInt(1,id);
			a=ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return 0;

	}
	//修改
	public int update(Book Book,int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBHelper.getConn();
			String sql4="update book set bname=?,bauthor=?,btype=?,bprice=?,bmark=? where id=?";
			ps=con.prepareStatement(sql4);
			
			ps.setString(1,Book.getBname());
			ps.setString(2,Book.getBauthor());
			ps.setString(3,Book.getBtype());
			ps.setInt(4,Book.getBprice());
			ps.setString(5, Book.getBmark());
			ps.setInt(6, id);
			int c=ps.executeUpdate();
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return 0;		
	}
	//按id来查询
	public Book selectbooks(int id) {
		// TODO Auto-generated method stub
		Book book=new Book();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBHelper.getConn();
			String sql2="select * from book where id=?";
			ps=con.prepareStatement(sql2);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 

			while(rs.next()){
//				System.out.print(rs.getInt("id")+" ");
//				System.out.print(rs.getString("bname")+" ");
//				System.out.print(rs.getString("bauthor")+" ");
//				System.out.print(rs.getInt("bprice")+" ");
//				System.out.print(rs.getString("btype")+" ");
//				System.out.print(rs.getString("bmark")+" ");
				
				book.setId(rs.getInt("id"));
				book.setBname(rs.getString("bname"));
				book.setBauthor(rs.getString("bauthor"));
				book.setBprice(rs.getInt("bprice"));
				book.setBtype(rs.getString("btype"));
				book.setBmark(rs.getString("bmark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return book;	
	}
}

