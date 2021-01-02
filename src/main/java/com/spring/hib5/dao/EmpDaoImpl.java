package com.spring.hib5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.spring.hib5.entity.Emp;

public class EmpDaoImpl implements EmpDao {
	private static StandardServiceRegistry registry = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
    private static Transaction transaction = null;
	
    static {
    	StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		Map<String, String> settings = new HashMap<>();
		settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/class");
		settings.put("hibernate.connection.username", "devuser");
		settings.put("hibernate.connection.password", "guest");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.hbm2ddl.auto", "update");

		registryBuilder.applySettings(settings);
		registry = registryBuilder.build();

		MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Emp.class);
		Metadata metadata = sources.getMetadataBuilder().build();

		sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    
    @Override
	public boolean saveEmp(Emp emp) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
    	return true;
	}

	@Override
	public boolean updateEmp(Emp emp) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.update(emp);
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteEmp(Integer empNo) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Emp emp = new Emp();
		emp.setEmpNo(empNo);
		session.delete(emp);
		transaction.commit();
    	return true;
	}

	@Override
	public List<Emp> getAllEmps() {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Emp.class);
		return criteria.list();
	}

	@Override
	public Emp getEmpByNo(Integer empNo) {
		session = sessionFactory.openSession();
		return session.get(Emp.class, empNo);
	}
}
