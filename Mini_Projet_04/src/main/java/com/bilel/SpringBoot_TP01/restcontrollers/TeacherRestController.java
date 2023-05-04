package com.bilel.SpringBoot_TP01.restcontrollers;

import java.util.List;

import com.bilel.SpringBoot_TP01.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.services.TeacherService;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin
public class TeacherRestController {
	@Autowired
	private TeacherService teacherService;

	@GetMapping("/all")
	List<TeacherDTO> getAllTeachers() {
		return this.teacherService.getAllTeachers();
	}

	@GetMapping
	Page<TeacherDTO> getTeachersPageByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		return this.teacherService.getTeachersByPage(page, size);
	}

	@GetMapping("/{teacherId}")
	TeacherDTO getTeacherById(@PathVariable("teacherId") Long teacherId) {
		return this.teacherService.getTeacher(teacherId);
	}

	@PostMapping
	TeacherDTO createNewTeacher(@RequestBody Teacher teacher) {
		return this.teacherService.createTeacher(teacher);
	}

	@PatchMapping("/{teacherId}")
	TeacherDTO updateTeacher(@PathVariable("teacherId") Long teaherId, @RequestBody Teacher teacher) {
		teacher.setTeacherId(teaherId);
		return this.teacherService.updateTeacher(teacher);
	}

	@DeleteMapping("/{teacherId}")
	void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
		this.teacherService.deleteTeacherById(teacherId);
	}
}
