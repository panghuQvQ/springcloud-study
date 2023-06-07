package com.wang.order.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName MybatisConfig.java
 * @Description TODO
 * @createTime 2023年02月02日 13:29:00
 */
//@Configuration

public class MybatisConfig {

//    /**
//     * 增加生成器
//     * @return
//     */
//    @Bean
//    public OracleKeyGenerator oracleKeyGenerator(){
//        return new OracleKeyGenerator();
//    }
//
//
//    /**
//     * 分页插件
//     * @return
//     */
//    @Bean
//    public MybatisPlusInterceptor paginationInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return  interceptor;
//    }
//
//    /**
//     * 自定义Sql注入器
//     */
//    @Bean
//    public DefaultSqlInjector sqlInjector() {
//        return new DefaultSqlInjector(){
//            @Override
//            public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
//                List<AbstractMethod> methodList = super.getMethodList(mapperClass);
//                /**
//                 * 以下 3 个为内置选装件
//                 * 头 2 个支持字段筛选函数
//                 */
//                // 例: 不要指定了 update 填充的字段
//                methodList.add(new InsertBatchSomeColumn(i -> i.getFieldFill() != FieldFill.UPDATE));
//                methodList.add(new AlwaysUpdateSomeColumnById());
//                methodList.add(new LogicDeleteByIdWithFill());
//                return methodList;
//            }
//        };
//    }
}
