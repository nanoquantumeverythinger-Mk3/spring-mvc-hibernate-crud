package xo.andrey.autopark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xo.andrey.autopark.DAO.AutoparkDAO;
import xo.andrey.autopark.model.Car;

import java.util.List;

@Service
public class AutoparkServiceImpl implements AutoparkService {
    private AutoparkDAO dao;

    @Autowired
    public void setDao(AutoparkDAO dao) {
        this.dao = dao;
    }


    @Transactional
    public List<Car> allCars() {
        return dao.allCars();
    }

    @Transactional
    public void add(Car car) {
        dao.add(car);
    }

    @Transactional
    public void delete(Car car) {
        dao.delete(car);
    }

    @Transactional
    public void edit(Car car) {
        dao.edit(car);
    }

    @Transactional
    public Car getById(int id) {
        return dao.getById(id);
    }
}
