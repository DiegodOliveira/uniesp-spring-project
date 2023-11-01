package com.alunoonline.api.controler;

import com.alunoonline.api.Dto.AlunoPatchRequestDto;
import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
       Aluno AlunoCreated = service.create(aluno);

       return ResponseEntity.status(201).body(AlunoCreated);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patch(@RequestBody AlunoPatchRequestDto alunoPatchRequestDto, @PathVariable Long id){
        service.patch(id, alunoPatchRequestDto.getEmail());
    }

}
