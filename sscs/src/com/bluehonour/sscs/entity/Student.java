package com.bluehonour.sscs.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable,Comparable<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sno;
	private String password;
	private String sname;
	private long phone;
	private String sex;//性别
	private Date birthday;
	private int classno;
	private String remark;
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", password=" + password + ", sname=" + sname + ", phone=" + phone + ", sex="
				+ sex + ", birthday=" + birthday + ", classno=" + classno + ", remark=" + remark + "]";
	}
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + classno;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + sno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (classno != other.classno)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (sno != other.sno)
			return false;
		return true;
	}
	public Student(String password, String sname, long phone, String sex, Date birthday, int classno,
			String remark) {
		super();
		this.password = password;
		this.sname = sname;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.classno = classno;
		this.remark = remark;
	}
	
	public Student(int sno, String password, String sname, long phone, String sex, Date birthday, int classno,
			String remark) {
		super();
		this.sno = sno;
		this.password = password;
		this.sname = sname;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.classno = classno;
		this.remark = remark;
	}

	public Student() {
		super();
	}
	public Student(int sno, String sname, String sex, int sclass, String remark) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.classno = sclass;
		this.remark = remark;
	}

	@Override
	public int compareTo(Student o) {
		return this.sno - o.sno;
	}

	
	
}
