package com.shihan.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shihan.springboot.model.StudentInfo;

public interface StudentInfoRepository extends MongoRepository<StudentInfo, String> {


	
	
}
