package com.chunfeng.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.chunfeng.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

/**
 * web核心配置类
 *
 * @author by 春风能解释
 * <p>
 * 2022/9/28
 */
@Configuration
@Slf4j
public class ServiceConfig implements WebMvcConfigurer, MetaObjectHandler {

    /**
     * 拦截器
     */
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        /*是否允许请求带有验证信息*/
        corsConfiguration.setAllowCredentials(true);
        /*允许访问的客户端域名*/
        corsConfiguration.addAllowedOrigin("*");
        /*允许服务端访问的客户端请求头*/
        corsConfiguration.addAllowedHeader("*");
        /*允许访问的方法名,GET POST等*/
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        log.info("跨域处理器准备就绪!");
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


    /**
     * 自动添加
     *
     * @param metaObject metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "userCreateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "userUpdateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "orderCreateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "orderUpdateTime", Date.class, new Date());
    }

    /**
     * 自动修改
     *
     * @param metaObject metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "userUpdateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "orderUpdateTime", Date.class, new Date());
    }


    /**
     * 分页插件
     *
     * @return MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        log.info("分页插件准备就绪!");
        return interceptor;
    }


    /**
     * 注册登录拦截器
     *
     * @param registry 拦截器仓库
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/account/login",//登录
                        "/account/register",//注册
                        "/**/*.html",       //html静态资源
                        "/**/*.js",         //js静态资源
                        "/**/*.css",        //css静态资源
                        "/**/*.img");       //图片资源
        log.info("全局拦截器准备就绪!");
    }
}
