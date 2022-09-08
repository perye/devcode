package com.perye.executor;

import com.perye.executor.mgr.TestTimerMgr;
import com.perye.executor.mgr.TestTimerMgr2;
import com.perye.executor.mgr.TestTimerMgr3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        // 启动定时器1
        TestTimerMgr.init();
        // 启动定时器2
        TestTimerMgr2.init();
        // 启动定时器3(用于停止服务器，task5执行5次触发ShutdownHook)
        TestTimerMgr3.init();

        // 注册异常关闭处理过程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.error("kill 关闭服务器");
            TestTimerMgr.stop();
            TestTimerMgr2.stop();
            TestTimerMgr3.stop();
        }, "ShutdownHook"));
    }

}
