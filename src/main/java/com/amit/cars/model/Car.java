package com.amit.cars.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author aagrawal
 * @since 11/12/2017
 * */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "CAR")
public class Car implements Comparable<Car>{
    public Car(Integer id, String name){
        this.carId =id;
        this.name=name;
    }

    @Id
    private int carId;
    private String name;

    @Override
    public int compareTo(Car o) {
        if(o ==null) return 1;
        return (carId - o.getCarId());
    }
}
