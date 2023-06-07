package com.wang.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Result.java
 * @Description TODO
 * @createTime 2023年01月12日 16:24:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T date;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result error(Integer code, String msg){
        return new Result(code,msg);
    }
}
