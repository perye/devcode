package com.perye.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class GeneralTask extends CancellableTask {

    /**
     * 延迟第一次执行的时间
     */
    private long initialDelay;

    /**
     * 从一个执行的终止到下一个执行的开始之间的延迟
     */
    private long delay;

    /**
     * initialDelay和delay参数的时间单位
     */
    private TimeUnit unit;

    public GeneralTask() {

    }

    public GeneralTask(long initialDelay, long delay, TimeUnit unit) {
        this.initialDelay = initialDelay;
        this.delay = delay;
        this.unit = unit;
    }

    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();
            doRun();
            long end = System.currentTimeMillis();
            log.info("task: [{}],cost: {}ms", getTaskName(), end - start);
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(), throwable);
        }

    }

    /**
     * 执行
     */
    public abstract void doRun();

    /**
     * 获取定时任务名称
     */
    public String getTaskName() {
        return this.getClass().getName();
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public long getDelay() {
        return delay;
    }

    public TimeUnit getUnit() {
        return unit;
    }
}
