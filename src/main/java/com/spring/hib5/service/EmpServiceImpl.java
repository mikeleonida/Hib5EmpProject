package com.spring.hib5.service;

import java.util.List;

import com.spring.hib5.dao.EmpDao;
import com.spring.hib5.dao.EmpDaoImpl;
import com.spring.hib5.entity.Emp;

public class EmpServiceImpl implements EmpService {

	private static EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public boolean saveEmp(Emp emp) {
		return empDao.saveEmp(emp);
	}

	@Override
	public boolean updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}

	@Override
	public boolean deleteEmp(Integer empNo) {
		return empDao.deleteEmp(empNo);
	}

	@Override
	public List<Emp> getAllEmps() {
		return empDao.getAllEmps();
	}

	@Override
	public Emp getEmpByNo(Integer empNo) {
		return empDao.getEmpByNo(empNo);
	}
}
