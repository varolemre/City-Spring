package com.mavidevproje.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
@Data
public class Province {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


}
