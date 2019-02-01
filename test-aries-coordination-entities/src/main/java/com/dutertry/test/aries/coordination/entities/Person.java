package com.dutertry.test.aries.coordination.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = {
    @Index(columnList = "lastName"),
    @Index(name = "idxage", columnList = "age")
})
public class Person implements Serializable {
    @Id
    private String lastName;
    
    @Column
    private int age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    
    
    
}
