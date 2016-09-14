package com.doc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TopitTag extends TagSupport {
	public static List<Exception> es=new ArrayList<>();
	public static  int flag=12;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3002643386716386520L;
	private String value; // 处理的字符串

	public void setValue(String value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		String newValue = EmojiFilter.emojiRecovery(value);
		JspWriter out = pageContext.getOut();
		try {
			out.write(newValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	 private static  List<Integer> age=new ArrayList();
	static Lock lock = new ReentrantLock();
	static AtomicInteger ato=new AtomicInteger(0);
	static int i=0;
	  public static void main(String[] args)   {
		  
		 TopitTag tag=new TopitTag();
		  
		  int i=0;
	        ThreadFactory threadFactory=new ThreadFactory() {
				
				@Override
				public Thread newThread(Runnable r) {
					return new Thread(r,"thread"+i);
				}
			};
			ScheduledExecutorService schedule=Executors.newScheduledThreadPool(1, threadFactory);
		 
		 ScheduledFuture	futu=schedule.schedule(new Runnable() {
				
				@Override
				public void run() {
					 
					try {
						int i=1/0;
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
						es.add(e);
					}
				}
			}, 1,TimeUnit.SECONDS);
		  
		System.out.println(futu.isDone());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	   private static BlockingDeque<Integer> block=new LinkedBlockingDeque<>();
	   
	   
	   public static void setEc(Exception e){
		   es.add(e);
	   }
	   
	    public static void  lock(){
	        System.out.println("nihao");
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println(i++);
	        System.out.println(ato.addAndGet(12));
	    }
}
