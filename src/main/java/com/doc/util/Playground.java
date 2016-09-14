package com.doc.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Playground {

    /**
     * @param args
     */
    public static void main(String[] args) {
        startThread();
    }

    private static void startThread() {
        ScheduledExecutorService timer = Executors
                .newSingleThreadScheduledExecutor();
        Runnable r = new Runnable() {
            int dummyInt = 0;
            boolean dummyBoolean = false;

            @Override
            public void run() {
					dummyInt = Integer.parseInt("AAAA");

					if (dummyBoolean) {
					    dummyBoolean= false;
					} else {
					    dummyBoolean= true;
					}
            }
        };
        ScheduledFuture<?> future = timer.schedule(r, 0,  TimeUnit.MILLISECONDS);
        try {
            future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            cause.printStackTrace();
            System.out.println(future.isCancelled());
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
   }