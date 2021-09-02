package com.mavidevproje.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="UserResult")
public class UserResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    User user;

    @OneToOne
    Province province;

    @OneToOne
    District district;
}
