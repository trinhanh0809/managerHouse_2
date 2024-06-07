package com.example.managerHome_3.repository;

import com.example.managerHome_3.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseReponsitory extends JpaRepository<House, Integer> {

}
