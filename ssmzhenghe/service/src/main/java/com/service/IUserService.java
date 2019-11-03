package com.service;

import com.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(int id);
}
