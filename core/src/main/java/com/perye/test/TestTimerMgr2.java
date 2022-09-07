package com.perye.test;

import com.perye.executor.AbstractTimerMgr;
import com.perye.executor.ExecutorHelper;
import com.perye.executor.GeneralTask;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
public class TestTimerMgr2 extends AbstractTimerMgr {

    private static ScheduledExecutorService timerExecutorService;

    private static List<GeneralTask> taskList = new ArrayList<>();


    /**
     * 添加任务到定时器
     */
    @Override
    public void addTask(GeneralTask task) {
        if (task != null) {
            taskList.add(task);
        }
    }

    /**
     * 初始化
     */
    @Override
    public synchronized void init(int corePoolSize, String threadName) {
        timerExecutorService = ExecutorHelper.createScheduledThreadPoolExecutor(corePoolSize, threadName);
        initTask();
    }

    /**
     * 初始化加载定时器
     */
    @Override
    public void initTask() {
        for (GeneralTask task : taskList) {
            if (task != null) {
                timerExecutorService.scheduleWithFixedDelay(task, task.getInitialDelay(), task.getDelay(), task.getUnit());
            }
        }
    }


    /**
     * 取消任务
     */
    @Override
    public void cancelTask(GeneralTask task) {
        if (task != null) {
            task.cancel(false);
        }
    }

    /**
     * 停止任务
     */
    @Override
    public void stop() {
        for (GeneralTask generalTask : taskList) {
            cancelTask(generalTask);
        }
    }


}
