package com.ssafy.exam.model.service;

import java.util.List;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

public class DoctorServiceImpl implements DoctorService {

	private final DoctorDao doctorDao;
	
	public DoctorServiceImpl(DoctorDao doctorDao) {
		this.doctorDao=doctorDao;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		int result = doctorDao.insertDoctor(doctor);
		return result==1;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list = doctorDao.selectAllDoctors();
		return list;
	}

	@Override
	public Doctor getDoctorById(int id) {
		Doctor hello=doctorDao.selectDoctorById(id);
		return hello;
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		doctor.setDoctorId(id);
		int result = doctorDao.updateDoctor(doctor);
		return result==1;
	}

	@Override
	public boolean deleteDoctor(int id) {
		int result = doctorDao.deleteDoctor(id);
		return result==1;
	}
	
	
}
