package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Mazda", 2005, "Red"));
        cars.add(new Car("BMW", 2006, "Blue"));
        cars.add(new Car("Audi", 2007, "Green"));
        cars.add(new Car("Honda", 2008, "Yellow"));
        cars.add(new Car("Ford", 2009, "Red"));
    }

    @Override
    public List<Car> listCar(int count) {
        return cars.stream().limit(count).toList();
    }

    @Override
    public List<Car> listCar() {
        return cars;
    }

}
