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
    private String mac;
    private String type;
    private List<Update> updates;
    protected Device(){
        this.updates=new ArrayList<>();
    }

    public Device(ObjectId _id, String name, String mac, String type, List<Update> update){
        this._id = _id;
        this.name = name;
        this.mac = mac;
        this.type = type;
        this.updates = update;

    }

    public void setId(ObjectId docId){
      this._id = docId;
    }

    public String getId(){
        return _id.toHexString();
    }

    public String getName(){
        return name;

    }

    public String getMac(){
        return mac;
    }

    public String getType(){
        return type;
    }

    public List<Update> getUpdates(){
        return updates;
    }
}
