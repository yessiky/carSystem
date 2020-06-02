package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarDao {
    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id")
    List<Car> findAll();


    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id and t1.id = #{id}")
    Car findById(int id);

    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id and t1.carName like '%${carName}%'")
    List<Car> findByCarName(String carName);


//    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id and t1.carName like '%${carName}%' limit #{start},#{num}")
    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id and t1.carName like '%${carName}%'")
    List<Car> findByCarNameF(String carName);

    @Select("select t1.id,t1.carName,t1.carSeries,t1.carType,t1.price,t2.stock from carmessage t1,car_stock t2 where t1.id = t2.car_id and t1.carSeries = #{carSeries}")
    List<Car> findByCarSeries(String carSeries);

    @Delete("delete from carMessage where id = #{id}")
    void deleteCarById(int id);

    @Delete("delete from car_stock where id = #{id}")
    void deleteStockById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries} where id = #{id}")
    void updateCarById(Car car);

    @Update("update car_stock set stock=#{stock} where id = #{id}")
    void updateStockById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries) values(#{carName},#{carType},#{price},#{carSeries})")
    void insertCar(Car car);

    @Insert("insert into car_stock(car_id,stock) values(#{id},#{stock})")
    void insertStock(Car car);

    @Select("select max(id) from carMessage")
    int findMaxCarId();

}
