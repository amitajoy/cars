package com.amit.cars;

import com.amit.cars.model.Car;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Returns a list of cars", responseContainer = "List", response = Car.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", responseContainer = "List", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Car does not exist"),
            @ApiResponse(code = 500, message = "Unexpected failure")})
    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<List<Car>> getCars(){
        List<Car> cars = carService.getCars();
        return ResponseEntity.ok().body(cars);
    }

    @ApiOperation(value = "Returns a car by ID", response = Car.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Car does not exist"),
            @ApiResponse(code = 500, message = "Unexpected failure")})
    @RequestMapping(method = {RequestMethod.GET} , value = "/{carid}")
    public ResponseEntity<Car> getCarById(@PathVariable("carid") Integer carId){
        Car car = carService.getCar(carId);
        return ResponseEntity.ok().body(car);
    }

    @ApiOperation(value = "Adds a car", response = Car.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Car does not exist"),
            @ApiResponse(code = 500, message = "Unexpected failure")})
    @RequestMapping(method = {RequestMethod.PUT} , value = "/{carid}/{carname}")
    public ResponseEntity<Car> addCar(@PathVariable("carid") Integer carId,@PathVariable("carname") String carName){
        Car car = carService.addCar(carId, carName);
        return ResponseEntity.ok().body(car);
    }

    @ApiOperation(value = "Removes a car",  response = Void.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Void.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Car does not exist"),
            @ApiResponse(code = 500, message = "Unexpected failure")})
    @RequestMapping(method = {RequestMethod.DELETE} , value = "/{carid}")
    public ResponseEntity removeCar(@PathVariable("carid") Integer carId){
        carService.removeCar(carId);
        return ResponseEntity.ok().body("");
    }

}
