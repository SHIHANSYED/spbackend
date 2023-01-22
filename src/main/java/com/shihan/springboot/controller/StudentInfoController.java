package com.shihan.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.shihan.springboot.model.StudentInfo;
import com.shihan.springboot.repository.StudentInfoRepository;
import com.shihan.springboot.service.SequenceGeneratorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/studentinfo")
public class StudentInfoController {

	@Autowired
	private StudentInfoRepository studenInfoRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@PostMapping
	public StudentInfo createStudentInfo(@RequestBody StudentInfo studentInfo) {
		long c = sequenceGeneratorService.generateSequence();
		String s = new StringBuilder("R-").append(c).toString();
		studentInfo.setId(s);
		return studenInfoRepository.save(studentInfo);
	}
	
	@GetMapping
	public List<StudentInfo> getStudentInfo() {

		return studenInfoRepository.findAll();
	}
	@GetMapping("/{division}")
	public List<StudentInfo> getStudentInfoByDivision(@PathVariable String division) {
		List<StudentInfo> studentInfo = studenInfoRepository.findAll();
		studentInfo = studentInfo.stream().filter(s->s.getDivision().equalsIgnoreCase(division)).collect(Collectors.toList());
		return studentInfo;

	}
	@GetMapping("/name")
	public List<StudentInfo> getStudentInfoByName() {

		return studenInfoRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	
}
