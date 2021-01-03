package com.spring.hib5.app;

import java.util.List;

import com.spring.hib5.entity.Emp;
import com.spring.hib5.service.EmpService;
import com.spring.hib5.service.EmpServiceImpl;



public class EmpHibApp {

	private static EmpService empService = new EmpServiceImpl();
	
	public static void main(String[] args) {
		Emp e1 = new Emp(101, "Mike", "Bergenfield");
		Emp e2 = new Emp(102, "Megan", "Manhattan");
		
		empService.saveEmp(e1);
		empService.saveEmp(e2);
		
		e2.setCity("Bergenfield");
		if(empService.updateEmp(e2)) {
			System.out.println("Employee updated successfully");
		} else {
			System.out.println("Employee not updated");
		}
		
		List<Emp> e = empService.getAllEmps();
		e.stream().forEach(System.out::println);
		System.out.println("-----------------------------------------");
		System.out.println("Product Details - " + empService.getEmpByNo(2));

	}

}
