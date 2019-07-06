package com.pknu.room.vo;

import java.util.Vector;

// 조회한 것을 담을 객체
public class MemberVO {
	
	// Fields
	private String id;
	private String pwd;
	private String name;
	private String job;
	private String gender;	// M, F
	private String intro;
	private String[] v;
	
	
	// Constructor : class 외부에서 넘어오는 정보를 받기위해 - setter 역할
	// 생성자가 있으면 setter가 필요없다 - 하지만 나중에 값 변경 불가(setter 있으면 가능) 
	public MemberVO(String id, String pwd, String name, String job, String gender, String intro) {
		this.id 	= id;
		this.pwd 	= pwd;
		this.name 	= name;
		this.job 	= job;
		this.gender = gender;
		this.intro 	= intro;
	}


	// Getter : 내 클래스의 정보(Fields)를 외부로 내보냄
	// Setter : 내 클래스의 정보를 외부에서 수정하고자 할 때
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	// toString : for debugging
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", job=" + job + ", gender=" + gender
				+ ", intro=" + intro + "]";
	}
		
}
