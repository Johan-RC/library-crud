package com.sena.library_crud.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.library_crud.view.Views;

@Getter
@Setter
public class EventDto {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String title;

    @JsonView(Views.Public.class)
    private LocalDateTime startDate;

    @JsonView(Views.Detailed.class)
    private String description;

    @JsonView(Views.Detailed.class)
    private LocalDateTime endDate;

    @JsonView(Views.Public.class)
    private Long roomId;

    @JsonView(Views.Public.class)
    private Long organizerId;
}