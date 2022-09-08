package com.perye.executor.test.task;

import com.perye.executor.GeneralTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时任务5
 */
@Slf4j
public class TestTask5 extends GeneralTask {

    public TestTask5() {

    }

    /**
     * 计数
     */
    private static AtomicInteger cnt = new AtomicInteger(0);

    @Override
    public void doRun() {
        cnt.getAndIncrement();
        log.info("定时任务5执行次数: {}", cnt.get());
        if (cnt.get() == 5) {
            System.exit(0);
        }
    }
}
