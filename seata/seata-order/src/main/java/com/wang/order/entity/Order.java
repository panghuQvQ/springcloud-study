package com.wang.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Order.java
 * @Description TODO
 * @createTime 2023年02月02日 13:07:00
 */
@Data
@TableName("order_tbl")
public class Order {

    // 序号,指定自增策略
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 商品ID
    @TableField("product_id")
    private Integer productId;
    // 状态
    @TableField("state")
    private Integer state;
    // 总金额
    @TableField("total_amount")
    private Integer totalAmount;


}
