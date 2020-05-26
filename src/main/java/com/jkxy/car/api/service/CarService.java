package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    List<Car> findByCarNameF(String carName,int start,int num);

    List<Car> findByCarSeries(String carSeries);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    void updateStockById(int id,int stock);
}
