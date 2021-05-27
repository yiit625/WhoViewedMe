package com.example.Assignment.entity;


import com.example.Assignment.commons.AbstractAuditionGuidKeyEntity;
import com.example.Assignment.enums.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractAuditionGuidKeyEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "status")
    private EnumStatus status;

    @Column(name = "created_date")
    private Date createdDate;




}
