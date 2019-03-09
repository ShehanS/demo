package com.shehan.app.demo;

import com.shehan.app.demo.models.DeviceRepository;
import org.springframework.boot.CommandLineRunner;

public class TestData implements CommandLineRunner {
    private DeviceRepository deviceRepository;

    public TestData(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       // Device dev1 = new Device("jjkjjk","temp","9wjiss", Arrays.asList(new Update("01.1","2011-20-10",true)),new DeviceReg("9099990","00202","mqtt","test.net",8888,"abc","cc",2));

      //  List<Device> d = Arrays.asList(dev1);
       // this.deviceRepository.insert(d);



    }



}
