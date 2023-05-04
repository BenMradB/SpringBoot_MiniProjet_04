package com.bilel.SpringBoot_TP01.services;

import java.util.List;

import com.bilel.SpringBoot_TP01.dto.SpecialityDTO;
import org.springframework.data.domain.Page;

import com.bilel.SpringBoot_TP01.entities.Speciality;

public interface SpecialityService {
	SpecialityDTO createSpeciality(Speciality speciality);
	SpecialityDTO updateSpeciality(Speciality speciality);
	SpecialityDTO convertEntityToDTO(Speciality speciality);
	Speciality convertDtoToEntity(SpecialityDTO specialityDTO);

	SpecialityDTO getSpecialityById(Long id);
	List<SpecialityDTO> getSpecialities();
	Page<SpecialityDTO> getSpecialitiesByPage(int page, int size);
	void deleteSpeciality(Speciality speciality);
	void deleteSpecialityById(Long id);
}
