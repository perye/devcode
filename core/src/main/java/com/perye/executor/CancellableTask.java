package com.perye.executor;

import java.util.concurrent.ScheduledFuture;

public abstract class CancellableTask implements Runnable{

    volatile ScheduledFuture<?> scheduledFuture = null;

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (scheduledFuture != null) {
            return scheduledFuture.cancel(mayInterruptIfRunning);
        }
        return true;
    }

}
