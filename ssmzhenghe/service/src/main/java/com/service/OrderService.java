package com.service;

import com.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();



    List<Orders> finall(int page, int pagenum);
}
