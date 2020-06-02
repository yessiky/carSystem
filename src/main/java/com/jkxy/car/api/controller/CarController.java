package com.jkxy.car.api.controller;

import com.github.pagehelper.PageHelper;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {

        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    @PostMapping("findByCarNameF")
    public JSONResult findByCarNameF(String carName,int start,int num) {
        PageHelper.startPage(start,num);
        List<Car> cars = carService.findByCarNameF(carName);

        return JSONResult.ok(cars);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName")
    public JSONResult findByCarNameUrlParam(String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }


    /**
     * 通过车系查询
     *
     * @param carSeries
     * @return
     */
    @GetMapping("findByCarSeries/{carSeries}")
    public JSONResult findByCarSeries(@PathVariable String carSeries) {
        List<Car> cars = carService.findByCarSeries(carSeries);
        return JSONResult.ok(cars);
    }

    /**
     * 通过车系查询
     *
     * @param carSeries
     * @return
     */
    @GetMapping("findByCarSeries")
    public JSONResult findByCarSeriesUrlParam(String carSeries) {
        List<Car> cars = carService.findByCarSeries(carSeries);
        return JSONResult.ok(cars);
    }


    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteStockById(id);
        carService.deleteCarById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateCarById(car);
        carService.updateStockById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

        /**
         * 通过车系买车
         * @param id，quality
         * @return
         */
        @PostMapping("buyCarById")
        public String buyCarById(int id,int amount) {
            return carService.buyCarById(id,amount);
        }



}
