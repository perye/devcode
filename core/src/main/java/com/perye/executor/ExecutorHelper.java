package com.perye.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ExecutorHelper {

    public static ScheduledThreadPoolExecutor createScheduledThreadPoolExecutor(int corePoolSize, String threadName) {
        return new GeneralScheduledThreadPoolExecutor(corePoolSize, new GeneralThreadFactory(threadName));
    }

}
