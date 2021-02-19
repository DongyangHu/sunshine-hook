package com.hudongyang.sunshinehook.engine.handler;

import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.common.constants.BaseConstants;
import com.hudongyang.sunshinehook.common.utils.ScriptUtils;
import com.hudongyang.sunshinehook.storage.monitor.RunningData;
import com.hudongyang.sunshinehook.storage.queue.HookEventQueue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/17 1:28
 */
@Slf4j
public class EventHandler extends EventHandlerWrapper<HookEvent> {

    private static final long DEFAULT_CONSUME_DELAY = 10L;

    /**
     * event触发执行脚本
     */
    private final String scriptPath;

    public EventHandler(HookEventQueue<HookEvent> queue, long consumeDelay, String scriptPath) {
        super(queue, consumeDelay);
        this.scriptPath = scriptPath;
    }

    public EventHandler(HookEventQueue<HookEvent> queue, String scriptPath) {
        super(queue, DEFAULT_CONSUME_DELAY);
        this.scriptPath = scriptPath;
    }

    @Override
    void handle(HookEvent event) {
        try {
            log.info("received event:{}", event);
            if (StringUtils.isEmpty(scriptPath)) {
                RunningData.increase(RunningData.MonitorType.FAILED_EVENT_COUNT);
                log.info("execute script skip, scriptPath is null");
                return;
            }
            log.info("execute script:{}", scriptPath);
            List<String> commandList = new ArrayList<>();
            commandList.add(BaseConstants.SHELL_EXEC_PREFIX);
            commandList.add(BaseConstants.SHELL_EXEC_OPTIONS);
            commandList.add(scriptPath);
            boolean executeResult = ScriptUtils.executeShell(commandList.toArray(new String[0]));
            if (executeResult) {
                RunningData.increase(RunningData.MonitorType.SUCCESS_EVENT_COUNT);
                log.info("execute script success, script:{}", scriptPath);
            } else {
                RunningData.increase(RunningData.MonitorType.FAILED_EVENT_COUNT);
                log.info("execute script failed, script:{}", scriptPath);
            }
        } catch (Exception e) {
            RunningData.increase(RunningData.MonitorType.FAILED_EVENT_COUNT);
            log.error("handle event exception:{}", event, e);
        }
    }
}
