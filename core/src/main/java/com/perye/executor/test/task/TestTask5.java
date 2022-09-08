package com.perye.executor.test.task;

import com.perye.executor.GeneralTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 定时任务2
 */
@Slf4j
public class TestTask5 extends GeneralTask {

    public TestTask5(long initialDelay, long delay, TimeUnit unit) {
        super(initialDelay, delay, unit);
    }

    @Override
    public void doRun() {
        log.info("-------------------------------执行定时任务5-------------------------------");
        log.info("do something");
        log.info("-------------------------------执行定时任务5-------------------------------");
    }
}
