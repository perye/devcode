package com.perye.executor.test.mgr;

import com.perye.executor.ExecutorHelper;
import com.perye.executor.GeneralTask;
import com.perye.executor.test.task.TestTask2;
import com.perye.executor.test.task.TestTask4;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器管理2
 */
@Slf4j
public class TestTimerMgr2 {

    private static ScheduledExecutorService timerExecutorService;

    // --------------------------------------------------定时器列表--------------------------------------------------
    private static TestTask2 testTask2 = null;
    private static TestTask4 testTask4 = null;
    // --------------------------------------------------定时器列表--------------------------------------------------

    /**
     * 初始化
     */
    public static synchronized void init() {
        // 初始化定时器线程池
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        corePoolSize = Math.min(8, Math.max(4, corePoolSize));
        timerExecutorService = ExecutorHelper.createScheduledThreadPoolExecutor(corePoolSize, "TestTimerMgr2");
        // 加载任务
        initTask();
    }

    /**
     * 初始化加载定时器
     */
    public static void initTask() {
        if (testTask2 == null) {
            testTask2 = new TestTask2();
            timerExecutorService.scheduleWithFixedDelay(testTask2, 3, 7, TimeUnit.SECONDS);
        }

        if (testTask4 == null) {
            testTask4 = new TestTask4();
            timerExecutorService.scheduleWithFixedDelay(testTask4, 5, 5, TimeUnit.SECONDS);
        }
    }


    /**
     * 停止任务
     */
    public static void stop() {
        cancelTask(testTask2);
        cancelTask(testTask4);
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
