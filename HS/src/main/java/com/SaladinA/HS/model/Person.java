package com.SaladinA.HS.model;

/**
 * This class is a POJO of Person
 * 
 * @author Amber Saladin
 *
 */
public class Person {
	protected int id;
	protected String patientName;
	protected String ssn;
	protected String age;
	protected String phoneNumber;
	protected String status;

	/**
	 * 
	 * @param id          unique identifier for Person object
	 * @param patientName first and last name of Person Object
	 * @param ssn         social security number of Person object
	 * @param age         age of Person object
	 * @param phoneNumber phone number of Person object
	 * @param status      status of patient of Person object
	 */
	public Person(int id, String patientName, String ssn, String age, String phoneNumber, String status) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.ssn = ssn;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	/**
	 * {@link Person#id}
	 * 
	 * @return id of Person
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * {@link Person#patientName}
	 * 
	 * @return patient's name
	 */
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * {@link Person#ssn}
	 * 
	 * @return person's SSN
	 */
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * {@link Person#age}
	 * 
	 * @return age of person
	 */
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * {@link Person#phoneNumber}
	 * 
	 * @return phone number of person
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * {@link Person#status}
	 * 
	 * @return patient status of Person
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * To String used to output to Console
	 */
	@Override
	public String toString() {
		return "[" + patientName + "][" + ssn + "][" + age + "][" + phoneNumber + "][" + status + "]";
	}
}
