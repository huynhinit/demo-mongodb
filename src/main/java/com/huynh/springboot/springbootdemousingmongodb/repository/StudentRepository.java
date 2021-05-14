package com.huynh.springboot.springbootdemousingmongodb.repository;

import com.huynh.springboot.springbootdemousingmongodb.model.Students;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Students, ObjectId> {

    Optional<Students> findByPhone(String phone);

    List<Students> findByNameLike(String name);

    // Supports native JSON query string
    @Query("{name:'?0'}")
    List<Students> findCustomByName(String name);

}
