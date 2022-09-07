package com.perye.test;

import com.perye.executor.GeneralTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestTask2 extends GeneralTask {

    public TestTask2(long initialDelay, long delay, TimeUnit unit) {
        super(initialDelay, delay, unit);
    }

    @Override
    public void doRun() {
        // do something
        log.info("test task2 haha");
    }
}
