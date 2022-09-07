package com.perye.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class GeneralTask extends CancellableTask {

    private long initialDelay;

    private long delay;

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
     * 取消定时任务
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return super.cancel(mayInterruptIfRunning);
    }


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
