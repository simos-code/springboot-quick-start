package com.simos.service;

import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by l2h on 18-4-25.
 * Desc:消息推送任务池组件.使用aware,这样业务代码就依赖了Spring框架
 * @author l2h
 */
@Service
public class AwarePushMsgPool implements ApplicationContextAware{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 线程池
     */
    private ThreadPoolExecutor executorService;
    /**
     * 任务队列
     */
    private TaskQueue taskqueue ;
    /**
     * 最大队列数量.通常配置在配置文件中.这里样例代码不加太多东西．
     * 简单点使用@value注入，复杂点像springboot一样＠Configuration＋＠ConfigurationProperties
     */
    private final int acceptCount = 10000;
    /**
     *核心线程数
     */
    private final int corePoolSize = 20;
    /**
     * 最大线程数
     */
    private final int maxPoolSize = 100;
    /**
     * 线程保活时间
     */
    private final int keepAliveTime =60;
    public AwarePushMsgPool(){
        taskqueue = new TaskQueue(acceptCount);
        TaskThreadFactory tf =  new TaskThreadFactory("simos-pool-msg-",true,Thread.NORM_PRIORITY);
        executorService = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime, TimeUnit.SECONDS,
                taskqueue, tf);
        executorService.setThreadRenewalDelay(org.apache.tomcat.util.threads.Constants.DEFAULT_THREAD_RENEWAL_DELAY);
        taskqueue.setParent(executorService);
    }
    public void pushMsg(String msg){
        if (msg!=null){
            try {
                //所需要的原型bean不是通过依赖注入的，而是直接bean容器拿到的，违反了IoC原则
                PushMsgTask task = pushMsgTask(msg);
                System.out.println("aware class:"+this.getClass());
                executorService.submit(task);
            }

            catch (Exception exception){
                System.out.println("推送失败,失败原因:"+exception.getMessage());
            }

        }
    }

    protected PushMsgTask pushMsgTask(String msg){
        PushMsgTask task = applicationContext.getBean("task",PushMsgTask.class);
        task.setMsg(msg);
        return task;
    }
}
