package com.example.dckurty.carsregistercam.data;

import com.example.dckurty.carsregistercam.models.Car;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Car> cars(){
        List<Car> cars = new ArrayList<>();
        List<Car> carList = Car.find(Car.class, "done = 0");
        if(carList != null && carList.size() > 0){
            cars.addAll(carList);
        }
        return cars;
    }

}
