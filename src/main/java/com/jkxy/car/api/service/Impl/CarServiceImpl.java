package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public List<Car> findByCarNameF(String carName) {
        return carDao.findByCarNameF(carName);
    }

    @Override
    public List<Car> findByCarSeries(String carSeries) {
        return carDao.findByCarSeries(carSeries);
    }

    @Override
    public int findMaxCarId() {
        return carDao.findMaxCarId();
    }

    @Override
    public void deleteCarById(int id) {
        carDao.deleteCarById(id);
    }

    @Override
    public void deleteStockById(int id) {
        carDao.deleteStockById(id);
    }

    @Override
    public void updateCarById(Car car) {
        carDao.updateCarById(car);
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void insertCar(Car car) {
        int carId;
        carDao.insertCar(car);
        carId = findMaxCarId();
        car.setId(carId);
        insertStock(car);
        try{
            Thread.sleep(20000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertStock(Car car) {
        carDao.insertStock(car);
    }

    @Override
    public void updateStockById(Car car){ carDao.updateStockById(car);}

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String buyCarById(int id,int amount) {
        String res = "";
        int stock;
        Car car = new Car();

        if(amount <= 0){
            res = res + "请正确设置购买数量";
        }
        else
        {
            car = findById(id);
            stock = car.getStock() - amount;
            if(stock < 0 ){
                res = res + car.getCarName() + car.getCarSeries() + "库存不足，最多可买"+car.getStock()+"辆。";
            }else{
                updateStockById(car);
                res = res + "购买成功："+car.getCarName()+amount+"辆。";
            }
        }
        return res;
    }
}
