package com.SaladinA.HS.model;

public class Person {
	protected int id;
	protected String patientName;
	protected String ssn;
	protected String age;
	protected String phoneNumber;
	protected String status;
	public Person(int id, String patientName, String ssn, String age, String phoneNumber, String status) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.ssn = ssn;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "[" + patientName + "][" + ssn + "][" + age + "][" + phoneNumber
				+ "][" + status + "]";
	}
}
