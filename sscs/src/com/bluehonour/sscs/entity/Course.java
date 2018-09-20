package com.bluehonour.sscs.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 课程类
 * @author 蓝尊宝
 * 2018年5月27日 下午8:34:39
 */
public class Course implements Serializable,Comparable<Course> {
	
	private int cno;
	private String name;
	private int credit;
	private Date periodstart;
	private Date periodend;
	private Teacher teacher;
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
	public Date getPeriodstart() {
		return periodstart;
	}
	public void setPeriodstart(Date periodstart) {
		this.periodstart = periodstart;
	}
	public Date getPeriodend() {
		return periodend;
	}
	public void setPeriodend(Date periodend) {
		this.periodend = periodend;
	}
	public Course(int cno, String name, int credit, Date periodstart, Date periodend) {
		super();
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.periodstart = periodstart;
		this.periodend = periodend;
	}
	public Course() {
	}
	
	public Course(String name, int credit, Date periodstart, Date periodend) {
		super();
		this.name = name;
		this.credit = credit;
		this.periodstart = periodstart;
		this.periodend = periodend;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cno;
		result = prime * result + credit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((periodend == null) ? 0 : periodend.hashCode());
		result = prime * result + ((periodstart == null) ? 0 : periodstart.hashCode());
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
		Course other = (Course) obj;
		if (cno != other.cno)
			return false;
		if (credit != other.credit)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (periodend == null) {
			if (other.periodend != null)
				return false;
		} else if (!periodend.equals(other.periodend))
			return false;
		if (periodstart == null) {
			if (other.periodstart != null)
				return false;
		} else if (!periodstart.equals(other.periodstart))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", name=" + name + ", credit=" + credit + ", periodstart=" + periodstart
				+ ", periodend=" + periodend + "]";
	}
	@Override
	public int compareTo(Course o) {
		return this.cno - o.cno;
	}
	
	
}
