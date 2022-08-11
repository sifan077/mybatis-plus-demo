/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/6/7
 * Time: 9:25
 * Describe:
 */

package com.shentu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField(select = false)
    private Integer age;
    private String email;
    // 逻辑删除字段，标记是否被删除
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @TableField(exist = false)
    private String onLine;
}
