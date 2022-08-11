package com.shentu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shentu.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
