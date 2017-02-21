/**
 * 
 */
package com.hna.springtask;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TaskJob {

    @Scheduled(cron = "0/10 * * * * ?")
    public void springTask() {
        System.out.println("spring task.. " + new Date());
    }

    public void job1() {
        System.out.println("lll");
        System.out.println("基于XML的任务。。" + new Date());
    }
}
