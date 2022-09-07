package com.perye.executor;

import lombok.extern.slf4j.Slf4j;


/**
 * 定时器管理器
 */
@Slf4j
public abstract class AbstractTimerMgr {


    /**
     * 初始化
     */
    public abstract void init(int corePoolSize, String threadName);

    /**
     * 初始化加载定时器
     */
    public abstract void initTask();


    /**
     * 取消任务
     */
    public abstract void cancelTask(GeneralTask task);


    /**
     * 停止任务
     */
    public abstract void stop();

    public abstract void addTask(GeneralTask task);

}
