package com.service.impl;

import com.Orders;
import com.dao.OrderDao;
import com.github.pagehelper.PageHelper;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServerImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAll() {

        return orderDao.findAll();
    }

    @Override
    public  List<Orders> finall(int page, int pagenum) {
        PageHelper.startPage(page,pagenum);

        return  orderDao.findAll();
    }


}


