package com.bluehonour.sscs.entity;

public class CriteriaStudent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sno;
	private String sname;
	private String sex;//性别
	private String classno;
	private String remark;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public CriteriaStudent(String sno, String sname, String sex, String classno, String remark) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.classno = classno;
		this.remark = remark;
	}

	public CriteriaStudent() {
	}
	@Override
	public String toString() {
		return "CriteriaStudent [sno=" + sno + ", sname=" + sname + ", sex=" + sex + ", classno=" + classno
				+ ", remark=" + remark + "]";
	}
	
}
