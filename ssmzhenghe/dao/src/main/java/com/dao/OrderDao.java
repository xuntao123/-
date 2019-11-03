package com.dao;

import com.Member;
import com.Orders;
import com.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),

            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one = @One(select ="com.dao.ProductDao.findById"))
    })
    List<Orders> findAll();
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),

            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product" ,column = "productId",javaType = Product.class,one = @One(select ="com.dao.ProductDao.findById")),
            @Result(property = "member" ,column = "memberId",javaType = Member.class,one = @One(select ="com.dao.MemberDao.findByid")),
            @Result(property = "travellers" ,column = "id",javaType = java.util.List.class,many = @Many(select ="com.dao.TravellerDao.findByOdersId"))
    })
    Orders findAByid(int id);
}
