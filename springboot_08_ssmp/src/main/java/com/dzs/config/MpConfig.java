package com.dzs.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
//    @Bean用来为spring添加外部bean
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        新建一个mp的拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        在mp拦截器中添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
