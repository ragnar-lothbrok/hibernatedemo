package com.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.model.Employee;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Employee save(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
        return employee;

    }

    public Employee delete(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(employee);
        tx.commit();
        session.close();
        return employee;
    }

    public Employee update(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(employee);
        tx.commit();
        session.close();
        return employee;
    }

    public Employee get(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        employee = (Employee) session.get(Employee.class, employee.getId());
        tx.commit();
        session.close();
        return employee;
    }
    
    /**
     * Will work till session is open.
     */
    public Employee load(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        employee = (Employee) session.load(Employee.class, employee.getId());
        tx.commit();
        session.close();
        return employee;
    }

}
