package xo.andrey.autopark.service;

import xo.andrey.autopark.model.Car;

import java.util.List;

public interface AutoparkService {
    List<Car> allCars();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getById(int id);
}
