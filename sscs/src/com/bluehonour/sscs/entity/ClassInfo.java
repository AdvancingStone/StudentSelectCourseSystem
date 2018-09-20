package com.bluehonour.sscs.entity;

public class ClassInfo {
	
	private int classno;
	private String cname;
	private String cteacher;
	private String classroom;
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
	public String getCteacher() {
		return cteacher;
	}
	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public ClassInfo(int classno, String cname, String cteacher, String classroom) {
		super();
		this.classno = classno;
		this.cname = cname;
		this.cteacher = cteacher;
		this.classroom = classroom;
	}
	public ClassInfo() {
	}
	@Override
	public String toString() {
		return "ClassInfo [classno=" + classno + ", cname=" + cname + ", cteacher=" + cteacher + ", classroom=" + classroom
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classno;
		result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((cteacher == null) ? 0 : cteacher.hashCode());
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
		ClassInfo other = (ClassInfo) obj;
		if (classno != other.classno)
			return false;
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (cteacher == null) {
			if (other.cteacher != null)
				return false;
		} else if (!cteacher.equals(other.cteacher))
			return false;
		return true;
	}
	
	
}
