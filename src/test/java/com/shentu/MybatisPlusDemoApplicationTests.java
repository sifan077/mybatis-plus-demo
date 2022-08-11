package com.shentu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shentu.dao.UserMapper;
import com.shentu.entity.User;
import com.shentu.entity.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println("Hello world");
    }

    @Test
    public void getAll() {
        // 查询所有
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void add() {
        // 插入一条数据
        User user = new User();
        user.setName("张三丰");
        user.setAge(20);
        user.setEmail("65846@qq.com");
        userMapper.insert(user);
        getAll();
    }

    @Test
    public void delete() {
        // 删除一条数据
        userMapper.deleteById(5);
        getAll();
    }

    @Test
    public void update() {
        // 更新一条数据
        User user = new User();
        user.setId(5);
        user.setAge(20);
        // 提供什么字段 修改什么字段
        userMapper.updateById(user);
    }

    @Test
    public void page() {
        // 分页查询
        IPage<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);
        System.out.println("当前页码值" + page.getCurrent());
        System.out.println("每页显示数量" + page.getSize());
        System.out.println("总页码值" + page.getPages());
        System.out.println("总数据量" + page.getTotal());
        System.out.println("数据" + page.getRecords());
    }


    // 条件查询
    @Test
    public void queryWrapper() {
        // 条件查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 姓名模糊查询
        queryWrapper.like("name", "J");
        // 年龄大于等于20
        queryWrapper.ge("age", 20);
        // 年龄小于等于25
        queryWrapper.le("age", 25);
        // 年龄在20-25之间
        queryWrapper.between("age", 20, 25);
        // 年龄不等于25
        queryWrapper.ne("age", 25);


        // 年龄大于20 或者 年龄小于等于25
        queryWrapper.lt("age", 25).or().lt("age", 20);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void queryWrapper2() {
        // lambda表达式查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().lt(User::getAge, 20);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void queryWrapper3() {
        // lambda查询
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(User::getAge, 20);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    // 直接按情况添加条件
    @Test
    public void nullQuery() {
        UserQuery userQuery = new UserQuery();
        userQuery.setAge(10);
        userQuery.setAge2(30);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 如果 age 为 null 则不查询
        // 如果第一个参数为false 则不查询
        // 如果第一个参数为true 则查询
        queryWrapper.lt(null != userQuery.getAge2(), User::getAge, userQuery.getAge2());
        queryWrapper.gt(null != userQuery.getAge(), User::getAge, userQuery.getAge());
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    // 投影查询
    @Test
    public void paraQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 设置投影，查询某个参数,可以在括号里面写多个投影的值
        // 只适用于lambda查询
        queryWrapper.select(User::getName, User::getAge);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    // Map查询
    @Test
    public void mapQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 原始查询
//        queryWrapper.select("count(*)", "sum(age)");
        // 使用别名
//        queryWrapper.select("count(*) as count", "sum(age) as sum");
        // 按电话分组
        queryWrapper.select("count(*) as count", "age");
        queryWrapper.groupBy("age");
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        System.out.println(userList);
    }

    // 等匹配查询
    @Test
    public void eqQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Jack");
        queryWrapper.eq("age", 20);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    // 模糊匹配查询
    @Test
    public void likeQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 左右两边都有%
        queryWrapper.like("name", "J");
        // 左边有%
//        queryWrapper.likeLeft("name", "J");
        // 右边有%
//        queryWrapper.likeRight("name", "J");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    // 多数据删除
    @Test
    public void deleteList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 按列表删除
        userMapper.deleteBatchIds(list);
    }

}
