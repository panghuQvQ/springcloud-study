package com.wang.gateway.controller;

import com.wang.gateway.dto.SwAlarmDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SwAlarmController.java
 * @Description TODO SkyWalking 告警功能，当SkyWalking存在告警信息时，调用该接口
 * @createTime 2023年02月13日 09:58:00
 */
@Slf4j
@RestController
@RequestMapping("/alarm")
public class SwAlarmController {

    /**
     * 告警时，发送邮件
     *
     * @param alarmList
     */
    @PostMapping("/receive")
    public void receive(@RequestBody List<SwAlarmDTO> alarmList) {
        String content = getContent(alarmList);
        log.info("告警邮件已经发送...\n" + content);
    }

    public String getContent(List<SwAlarmDTO> alarmList) {
        StringBuilder sb = new StringBuilder();
        for (SwAlarmDTO dto : alarmList) {
            sb.append("scopeId: ").append(dto.getScopeId())
                    .append("\nscope: ").append(dto.getScope())
                    .append("\n目标Scope的实体名称: ").append(dto.getName())
                    .append("\nScope实体的ID: ").append(dto.getId0())
                    .append("\nid1").append(dto.getId1())
                    .append("\n告警规则名称: ").append(dto.getRuleName())
                    .append("\n告警消息内容: ").append(dto.getAlarmMessage())
                    .append("\n告警时间: ").append(dto.getStartTime())
                    .append("\n\n---------------\n\n");
        }
        return sb.toString();
    }
}
