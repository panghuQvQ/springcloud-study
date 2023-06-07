package com.wang.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.order.entity.Stock;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2023年02月02日 13:06:00
 */
public interface StockService extends IService<Stock> {

    void updateStock();
}
