package com.spring.hib5.service;

import java.util.List;

import com.spring.hib5.entity.Emp;


public interface EmpService {
	public boolean saveEmp(Emp emp);
	public boolean updateEmp(Emp emp);
	public boolean deleteEmp(Integer empNo);
	public List<Emp> getAllEmps();
	public Emp getEmpByNo(Integer empNo);

}
