package com.gnq.datasource.service.impl;

import com.gnq.datasource.bean.User;
import com.gnq.datasource.dao.local.UserMapper;
import com.gnq.datasource.dao.remote.RemoteUserMapper;
import com.gnq.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RemoteUserMapper remoteUserMapper;

    @Override
    public List<User> listFromLocal() {
        return userMapper.queryUsers();
    }

    @Override
    public List<User> listFromRemote() {
        return remoteUserMapper.queryUsers();
    }
}
