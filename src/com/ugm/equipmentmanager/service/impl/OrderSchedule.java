package com.ugm.equipmentmanager.service.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OrderSchedule {
    private static ScheduledExecutorService Manager;
    private static OrderSchedule orderSchedule;
    
    static{
        Manager = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private OrderSchedule(){	
    }

    public synchronized static OrderSchedule getInstance(){
        if(orderSchedule == null){
            orderSchedule = new OrderSchedule();
        }
        return orderSchedule;
    }

    /**
     * 生成订单时调用，一段时间后订单取消
     */
    public void startTask(Runnable task,long delay ,TimeUnit time ){
        Manager.schedule(task,delay,time);
    }
}


