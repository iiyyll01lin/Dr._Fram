package com.peijie.bean;

public class EmpBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int empno;
	private String ename;
	private String hiredate;
	private int salary;
	private int deptno;
	private String title;
	
	public EmpBean(int empno, String ename, 
			String hiredate, int salary, int deptno, String title) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.salary = salary;
		this.deptno = deptno;
		this.title = title;
	}

	public EmpBean(String ename, String hiredate, int salary, int deptno, String title) {
		super();
		this.ename = ename;
		this.hiredate = hiredate;
		this.salary = salary;
		this.deptno = deptno;
		this.title = title;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
