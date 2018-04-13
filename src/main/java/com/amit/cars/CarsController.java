package com.amit.cars;

import com.amit.cars.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping(value = CarsController.CARS_RESOURCE)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CarsController {
    public static final String CARS_RESOURCE = "/cars";
    @Inject
    private CarService carService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<List<Car>> getCars(){
        List<Car> cars = carService.getCars();
        return ResponseEntity.ok().body(cars);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST} , value = "/{carid}")
    public ResponseEntity<Car> getCarById(@PathVariable("carid") Integer carId){
        Car car = carService.getCar(carId);
        return ResponseEntity.ok().body(car);
    }

    @RequestMapping(method = {RequestMethod.PUT} , value = "/{carid}/{carname}")
    public ResponseEntity<Car> addCar(@PathVariable("carid") Integer carId,@PathVariable("carname") String carName){
        Car car = carService.addCar(carId, carName);
        return ResponseEntity.ok().body(car);
    }

    @RequestMapping(method = {RequestMethod.DELETE} , value = "/{carid}")
    public ResponseEntity removeCar(@PathVariable("carid") Integer carId){
        carService.removeCar(carId);
        return ResponseEntity.ok().body("");
    }

}
