package xo.andrey.autopark.DAO;

import xo.andrey.autopark.model.Car;

import java.util.List;

public interface AutoparkDAO {
    List<Car> allCars();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getById(int id);
}
