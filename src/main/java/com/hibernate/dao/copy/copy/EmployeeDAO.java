package com.hibernate.dao.copy.copy;

import com.hibernate.model.Employee;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee delete(Employee employee);

    Employee update(Employee employee);

    Employee get(Employee employee);
    
    Employee load(Employee employee);

}
