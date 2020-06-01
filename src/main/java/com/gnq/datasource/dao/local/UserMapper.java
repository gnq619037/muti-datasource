package com.gnq.datasource.dao.local;

import com.gnq.datasource.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * local-dataSource
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select id, username, password from t_user")
    public List<User> queryUsers();
}
