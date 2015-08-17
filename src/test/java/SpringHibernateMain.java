
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.hibernate.Address;
import com.home.hibernate.AddressDetail;
import com.home.hibernate.UserDetails;

public class SpringHibernateMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        
        Address address = new Address();
        address.setCountry("India");
        address.setMobile(7276507023l);
        {
            UserDetails userDetails = new UserDetails();
            userDetails.setFirstName("John");
            userDetails.setLastName("Wick");
            userDetails.setEmailId("john.wick@gmail.com");
            userDetails.setGender("Male");
            userDetails.setCreateDate(new Date());
            userDetails.setModifyDate(new Date());

            userDetails.setHomeAddress(address);

            userDetails.setOfficeAddress(address);

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(userDetails);
            tx.commit();
            session.close();
        }

        {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            System.out.println(session.get(UserDetails.class, 1l));
            tx.commit();
            session.close();
        }

        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            session.load(UserDetails.class, 15l);
            System.out.println("*******LOAD METHOD1 "/*
                                                      * +session.load(UserDetails
                                                      * .class, 15l)
                                                      */);
            session.close();
            System.out.println("========================================");
        }

        {
            System.out.println("========================================");
            UserDetails userDetails = new UserDetails();
            userDetails.setId(1l);
            Session session = sessionFactory.openSession();
            session.load(userDetails, 1l);
            System.out.println("*******LOAD METHOD" + userDetails);
            session.close();
            System.out.println("========================================");
        }

        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1l);
            System.out.println("*******GET METHOD" + userDetails);
            session.close();
            System.out.println("========================================");
        }

        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1l);
            userDetails.setEmailId("bahubali@gmail.com");
            System.out.println("$$$$Before refreshing : " + userDetails);
            session.refresh(userDetails);
            System.out.println("$$$$After refreshing : " + userDetails);
            session.close();
            System.out.println("========================================");
        }

        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1l);
            userDetails.setEmailId("bahubali@gmail.com");
            System.out.println("$$$$Before saving to DB : " + userDetails);
            session.flush();
            System.out.println("$$$$After Flushing : " + (UserDetails) session.get(UserDetails.class, 1l));
            session.close();
            System.out.println("========================================");
        }

        {
            System.out.println("========================================");
            AddressDetail addressDetail = new AddressDetail();
            addressDetail.setStreet("Conco Flat 1"+Math.round(100));
            addressDetail.setPincode(411045);
            address.setCountry(address.getCountry()+Math.round(100));
            addressDetail.setAddress(address);
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
//            session.save(addressDetail);
            tx.commit();
            session.close();
            System.out.println("========================================");
        }
        
        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            AddressDetail addressDetail = (AddressDetail) session.get(AddressDetail.class, address);
            Transaction tx = session.beginTransaction();
//            session.save(addressDetail);
            addressDetail.setStreet("Azad Maidan111");
//            session.update(addressDetail);
            tx.commit();
            session.close();
            System.out.println("========================================");
        }
        
        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from AddressDetail");
            System.out.println("$$$$$$$$$$"+query.list());
            session.close();
            System.out.println("========================================");
        }
        
        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("select ad from AddressDetail as ad where ad.pincode =?");
            query.setInteger(0, 411045);
            System.out.println("$$$$$$$$$$"+query.list());
            session.close();
            System.out.println("========================================");
        }
        
        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("select ad from AddressDetail as ad where ad.pincode =:p");
            query.setParameter("p",411045);
            System.out.println("**$$$$$$$$$$"+query.list());
            session.close();
            System.out.println("========================================");
        }
        
        {
            System.out.println("========================================");
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("select ad from AddressDetail as ad where ad.pincode =? and ad.street =:s");
            query.setParameter("s","Azad Maidan111");
            query.setInteger(0, 411045);
            System.out.println("**$$$$$$$$$$"+query.list());
            session.close();
            System.out.println("========================================");
        }

    }

}
