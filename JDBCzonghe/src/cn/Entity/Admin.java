package cn.Entity;
//登录的实体类
public class Admin {
   //属性---表中的字段
	private Integer id;
	private String username;
	private String password;
	
	//提供get/set方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//提供有参，无参构造---方便创建对象赋值
	public Admin(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
	}
	//提供toString方法---打印对象的内容
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
