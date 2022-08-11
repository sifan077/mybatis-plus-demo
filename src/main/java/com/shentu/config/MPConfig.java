/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/6/7
 * Time: 10:08
 * Describe:
 */

package com.shentu.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {

    // 分页插件
    @Bean
    public MybatisPlusInterceptor mpInterceptor() {
        // 定义一个拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
