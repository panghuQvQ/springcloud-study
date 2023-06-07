package com.wang.gateway.dto;

import lombok.Data;
import org.aspectj.apache.bcel.generic.Tag;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SwAlarmDTO.java
 * @Description TODO 接收SkyWalking告警时，传来的参数
 * @createTime 2023年02月13日 10:01:00
 */
@Data
public class SwAlarmDTO {

    private int scopeId;
    private String scope;
    private String name;
    private String id0;
    private String id1;
    private String ruleName;
    private String alarmMessage;
    private List<Tag> tags;
    private long startTime;
    private transient int period;
    private transient boolean onlyAsCondition;
}
