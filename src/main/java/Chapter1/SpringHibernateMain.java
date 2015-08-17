package Chapter1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.enums.Gender;
import com.hibernate.model.Employee;

public class SpringHibernateMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAOImpl");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Wick");
        employee.setGender(Gender.MALE);

        employeeDAO.save(employee);

        System.out.println(employeeDAO.get(employee));

        employee.setFirstName("Gabriel");

        System.out.println(employeeDAO.load(employee));

//        System.out.println(employeeDAO.delete(employee));
//
//        System.out.println(employeeDAO.get(employee));

        context.close();

    }

}
