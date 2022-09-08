package com.perye.executor.test.mgr;

import com.perye.executor.ExecutorHelper;
import com.perye.executor.GeneralTask;
import com.perye.executor.test.task.TestTask5;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时器管理2
 */
@Slf4j
public class TestTimerMgr3 {

    private static ScheduledExecutorService timerExecutorService;

    // --------------------------------------------------定时器列表--------------------------------------------------
    private static TestTask5 testTask5 = null;
    // --------------------------------------------------定时器列表--------------------------------------------------

    /**
     * 初始化
     */
    public static synchronized void init() {
        // 初始化定时器线程池
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        corePoolSize = Math.min(8, Math.max(4, corePoolSize));
        timerExecutorService = ExecutorHelper.createScheduledThreadPoolExecutor(corePoolSize, "TestTimerMgr3");
        // 加载任务
        initTask();
    }

    /**
     * 初始化加载定时器
     */
    public static void initTask() {
        if (testTask5 == null) {
            testTask5 = new TestTask5();
            timerExecutorService.scheduleWithFixedDelay(testTask5, 0, 5, TimeUnit.SECONDS);
        }
    }


    /**
     * 停止任务
     */
    public static void stop() {
        cancelTask(testTask5);
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
