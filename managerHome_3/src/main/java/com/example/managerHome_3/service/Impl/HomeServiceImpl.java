package com.example.managerHome_3.service.Impl;

import com.example.managerHome_3.entity.House;
import com.example.managerHome_3.repository.HouseReponsitory;
import com.example.managerHome_3.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
    private HouseReponsitory houseReponsitory;
    @Autowired
    public HomeServiceImpl(HouseReponsitory houseReponsitory) {
        this.houseReponsitory = houseReponsitory;
    }
    @Override
    public List<House> getAllHouses() {
        return houseReponsitory.findAll();
    }

    @Override
    public House getHouseById(int id) {
        return houseReponsitory.findById(id).get();
    }

    @Override
    public House addHouse(House house) {
        return houseReponsitory.save(house);
    }

    @Override
    public House updateHouse(House house) {
        return houseReponsitory.saveAndFlush(house);
    }

    @Override
    public void deleteHouse(int id) {
        houseReponsitory.deleteById(id);
    }


}
