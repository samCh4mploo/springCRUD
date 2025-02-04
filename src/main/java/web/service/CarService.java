package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> listCar(int count);

    public List<Car> listCar();
}
