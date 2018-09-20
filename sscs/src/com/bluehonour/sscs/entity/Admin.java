package com.bluehonour.sscs.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员类
 * @author 蓝尊宝
 * 2018年5月16日 下午4:59:22
 */
public class Admin implements Serializable, Comparable<Admin> {
	
	private String userId;
	private String userName;
	private String password;
	private int age;
	private double score;
	private Date enterDate;
	private String introduction;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Admin() {
		super();
	}
	public Admin(String userId, String userName, String password, int age, double score, Date enterDate, String introduction) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.score = score;
		this.enterDate = enterDate;
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", score=" + score + ", enterDate=" + enterDate + ", hobby=" + introduction + "]";
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((enterDate == null) ? 0 : enterDate.hashCode());
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Admin other = (Admin) obj;
		if (age != other.age)
			return false;
		if (enterDate == null) {
			if (other.enterDate != null)
				return false;
		} else if (!enterDate.equals(other.enterDate))
			return false;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Admin other) {
		return this.userId.compareTo(other.userId);
	}
	
}
