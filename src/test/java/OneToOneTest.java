import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Chapter5.Car;
import Chapter5.CarDetail;


public class OneToOneTest {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        
        {
            Session session = sessionFactory.openSession();
            Car car = new Car("Basic Car", "India");
            CarDetail carDetail = new CarDetail();
            carDetail.setCar(car);
            carDetail.setCarName("Audi");
            Transaction tx = session.beginTransaction();
            session.save(car);
            session.save(carDetail);
            tx.commit();
            session.close();
        }
        
        {
            Session session = sessionFactory.openSession();
            System.out.println("&&&&"+session.load(Car.class, 1l));
            System.out.println("&&&&"+session.load(CarDetail.class, 1l));
            session.close();
        }
    }
}
