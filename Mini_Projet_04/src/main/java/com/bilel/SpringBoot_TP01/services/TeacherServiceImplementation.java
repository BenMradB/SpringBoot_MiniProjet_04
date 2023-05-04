package com.bilel.SpringBoot_TP01.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bilel.SpringBoot_TP01.dto.TeacherDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.repos.TeacherRepo;

import static org.modelmapper.convention.MatchingStrategies.*;

@Service
public class TeacherServiceImplementation implements TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;

	@Autowired
	ModelMapper modelMapper;


	@Override
	public TeacherDTO createTeacher(Teacher teacher) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String hashedPassword = bcrypt.encode(teacher.getPassword());
		teacher.setPassword(hashedPassword);
		
		return this.convertEntityToDTO(
				this.teacherRepo.save(teacher)
		);
	}

	@Override
	public TeacherDTO updateTeacher(Teacher teacher) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String hashedPassword = bcrypt.encode(teacher.getPassword());
		teacher.setPassword(hashedPassword);
		return this.convertEntityToDTO(
				this.teacherRepo.save(teacher)
		);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		this.teacherRepo.delete(teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		this.teacherRepo.deleteById(id);

	}

	@Override
	public List<TeacherDTO> getAllTeachers() {
		return this.teacherRepo.findAll().stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Page<TeacherDTO> getTeachersByPage(int page, int size) {
		return new PageImpl<>(this.teacherRepo.findAll(PageRequest.of(page, size)).stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList()));
	}

	@Override
	public TeacherDTO getTeacher(Long teacherId) {
		// TODO Auto-generated method stub
		return this.convertEntityToDTO(
				this.teacherRepo.findById(teacherId).get()
		);
	}

	@Override
	public TeacherDTO convertEntityToDTO(Teacher teacher) {
		modelMapper.getConfiguration().setMatchingStrategy(LOOSE);
		return modelMapper.map(teacher, TeacherDTO.class);
	}

	@Override
	public Teacher convertDtoToEntity(TeacherDTO teacherDTO) {
		return modelMapper.map(teacherDTO, Teacher.class);
	}

	@Override
	public List<TeacherDTO> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.teacherRepo.findByUserName(userName).stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<TeacherDTO> findByUserNameContains(String name) {
		// TODO Auto-generated method stub
		return this.findByUserNameContains(name);
	}

	@Override
	public List<TeacherDTO> findByUserNameEmail(String userName, String email) {
		// TODO Auto-generated method stub
		return this.findByUserNameEmail(userName, email);
	}

	@Override
	public List<TeacherDTO> sortTeacherByLastNameEmail() {
		// TODO Auto-generated method stub
		return this.sortTeacherByLastNameEmail();
	}



}
