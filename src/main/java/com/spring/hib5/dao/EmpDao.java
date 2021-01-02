package com.spring.hib5.dao;

import java.util.List;

import com.spring.hib5.entity.Emp;

public interface EmpDao {
	public boolean saveEmp(Emp emp);
	public boolean updateEmp(Emp emp);
	public boolean deleteEmp(Integer empNo);
	public List<Emp> getAllEmps();
	public Emp getEmpByNo(Integer empNo);
}
