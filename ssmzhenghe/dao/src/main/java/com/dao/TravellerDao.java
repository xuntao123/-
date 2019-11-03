package com.dao;

import com.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOdersId(int ordersId);
}
