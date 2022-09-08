package com.perye.executor.test;

import com.perye.executor.test.mgr.TestTimerMgr;
import com.perye.executor.test.mgr.TestTimerMgr2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 启动定时器1
        TestTimerMgr.init();
        // 启动定时器2
        TestTimerMgr2.init();
        // 30s后停止定时器2
        Thread.sleep(30000);
        TestTimerMgr2.stop();

        // 注册异常关闭处理过程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.error("kill 关闭服务器");
            TestTimerMgr.stop();
            TestTimerMgr2.stop();
        }, "ShutdownHook"));
    }

}
