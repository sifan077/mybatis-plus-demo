/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/6/7
 * Time: 17:59
 * Describe:
 */

package com.shentu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shentu.dao.UserMapper;
import com.shentu.entity.User;
import com.shentu.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
