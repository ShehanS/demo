package com.shehan.app.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "device-registration")
public class Device {
    @Id
    private ObjectId _id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private String type;
    private String uuid;
    private String id;
    private String MAC;
    private String protocol;
    private String server;
    private String port;
    private String topic;
    private String subscribe;
    private int qos;
    private List<Update> updates;
    private boolean status = false;
    private String isStatus = "Not activated";
    private String location;

    protected Device(){
        this.updates=new ArrayList<>();
    }

    public Device(ObjectId _id, String name, String type, String uuid, String id, String MAC, String protocol, String server, String port, String topic, String subscribe, int qos, List<Update> updates, boolean status, String isStatus, String location) {
        this._id = _id;
        this.name = name;
        this.type = type;
        this.uuid = uuid;
        this.id = id;
        this.MAC = MAC;
        this.protocol = protocol;
        this.server = server;
        this.port = port;
        this.topic = topic;
        this.subscribe = subscribe;
        this.qos = qos;
        this.updates = updates;
        this.status = status;
        this.isStatus = isStatus;
        this.location = location;

    }

    public void setId(ObjectId docId){
      this._id = docId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setUuid(String uuid){ this.uuid = uuid; }

    public void setMAC(String MAC){
        this.MAC = MAC;
    }

    public void setServer(String server){
        this.server = server;
    }

    public void setPort(String port){
        this.port = port;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void setSubscribe(String subscribe){
        this.subscribe = subscribe;
    }

    public void setQos(int qos){
        this.qos = qos;
    }

    public void setUpdates(List<Update> updates){
        this.updates = updates;
    }

    public void setProtocol(String protocol){
        this.protocol = protocol;
    }

    public void setStatus(boolean status){ this.status = status; }

    public void setLocation(String location){this.location = location; }

    public void setIsStatus(String isStatus){
        this.isStatus = isStatus;
    }

    public String getId(){
        return _id.toHexString();
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getUuid(){
        return uuid;
    }

    public String getMAC(){
        return MAC;
    }

    public String getProtocol(){
        return protocol;
    }

    public String getServer(){
        return server;
    }

    public String getPort(){
        return port;
    }

    public String getTopic(){
        return topic;
    }

    public String getSubscribe(){
        return subscribe;
    }

    public int getQos(){
        return qos;
    }

    public List<Update> getUpdates(){
        return updates;
    }

    public boolean getStatus(){
        return status;
 }

    public String getIsStatus(){
        return isStatus;
 }

    public String getLocation(){ return location;
    }
}
