package com.perye.executor;

import java.util.concurrent.ThreadFactory;

public class GeneralThreadFactory implements ThreadFactory {

    private final String threadName;

    private int threadIndex = 0;

    public GeneralThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("thread pool name :" + threadName + ",thread-" + threadIndex++);
        return thread;
    }
}
