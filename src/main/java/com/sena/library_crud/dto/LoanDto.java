package com.sena.library_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import com.sena.library_crud.enums.LoanStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    
    private Long id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;
    private Long userId;
    private Long volumeId;
}