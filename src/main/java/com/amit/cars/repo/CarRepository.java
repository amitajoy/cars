package com.amit.cars.repo;

import com.amit.cars.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
@Component("carrepository")
public interface CarRepository extends MongoRepository<Car, Integer> {

}
