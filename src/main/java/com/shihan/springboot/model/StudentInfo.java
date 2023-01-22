package com.shihan.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studentInfo")
public class StudentInfo {

	@Id
	private String id;

	private String name;
	private String dob;
	private String className;
	private String division;
	private String gender;

	
	public StudentInfo(String name, String dob, String className, String division, String gender) {
		this.name = name;
		this.dob = dob;
		this.className = className;
		this.division = division;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



}
