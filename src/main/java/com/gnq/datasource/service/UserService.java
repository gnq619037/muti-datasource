package com.gnq.datasource.service;

import com.gnq.datasource.bean.User;

import java.util.List;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 从本地数据库获取用户数据
     * @return
     */
    public List<User> listFromLocal();

    /**
     * 从远程数据库获取用户数据
     * @return
     */
    public List<User> listFromRemote();
}
