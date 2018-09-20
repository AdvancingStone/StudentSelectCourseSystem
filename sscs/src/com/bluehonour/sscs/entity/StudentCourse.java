package com.bluehonour.sscs.entity;

public class StudentCourse {

	//学生
	private int sno;
	private String sname;
	//班级
	private int classno;
	private String cname;
	//课程
	private int cno;
	private String name;
	private int credit;
	//sc，分数
	private double score;
	@Override
	public String toString() {
		return "StudentCourse [sno=" + sno + ", sname=" + sname + ", classno=" + classno + ", cname=" + cname + ", cno="
				+ cno + ", name=" + name + ", credit=" + credit + ", score=" + score + "]";
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public StudentCourse(int sno, String sname, int classno, String cname, int cno, String name, int credit,
			double score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.classno = classno;
		this.cname = cname;
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.score = score;
	}
	
	public StudentCourse() {
	}
	
	
}
