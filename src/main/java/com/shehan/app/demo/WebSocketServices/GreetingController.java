package com.shehan.app.demo.WebSocketServices;

import com.shehan.app.demo.models.Device;
import com.shehan.app.demo.models.DeviceRepository;
import com.shehan.app.demo.models.GraphData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;


@Controller
public class GreetingController {
    private final DeviceRepository deviceRepository;
    private final SimpMessagingTemplate Template;


    @Autowired
    public GreetingController(DeviceRepository deviceRepository, SimpMessagingTemplate template) {
        this.deviceRepository = deviceRepository;
        Template = template;
    }

    @MessageMapping("/sejnd/bb")
    @SendTo("/chatjj")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(100); // simulated delay
        return new Greeting("ABC");
    }


    @MessageMapping("/send/message1")
    @SendTo("/chat1")
    public List<Device> showAllDevices() throws Exception{
        List<Device> devices = this.deviceRepository.findAll();
        return devices;
    }
    @MessageMapping("/send/message")
    @SendTo("/chat")
    public GraphData graph() throws Exception{
        Thread.sleep(100);
        return new GraphData(1.9);
    }

    @MessageMapping("/send/")
    public void onReceivedMessage(String message){
        this.Template.convertAndSendToUser("","/chat", "Return-"+message);
        System.out.println(message);
    }
}
