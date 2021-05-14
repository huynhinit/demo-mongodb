package com.huynh.springboot.springbootdemousingmongodb.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field(value = "_id")
    private ObjectId id;

    @Field(value = "name")
    private String name;

    @Field(value = "phone")
    private String phone;

    @Field(value = "date_login")
    private Date dateLogin;

}
