package com.pknu.room.vo;

public class RoomVO {
	
	// Fields
	private String fname;
	private String lname;
	private String ckindate;
	private String ckoutdate;
	private int    numofpp;
	private String natity;
	private String phone;
	private String csid;
	private int    roomnum;
	private String accid;
	private String roomtype;
	private int    roomfloor;
	private int    ppnum;
	private String email;
	private String cspwd;
	
	// Constructors
	public RoomVO(String fname, String lname, String ckindate, String ckoutdate, int numofpp, String natity,
			String phone, String csid, int roomnum) {
		this.fname = fname;
		this.lname = lname;
		this.ckindate = ckindate;
		this.ckoutdate = ckoutdate;
		this.numofpp = numofpp;
		this.natity = natity;
		this.phone = phone;
		this.csid = csid;
		this.roomnum = roomnum;
	}
	public RoomVO(String fname, String lname, String ckindate, String ckoutdate, int numofpp, String natity,
			String phone, String csid, int roomnum, String accid) {
		this.fname = fname;
		this.lname = lname;
		this.ckindate = ckindate;
		this.ckoutdate = ckoutdate;
		this.numofpp = numofpp;
		this.natity = natity;
		this.phone = phone;
		this.csid = csid;
		this.roomnum = roomnum;
		this.accid = accid;
	}
	public RoomVO(int roomnum, String roomtype, int roomfloor, int ppnum) {
		this.roomnum = roomnum;
		this.roomtype = roomtype;
		this.roomfloor = roomfloor;
		this.ppnum = ppnum;
	}
	
	public RoomVO(String fname, String lname, String csid, String email) {
		this.fname = fname;
		this.lname = lname;
		this.csid = csid;
		this.email = email;
	}
	public RoomVO() {
		
	}
	
	// Getter and Setter
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCkindate() {
		return ckindate;
	}
	public void setCkindate(String ckindate) {
		this.ckindate = ckindate;
	}
	public String getCkoutdate() {
		return ckoutdate;
	}
	public void setCkoutdate(String ckoutdate) {
		this.ckoutdate = ckoutdate;
	}
	public int getNumofpp() {
		return numofpp;
	}
	public void setNumofpp(int numofpp) {
		this.numofpp = numofpp;
	}
	public String getNatity() {
		return natity;
	}
	public void setNatity(String natity) {
		this.natity = natity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getRoomfloor() {
		return roomfloor;
	}
	public void setRoomfloor(int roomfloor) {
		this.roomfloor = roomfloor;
	}
	public int getPpnum() {
		return ppnum;
	}
	public void setPpnum(int ppnum) {
		this.ppnum = ppnum;
	}
	public String getCspwd() {
		return cspwd;
	}
	public void setCspwd(String cspwd) {
		this.cspwd = cspwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// toString
	@Override
	public String toString() {
		return "RoomVO [fname=" + fname + ", lname=" + lname + ", ckindate=" + ckindate + ", ckoutdate=" + ckoutdate
				+ ", numofpp=" + numofpp + ", natity=" + natity + ", phone=" + phone + ", csid=" + csid + ", roomnum="
				+ roomnum + "]";
	}
	
	
}
