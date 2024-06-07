package com.example.managerHome_3.service;

import com.example.managerHome_3.entity.House;

import java.util.List;

public interface HomeService {
    //      Lấy ra tất cả các bài đăng
    public List<House> getAllHouses();

    //    Lấy bài đăng dựa trên id
    public House getHouseById(int id);

    //    Thêm bài đăng mới
    public House addHouse(House house);

    //    Chỉnh sửa bài đăng
    public House updateHouse(House house);

    //    Xoá một bài đăng
    public void deleteHouse(int id);
}
