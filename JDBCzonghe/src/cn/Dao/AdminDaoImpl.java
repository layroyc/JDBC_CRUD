package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.Entity.Admin;
import cn.Util.DBHelper;

public class AdminDaoImpl implements AdminDao {

	public Admin selectByUsername(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//��������
			conn=DBHelper.getConn();
			//��дsql���
			String sql="select * from admin where username=? and password=?";
			//����PrepareStatement  ִ��sql
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,username);
			pstm.setString(2,password);
		    rs=pstm.executeQuery();
			//��������
			while(rs.next()){
				admin=new Admin(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(rs, pstm, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return admin;
	}

}
