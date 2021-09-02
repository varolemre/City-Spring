package com.mavidevproje.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Data
public class District {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Province province;

}
