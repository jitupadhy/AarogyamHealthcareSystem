/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.bean;

import java.util.Date;

/**
 *
 * @author Manojeet Padhy
 */
public class RegistrationBean {

	private int id;
	private String empName;
	private String empId;
	private String empPassword;
	private String empCity;
	private long empTelephone;
	private int empActiveId;
	private String empRole;
	private String empMailId;

	private String empCreateDate;
	private String empUpdateDate;
	private String empDOB;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public long getEmpTelephone() {
		return empTelephone;
	}

	public void setEmpTelephone(long empTelephone) {
		this.empTelephone = empTelephone;
	}

	public int getEmpActiveId() {
		return empActiveId;
	}

	public void setEmpActiveId(int empActiveId) {
		this.empActiveId = empActiveId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpMailId() {
		return empMailId;
	}

	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}

	public String getEmpCreateDate() {
		return empCreateDate;
	}

	public void setEmpCreateDate(String empCreateDate) {
		this.empCreateDate = empCreateDate;
	}

	public String getEmpUpdateDate() {
		return empUpdateDate;
	}

	public void setEmpUpdateDate(String empUpdateDate) {
		this.empUpdateDate = empUpdateDate;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

}
