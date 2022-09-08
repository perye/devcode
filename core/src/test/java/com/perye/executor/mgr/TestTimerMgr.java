package com.perye.executor.mgr;

import com.perye.executor.ExecutorHelper;
import com.perye.executor.GeneralTask;
import com.perye.executor.task.TestTask;
import com.perye.executor.task.TestTask3;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器管理1
 */
@Slf4j
public class TestTimerMgr {

    private static ScheduledExecutorService timerExecutorService;

    // --------------------------------------------------定时器列表--------------------------------------------------
    private static TestTask testTask = null;
    private static TestTask3 testTask3 = null;
    // --------------------------------------------------定时器列表--------------------------------------------------

    /**
     * 初始化
     */
    public static synchronized void init() {
        // 初始化定时器线程池
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        corePoolSize = Math.min(8, Math.max(4, corePoolSize));
        timerExecutorService = ExecutorHelper.createScheduledThreadPoolExecutor(corePoolSize, "TestTimerMgr");
        // 加载任务
        initTask();
    }

    /**
     * 初始化加载定时器
     */
    public static void initTask() {
        if (testTask == null) {
            testTask = new TestTask();
            timerExecutorService.scheduleWithFixedDelay(testTask, 0, 3, TimeUnit.SECONDS);
        }
        if (testTask3 == null) {
            testTask3 = new TestTask3();
            timerExecutorService.schedule(testTask3, 5, TimeUnit.SECONDS);
        }
    }


    /**
     * 停止任务
     */
    public static void stop() {
        cancelTask(testTask);
        cancelTask(testTask3);
    }


    /**
     * 取消任务
     */
    public static void cancelTask(GeneralTask task) {
        if (task != null) {
            task.cancelTask(false);
        }
    }


}
