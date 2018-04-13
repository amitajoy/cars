package com.amit.cars.impl;

import com.amit.cars.CarService;
import com.amit.cars.model.Car;
import com.amit.cars.repo.CarRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;


@Component
public class CarServiceImpl implements CarService {
    @Inject
    private CarRepository carRepository;


    @Override
    public void removeCar(Integer carId) {
    carRepository.delete(carId);
    }

    @Override
    public Car addCar(Integer carId, String carName) {
        Car c = new Car(carId,carName);
        return carRepository.insert(c);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(int id) {
       return carRepository.findOne(id);
    }

}
