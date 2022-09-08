package com.perye.executor;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class GeneralScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    public GeneralScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        if (runnable instanceof CancellableTask) {
            ((CancellableTask) runnable).scheduledFuture = task;
        }
        return task;
    }


}
