package com.wang.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2023年02月02日 13:30:00
 */
//表明这是一个Mapper，也可以在启动类上加上包扫描
//Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
