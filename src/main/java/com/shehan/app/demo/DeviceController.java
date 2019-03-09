package com.shehan.app.demo;

import com.shehan.app.demo.models.Device;
import com.shehan.app.demo.models.DeviceRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.List;
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
   public Device insert(@RequestBody Device device){
      device.setId(ObjectId.get());
     this.deviceRepository.insert(device);
    return (device);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Device update(@PathVariable("id") ObjectId id, @RequestBody Device device) {

       Device updateDevice = this.deviceRepository.findOneById(id);
        device.setId(id);
       if (device.getName()!=null){
           updateDevice.setName(device.getName());
       }

        if (device.getType()!=null){
            updateDevice.setType(device.getType());
        }

        if (device.getUpdates()!=null){
            updateDevice.setUpdates(device.getUpdates());
        }

        if (device.getUuid()!=null){
            updateDevice.setUuid(device.getUuid());
        }

        if (device.getMAC()!=null){
            updateDevice.setMAC(device.getMAC());
        }

        if (device.getProtocol()!=null){
            updateDevice.setProtocol(device.getProtocol());
        }

        if (device.getServer()!=null){
            updateDevice.setServer(device.getServer());
        }

        if (device.getPort()!=null){
            updateDevice.setPort(device.getPort());
        }

        if (device.getTopic()!=null){
            updateDevice.setTopic(device.getTopic());
        }

        if (device.getSubscribe()!=null){
            updateDevice.setSubscribe(device.getSubscribe());
        }


            updateDevice.setQos(device.getQos());


        if(device.getUpdates()!=null){
            updateDevice.setUpdates(device.getUpdates());
        }


        updateDevice.setStatus(device.getStatus());


        if(device.getIsStatus()!=null){
            updateDevice.setIsStatus(device.getIsStatus());
        }

        if(device.getLocation()!=null){
            updateDevice.setLocation(device.getLocation());
        }

        this.deviceRepository.save(updateDevice);

        return (device);
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
