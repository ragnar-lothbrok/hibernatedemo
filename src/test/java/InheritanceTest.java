import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Chapter6.Company;
import Chapter6.Manager;
import Chapter6.Student;

public class InheritanceTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        // Person3 person = new Person3("Radhe", "Thakur");
        // person.setId(5l);
        //
        // Employee3 employee = new Employee3("Radhe", "India", 121212.45,
        // "Marketing");
        // employee.setId(6l);
        //
        // {
        // Session session = sessionFactory.openSession();
        // Transaction tx = session.beginTransaction();
        // session.save(person);
        // session.save(employee);
        // tx.commit();
        // session.close();
        //
        // }
        //
        // {
        // Session session = sessionFactory.openSession();
        // System.out.println("###" + session.load(Employee3.class, 2l));
        // System.out.println("###" + session.load(Person3.class, 2l));
        // session.close();
        //
        // }

//        {
//            Manager manager1 = new Manager("Azgar1");
//            Manager manager2 = new Manager("Anaconda1");
//            Company company = new Company("Talentica1");
//            Session session = sessionFactory.openSession();
//            session.save(company);
//            manager1.setCompany(company);
//            manager2.setCompany(company);
//            session.save(manager2);
//            session.save(manager1);
//            session.close();
//        }

//        {
//            Session session = sessionFactory.openSession();
//            Company company = (Company) session.load(Company.class, 1l);
//            System.out.println("###" +company+"  "+company.getManagerList());
//            System.out.println("###" + session.load(Manager.class, 1l));
//            session.close();
//
//        }
        
        {
            Company company = new Company("PubMatic231");
            Student st1 = new Student("A");
            Student st2 = new Student("B");
            List<Student> student = new ArrayList<Student>();
            student.add(st1);
            student.add(st2);
            company.setStudentList(student);
            Session session = sessionFactory.openSession();
            Transaction tx=session.beginTransaction();
            session.save(company);
            tx.commit();
            session.close();
            
        }

    }

}
