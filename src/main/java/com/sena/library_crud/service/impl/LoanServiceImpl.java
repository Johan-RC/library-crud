package com.sena.library_crud.service.impl;

import com.sena.library_crud.dto.LoanDto;
import com.sena.library_crud.entity.Loan;
import com.sena.library_crud.enums.LoanStatus;
import com.sena.library_crud.repository.LoanRepository;
import com.sena.library_crud.repository.UserRepository;
import com.sena.library_crud.repository.VolumeRepository;
import com.sena.library_crud.service.LoanService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VolumeRepository volumeRepository;

    @Override
    @Transactional
    public LoanDto create(LoanDto dto) {
        Loan loan = new Loan();
        loan.setLoanDate(dto.getLoanDate());
        loan.setDueDate(dto.getDueDate());
        loan.setStatus(LoanStatus.PENDING);
        loan.setUser(userRepository.findById(dto.getUserId()).orElseThrow());
        loan.setVolume(volumeRepository.findById(dto.getVolumeId()).orElseThrow());
        return toDto(loanRepository.save(loan));
    }

    @Override
    @Transactional
    public LoanDto returnLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        loan.setReturnDate(java.time.LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);
        return toDto(loanRepository.save(loan));
    }

    @Override
    public List<LoanDto> getAll() {
        return loanRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public LoanDto getById(Long id) {
        return loanRepository.findById(id).map(this::toDto).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }
    
    //Ayuda: metodo para convertir entidad a dto

    private LoanDto toDto(Loan loan) {
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
}