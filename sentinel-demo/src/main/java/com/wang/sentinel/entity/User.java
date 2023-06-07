package com.wang.sentinel.entity;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2023年01月11日 13:25:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

//    public static User blockHandlerForGetUser(String id, BlockException ex) {
//        ex.printStackTrace();
//        return new User("流控!!!");
//    }
}
