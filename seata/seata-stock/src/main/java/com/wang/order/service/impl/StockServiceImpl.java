package com.wang.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.order.entity.Stock;
import com.wang.order.mapper.StockMapper;
import com.wang.order.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2023年02月02日 13:10:00
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Override
    @Transactional
    public void updateStock() {

        Wrapper<Stock> wrapper = new QueryWrapper<Stock>().eq("product_id", 1);
        Stock stock = this.getOne(wrapper);

        stock.setCount(stock.getCount() - 1);

        this.saveOrUpdate(stock);
    }
}
