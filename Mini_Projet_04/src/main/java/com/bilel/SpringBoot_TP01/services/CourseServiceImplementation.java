package com.bilel.SpringBoot_TP01.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bilel.SpringBoot_TP01.dto.CourseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bilel.SpringBoot_TP01.entities.Course;
import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.entities.Teacher;
import com.bilel.SpringBoot_TP01.repos.CourseRepo;

import static org.modelmapper.convention.MatchingStrategies.*;

@Service
public class CourseServiceImplementation implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CourseDTO addCourse(Course course) {
		// TODO Auto-generated method stub
		return this.concertEntityToDTO(
				this.courseRepo.save(course)
		);
	}

	@Override
	public CourseDTO updateCourse(Course course) {
		// TODO Auto-generated method stub
		return this.concertEntityToDTO(
				this.courseRepo.save(course)
		);
	}

	@Override
	public CourseDTO concertEntityToDTO(Course course) {
		return modelMapper.map(course, CourseDTO.class);
	}

	@Override
	public Course convertDtoToEntity(CourseDTO courseDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(LOOSE);
		return modelMapper.map(courseDTO, Course.class);
	}

	@Override
	public CourseDTO getCourse(Long courseId) {
		// TODO Auto-generated method stub
		return this.concertEntityToDTO(
				this.courseRepo.findById(courseId).get()
		);
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		// TODO Auto-generated method stub
		return this.courseRepo.findAll().stream()
				.map(this::concertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Page<CourseDTO> getAllCourseByPage(int page, int size) {
		// TODO Auto-generated method stub
		return new PageImpl<>(
				this.courseRepo.findAll(PageRequest.of(page, size)).stream()
						.map(this::concertEntityToDTO)
						.collect(Collectors.toList())
		);
	}

	@Override
	public void deleteCourseById(Long courseId) {
		// TODO Auto-generated method stub
		this.courseRepo.deleteById(courseId);
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		this.courseRepo.delete(course);
	}

	@Override
	public List<CourseDTO> findByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return this.courseRepo.findByTeacher(teacher).stream()
				.map(this::concertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> findByTeacherTeacherId(Long teacherId) {
		// TODO Auto-generated method stub
		return this.courseRepo.findByTeacherTeacherId(teacherId).stream()
				.map(this::concertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> findBySpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return this.courseRepo.findBySpeciality(speciality).stream()
				.map(this::concertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> findCoursesBySpecialityId(Long specialityId) {
		// TODO Auto-generated method stub
		return this.courseRepo.findBySpecialitySpecialityId(specialityId).stream()
				.map(this::concertEntityToDTO)
				.collect(Collectors.toList());
	}

}
