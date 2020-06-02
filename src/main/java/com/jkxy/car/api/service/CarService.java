package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    List<Car> findByCarNameF(String carName);

    List<Car> findByCarSeries(String carSeries);

    int findMaxCarId();

    void deleteCarById(int id);

    void deleteStockById(int id);

    void updateCarById(Car car);

    void insertCar(Car car);

    void insertStock(Car car);

    void updateStockById(Car car);

    String buyCarById(int id,int amount);
}
