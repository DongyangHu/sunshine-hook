package com.hudongyang.sunshinehook.common.bean;

import com.hudongyang.sunshinehook.common.enums.EventSourceEnum;
import com.hudongyang.sunshinehook.common.enums.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Git Hook Event
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 22:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HookEvent {
    private EventSourceEnum source;
    private EventTypeEnum<? extends EventTypeEnum<?>> eventType;
    private String branch;
    private Object event;
    private long createTime;

    public boolean hasEvent() {
        return Objects.nonNull(event);
    }
}
