package com.shehan.app.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface DeviceRepository extends MongoRepository<Device, String> {

    @Query(value="{\"type\":?0}")
    List<Device> findByType(String type);
    @Query(value = "{\"_id\":?0}")
    List<Device> findById(ObjectId id);
}
