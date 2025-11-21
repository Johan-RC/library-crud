package com.sena.library_crud.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.library_crud.view.Views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String fullName;

    @JsonView(Views.Public.class)
    private Boolean active;

    @JsonView(Views.Detailed.class)
    private String email;

    @JsonView(Views.Public.class)
    private Long roleId;
}