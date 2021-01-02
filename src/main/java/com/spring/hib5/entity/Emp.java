package com.spring.hib5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpHib5")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empNo;
	
	@Column (name = "EMPNAME", length = 50, nullable = false)
	private String empName;
	
	@Column (name = "CITY", length = 30)
	private String city;

	public Emp() {
		super();
	}

	public Emp(int empNo, String empName, String city) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.city = city;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", city=" + city + "]";
	}
}
