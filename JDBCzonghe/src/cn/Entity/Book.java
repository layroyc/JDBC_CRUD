package cn.Entity;
public class Book {
	 private int id;
	 private String bname;
	 private String bauthor;
	 private int bprice;
	 private String btype;
	 private String bmark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBmark() {
		return bmark;
	}
	public void setBmark(String bmark) {
		this.bmark = bmark;
	}
	public Book(int id,String bname,String bauthor,int bprice,String btype,String bmark){
		this.id = id;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.btype = btype;
		this.bmark = bmark;
	}
	
	public Book(){
		super();
	}
     //修改的有参构造
	public Book(String bname, String bauthor, String btype,int bprice,
			String bmark) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.btype = btype;
		this.bmark = bmark;
	}
	//添加的有参构造
	public Book(String bname2, String bauthor2, int bprice2, String btype2,
			String bmark2) {
		// TODO Auto-generated constructor stub
		this.bname = bname2;
		this.bauthor = bauthor2;
		this.bprice = bprice2;
		this.btype = btype2;
		this.bmark = bmark2;
	}
	public String toString() {
		return "Book [id=" + id + ", bname=" + bname + ", bauthor=" + bauthor
				+ ", bprice=" + bprice + ", btype=" + btype + ", bmark="
				+ bmark + "]";
	}
	
}
