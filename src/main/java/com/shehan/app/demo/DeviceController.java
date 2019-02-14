package com.shehan.app.demo;

import com.shehan.app.demo.models.Device;
import com.shehan.app.demo.models.DeviceRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.List;
@SpringBootApplication
@RestController
@RequestMapping("/devices")
public class DeviceController {
    private DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/all")
    public List<Device> showAllDevices() {
        List<Device> devices = this.deviceRepository.findAll();
         return devices;
    }
    @RequestMapping(value = "/userid/{id}", method = RequestMethod.GET)
    public List<Device> searchById(@PathVariable("id") ObjectId id) {
        List<Device> devices = this.deviceRepository.findById(id);
        return  devices;
    }


   /* @PostMapping()
    public void insert(@RequestBody Device device){
    this.deviceRepository.insert(device);
    }*/

   @RequestMapping(value = "/", method = RequestMethod.POST)
   public void insert(@RequestBody Device device){
       device.setId(ObjectId.get());
       this.deviceRepository.insert(device);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") ObjectId id, @RequestBody Device device) {
    device.setId(id);
    this.deviceRepository.save(device);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId id){
       this.deviceRepository.deleteById(id.toHexString());
    }


/*
    @DeleteMapping(value = "/{id}", )
    public void delete(@PathVariable("id") String id){
        this.deviceRepository.deleteById(id);
    }
*/

    @GetMapping("/{type}")
    public List<Device> searchByType(@PathVariable("type") String type) {
        List<Device> devices = this.deviceRepository.findByType(type);
        return  devices;
    }









}
