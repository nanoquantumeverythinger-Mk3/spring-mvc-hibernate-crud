package xo.andrey.autopark.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xo.andrey.autopark.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AutoparkDAOImpl implements AutoparkDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> allCars() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").list();
    }

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Override
    public void edit(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.update(car);
    }

    @Override
    public Car getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }
}
