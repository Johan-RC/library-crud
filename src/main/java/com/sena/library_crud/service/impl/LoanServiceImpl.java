package com.sena.library_crud.service.impl;

import com.sena.library_crud.dto.LoanDto;
import com.sena.library_crud.entity.Loan;
import com.sena.library_crud.entity.User;
import com.sena.library_crud.entity.Volume;
import com.sena.library_crud.enums.LoanStatus;
import com.sena.library_crud.mapper.LoanMapper;
import com.sena.library_crud.repository.LoanRepository;
import com.sena.library_crud.repository.UserRepository;
import com.sena.library_crud.repository.VolumeRepository;
import com.sena.library_crud.service.LoanService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Override
    @Transactional
    public LoanDto create(LoanDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Volume volume = volumeRepository.findById(dto.getVolumeId()).orElseThrow();
        Loan loan = loanMapper.toEntity(dto, user, volume);
        loan.setStatus(LoanStatus.PENDING);
        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    @Transactional
    public LoanDto returnLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        loan.setReturnDate(java.time.LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);
        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    public List<LoanDto> getAll() {
        return loanRepository.findAll().stream().map(loanMapper::toDto).toList();
    }

    @Override
    public LoanDto getById(Long id) {
        return loanRepository.findById(id).map(loanMapper::toDto).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }
}