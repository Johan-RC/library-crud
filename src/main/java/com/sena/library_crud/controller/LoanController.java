package com.sena.library_crud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.library_crud.dto.LoanDto;
import com.sena.library_crud.service.LoanService;
import com.sena.library_crud.view.Views;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    @JsonView(Views.Public.class)
    public ResponseEntity<LoanDto> create(@RequestBody @Valid LoanDto dto) {
        return ResponseEntity.ok(loanService.create(dto));
    }

    @PutMapping("/{id}/return")
    @JsonView(Views.Public.class)
    public ResponseEntity<LoanDto> returnLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.returnLoan(id));
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public ResponseEntity<List<LoanDto>> getAll() {
        return ResponseEntity.ok(loanService.getAll());
    }

    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    public ResponseEntity<LoanDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}