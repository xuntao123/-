package com.controller;

import com.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.OrderService;
import com.service.impl.OrderServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderServer;
   /* @RequestMapping("/findAll.do")
    public ModelAndView findall(){
        ModelAndView modelAndView=new ModelAndView();

        List<Orders> all = orderServer.findAll();
        modelAndView.addObject("ordersList",all);
        modelAndView.setViewName("orders-list");

        return modelAndView;
    }*/
    @RequestMapping("/findAll.do")
    public ModelAndView findByid(@RequestParam(value = "page",required = true,defaultValue = "1") int page,
                                 @RequestParam(value = "pageSize",required = true,defaultValue = "5") int pagenum){
        ModelAndView modelAndView=new ModelAndView();
        List<Orders> orders=orderServer.finall(page,pagenum);
        PageInfo<Orders> pageInfo=new PageInfo<>(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
}
