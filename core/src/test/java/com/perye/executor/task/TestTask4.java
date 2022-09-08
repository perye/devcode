package com.perye.executor.task;

import com.perye.executor.GeneralTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时任务4
 */
@Slf4j
public class TestTask4 extends GeneralTask {

    /**
     * 计数
     */
    private static AtomicInteger cnt = new AtomicInteger(0);

    @Override
    public void doRun() {
        cnt.getAndIncrement();
        log.info("定时任务4执行次数: {}", cnt.get());
        if (cnt.get() == 2) {
            this.cancelTask(false);
        }
    }
}
