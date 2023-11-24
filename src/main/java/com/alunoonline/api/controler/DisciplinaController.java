package com.alunoonline.api.controler;

import com.alunoonline.api.Dto.DisciplinaPatchRequestDto;
import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina){
        Disciplina disciplinaCreated = service.create(disciplina);

        return ResponseEntity.status(201).body(disciplinaCreated);
    }

    @GetMapping("/professor/{professorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> findByProfessorId(@PathVariable Long professorId){
        return service.findByProfessorId(professorId);
    }

    @PatchMapping("/disciplina-nome/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void newName(@RequestBody DisciplinaPatchRequestDto disciplinaPatchRequestDto,@PathVariable Long id){
        service.patchNome(id, disciplinaPatchRequestDto.getNome());
    }
}
