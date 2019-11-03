package com.service.impl;

import com.Role;
import com.UserInfo;
import com.dao.IUserDao;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<UserInfo> findAll() {

        return iUserDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        iUserDao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) {

        return iUserDao.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=iUserDao.findByUsername(username);
        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority());
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
