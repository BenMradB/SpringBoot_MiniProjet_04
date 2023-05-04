package com.bilel.SpringBoot_TP01.services;

import java.util.List;

import com.bilel.SpringBoot_TP01.dto.CourseDTO;
import org.springframework.data.domain.Page;

import com.bilel.SpringBoot_TP01.entities.Course;
import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.entities.Teacher;

public interface CourseService {
	CourseDTO addCourse(Course course);
	CourseDTO updateCourse(Course course);
	CourseDTO concertEntityToDTO(Course course);
	Course convertDtoToEntity(CourseDTO courseDTO);
	CourseDTO getCourse(Long courseId);
	List<CourseDTO> getAllCourses();
	Page<CourseDTO> getAllCourseByPage(int page, int size);
	void deleteCourseById(Long courseId);
	void deleteCourse(Course course);
	List<CourseDTO> findByTeacher(Teacher teacher);
	List<CourseDTO> findByTeacherTeacherId(Long teacherId);
	List<CourseDTO> findBySpeciality(Speciality speciality);
	List<CourseDTO> findCoursesBySpecialityId(Long specialityId);
}
