package com.sena.library_crud.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.library_crud.view.Views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolumeDto {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String title;

    @JsonView(Views.Detailed.class)
    private String description;

    @JsonView(Views.Detailed.class)
    private Integer publicationYear;

    @JsonView(Views.Detailed.class)
    private String isbn;

    @JsonView(Views.Public.class)
    private Long publisherId;
}