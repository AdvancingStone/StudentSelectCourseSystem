package com.bluehonour.sscs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师类
 * @author 蓝尊宝
 * 2018年5月28日 下午3:03:57
 */
/**
 * @author 蓝尊宝
 * 2018年5月28日 下午3:07:00
 */
public class Teacher implements Serializable,Comparable<Teacher>{
	
	private int tno;
	private String tname;
	private String password;
	private long phone;
	private Date hiredate;
	private String remark;
	
	
	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Teacher() {
	}
	
	public Teacher(String tname, String password, long phone, Date hiredate, String remark) {
		super();
		this.tname = tname;
		this.password = password;
		this.phone = phone;
		this.hiredate = hiredate;
		this.remark = remark;
	}

	public Teacher(int tno, String tname, String password, long phone, Date hiredate, String remark) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.password = password;
		this.phone = phone;
		this.hiredate = hiredate;
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", password=" + password + ", phone=" + phone
				+ ", hiredate=" + hiredate + ", remark=" + remark + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + tno;
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
		Teacher other = (Teacher) obj;
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
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
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno != other.tno)
			return false;
		return true;
	}

	@Override
	public int compareTo(Teacher t) {
		return this.tno - t.tno;
	}
	
	
}
