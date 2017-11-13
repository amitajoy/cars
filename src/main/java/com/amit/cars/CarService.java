package com.amit.cars;

import com.amit.cars.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    void removeCar(Integer carId );
    Car getCar(int id);
    Car addCar(Integer carId, String carName);
}
