package com.bilel.SpringBoot_TP01.services;

import java.util.List;

import com.bilel.SpringBoot_TP01.dto.TeacherDTO;
import org.springframework.data.domain.Page;

import com.bilel.SpringBoot_TP01.entities.Teacher;

public interface TeacherService {
	TeacherDTO createTeacher(Teacher teacher);
	TeacherDTO updateTeacher(Teacher teacher);
	TeacherDTO getTeacher(Long teacherId);
	TeacherDTO convertEntityToDTO(Teacher teacher);
	Teacher convertDtoToEntity(TeacherDTO teacherDTO);
	void deleteTeacher(Teacher teacher);
	void deleteTeacherById(Long id);
	List<TeacherDTO> getAllTeachers();
	Page<TeacherDTO> getTeachersByPage(int page, int size);
	List<TeacherDTO> findByUserName(String userName);
	List<TeacherDTO> findByUserNameContains(String name);
	List<TeacherDTO> findByUserNameEmail(String userName, String email);
	List<TeacherDTO> sortTeacherByLastNameEmail();
}
