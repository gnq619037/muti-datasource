package com.gnq.datasource.dao.remote;

import com.gnq.datasource.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * remote-dataSource
 */
@Mapper
public interface RemoteUserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select id, username, password from t_user")
    public List<User> queryUsers();
}
