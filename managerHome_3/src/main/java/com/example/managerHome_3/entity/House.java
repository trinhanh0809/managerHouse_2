package com.example.managerHome_3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id", length = 50)
    private String userId;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "price")
    private double price;
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "title",length = 100)
    private String title;
    @Column(name = "phone",length = 10)
    private Long phone;

    // Constructor
    public House() {}

    public House(String userId, String address, double price, String description, String title, Long phone) {
        this.userId = userId;
        this.address = address;
        this.price = price;
        this.description = description;
        this.title = title;
        this.phone = phone;
    }

    public House(int id, String userId, String address, double price, String description, String title, Long phone) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.price = price;
        this.description = description;
        this.title = title;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
