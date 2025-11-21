package com.sena.library_crud.service;

import com.sena.library_crud.dto.LoanDto;
import java.util.List;

public interface LoanService {
    LoanDto create(LoanDto dto);
    LoanDto returnLoan(Long id);
    List<LoanDto> getAll();
    LoanDto getById(Long id);
    void delete(Long id);
}