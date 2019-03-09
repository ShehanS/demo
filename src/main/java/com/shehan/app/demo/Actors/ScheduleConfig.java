//package com.shehan.app.demo.Actors;
//
//import com.shehan.app.demo.models.Device;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@EnableScheduling
//@Configuration
//public class ScheduleConfig {
//    @Autowired
//    SimpMessagingTemplate simpMessagingTemplate;
//
//    @Scheduled(fixedDelay = 3000)
//    public void sendAdhocMessage(){
//        simpMessagingTemplate.convertAndSendToUser("","/chat");
//    }
//
//
//}
