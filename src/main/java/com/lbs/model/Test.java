package com.lbs.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    private Integer id;
    private String name;
}
