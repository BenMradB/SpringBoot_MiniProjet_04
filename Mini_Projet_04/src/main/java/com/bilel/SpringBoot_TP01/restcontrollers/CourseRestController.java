package com.bilel.SpringBoot_TP01.restcontrollers;

import java.util.List;

import com.bilel.SpringBoot_TP01.dto.CourseDTO;
import com.bilel.SpringBoot_TP01.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.bilel.SpringBoot_TP01.entities.Course;
import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.services.CourseService;
import com.bilel.SpringBoot_TP01.services.SpecialityService;
import com.bilel.SpringBoot_TP01.services.TeacherService;

@RequestMapping("/api/courses")
@RestController
@CrossOrigin
public class CourseRestController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private SpecialityService specialityService;

	@GetMapping
	Page<CourseDTO> getCoursesPageByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		return this.courseService.getAllCourseByPage(page, size);
	}

	@GetMapping("/all")
	List<CourseDTO> getAllCourses() {
		return this.courseService.getAllCourses();
	}

	@GetMapping("/{courseId}")
	CourseDTO getCourseById(@PathVariable("courseId") Long courseId) {
		return this.courseService.getCourse(courseId);
	}

	@GetMapping("/teacher_courses/{teacherId}")
	List<CourseDTO> getAllCoursesByTeacher(@PathVariable("teacherId") Long teacherId) {
		return this.courseService.findByTeacherTeacherId(teacherId);
	}

	@GetMapping("/speciality_courses/{specialityId}")
	List<CourseDTO> getAllCoursesBySpeciality(@PathVariable("specialityId") Long specialityId) {
		return this.courseService.findCoursesBySpecialityId(specialityId);
	}

	@PostMapping("/create")
	CourseDTO createNewCourse(@RequestBody Course course, @RequestParam("teacher") Long teacherId,
			@RequestParam("speciality") Long specialityId) {
		Teacher teacher = this.teacherService.convertDtoToEntity(
				this.teacherService.getTeacher(teacherId)
		);
		Speciality speciality = this.specialityService.convertDtoToEntity(
				this.specialityService.getSpecialityById(specialityId)
		);

		course.setTeacher(teacher);
		course.setSpeciality(speciality);

		return this.courseService.addCourse(course);
	}

	@PatchMapping("/{courseId}")
	CourseDTO updateCourse(@RequestBody Course course, @PathVariable("courseId") Long courseId, @RequestParam("teacher") Long teacherId, @RequestParam("speciality") Long specialityId) {
		Teacher teacher = this.teacherService.convertDtoToEntity(
				this.teacherService.getTeacher(teacherId)
		);
		Speciality speciality = this.specialityService.convertDtoToEntity(
				this.specialityService.getSpecialityById(specialityId)
		);

		course.setTeacher(teacher);
		course.setSpeciality(speciality);

		course.setCourseId(courseId);

		return this.courseService.updateCourse(course);
	}

	@DeleteMapping("/{courseId}")
	void deleteCourse(@PathVariable("courseId") Long courseId) {
		this.courseService.deleteCourseById(courseId);
	}

}
