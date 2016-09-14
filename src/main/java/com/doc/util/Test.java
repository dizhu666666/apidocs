package com.doc.util;

import java.util.Date;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;  
  
public class Test {  
    static class EchoServer1 implements Runnable {  
        @Override  
        public void run() {  
            // TODO Auto-generated method stub  
            try {  
                Thread.sleep(10000);  
                i++;  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            if(i==1){  
                throw new java.lang.RuntimeException("Dasds");  
            }  
            System.out.println(i+"-"+10+"-"+Thread.currentThread().getName() +"-"+new Date());  
        }  
          
    }  
    static int i =0;  
    static class EchoServer2 implements Runnable {  
        @Override  
        public void run() {  
            // TODO Auto-generated method stub  
              
            System.out.println(20+"-"+Thread.currentThread().getName() +"-"+new Date());  
        }  
          
    }  
      
    public static void main(String[] args){  
    	System.out.println(TimeManager.TimeToFormatString(1468682744,"yyyy-MM-dd HH:mm"));
    	
    }  
  public void ru(){
	  ThreadFactory threadFactory=new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"thread"+i);
			}
		};
	
  ScheduledExecutorService executor = Executors.newScheduledThreadPool(2,threadFactory);    
  ScheduledFuture future=executor.schedule(    
          new EchoServer1(),    
          1L,    
          TimeUnit.SECONDS);    
     
  try {  
           try {  
              future.get();  
                
          } catch (InterruptedException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }  
       } catch (ExecutionException e) {  
           Throwable cause = e.getCause();  
           cause.printStackTrace();  
       }  
  System.out.println(3333);
  System.out.println(future.isDone());
  System.out.println(future.isCancelled());
  }
}  