package com.ssafy.exam.model.service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

public class SpecialtyServiceImpl implements SpecialtyService  {

	private final SpecialtyDao specialtyDao;
	
	public SpecialtyServiceImpl(SpecialtyDao specialtyDao) {
		this.specialtyDao = specialtyDao;
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {
		int result =specialtyDao.insertSpecialty(specialty);
		return result==1; 
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		specialtyDao.selectSpecialtyByCode(code);
		return null;
	}

	@Override
	public boolean deleteSpecialty(int code) {
		int result = specialtyDao.deleteSpecialty(code);
		return result==1;
	}
	
	
}
