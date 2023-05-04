package com.bilel.SpringBoot_TP01.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bilel.SpringBoot_TP01.dto.SpecialityDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bilel.SpringBoot_TP01.entities.Speciality;
import com.bilel.SpringBoot_TP01.repos.SpecialityRepo;

import static org.modelmapper.convention.MatchingStrategies.*;

@Service
public class SpecialityServiceImplementation implements SpecialityService {

	@Autowired
	private SpecialityRepo specialityRepo;
	@Autowired
	ModelMapper modelMapper;

	
	@Override
	public SpecialityDTO createSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return this.convertEntityToDTO(
				this.specialityRepo.save(speciality)
		);
	}

	@Override
	public SpecialityDTO updateSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return this.convertEntityToDTO(
				this.specialityRepo.save(speciality)
		);
	}

	@Override
	public SpecialityDTO convertEntityToDTO(Speciality speciality) {
		modelMapper.getConfiguration().setMatchingStrategy(LOOSE);
		return modelMapper.map(speciality, SpecialityDTO.class);
	}

	@Override
	public Speciality convertDtoToEntity(SpecialityDTO specialityDTO) {
		return modelMapper.map(specialityDTO, Speciality.class);
	}

	@Override
	public SpecialityDTO getSpecialityById(Long id) {
		// TODO Auto-generated method stub
		return this.convertEntityToDTO(
				this.specialityRepo.findById(id).get()
		);
	}

	@Override
	public List<SpecialityDTO> getSpecialities() {
		// TODO Auto-generated method stub
		return this.specialityRepo.findAll().stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Page<SpecialityDTO> getSpecialitiesByPage(int page, int size) {
		// TODO Auto-generated method stub
		return new PageImpl<>(
				this.specialityRepo.findAll(PageRequest.of(page, size)).stream()
						.map(this::convertEntityToDTO)
						.collect(Collectors.toList())
		);
	}

	@Override
	public void deleteSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		this.specialityRepo.delete(speciality);
	}

	@Override
	public void deleteSpecialityById(Long id) {
		// TODO Auto-generated method stub
		this.specialityRepo.deleteById(id);
	}

}
