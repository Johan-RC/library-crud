package com.sena.library_crud.mapper;

import com.sena.library_crud.dto.LoanDto;
import com.sena.library_crud.entity.Loan;
import com.sena.library_crud.entity.User;
import com.sena.library_crud.entity.Volume;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanDto toDto(Loan loan) {
        LoanDto dto = new LoanDto();
        dto.setId(loan.getId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setDueDate(loan.getDueDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setStatus(loan.getStatus());
        dto.setUserId(loan.getUser().getId());
        dto.setVolumeId(loan.getVolume().getId());
        return dto;
    }

    public Loan toEntity(LoanDto dto, User user, Volume volume) {
        Loan loan = new Loan();
        loan.setLoanDate(dto.getLoanDate());
        loan.setDueDate(dto.getDueDate());
        loan.setStatus(dto.getStatus());
        loan.setUser(user);
        loan.setVolume(volume);
        return loan;
    }
}