package com.perye.test;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 初始化定时器线程池
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        corePoolSize = Math.min(8, Math.max(4, corePoolSize));
        TestTimerMgr timerMgr = new TestTimerMgr();
        timerMgr.addTask(new TestTask(0,3, TimeUnit.SECONDS));
        timerMgr.init(corePoolSize, "test-timer");
        TestTimerMgr2 timerMgr2 = new TestTimerMgr2();
        timerMgr2.addTask(new TestTask2(1,5, TimeUnit.SECONDS));
        timerMgr2.init(corePoolSize, "test-timer2");
        Thread.sleep(15000);
        timerMgr2.stop();
    }

}
