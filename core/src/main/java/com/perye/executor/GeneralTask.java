package com.perye.executor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class GeneralTask extends CancellableTask {

    public GeneralTask() {

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

    /**
     * 取消任务
     */
    public void cancelTask(boolean mayInterruptIfRunning) {
        if (!isDone() && !isCancelled()) {
            log.info("停止任务: {}", this.getTaskName());
            this.cancel(mayInterruptIfRunning);
        }
    }

    /**
     * 任务是否完成
     */
    public boolean isDone(){
        return this.scheduledFuture != null && this.scheduledFuture.isDone();
    }

    /**
     * 任务是否取消
     */
    public boolean isCancelled(){
        return this.scheduledFuture != null && this.scheduledFuture.isCancelled();
    }
}
