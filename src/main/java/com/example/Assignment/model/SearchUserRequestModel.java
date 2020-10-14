package com.example.Assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchUserRequestModel {

    private String id;

    private String userName;

    private String userSurname;

    private Integer status;

}
